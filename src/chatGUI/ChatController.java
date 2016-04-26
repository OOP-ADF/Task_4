/*
 * To change this template, choose Tools | Templates
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
 * @author Ekaaaa 
 * NIM 1301144312 
 * Kelas IF - 38 -02
 */
public class ChatController implements ActionListener {

    private ChatView view;
    private ClientConnection client = null;

    class WriteOutput extends Thread {

        public void run() {
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    view.setTextAreaChat(inputan);
                }
            } catch (IOException ex) {
                Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);

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
        if (source instanceof JTextField) {
            if (client == null) {
                try {
                    client = new ClientConnection();
                    
                    String ip = view.getStringChat();
                    client.connect(ip);

                    WriteOutput w = new WriteOutput();
                    w.start();

                    String input = view.getStringChat();
                    client.writeStream(input);

                    view.setTextFieldChat(" ");
                } catch (IOException ex) {
                    Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTextFieldChat(" ");
            }
        }
    }
}