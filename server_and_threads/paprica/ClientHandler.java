package server_and_threads.paprica;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class ClientHandler extends Thread {

    private Socket socket;
    private ArrayList<Book> books = new ArrayList<>();

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            books.add(new Book("123", "qwe"));
            books.add(new Book("456", "asd"));
            books.add(new Book("789", "zxc"));
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData packageData;

            while ((packageData = (PackageData) inputStream.readObject()) != null) {
                System.out.println(packageData.toString());
                if (packageData.getOperationType() == 1) {
                    System.out.println(books.toString());
                    outputStream.writeObject(new PackageData(books));
                }
                else if (packageData.getOperationType() == 2) {
                    books.add(packageData.getBook());
                }
                packageData = null;
            }

            System.out.println("Client disconnected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
