/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatGUI;
import consoleApp.ConsoleApplication.WriteOutput;
import java.awt.event.ActionEvent;
import javaChat.ClientConnection;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 * @author Manda
 */
public class ChatController implements ActionListener {

    private ChatView view;
    private ClientConnection client;

    public ChatController() {
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }

    class WriteOutput extends Thread {
        public void run() {
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    view.setTxAreaChat(inputan);
                }
            } catch (Exception e) {
                System.out.println("Ada error atau masalah teknis");
            }
        }
    }
    
    @Override
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
                } catch (Exception e) {
                    System.out.println("Ada error atau masalah teknis");
                }
            }
            else {
                String input = view.getStringChat();
                client.writeStream(input);
            }
        }
        view.setTxFieldChat("");
    }

    
}