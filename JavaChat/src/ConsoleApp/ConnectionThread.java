/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsoleApp;

import java.io.IOException;
import java.net.Socket;
import javachat.Connection;

/**
 *
 * @author Nindia Cahyaning Putri
 * 1301154567
 * IF3907
 */
public class ConnectionThread {
    private Socket client;
    private Connection connection;
    
    public ConnectionThread(Socket newClient) throws IOException {
        this.client = newClient;
        connection = new Connection(client);
    }
    
    
    
    public void run() throws IOException{
        //method yang dijalankan saat thread diaktifkan
        //Thread akan aktif setiap ada Client baru yang terhubung ke Server
        //Thread akan berhenti ketika Client mengirimkan pesan "quit"
        try{
            connection.startChat("start the chat");
            System.out.println("----------------------");
            System.out.println("new client connected");
            System.out.println("client information: ");
            System.out.println(connection.getClientInformation());
            
            String inputan;
            String message;
            while ((inputan = connection.readStream()) !=null && !inputan.equals("quit")){
                message = "Client " +connection.getIpClient()
                        + "said : " +inputan;
                System.out.println(message);
                connection.sendToAll(message);
            }
            message = "Client from IP : " +connection.getIpClient()
                    +"Quit the char room";
            System.out.println(message);
            connection.sendToAll(message);
            connection.disconnect();
        }
        catch (IOException E) {
            System.out.println("error");
        }
    }
}
