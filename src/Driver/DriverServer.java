/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;


import ConsoleApp.connectionThread;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaChat.ServerConnection;

/**
 *
 * @author Ferawidya
 */
public class DriverServer {
    public static void main(String[] args) {
        try {
            ServerConnection server = new ServerConnection();
            System.out.println("Server Information");
            System.out.println(server.getServerInformation());
            
            while(true) {
                connectionThread connection = new connectionThread(server.getClient());
                connection.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(DriverServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
