package javaChat;

import java.io.IOException;

public class DriverServer {

    public static void main(String[] args) throws IOException {
        try {
            ServerConnection server = new ServerConnection();
            System.out.println("Server Information");
            System.out.println(server.getServerInformation());
        while (true){
            ConnectionThread connection = new ConnectionThread(server.getClient());
            connection.run();
        }
        }
        catch(IOException E){
            System.out.println("Error");
        }
    }
}
