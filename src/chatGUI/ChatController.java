/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaChat.ClientConnection;

/**
 *
 * @author Novak
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
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.getTxFieldChat()) {
            if (client==null) {
                try {
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    WriteOutput w = new WriteOutput();
                    w.start();
                } catch (IOException ex) {
                    System.out.println("error io");
                }
            } else {
                String input = view.getStringChat();
                client.writeStream(input);
            }
            view.setTxFieldChat("");
        }
    }
    
    public class WriteOutput extends Thread {
        @Override
        public void run() {
           try {
               String inputan;
               while ((inputan = client.readStream()) != null) {
                   view.setTxAreaChat(inputan);
               }
           } catch (Exception e) {
               System.out.println("eror");
           }
        }
    }
}
