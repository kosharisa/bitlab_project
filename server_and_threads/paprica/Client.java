package server_and_threads.paprica;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 1234);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            while (true) {

                System.out.println("PRESS [1] TO LIST BOOKS");
                System.out.println("PRESS [2] TO ADD BOOK");
                System.out.println("PRESS [0] TO DISCONNECT FROM SERVER");

                int choice = in.nextInt();

                if (choice == 1) {
                    outputStream.writeObject(new PackageData(choice));
                    PackageData packageData = (PackageData) inputStream.readObject();
                    System.out.println(packageData.getBooks());
                }
                else if (choice == 2) {
                    System.out.println("Enter name of new book");
                    String name = in.next();
                    System.out.println("Enter author of new book");
                    String author = in.next();
                    outputStream.writeObject(new PackageData(choice, new Book(name, author)));
                }
                else if (choice == 0) {
                    outputStream.writeObject(null);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
