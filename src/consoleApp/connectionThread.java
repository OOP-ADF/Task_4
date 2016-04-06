/*
 * Rizma Nurviarelda (1301144229)
 * IF-38-09
 */
package consoleApp;

import java.io.IOException;
import java.net.Socket;
import javaChat.Connection;

public class connectionThread {
    private Socket client;
    private Connection connection;
    
    public connectionThread (Socket newClient) throws IOException {
        this.client = newClient;
        connection = new Connection(client);
    }
    
    public void run() throws IOException {
        try{
        connection.startChat("Start The Chat");
        System.out.println("-------------");
        System.out.println("New Client Connected");
        System.out.println(connection.getClientInformation());
        String inputan;
        String message;
        while ((inputan = connection.readStream()) != null && !inputan.equals("quit")) {
            message = "Client " + connection.getIpClient() + " said: " +inputan;
            System.out.println(message);
            connection.sendToAll(message);
        }
        
        message = "Client from IP: " + connection.getIpClient() + "Quit the Chat Room";
        System.out.println(message);
        connection.sendToAll (message);
        connection.disconnect();
        }
    catch (Exception e){
        System.out.println("Error");
    }
    }

    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
