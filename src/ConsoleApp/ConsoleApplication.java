/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsoleApp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaChat.ClientConnection;

/**
 *
 * @author HP
 */
public class ConsoleApplication {
    ClientConnection client;
    public void startChat(){
        try {
            client = new ClientConnection();
            System.out.println("inputan server IP : ");
            String ip = client.inputString();
            client.connect(ip);
            ReadInput in = new ReadInput();
            WriteOutput out = new WriteOutput();
            in.start();
            out.start();
        } catch (IOException ex) {
            Logger.getLogger(ConsoleApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public class ReadInput extends Thread{
        public void run(){
           try {
                String inputankeyboard;
                do{
                    System.out.println(">> ");
                    inputankeyboard = client.inputString();
                }while(!inputankeyboard.equals("quit"));
            
                client.disconnect();
            } catch (IOException ex) {
                Logger.getLogger(ConsoleApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public class WriteOutput extends Thread{
        public void run(){
            String inputan;
            try {
                while((inputan = client.readStream())!=null){
                    System.out.println(inputan);
                    System.out.println(">> ");
                }
            } catch (IOException ex) {
                Logger.getLogger(ConsoleApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
