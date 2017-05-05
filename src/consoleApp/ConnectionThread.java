/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleApp;

import java.io.IOException;
import java.net.Socket;
import javaChat.Connection;

/**
 * File Description
 *
 * @author Afnizar Nur Ghifari <afnizarhilmi@gmail.com>
 * @since May 6, 2017
 */
public class ConnectionThread {

    private Socket client;
    private Connection connection;

    public ConnectionThread(Socket newClient) throws IOException {
        this.client = newClient;
        connection = new Connection(client);
    }

    public void run() {
        try {
            connection.startChat("Chat has been started");
            System.out.println("Connected new client");
            System.out.println("Client Info");
            System.out.println(connection.getClientInformation());
            String in;
            String message;
            while ((in = connection.readStream()) != null && !in.equals("quit")) {
                message = "Client " + connection.getIpClient() + "said : " + in;
                System.out.println(message);
                connection.sendToAll(message);
            }
            message = "Client from IP : " + connection.getIpClient() + "Quit from chat room ";
            System.out.println(message);
            connection.sendToAll(message);
            connection.disconnect();
        } catch (IOException ex) {
            System.out.println("Some error has been occured");
        }
    }

}
