/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javachat.ClientConnection;

/**
 *
 * @author Nindia Cahyaning Putri
 * IF3907
 * 1301154567
 */
public class JChatController implements ActionListener {
    private ChatView view;
    private ClientConnection client;
    
    public JChatController() {
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }
    public class WriteOutput extends Thread{
        @Override
        public void run(){
            String inputan;
            try{
                while ((inputan = client.readStream()) != null){
                    view.setTxAreaChat(inputan);
                }
            } catch (IOException E){
                System.out.println("error");
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        
        if(source.equals(view.getTxFieldChat())) {
            if(client == null) {
                try{
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    WriteOutput w = new WriteOutput();
                    w.start();
                } catch(IOException E){
                    System.out.println("eror");
                }
            } else {
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTxFieldChat("");
            }
        }
    }
}
