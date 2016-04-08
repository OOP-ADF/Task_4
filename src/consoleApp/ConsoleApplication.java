package consoleApp;

import javaChat.ClientConnection;

/**
 *
 * @author g40
 */

public class ConsoleApplication {

    private ClientConnection client;
    
    public void startChat(){
        try {
            client = new ClientConnection();
            System.out.print("Input server IP : ");
            String ip = client.inputString();
            client.connect(ip);
            
            ReadInput in = new ReadInput();
            WriteOutput out = new WriteOutput();
            in.start();
            out.start();
            
        } catch(Exception e){
            System.out.println("error log : " + e);
        }
        
    }
    
    class ReadInput extends Thread{
        @Override
        public void run(){
            try {
                String inputKeyboard;
                do {
                    System.out.print(">> : ");
                    inputKeyboard = client.inputString();
                    client.writeStream(inputKeyboard);
                    
                } while (!inputKeyboard.equals("quit"));
                client.disconnect();
            } catch (Exception e) {
                System.out.println("error log : " + e);
            }
        }
    }
    
    class WriteOutput extends Thread{
        @Override
        public void run(){
            try {
                String input;
                while ((input = client.readStream()) != null){
                    System.out.println(input);
                    System.out.print(">> : ");
                }
            } catch(Exception e){
                System.out.println("error log : " + e);
            }
        }
    }
    
}
