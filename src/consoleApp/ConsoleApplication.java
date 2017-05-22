/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleApp;

import java.io.IOException;
import javaChat.ClientConnection;
import java.util.logging.Logger;
import java.util.logging.Level;
import javaChat.ClientConnection;

/**
 *
 * @author Nisa N
 */
public class ConsoleApplication extends Thread{
    private ClientConnection client;
    
    public class ReadInput extends Thread{
        public void run(){
            try {
                String inputKeyBoard;
                do{
                    System.out.println(">>");
                    inputKeyBoard = client.inputString();
                    client.writeStream(inputKeyBoard);
                } while(! inputKeyBoard.equals("Quit"));
                client.disconnect();
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }
    
    public class WriteInput extends Thread{
        public void run(){
            try {
                String inputan;
                while ((inputan = client.readStream()) != null) {                    
                    System.out.println(inputan);
                    System.out.println(">>");
                }
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
    
    public void startChat(){
        try {
            client = new ClientConnection();
            System.out.println("Input Server IP : ");
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