/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author dee
 */
public class ClientConnection {

    private BufferedReader keyBoard;
    private BufferedReader inputStream;
    private PrintWriter outputStream;
    final private int PORT = 4444;
    private Socket client;

    public ClientConnection() {
        keyBoard = new BufferedReader(new InputStreamReader(System.in));
    }

    public void connect(String ip) throws IOException {
        client = new Socket(ip, PORT);
        inputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outputStream = new PrintWriter(client.getOutputStream(), true);
    }

    public void disconnect() throws IOException {
        keyBoard.close();
        inputStream.close();
        outputStream.close();
        client.close();
    }

    public String inputString() throws IOException {
        return keyBoard.readLine();
    }

    public String readStream() throws IOException {
        return inputStream.readLine();
    }

    public void writeStream(String text) {
        outputStream.println(text);
        outputStream.flush();
    }

}
