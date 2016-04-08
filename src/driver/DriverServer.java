package driver;

import consoleApp.ConnectionThread;
import javaChat.ServerConnection;

/**
 *
 * @author g40
 */

public class DriverServer {

    public static void main(String[] args){
        try {
            ServerConnection server = new ServerConnection();
            System.out.println("Server Information \n"
                    + server.getServerInformation()
            );
            
            while(true){
                ConnectionThread connection = 
                        new ConnectionThread(server.getClient());
                connection.start();
            }
            
        }catch(Exception e) {
            System.out.println("Error log : " + e);
        }
    }
}
