/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatGUI;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaChat.ClientConnection;
import javax.swing.JTextField;

/**
 *
 * @author g40
 */
public class ChatController implements ActionListener {
    private ChatView view;
    private ClientConnection client;
    
    public ChatController(){
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }
    
    class WriteOutput extends Thread{
        public void run() {
            try {
                String input;
                while((input = client.readStream()) != null){
                    view.setTxAreaChat(input);
                }
            } catch (Exception e){
                System.out.println("error log : " + e);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source instanceof JTextField){
            if(client == null){
                try{
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    
                    WriteOutput out = new WriteOutput();
                    out.start();
                } catch (Exception e) {
                    System.out.println("Error Log : " + e);
                }
            } else {
                String input = view.getStringChat();
                client.writeStream(input);
            }
            view.setTxFieldChat("");
        }
    }

}
