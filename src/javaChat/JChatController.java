package javaChat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.text.View;

public class JChatController implements ActionListener {

    private ChatView view;
    private ClientConnection client;

    public JChatController() {
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }

    public class WriteOutput extends Thread {

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
                }
                catch (IOException E){
                    System.out.println("Error");
                }
            }
            else {
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTxFieldChat("");
            }
        }
    }
}
