/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleApp;

/**
 *
 * @author friendly halomoan sipayung
 */
import java.io.IOException;
import java.net.Socket;
import javaChat.Connection;

public class ConnectionThread extends Thread {

    private Socket client;
    private Connection connection;

    public ConnectionThread(Socket newclient) throws IOException {
        this.client = newclient;
        connection = new Connection(client);
    }

    public void run() {
        
        try {
            connection.startChat("start the chat");
            System.out.println("--------------");
            System.out.println("new client connected");
            System.out.println("client information");
            System.out.println(connection.getClientInformation());
            
            String inputan;
            String message;
            while ((inputan = connection.readStream()) != null &&!inputan.equals("quit")) {
                    
                message = "Client "+connection.getIpClient()
                        + " said : " + inputan;
                
                System.out.println(message);
                connection.sendToAll(message);
            }
            message = "Client from IP : "+ connection.getIpClient() 
                    + "Quit the chat room";
            System.out.println(message);
            connection.sendToAll(message);
            connection.disconnect();
            
            } catch (IOException ex) {
            System.out.println("error : "+ex );
        }
        } 
}
