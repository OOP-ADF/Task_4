/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleApp;

import java.io.IOException;
import javaChat.ClientConnection;


public class ConsoleApplication {
        private ClientConnection client;
        public void startChat(){
            
        }
        class ReadInput{
            public void run(){
                try{
                    String inputKeyboard;
                    do{
                        System.out.println(">>");
                        inputKeyboard = client.inputString();
                        client.writeStream(inputKeyboard);
                    }while (!inputKeyboard.equals("quit"));
                    client.disconnect();
                }
                catch(IOException e){
                    System.out.println("Error");
                }
            }
                    
        }
        class WriteOutput{
            public void run(){
                try{
                    client = new ClientConnection();
                    System.out.println("input server IP : ");
                    String ip = client.inputString();
                    client.connect(ip);
                    ReadInput in = new ReadInput();
                    WriteOutput out = new WriteOutput();
                    in.run();
                    out.run();
                }
                catch(IOException e){
                    System.out.println("Error");
                }
            }
        }
}
    


