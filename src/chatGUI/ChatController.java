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
import javax.swing.JTextField;

/**
 *
 * @author Adam
 */
public class ChatController implements ActionListener {
    private ChatView view;
    private ClientConnection client = null;

    class WriteOutput extends Thread {
        public void run() {
            try {
                String inputan;
                while((inputan = client.readStream()) != null) {
                    view.setTxAreaChat(inputan);
                }
            } catch (IOException ex) {
                Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    public ChatController() {
        view = new ChatView();
        view.setVisible(true);
        client = null;
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof JTextField) {
            if(client == null) {
                try {
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    
                    WriteOutput w = new WriteOutput();
                    w.start();
                    
                    String input = view.getStringChat();
                    client.writeStream(input);
                    
                    view.setTxFieldChat("");
                } catch (IOException ex) {
                    Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTxFieldChat("");
            }
        }
    }
    
}
