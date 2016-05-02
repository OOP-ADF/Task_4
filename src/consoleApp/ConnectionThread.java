/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleApp;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaChat.Connection;
import javaChat.Connection;

/**
 *
 * @author Guntur
 */
public class ConnectionThread extends Thread{
    private Socket client;
    private Connection connection;
    
    public ConnectionThread(Socket newClient) throws IOException {
        this.client = newClient;
        connection = new Connection(client);
    }
    
    
    
    public void ConnectionThread(Socket newClient) throws IOException{
        
    }
    public void run(){
        try {
            String inputan;
            String message;
            connection.startChat("start the chat");
            System.out.println("-----------------");
            System.out.println("new client connected");
            System.out.println("client information : ");
            System.out.println(connection.getClientInformation());
            while((inputan = connection.readStream()) != null
                    && !inputan.equals("quit")){
                message = "Client "+ connection.getIpClient()
                        + " said : "+inputan;
                System.out.println(message);
                connection.sendToAll(message);
                //connection.readStream();
                connection.disconnect();
            }
        } catch (IOException ex) {
            Logger.getLogger(ConnectionThread.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR");
        }
    }
}
