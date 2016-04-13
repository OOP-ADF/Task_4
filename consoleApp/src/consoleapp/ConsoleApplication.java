/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleapp;
import javaChat.ClientConnection;
/**
 *
 * @author Fatima Nurshafarani
 */
public class ConsoleApplication {
    private ClientConnection client;
    public void startChat(){
        try{
            client = new ClientConnection();
            System.out.println("inpt server IP : ");
            String ip = client.inputString();
            client.connect(ip);
            ReadInput in = new ReadInput();
            WriteOutput out = new WriteOutput();
            in.start();
            out.start();
        }catch(Exception ex){
            System.out.println("Pesan Error"+ex);
        }
    }

    public class ReadInput extends Thread{
        public void run(){
            try{
                String inputKeyboard;
                do{
                    System.out.println(">> ");
                    inputKeyboard = client.inputString();
                    client.writeStream(inputKeyboard);
                } while(!inputKeyboard.equals("quit"));
                client.disconnect();
            }catch(Exception ex){
                System.out.println("Pesan Error"+ex);
            }
        }
    }
    public class WriteOutput extends Thread{
        public void run(){
            try{
                String inputan;
                while((inputan = client.readStream()) != null){
                    System.out.println(inputan);
                    System.out.println(">> ");
                }
            }catch(Exception ex){
                System.out.println("Pesan Error"+ex);
            }
        }
    }
}
