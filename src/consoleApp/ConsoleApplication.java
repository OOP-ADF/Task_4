package consoleApp;

import java.io.IOException;
import javaChat.ClientConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * File Description
 *
 * @author Afnizar Nur Ghifari <afnizarhilmi@gmail.com>
 * @since May 6, 2017
 */
public class ConsoleApplication {

    private ClientConnection client;

    public class ReadInput extends Thread {

        public void run() {
            try {
                String inputKeyboard;
                do {
                    System.out.println("> ");
                    inputKeyboard = client.inputString();
                    client.writeStream(inputKeyboard);
                } while (!inputKeyboard.equals("Quits"));
                client.disconnect();
            } catch (IOException ex) {
                System.out.println("Some error has been occured");
            }
        }
    }

    public class WriteOutput extends Thread {

        public void run() {
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    System.out.println(inputan);
                    System.out.println("> ");
                }
            } catch (IOException ex) {
                System.out.println("Some error has been occured");
            }
        }
    }

    public void startChat() {
        try {
            client = new ClientConnection();
            System.out.println("Input Server IP Address : ");
            String ip = client.inputString();
            client.connect(ip);
        } catch (IOException ex) {
            System.out.println("Some error has been occured");
        }
        ReadInput in = new ReadInput();
        WriteOutput out = new WriteOutput();
        in.start();
        out.start();
    }

}
