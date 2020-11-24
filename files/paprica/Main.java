package files.paprica;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<User> users = getUsersList();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("PRESS [1] TO ADD USER");
            System.out.println("PRESS [2] TO LIST USERS");
            System.out.println("PRESS [3] TO DELETE USER");
            System.out.println("PRESS [4] TO EXIT");

            int choice = in.nextInt();

            if (choice == 1) {
                String login = in.next();
                String password = in.next();
                users.add(new User(login, password));
                saveUsersList(users);
            }

            else if (choice == 2) {
                System.out.println(getUsersList() + "\n");
            }

            else if (choice == 4) {
                break;
            }
        }

    }

    static ArrayList<User> getUsersList() {
        ArrayList<User> users = new ArrayList<>();
        try {

            BufferedReader reader = new BufferedReader(new FileReader("D:\\USER\\Bitlab\\general\\2nd module\\src\\files\\paprica\\memory.txt"));
            String login, password = null;

            while ((login = reader.readLine()) != null) {
                password = reader.readLine();
                users.add(new User(login, password));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    static void saveUsersList(ArrayList<User> users) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\USER\\Bitlab\\general\\2nd module\\src\\files\\paprica\\memory.txt"));
            for (User user: users) {
                writer.write(user.getLogin() + "\n" + user.getPassword() + "\n");
            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
