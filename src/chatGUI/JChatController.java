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
 * @author Reinaldi
 */
public class JChatController implements ActionListener {

    private ChatView view;
    private ClientConnection client = null;
    
    public JChatController(){
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source instanceof JTextField){
            if(client == null){
                try {
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    WriteOutput w = new WriteOutput();
                    w.start();
                    String inputan = view.getStringChat();
                    client.writeStream(inputan);
                    view.setTxFieldChat("");
                } catch (Exception e) {
                    System.out.println("Error "+e.getMessage());
                }
            } else{
                String inputan = view.getStringChat();
                client.writeStream(inputan);
                view.setTxFieldChat("");
            }
        }
    }
    
    class WriteOutput extends Thread{
        
        @Override
        public void run(){
            try{
                String inputan;
                while((inputan = client.readStream()) != null){
                    view.setTxAreaChat(inputan);
                }
            }catch(Exception e){
                System.out.println("Error "+e.getMessage());
            }
        }
    }
    
}
