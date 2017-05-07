/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.io.IOException;
import javaChat.ServerConnection;
import ConsoleApp.ConsoleThread;

/**
 *
 * @author faza
 */
public class DriverServer {
    public static void main(String[] args) {
        try {
            ServerConnection serverc = new ServerConnection();
            System.out.println("Server Information");
            System.out.println(serverc.getServerInformation());
            while (true) {
                ConsoleThread connectionT = new ConsoleThread(serverc.getClient());
                connectionT.run();

            }
        } catch (IOException E) {
            System.out.println("Error");
        }
    }
}
