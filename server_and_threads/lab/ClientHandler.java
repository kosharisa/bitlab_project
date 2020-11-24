package server_and_threads.lab;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            String message = "";

            while ((message = (String) inputStream.readObject()) != null) {
                System.out.println(message);
                message = "";
            }

            System.out.println("Client disconnected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
