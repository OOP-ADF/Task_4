/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleApp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaChat.ClientConnection;

/**
 *
 * @author Hirianinda M.S
 */
public class ConsoleApplication extends Thread {
    private ClientConnection client;
    
    public void startChat() {
        try {
            client = new ClientConnection();
            System.out.println("input server IP: ");
            String ip = client.inputString();
            client.connect(ip);
            
            ReadInput in = new ReadInput();
            WriteOutput out = new WriteOutput();
            in.start();
            out.start();
        } catch (IOException ex) {
            Logger.getLogger(ConsoleApplication.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error ");
        }
    }
    
    class ReadInput extends Thread {
        
        public void run() {
            try {
                String inputKeyboard;
                do {
                    System.out.println(">> ");
                    inputKeyboard = client.inputString();
                } while (!inputKeyboard.equals("quit"));
                client.disconnect();
            } catch (IOException ex) {
                Logger.getLogger(ConsoleApplication.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error");
            }
        }
    }
    
    class WriteOutput extends Thread {
        
        public void run() {
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {
                    System.out.println(inputan);
                    System.out.println(">> ");
                }
            } catch (IOException ex) {
                Logger.getLogger(ConsoleApplication.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error");
            }
        }
    }
}
