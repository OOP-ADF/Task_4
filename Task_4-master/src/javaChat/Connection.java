/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaChat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dee
 */
public class Connection {

    private Socket client;
    private String ipClient = "";
    private BufferedReader inputStream;
    private DataOutputStream outputStream;
    private InetAddress destAddress;
    private static ArrayList<Socket> list = new ArrayList<>();
//    private static Map<String, DataOutputStream> users = new HashMap<>();

//    public Connection(Socket client, String username) throws IOException {
//        this.client = client;
//        inputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
////        outputStream = new DataOutputStream(client.getOutputStream());
//        users.put(username, new DataOutputStream(client.getOutputStream()));
//
//        destAddress = this.client.getInetAddress();
//        byte ipAddress[] = destAddress.getAddress();
//        for (int i = 0; i < ipAddress.length; ++i) {
//            ipClient += String.valueOf((ipAddress[i] + 256) % 256) + ".";
//        }
//    }

    public Connection(Socket client) throws IOException {
        this.client = client;
        list.add(client);
        inputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outputStream = new DataOutputStream(client.getOutputStream());

        destAddress = this.client.getInetAddress();
        byte ipAddress[] = destAddress.getAddress();
        for (int i = 0; i < ipAddress.length; ++i) {
            ipClient += String.valueOf((ipAddress[i] + 256) % 256) + ".";
        }
    }

    public void disconnect() throws IOException {
        list.remove(client);
        inputStream.close();
        outputStream.close();
        client.close();
    }

    public String readStream() throws IOException {
        return inputStream.readLine();
    }

    public void startChat(String text) throws IOException {
        outputStream.writeBytes(text + "\n");
    }

    public void writeStream(String text) throws IOException {
        outputStream.writeBytes(text + "\n");
        outputStream.flush();
    }

    public void sendToAll(String s) {
        for (Socket c : list) {
            try {
                if (c != null) {
                    DataOutputStream d = new DataOutputStream(c.getOutputStream());
                    d.writeBytes(s + "\n");
                    d.flush();
                }
            } catch (Exception e) {
                System.out.println("error when send to all");
            }
        }
    }

    public String getIpClient() {
        return ipClient;
    }

    public int getPortClient() {
        return client.getPort();
    }

    public String getClientInformation() {

        String s = " Host name is " + destAddress.getHostName()
                + "\n IP address is " + this.ipClient
                + "\n Port number is " + getPortClient();
        return s;
    }

}
