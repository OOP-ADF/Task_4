/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaChat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author dee
 */
public class ServerConnection {

    private ServerSocket server;
    private InetAddress localAddress;
    private String host;
    private String ipServer = "";

    public ServerConnection() throws IOException {
        server = new ServerSocket(4444);
        localAddress = InetAddress.getLocalHost();
        host = localAddress.getHostName();
        byte ipAddress[] = localAddress.getAddress();
        for (int i = 0; i < ipAddress.length; ++i) {
            ipServer += String.valueOf((ipAddress[i] + 256) % 256) + ".";
        }
    }

    public Socket getClient() throws IOException {
        return server.accept();
    }

    public String getServerInformation() {
        String s = " Host name is " + host
                + "\n IP address is " + ipServer
                + "\n Port number  " + 4444;
        return s;
    }

}
