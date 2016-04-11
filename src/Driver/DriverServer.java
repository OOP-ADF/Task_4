package Driver;

import ConsoleApp.ConnectionThread;
import javaChat.ServerConnection;

/**
 * 
 * 
 * 
 */
public class DriverServer {
    public static void main(String[] args) {
       try {
           ServerConnection server = new ServerConnection();
           System.out.println("Server Information");
           System.out.println(server.getServerInformation());
           while (true) {
               ConnectionThread connection
                       = new ConnectionThread(server.getClient());
               connection.start();
           }
       } catch(Exception e) {
           System.out.println("Exception occurred: " + e.getMessage());
       }
    }
}