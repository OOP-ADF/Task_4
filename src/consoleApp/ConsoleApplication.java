package consoleApp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaChat.ClientConnection;

/**
 *
 * @author Diah Ajeng
 */
public class ConsoleApplication {

    private ClientConnection client;

    public class ReadInput extends Thread{
         public void run (){
             try {
                 String inputKeyboard;
                 do {
                     System.out.println(">> ");
                     inputKeyboard = client.inputString();
                     client.writeStream(inputKeyboard);
                 } while (! inputKeyboard.equals("quit"));
                 client.disconnect();
             } catch (IOException ex) {
                 System.out.println("Error");
             }
         }
    }
    
    public class WriteOutput extends Thread{
        public void run (){
            try {
                String inputan;
                while ((inputan = client.readStream()) != null){
                    System.out.println(inputan);
                    System.out.println(">> ");
                }
            } catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }

    public void startChat() {
        try {
            client = new ClientConnection();
            System.out.println("input server IP : ");
            String ip = client.inputString();
            client.connect(ip);
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
        ReadInput in = new ReadInput();
        WriteOutput out = new WriteOutput();
        in.start();
        out.start();
    }
    
}
