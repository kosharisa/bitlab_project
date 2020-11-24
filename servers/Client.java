package servers;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = in.next();

        try {
            Socket socket = new Socket("localhost", 1234);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                System.out.println("PRESS [1] TO SEND MESSAGE");
                System.out.println("PRESS [0] TO EXIT");

                int choice = in.nextInt();

                if (choice == 1) {
                    System.out.println("Enter message text");
                    String s = in.next();
                    outputStream.writeObject(new MessageData(name, s));
                } else if (choice == 0){
                    outputStream.writeObject(null);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
