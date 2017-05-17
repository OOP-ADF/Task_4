package Driver;

import Console.ConecThread;
import javaChat.ServerConnection;

/**
 *
 * @author abdulnursahid
 */
public class Driverserver {
    
    public static void main(String[] args) {
        try {
            ServerConnection server = new ServerConnection(); 
            System.out.println("Server Information");  
            System.out.println(server.getServerInformation()); 
            while (true) { 
                ConecThread connection = new ConecThread(server.getClient());  
                connection.start();  
            } 
            
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
