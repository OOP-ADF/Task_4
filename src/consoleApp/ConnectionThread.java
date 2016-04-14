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
 *
 * @author Adrian G Nurcahyo
 */
public class ConnectionThread {
    private Socket client;
    private Connection connection;
    
    
    public ConnectionThread(Socket newClient) throws IOException
    {
        this.client = newClient;
        connection = new Connection(client);
    }
    
    public void run()
    {
        try 
        {
            connection.startChat("Start the Chat");
            System.out.println("==============");
            System.out.println("New client connected");
            System.out.println("Client information");
            System.out.println(connection.getClientInformation());
            String inputan;
            String message;
            while ((inputan = connection.readStream()) !=null && !inputan.equals("quit"))
            {
                message = "Client " + connection.getIpClient() + "said : " + inputan;
                System.out.println(message);
                connection.sendToAll(message);
            }
            message = "Client from ip : " +connection.getIpClient() + " quit the chat room";
            System.out.println(message);
            connection.sendToAll(message);
            connection.disconnect();
        }
        catch (IOException ex)
        {
            System.out.println("Error : " + ex.getMessage());
        }
    }

    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
