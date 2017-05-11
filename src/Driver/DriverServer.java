
package Driver;

import Model.ConnectionThread;
import javaChat.ServerConnection;
import java.io.IOException;

public class DriverServer {
    
    public static void main(String[] args) {
        
        try {
            ServerConnection server = new ServerConnection(); 
            System.out.println("Server Information");  
            System.out.println(server.getServerInformation()); 
            while (true) { 
                ConnectionThread connection = new ConnectionThread(server.getClient());  
                connection.start();  
            } 
        } catch (Exception x) {
            System.out.println("Error...");
        }
    }
}
