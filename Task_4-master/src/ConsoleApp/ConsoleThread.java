/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsoleApp;

/**
 *
 * @author faza
 */
import java.io.IOException;
import java.net.Socket;
import javaChat.Connection;

public class ConsoleThread {
    private Socket client;
    private Connection connection;

    public ConsoleThread(Socket newClient) throws IOException {
        this.client = newClient;
        connection = new Connection(client);
    }

    public void run() throws IOException {
        try {
            connection.startChat("Start The Chat");

            System.out.println("-------------");
            System.out.println("New Client Connected");
            System.out.println("Client Information : ");
            System.out.println(connection.getClientInformation());

            String inputan;
            String message;
            while ((inputan = connection.readStream()) != null && !inputan.equals("quit")) {
                message = "Client " + connection.getIpClient()
                        + "said : " + inputan;
                System.out.println(message);
                connection.sendToAll(message);

            }
            message = "Client from IP : " + connection.getIpClient()
                    + "Quit the Char Room";
            System.out.println(message);
            connection.sendToAll(message);
            connection.disconnect();

        } catch (IOException E) {
            System.out.println("Error");
        }
    }
}
