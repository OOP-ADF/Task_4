/*
 * Fauzy Alfy A. (1301144269)
 * IF-38-09
 */
package chatGUI;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import javaChat.ClientConnection;
import java.awt.event.ActionListener;
/*
 * @author Eggy
 */
public class ChatController implements ActionListener {
    private ChatView view;
    private ClientConnection client = null;
    
    public ChatController() {
        view = new ChatView();
        view.setVisible(true);
        view.addListener(this);
        client = null;
    }
    
    public class WriteOutput extends Thread {
        public void run() {
            try {
                String inputan;
                while((inputan = client.readStream()) != null) {
                    view.setTxAreaChat(inputan);
                }
            } catch (Exception e) {
                
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.getTxFieldChat()) {
            if(client == null) {
                try {
                    client = new ClientConnection();
                    String ip = view.getStringChat();
                    client.connect(ip);
                    WriteOutput w = new WriteOutput();
                    w.start();
                } catch (Exception e) {
                    System.out.println("Error sistem : "+e.getMessage());
                }
            } else {
                String input = view.getStringChat();
                client.writeStream(input);
                view.setTXFieldChat("");
            }
        }
    }
    
    
}
