/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaChat.ClientConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author SagabAdi
 */
public class ChatController implements ActionListener {

    private ChatView view;
    private ClientConnection client;

    public ChatController() {
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        
        if (source.equals(view.getTextField())){
            if (client == null){
                try {
                    client = new ClientConnection();
                    view.setTxAreaCaht(view.getStringChat());
                    String ip = view.getStringChat();
                    client.connect(ip);
                    WriteOutput w = new WriteOutput();
                    w.start();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
            else {
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTextFieldChat("");
            }
        }
    }

    public class WriteOutput extends Thread {

        public void run() {
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    view.setTxAreaCaht(inputan);

                }
            } catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }
}
