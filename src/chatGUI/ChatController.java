/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatGUI;

import java.awt.event.ActionEvent;
import javaChat.ClientConnection;
import java.awt.event.ActionListener;

/**
 *
 * @author FebbyFebriansyah
 */
public class ChatController implements ActionListener {

    private ChatView view;
    private ClientConnection client = null;

    public class WriteOutput extends Thread {

        public void run() {
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    view.setTxAreaChat(inputan);
                }
            } catch (Exception e) {
                System.out.println("Exception message : " + e.getMessage());
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
        if (client == null) {
            try {
                //kalo nanti ada error mungkin di instansiasi client ini
                client = new ClientConnection();
                String ip = view.getStringChat();
                client.connect(ip);
                WriteOutput w = new WriteOutput();
                w.start();
            } catch (Exception e) {
                System.out.println("Exception message : " + e.getMessage());
            }
        }
        else{
            String input = view.getStringChat();
            client.writeStream(input);
            view.setTxFieldChat("");
        }
    }
}
