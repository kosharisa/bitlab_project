package exceptions.praktika;

import java.util.Scanner;

public class Main {

    public static void main(String [] args) {

        User[] users = new User[5];
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < users.length; i++) {

            String name = in.next();
            String surname = in.next();
            int age;
            try {
                age = in.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
                String x = in.next();
                age = 0;
            }
            users[i] = new User(name, surname, age);
            System.out.println();
        }

        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getAge());
        }
    }
}
