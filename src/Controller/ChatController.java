/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import chatGUI.ChatView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javaChat.ClientConnection;

/**
 *
 * @author Ulid
 */
public class ChatController implements ActionListener {

    private ChatView view;
    private ClientConnection client = null;

    class WriteOutput extends Thread {

        public void run() {
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    view.setTxtAreaChat(inputan);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(view, e.getMessage());
            }
        }
    }

    public ChatController() {
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getTxtFieldChat())){
            try{
                client = new ClientConnection();
                String ip = view.getStringChat();
                client.connect(ip);
                
                WriteOutput w = new WriteOutput();
                w.start();
            }catch(Exception e){
                JOptionPane.showMessageDialog(view, e.getMessage());
            }
        }else {
            String input = view.getStringChat();
            client.writeStream(input);
            view.setTxtFieldChat("");
        }
    }

}
