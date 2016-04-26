/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import chatGUI.ChatController;
import consoleApp.connectionThread;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaChat.Connection;
import javaChat.ServerConnection;

/**
 * @author Ekaaaa 
 * NIM 1301144312 
 * Kelas IF - 38 -02
 */
public class DriverServer {

    public static void main(String[] args) {
        try {
            ServerConnection server = new ServerConnection();
            System.out.println("Server Information");
            System.out.println(server.getServerInformation());

            while (true) {
                try {
                    connectionThread conenction = new connectionThread(server.getClient());
                } catch (IOException ex) {
                    Logger.getLogger(DriverServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                Connection.start();
            }
        } catch (IOException ex) {

            Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}