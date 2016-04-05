/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatGUI;

import java.awt.event.ActionEvent;
import javaChat.ClientConnection;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author PrimaAnanda-PC
 */
public class ChatController implements ActionListener {
    private ChatView view;
    private ClientConnection client = null;

    public ChatController() {
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }

    class WriteOutput extends Thread {
        @Override
        public void run() {
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    view.setTxAreaChat(inputan);
                }
            } catch (Exception e) {
                Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source instanceof JTextField) {
            if (client == null) {
                try {
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);

                    WriteOutput w = new WriteOutput();
                    w.start();
                } catch (Exception e) {
                   Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, e);
                }
            } else {
                String input = view.getStringChat();
                client.writeStream(input);
            }
            view.setTxFieldChat("");
        }
    }
    
    
}
