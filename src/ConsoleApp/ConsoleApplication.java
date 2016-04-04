package ConsoleApp;

import javaChat.ClientConnection;


/**
 *
 * @author Thoriq
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
        }catch(Exception e){
            System.out.println("Error - "+e);
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
            }catch(Exception e){
                System.out.println("Error -"+e);
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
            }catch(Exception e){
                System.out.println("Error -"+e);
            }
        }
    }
}