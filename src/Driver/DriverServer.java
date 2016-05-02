/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;
import consoleApp.ConnectionThread;
import java.io.IOException;
import javaChat.ServerConnection;
/**
 *
 * @author Guntur
 */
public class DriverServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerConnection server = new ServerConnection();
            System.out.println("Server Information");
            System.out.println(server.getServerInformation());
            while(true) {
                ConnectionThread connection = new ConnectionThread(server.getClient());
                connection.start();
            }
        } catch (IOException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }
    
}
