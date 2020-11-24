package servers;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(1234);
            Socket socket = server.accept();
            System.out.println("Client connected");
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            MessageData message;

            while ((message = (MessageData) inputStream.readObject()) != null) {
                System.out.println(message);
                message = null;
            }

            System.out.println("Client disconnected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
