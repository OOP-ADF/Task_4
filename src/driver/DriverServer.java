/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import javaChat.ServerConnection;
import chatGUI.*;
import consoleApp.*;
import javaChat.*;

/**
 *
 * @author Rizza
 */
public class DriverServer {
    public static void main(String[] args) {
        try {
            ServerConnection server = new ServerConnection();
            System.out.println("Server Information : ");
            System.out.println(server.getServerInformation());
            while (true) {                
                connectionThread connection = new connectionThread(server.getClient());
                connection.start();
            }
        } catch (Exception e) {
            System.out.println("Error "+ e.getMessage());
        }
    }    
}
