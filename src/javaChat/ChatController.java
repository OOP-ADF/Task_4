/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaChat;

import chatGUI.ChatView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ChatController implements ActionListener {
    ChatView  view;
    ClientConnection client;
    public ChatController(){
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       Object sourcr = ae.getSource();
       String ip = view.getStringChat();
        try {
            client.connect(ip);
            WriteOutput w = new WriteOutput();
            w.run();
        } catch (IOException ex) {
            Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String input = view.getStringChat();
        client.writeStream(input);
        view.setTxAreaChat("");
    }
    
    public class WriteOutput{
        public void run(){
            String inputan;
            try {
                while((inputan = client.readStream())!=null){
                    view.setTxAreaChat(inputan);
                }
            } catch (IOException ex) {
                Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
