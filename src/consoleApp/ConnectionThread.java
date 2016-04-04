/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleApp;

import java.io.IOException;
import java.net.Socket;
import javaChat.Connection;

/**
 * @author Andi Akhmad Fauzi, 1301144009, IF-38-09
 * 
 */
public class ConnectionThread extends Thread{
    private Socket client;
    private Connection connection;
    
    public ConnectionThread(Socket newClient) throws IOException {
        this.client = newClient;
        connection = new Connection(client);
    }
    
    @Override
    public void run() {
        try {
            connection.startChat("start the chat");
            System.out.println("--------------");
            System.out.println("new client connected");
            System.out.println("client information : ");
            System.out.println(connection.getClientInformation());
            
            String userInput;
            String message;
            while ((userInput = connection.readStream()) != null && !userInput.equals("quit")) {
                message = "Client " + connection.getIpClient()
                        + " said : " + userInput;
                System.out.println("message");
                connection.sendToAll(message);
            }
            message = "Client from IP : " + connection.getIpClient()
                    + "Quit the chat room";
            System.out.println(message);
            connection.sendToAll(message);
            connection.disconnect();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
