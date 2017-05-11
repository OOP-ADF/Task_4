
package Model;

import javaChat.ClientConnection;

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
              } while(!inputKeyboard.equals("quit"));
              client.disconnect();
            } catch (Exception x) {
                System.out.println("Error...");
            }
        }
    }
    
    public class WriteInput extends Thread{
       
        public void run(){
            
            try {
                String inputan;
                while ((inputan = client.readStream()) != null){
                    System.out.println(inputan);
                    System.out.println(">> ");
                }
            } catch (Exception x) {
                System.out.println("Error...");
            }
        }
    }
    
    public void startChat(){
        try {
            client = new ClientConnection();
            System.out.println("input server IP : ");
            String ip =  client.inputString();
            client.connect(ip);
            ReadInput in = new ReadInput();
            WriteInput out = new WriteInput();
            in.start();
            out.start();
        } catch (Exception x) {
            System.out.println("Error...");
        }
    }
}
