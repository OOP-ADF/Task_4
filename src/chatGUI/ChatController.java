package chatGUI;

/**
 *
 * @author Hizas
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaChat.ClientConnection;

public class ChatController implements ActionListener  {
    private ChatView view;
    private ClientConnection client = null;
    public ChatController(){
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source instanceof ActionListener) {
            if(client == null){
                try {
                    String ip = view.getStringChat();
                    client.connect(ip);
                    WriteOutput w = new WriteOutput();
                    w.start();
                }
                catch(Exception e) {
                    System.out.println("Error!");
                }
            }
            else {
                String input = view.getStringChat();
                client.writeStream(input);
            }
            view.setTxFieldChat("");
        }
    }
    class WriteOutput extends Thread {
        @Override
        public void run(){
            try {
                String inputan;
                while((inputan = client.readStream()) != null){
                    view.setTxAreaChat(inputan);
                }
            }
            catch(Exception e){
                System.out.println("Error!");
            }
        }
    }
    
    
}
