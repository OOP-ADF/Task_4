package consoleApp;

import java.io.IOException;
import java.net.Socket;
import javaChat.Connection;

/**
 *
 * @author Erwin
 */
public class ConnectionThread extends Thread{

    private Socket client;
    private Connection connection;

    public ConnectionThread(Socket newClient) throws IOException {
        this.client = newClient;
        connection = new Connection(client);
    }

    public void ConnectionThread(Socket newClient) throws IOException {

    }

    public void run() {
        try {
            connection.startChat("Start the chat");
            System.out.println("new Client connected");
            System.out.println("client information : ");
            System.out.println(connection.getClientInformation());
            String inputan;
            String message;
            while ((inputan = connection.readStream()) != null && !inputan.equals("quit")) {
                message = "Client " + connection.getIpClient() + "said : " + inputan;
                System.out.println(message);
                connection.sendToAll(message);
            }
            message = "Client from IP : " + connection.getIpClient() + "Quit the chat room";
            System.out.println(message);
            connection.sendToAll(message);
            connection.disconnect();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
