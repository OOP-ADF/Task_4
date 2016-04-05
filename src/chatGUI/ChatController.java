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
 * @author Lenovo
 */
public class ChatController implements ActionListener {
    private ChatView view;
    private ClientConnection client = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class WriteOutput extends Thread {
        public void run(){
            try {
                String inputan;
                while ((inputan = client.readStream())!= null){
                    view.setTxAreaChat(inputan);
                }
            } catch (IOException ex) {
                Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ChatController(){
        view = new ChatView();
        view.setVisible(true);
        client = null;
        view.addListener(this);
    }
    public void actionerformed(ActionEvent ae){
        Object source = ae.getSource();
        if(source instanceof JTextField) {
            if(client == null){
                try {
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    
                    WriteOutput w = new WriteOutput();
                    w.start();
                    String input = view.getStringChat();
                    client.writeStream(input);
                    view.setTxFieldChat("");
                } catch (IOException ex) {
                    Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                WriteOutput w = new WriteOutput();
                w.start();
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTxFieldChat("");
            }
        }
    }
}
