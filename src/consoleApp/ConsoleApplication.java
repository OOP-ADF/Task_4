//Irvan Nur Apendi IF-39-12 1301154208
package consoleApp;

import java.io.IOException;
import javaChat.ClientConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IRFAN
 */
public class ConsoleApplication {
    private ClientConnection client;
    
    public class ReadInput extends Thread {
        public void run(){
            try {
                String inputKeyboard;
                do {
                    System.out.print(">> ");
                    inputKeyboard = client.inputString();
                    client.writeStream(inputKeyboard);
                } while (!inputKeyboard.equals("quit"));
                client.disconnect();
            } catch (IOException e) {
                System.out.println("error");
            }
        }
    }
    
    public class WriteOutput extends Thread{
        public void run(){
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    System.out.println(inputan);
                    System.out.print(">> ");
                }
            } catch (IOException e) {
                System.out.println("error");
            }
        }
    }
    
    public void startChat(){
        try {
            client = new ClientConnection();
            System.out.print("input server IP : ");
            String ip = client.inputString();
            client.connect(ip);
            ReadInput in = new ReadInput();
            WriteOutput out = new WriteOutput();
            in.start();
            out.start();
        } catch (IOException e) {
            System.out.print("error");
        }
    }
}
