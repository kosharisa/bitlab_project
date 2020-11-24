package database.paprica;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();

        Database db = Database.getDb();
        db.connect();

//        db.addUser(new User(3, "zxcvb", "zxc123", 5000));

        users = db.getAllUsers();

//        db.updateUser();

        System.out.println(users);
    }
}
