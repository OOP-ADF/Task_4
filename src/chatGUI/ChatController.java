/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javaChat.ClientConnection;

/**
 *
 * @author Anggi
 */
public class ChatController implements ActionListener {
    private ChatView view;
    private ClientConnection client = null;
    
    public ChatController(){
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }

    
    class WriteOutput extends Thread {
        public void run(){
            try{
                String inputan;
                while ((inputan = client.readStream()) != null){
                    view.setTxAreaChat(inputan);
                }
            } catch(IOException ex) {
                System.out.println("Pesan Error");
            }
        }
    }
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        try{
            ClientConnection baru = new ClientConnection();
            String ip = view.getStringChat();
            client.connect(ip);
            WriteOutput w = new WriteOutput();
            w.start();
        } catch (IOException ex) {
            System.out.println("Pesan Error");
        }
        String input = view.getStringChat();
        client.writeStream(input);
        view.setTxFieldChat("");
    }
}