package edu.school21;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            // Прочитать сообщение от сервера
            String serverMessage = (String) objectInputStream.readObject();
            System.out.println("Received from server: " + serverMessage);

            // Закрыть соединение
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
