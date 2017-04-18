package javaChat;

import java.io.IOException;
import java.net.Socket;
import javaChat.Connection;

public class ConnectionThread {

    private Socket client;
    private Connection connection;

    public ConnectionThread(Socket newClient) throws IOException {
        this.client = newClient;
        connection = new Connection(client);
    }

    public void run() throws IOException {
        try {
            connection.startChat("Start The Chat");

            //Informasi Client
            System.out.println("-------------");
            System.out.println("new Client Connected");
            System.out.println("Client Information");
            System.out.println(connection.getClientInformation());

            String inputan;
            String message;
            while ((inputan = connection.readStream()) != null
                    && !inputan.equals("Quit")) {
                message = "Client " + connection.getIpClient() + " said : " + inputan;
                System.out.println(message);
                connection.sendToAll(message);
            }
            message = "Client from IP : " + connection.getIpClient()
                    + "Quit the char Room";
            System.out.println(message);
            connection.sendToAll(message);
            connection.disconnect();
        } catch (IOException E) {
            System.out.println("Error");
        }
    }
}
