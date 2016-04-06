/*
 * Fauzy Alfy A. (1301144269)
 * IF-38-09
 */
package consoleApp;

import javaChat.ClientConnection;

/*
 * @author Eggy
 */
public class ConsoleApplication {

    ClientConnection client;

    public class ReadInput extends Thread {

        public void run() {
            try {
                String inputKeyboard;
                do {
                    System.out.println(">> ");
                    inputKeyboard = client.inputString();
                    client.writeStream(inputKeyboard);
                } while (!inputKeyboard.equals("quit"));
                client.disconnect();
            } catch (Exception e) {
                System.out.println("Error system : " + e.getMessage());
            }
        }
    }

    public class WriteOutput extends Thread {
        public void run() {
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    System.out.println(inputan);
                    System.out.println(">> ");
                }
            } catch (Exception e) {
                System.out.println("Error system : " + e.getMessage());
            }
        }
    }

    public void startChat() {
        try {
            client = new ClientConnection();
            System.out.println("input server IP : ");
            String ip = client.inputString();
            client.connect(ip);
            ReadInput in = new ReadInput();
            WriteOutput out = new WriteOutput();
            in.start();
            out.start();
        } catch (Exception e) {
            System.out.println("Error system : " + e.getMessage());
        }
    }
}
