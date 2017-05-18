/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsoleApp;

import javaChat.ClientConnection;

/**
 *
 * @author praanggi
 */
public class ConsoleApplication {
    
    private ClientConnection client;
    
    public class ReadInput extends Thread{
        
        public void run(){
            
            try {
              String inputKeyboard;
              do {
                  System.out.println(">> ");
                  inputKeyboard = client.inputString();
                  client.writeStream(inputKeyboard);
              } while(!inputKeyboard.equals("Quit"));
              client.disconnect();
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
    
    public class WriteInput extends Thread{
       
        public void run(){
            
            try {
                String inputan;
                while ((inputan = client.readStream()) != null){
                    System.out.println(inputan);
                    System.out.println(">>");
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
    
    public void startChat(){
        try {
            client = new ClientConnection();
            System.out.println("Input server IP : ");
            String ip =  client.inputString();
            client.connect(ip);
            ReadInput in = new ReadInput();
            WriteInput out = new WriteInput();
            in.start();
            out.start();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}