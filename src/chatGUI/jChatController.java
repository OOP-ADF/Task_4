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
import javax.swing.text.View;

/**
 *
 * @author Ranestari Sastriani
 */
public class jChatController {
    private ChatView view;
    private ClientConnection client =null;
    
    public jChatController(){
        view= new ChatView();
        view.setVisible(true);
        view.addListener((ActionListener) this);
        client=null;
        
    }
    public class WriteOutput extends Thread {

        @Override
        public void run() {
            String inputan;
            try {
                while ((inputan = client.readStream()) != null) {
                    view.setTxAreaChat(inputan);
                }
            } catch (IOException E) {
                System.out.println("Error");
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source.equals(view.getTxFieldChat())) {
            if (client == null) {
                try {
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    WriteOutput w = new WriteOutput();
                    w.start();
                } catch (IOException E) {
                    System.out.println("Error");
                }
            } else {
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTxFieldChat("");
            }
        }
}
    
}
