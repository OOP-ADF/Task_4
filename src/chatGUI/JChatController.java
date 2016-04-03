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
 * @author ASUS
 */
public class JChatController implements ActionListener{
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
        if (source == view.getTxFieldChat()){
            if(client == null){
                try {
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    WriteOutput w = new WriteOutput();
                    w.start();
                    view.setTxFieldChat("");
                } catch (Exception e) {
                    System.out.println("error" + e);
                }
            
            }
            else{
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTxFieldChat("");
            }
            
            
        }
        

    }
    
    
    public class WriteOutput extends Thread{
        String inputan;
        public void run(){
            try {
                while((inputan = client.readStream())!=null){
                    view.setTxAreaChat(inputan);
                }
                
            } catch (Exception e) {
                System.out.println("error : " + e);
            }
        
        }
    }
    
}
