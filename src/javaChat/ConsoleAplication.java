/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaChat;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kukuh Sanddi
 */
public class ConsoleAplication {
    private ClientConnection client;
    
    public class ReadInput extends Thread{
        @Override
        public void run(){
            try {
                String inputKeyboard;
                do {
                    System.out.println(">> ");
                    inputKeyboard = client.inputString();
                    client.writeStream(inputKeyboard);
                } while (!inputKeyboard.equals("quit"));
                client.disconnect();
            } catch (Exception e) {
                System.out.println("Inputan anda salah");
            }
        }
    }
    
    public class WriteInput extends Thread {
        @Override
        public void run(){
            String inputan;
            try {
                while ((inputan = client.readStream()) != null){
                    System.out.println(inputan);
                    System.out.println(">> ");
                            }
            } catch (IOException ex) {
                System.out.println("Error!!");
            }
        }
    
    }
    
    public void startChat(){
        try {
            client = new ClientConnection();
            System.out.println("input server ip : ");
            String ip = client.inputString();
            client.connect(ip);
            
            ReadInput in = new ReadInput();
            WriteInput out = new WriteInput();
            in.start();
            out.start();
        } catch (IOException e) {
            System.out.println("Error!!");
        }
    }
}
