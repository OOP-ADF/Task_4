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
 * @author IRFAN
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
    
    public class writeOutput extends Thread{

        @Override
        public void run() {
            String inputan;
            try {
                while ((inputan = client.readStream()) != null){
                    view.setTxAreaChat(inputan);
                }
            } catch (IOException e) {
                System.out.println("error");
            }
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getTxFieldChat())) {
            if (client == null) {
                try {
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    writeOutput w = new writeOutput();
                    w.start();
                } catch (IOException e) {
                    System.out.println("error");
                }
            } else {
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTxFieldChat("");
            }
        }
    }
}
