/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatGUI;

/**
 *
 * @author Adzan
 */
import java.awt.event.ActionEvent;
import javaChat.ClientConnection;
import java.awt.event.ActionListener;

public class ChatController {
    private ChatView view;
    private ClientConnection client = null;
    
    public ChatController() {
        view = new ChatView();
        view.setVisible(true);
        view.addListener((ActionListener) this);
        client = null;
    }
    
    public class WriteOutput extends Thread{
        @Override
        public void run() {
            try {
                String inputan;
                while((inputan = client.readStream()) != null){
                    view.setTxAreaChat(inputan);
                }
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.getTxFieldChat()) {
            if (client == null) {
                try {
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    WriteOutput w = new WriteOutput();
                    w.start();
                } catch(Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTxFieldChat("");
            }
        }
    }
}
