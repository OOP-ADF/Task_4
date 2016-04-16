/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import chatGUI.ChatView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaChat.ClientConnection;

/**
 *
 * @author Hirianinda M.S
 */
public class ChatController implements ActionListener {
    private ChatView view;
    private ClientConnection client = null;
    
    class WriteOutput extends Thread {
        public void run() {
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    view.setTxAreaChat(inputan);
                }
            } catch (IOException ex) {
                Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error");
            }
        } 

    }
    
    public ChatController () {
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }
    
    
        @Override
        public void actionPerformed(ActionEvent ae) {
            Object source = ae.getSource();
            
            if (source.equals(view.getTxFieldChat())) {
                if (client != null) {
                    try {
                        String ip = view.getStringChat();
                        client.connect(ip);
                        
                        WriteOutput w = new WriteOutput();
                        w.start();
                    } catch (IOException ex) {
                        Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Error");
                    }
                }
            } else {
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTxFieldChat("");
            }
        }
}

