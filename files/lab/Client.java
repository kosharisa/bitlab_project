package files.lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Client {

    private static ArrayList<GoodItem> goodItems = getGoodItemList();
    private static ArrayList<PurchaseHistory> purchaseHistory = getPurchaseHistory();

    public static void main(String[] args) {
        while (true) {

            System.out.println("PRESS [1] TO LIST GOODS");
            System.out.println("PRESS [2] TO BUY GOOD");
            System.out.println("PRESS [3] TO LIST PURCHASE HiSTORY");
            System.out.println("PRESS [0] TO EXIT");

            Scanner in = new Scanner(System.in);

            int choice = in.nextInt();
            if (choice == 1) {
                System.out.println(getGoodItemList());
            }

            if (choice == 2) {
                GoodItem goodItem = goodItems.get(in.nextInt());
                purchaseHistory.add(new PurchaseHistory(goodItem.getName(), goodItem.getPrice()));
                savePurchaseHistory(purchaseHistory);
            }

            if (choice == 3) {
                System.out.println(getPurchaseHistory() + "\n");
            }

            if (choice == 0) {
                break;
            }
        }
    }

    public static ArrayList<GoodItem> getGoodItemList() {
        return Admin.getGoodItemList();
    }

    public static ArrayList<PurchaseHistory> getPurchaseHistory() {
        ArrayList<PurchaseHistory> purchaseHistory = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\USER\\Bitlab\\general\\2nd module\\src\\files\\lab\\purchaseHistory.txt"));
            String name;
            int price;
            Date purchaseTime;
            while ((name = reader.readLine()) != null) {
                price = Integer.parseInt(reader.readLine());
                SimpleDateFormat formatter = new SimpleDateFormat("E M dd hh:mm:ss ZZZZ yyyy");
                purchaseTime = formatter.parse(reader.readLine());
                purchaseHistory.add(new PurchaseHistory(name, price, purchaseTime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return purchaseHistory;
    }

    public static void savePurchaseHistory(ArrayList<PurchaseHistory> purchaseHistory) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\USER\\Bitlab\\general\\2nd module\\src\\files\\lab\\purchaseHistory.txt"));
            for (PurchaseHistory history : purchaseHistory) {
                writer.write(history.getGoodName() + "\n" + history.getGoodPrice() + "\n" + history.getPurchaseTime() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
