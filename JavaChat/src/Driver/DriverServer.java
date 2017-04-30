/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import ConsoleApp.ConnectionThread;
import javachat.ServerConnection;
import java.io.IOException;

/**
 *
 * @author Nindia Cahyaning Putri 
 * 1301154567
 * IF3907
 */
public class DriverServer {
    public static void main(String[] args) {
        try{
            ServerConnection serverc = new ServerConnection();
            System.out.println("Server Information");
            System.out.println(serverc.getServerInformation());
            //
            while(true){
                ConnectionThread connectionT = new ConnectionThread(serverc.getClient());
                connectionT.run();
                
            }
            
        }
        catch (IOExpection E){
            System.out.println("error");
        }
    }
}
