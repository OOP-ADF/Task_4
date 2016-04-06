/*
 * Rizma Nurviarelda (1301144229)
 * IF-38-09
 */
package Driver;

/**
 *
 * @author ASUS
 */

import consoleApp.connectionThread;
import javaChat.ServerConnection;

public class DriverServer {
    public static void main(String[] args) {
        try {
            ServerConnection server = new ServerConnection();
            System.out.println("Server Information");
            System.out.println(server.getServerInformation());
            
            while (true) {
                connectionThread connection = new connectionThread(server.getClient());
                connection.start();
            }
        } catch (Exception e) {
            System.out.println("Error System : "+e.getMessage());
        }
    }
}
