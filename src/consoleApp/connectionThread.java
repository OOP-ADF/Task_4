/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleApp;

import java.io.IOException;
import java.net.Socket;
import javaChat.Connection;

/**
 *
 * @author Ekaaaa
 * NIM 1301144312
 * class IF - 38 -02
 */
public class connectionThread {

    private Socket client;
    private Connection connection;

    public connectionThread(Socket newClient) throws IOException {
        this.client = newClient;
        connection = new Connection(client);
    }

    public void run() {
        try {
            connection.startChat("start the chat");
            System.out.println("------------------------------");
            System.out.println("new client connected");
            System.out.println("client information : ");
            System.out.println(connection.getClientInformation());
            String inputan;
            String message;
            while ((inputan = connection.readStream()) != null && !inputan.equals("quit")) {
                message = "Client " + connection.getIpClient() + " said : " + inputan;
                System.out.println(message);
                connection.sendToAll(message);
            }
            message = "Client from IP : " + connection.getIpClient() + "Quit the chat room";
            System.out.println(message);
            connection.sendToAll(message);
            connection.disconnect();
        } catch (Exception e) {
            System.out.println("Eror - " + e.getMessage());
        }
    }
}
