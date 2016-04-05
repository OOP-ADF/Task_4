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
    public void startChat(){
        
    }
    class ReadInput extends Thread{
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
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Missing argument");
            }
        }
    }
    
    class WriteOutput extends Thread{
        run();
    }
}
