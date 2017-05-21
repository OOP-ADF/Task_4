/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleApp;

/**
 *
 * @author ichank
 */
import javaChat.ClientConnection;

public class ConsoleApplication extends Thread {

    private ClientConnection client;

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
                System.out.println(" Error :" + e.getMessage());
            }

        }
    }

    public class WriteInput extends Thread {

        public void run() {
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    System.out.println(inputan);
                    System.out.println(">> ");
                }
            } catch (Exception e) {
                System.out.println(" Error :" + e.getMessage());
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
            WriteInput out = new WriteInput();
            in.start();
            out.start();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
