/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import ConsoleApp.ConnectionThread;
import javaChat.ServerConnection;

/**
 *
 * @author Guntur Fatmawan
 */
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
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
