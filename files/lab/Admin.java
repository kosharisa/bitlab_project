package files.lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    private static ArrayList<GoodItem> goodItems = getGoodItemList();

    public static void main(String[] args) {
        while (true) {
            System.out.println("PRESS [1] TO ADD GOOD");
            System.out.println("PRESS [2] TO LIST GOOD");
            System.out.println("PRESS [3] TO DELETE GOOD");
            System.out.println("PRESS [0] TO EXIT");

            Scanner in = new Scanner(System.in);

            int choice = in.nextInt();

            if (choice == 1) {
                String name = in.next();
                int price = in.nextInt();
                goodItems.add(new GoodItem(name, price));
                saveGoodItems(goodItems);
            }

            if (choice == 2) {
                System.out.println(getGoodItemList() + "\n");
            }

            if (choice == 3) {
                goodItems.remove(in.nextInt());
                saveGoodItems(goodItems);
            }

            if (choice == 0) {
                break;
            }
        }
    }

    public static ArrayList<GoodItem> getGoodItemList() {
        ArrayList<GoodItem> goodItems = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\USER\\Bitlab\\general\\2nd module\\src\\files\\lab\\gooditems.txt"));
            String name;
            int price;
            while ((name = reader.readLine()) != null) {
                price = Integer.parseInt(reader.readLine());
                goodItems.add(new GoodItem(name, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodItems;
    }

    public static void saveGoodItems(ArrayList<GoodItem> goodItems) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\USER\\Bitlab\\general\\2nd module\\src\\files\\lab\\gooditems.txt"));
            for (GoodItem goodItem : goodItems) {
                writer.write(goodItem.getName() + "\n" + goodItem.getPrice() + "\n");
            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
