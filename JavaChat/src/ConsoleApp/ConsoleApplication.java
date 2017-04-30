/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsoleApp;

import java.io.IOException;
import javachat.ClientConnection;
import javachat.Connection;

/**
 *
 * @author Nindia Cahyaning Putri
 * 1301154567
 * IF3907
 */
public class ConsoleApplication {
    private ClientConnection client;
    public class ReadInput extends Thread{
        @Override
        public void run(){
            try{
                String inputKeyboard;
                do{
                    System.out.println(">>");
                    inputKeyboard = client.inputString();
                    client.writeStream(inputKeyboard);
                } while (!inputKeyboard.equals("quit"));
                client.disconnect();
                
            }catch (IOExpection E){
                System.out.println("error");
                }
            }
        }
    
    public class WriteOutput extends Thread{
        @Override
        public void run(){
            try{
                String inputan;
                while ((inputan = client.readStream()) !=null){
                    System.out.println(inputan);
                    System.out.println(">>");
                }
            } catch (IOException E){
                System.out.println("error");
            }
        }
    }
    public void StarChat(){
        try{
            client = new Connection();
            System.out.println("Input server IP: ");
            String ip = client.inputString();
            client.connect(ip);
            ReadInput in = new ReadInput();
            WriteOutput out = new WriteOutput();
            in.start();
            out.start();
        }catch(IOException E){
            System.out.println("error");
        }
    }
}
