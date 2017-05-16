/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaChat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class JChatController implements ActionListener{
   
    private ChatView view;
    private ClientConnection client;

    public JChatController() {
        view = new ChatView();
        view.setVisible(true);
        view.ActionListener(this);
        client = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class WriteOutput extends Thread{
        
        public void run(){
            String inputan;
            try {
                while((inputan = client.readStream()) != null){
                    view.settxAreaChat(inputan);
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
    
    public void actionPermormed(ActionEvent ae){
        
        Object source = ae.getSource();
        
        if (source.equals(view.gettxFieldChat())){
            if (client == null){
                try {
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    WriteOutput w = new WriteOutput(); 
                    w.start(); 
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }else{
                String input = view.getStringChat(); 
                client.writeStream(input); 
                view.setTxFieldChat("");
            }
        }
    }    
}
