/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaChat.ClientConnection;

/**
 *
 * @author ac
 */
public class JChatController {
    ChatView view;
    ClientConnection client = null;

    public JChatController() {
        this.view = view;
        view = new ChatView();
        view.setVisible(true);
        view.addListener((ActionListener) this);
        client = null;
        
    }
    
    public class WriteOutput extends Thread{
        public void run(){
            try{
                String inputan;
                while ((inputan = client.readStream()) != null){
                    view.setTxAreaChat(inputan);
                }
            }catch (Exception e){
                System.out.println("Error: "+ e);
        }   
    }
}
        
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.getTxFieldChat()){
            if (client == null){
                try {
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    
                    WriteOutput w = new WriteOutput();
                    w.start();
                } catch (Exception e) {
                    System.out.println("Error: "+e);
                }
            }else{
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTxFieldChat("");
            }
        }    
    }  
}
