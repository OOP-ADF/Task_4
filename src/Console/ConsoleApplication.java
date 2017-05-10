/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;
import javaChat.ClientConnection;

/**
 *
 * @author Alwi faisal
 */
public class ConsoleApplication {
     private ClientConnection client;
   
    public void startChat() {
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
            System.out.println("Error : " + e.getMessage());
        }
        
        
    }
    
    public class ReadInput extends Thread{
        
        @Override
        public void run() {
           try {
                String inputKey;
                do {
                    System.out.println(">> ");
                    inputKey = client.inputString();
                    client.writeStream(inputKey);
                } while (!inputKey.equals("quit"));
                client.disconnect();
                
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
    
    public class WriteOutput extends Thread{
        
        @Override
        public void run() {
            try {
                String input;
                while ((input = client.readStream()) != null) {
                    System.out.println(input);
                    System.out.println(">> ");
                }
                
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
}
    

