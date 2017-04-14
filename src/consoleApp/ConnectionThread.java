/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleApp;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaChat.Connection;

/**
 *
 * @author SagabAdi
 */
public class ConnectionThread {
    private Socket client;
    private Connection connection;
   
    public ConnectionThread (Socket newClient ) throws IOException{
        this.client = newClient;
        connection = new Connection(client);
    }
    public void run () {
        try {
            connection.startChat("Strat the Chat-----");
            System.out.println("-----------");
            System.out.println("new client connected");
            System.out.println("client information : ");
            System.out.println(connection.getClientInformation());
            String inputan;
            String message;
            while ((inputan = connection.readStream())!= null && !inputan.equals("quit")){
                message = "Client " + connection.getIpClient() + "said : " + inputan;
                System.out.println(message);
                connection.sendToAll(message);
            }
            message = "Client from IP : " + connection.getIpClient() + "Quit from chat room ";
            System.out.println(message);
            connection.sendToAll(message);
            connection.disconnect();
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }
}
