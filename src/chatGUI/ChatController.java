/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javaChat.ClientConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author Herica Bunga M (1301154572)
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
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getTxFieldChat())) {
            if (client == null){
                try {
                    client = new ClientConnection();
                    view.setTxAreaChat(view.getStringChat());
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
                view.setTxFieldChat("");
            }
        }
    }

    public class WriteOutput extends Thread {

        public void run() {
            try {
                String inp;
                while ((inp = client.readStream()) != null) {
                    view.setTxAreaChat(inp);
                }
            } catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }
}

