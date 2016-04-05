/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consuleApp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javaChat.ClientConnection;

/**
 *
 * @author widodo
 */

public class ConsoleApplication {
    private ClientConnection client;
    
    class ReadInput extends Thread {
        @Override
        public void run() {
            try {
                String inputKeyboard;
                
                do {                    
                    System.out.println(">>");
                    inputKeyboard = client.inputString();
                    client.writeStream(inputKeyboard);
                } while (!inputKeyboard.equals("quit"));
                client.disconnect();
            } catch (Exception e) {
                Logger.getLogger(ConsoleApplication.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    class WriteOutput extends Thread {
        @Override
        public void run() {
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    System.out.println(inputan);
                    System.out.println(">>");
                }
            } catch (Exception e) {
                Logger.getLogger(ConsoleApplication.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public void startChat(){
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
            Logger.getLogger(ConsoleApplication.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
