

package consoleApp;

import java.io.IOException;
import java.net.Socket;
import javaChat.Connection;

public class ConnectionThread {
    private Socket client;
    private Connection connection;

    public ConnectionThread(Socket newClient) throws IOException {
        this.client = newClient;
        connection= new Connection(client);
    }
    
    public void run() throws IOException{
        try{
            connection.startChat("Start the Chat");
            
            System.out.println("-----------");
            System.out.println("newclient connected");
            System.out.println("client information:");
            System.out.println(connection.getClientInformation());
            
            String inputan;
            String message;
            while((inputan=connection.readStream()) != null && !inputan.equals("quit") ){
                message = "client "+connection.getIpClient() 
                        +"said : "+inputan;
                System.out.println(message);
                connection.sendToAll(message);
            }
            
            message = "client from ip : "+connection.getIpClient()
                    +"quit the char room";
            System.out.println(message);
            connection.sendToAll(message);
            connection.disconnect();
            
        }catch (IOException E){
            System.out.println("Error");
        }
        
    }
    
    
    
    
}
