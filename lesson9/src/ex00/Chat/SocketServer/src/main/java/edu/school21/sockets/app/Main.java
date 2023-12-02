package edu.school21.sockets.app;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final String WELCOME_MESSAGE = "Hello from Server!\nregistration\nsignUp";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket clientSocket = serverSocket.accept();
//        ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        objectOutputStream.writeObject(WELCOME_MESSAGE);
        objectOutputStream.flush();
        serverSocket.close();
    }
}
