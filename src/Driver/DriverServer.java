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
 * @author Ranestari Sastriani
 */
public class DriverServer {
    public static void main(String[] args) {
        try{
            ServerConnection serverc= new ServerConnection();
            System.out.println("server Information");
            System.out.println(serverc.getServerInformation());
            
            while (true){
                ConnectionThread connectionT
                        = new ConnectionThread(serverc.getClient());
                connectionT.run();
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }
    
    
}
