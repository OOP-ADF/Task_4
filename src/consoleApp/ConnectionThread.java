package consoleApp;

import java.io.IOException;
import java.net.Socket;
import javaChat.Connection;

/**
 *
 * @author g40
 */

public class ConnectionThread extends Thread {
    
    private Socket client;
    private Connection connection;
    
    public ConnectionThread(Socket newClient){
        this.client = newClient;
        try {
            connection = new Connection(client);
        } catch(Exception e){
            System.out.println("error log : " + e);
        }
    }
    
    public void run(){
        try {
            connection.startChat("Start the Chat!");
            System.out.println("-----------------\n"
                    + "New client connected\n"
                    + "Client Information : \n"
                    + connection.getClientInformation()
            );

            String textInput;
            String message;
            while(true){
                textInput = connection.readStream();
                if(textInput.equals("quit") || textInput == null ){
                    break;
                }
                message = "Client " + connection.getIpClient() + 
                        " said : " + textInput;
                System.out.println(message);
                connection.sendToAll(message);
            }
            
            message = "Client from IP : " + connection.getIpClient() + 
                    "Quit the chat room";
            System.out.println(message);
            connection.sendToAll(message);
            connection.disconnect();
            
        } catch(IOException ioe){
            System.out.println("error log : " + ioe);
        }
    }
    
}
