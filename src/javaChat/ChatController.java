/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaChat;
import gui.ChatView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author YangPentingHappy
 */
public class ChatController implements ActionListener{
    private ChatView view;
    private ClientConnection client = null;
    public ChatController(){
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }
    public class WriteOutput extends Thread{
        @Override
        public void run(){
            try {
                String inputan;
                while((inputan = client.readStream())!=null){
                    view.setTxAreaChat(inputan);
                }
            } catch (Exception e) {
                System.out.println("Error!!");
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getTxAreaChat())){
            if(client == null){
                try {
                    client = new ClientConnection();
                    view.setTxAreaChat(view.getStringChat());
                    
                    String ip = view.getStringChat();
                    client.connect(ip);
                    WriteOutput w = new WriteOutput();
                    w.start();
                } catch (Exception e) {
                    System.out.println("System Error!!");
                }
                
            }else{
                String input = view.getStringChat();  
                client.writeStream(input);
                view.setTxFieldChat("");
            }
        }
    }
    
}
