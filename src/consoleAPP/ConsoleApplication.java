/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleAPP;

/**
 *
 * @author AGUNG
 */
import java.io.IOException;
import java.net.Socket;
import javaChat.ClientConnection;

public class ConsoleApplication {
    private ClientConnection client;
    
    class ReadInput extends Thread{
        @Override
        public void run() {
            try{
                String inputKeyboard;
                do{
                    System.out.println(">> ");
                    inputKeyboard = client.inputString();
                    client.writeStream(inputKeyboard);
                } while (!inputKeyboard.equals("quit"));
                client.disconnect();
            } catch (IOException ex) {
                System.out.println("Pesan Error");
            }
               
        }
    }
    
    class WriteOutput extends Thread{
        public void run(){
            try{
                String inputan;
                while ((inputan = client.readStream()) != null){
                    System.out.println(inputan);
                    System.out.print(">> ");
                }
            } catch(IOException ex) {
                System.out.println("Pesan Error");
            }
        }
    }
    
    public void startChat(){
        try{
            client = new ClientConnection();
            System.out.print("Input server IP : ");
            String ip = client.inputString();
            client.connect(ip);
            ReadInput in = new ReadInput();
            WriteOutput out = new WriteOutput();
            in.start();
            out.start();
        } catch (IOException ex) {
            System.out.println("Pesan Error");
        }
    }
}
