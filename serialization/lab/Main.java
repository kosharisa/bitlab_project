package serialization.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Game> games = getGames();

        while (true) {
            System.out.println("PRESS 1 TO CREATE GAME");
            System.out.println("PRESS 2 TO ADD PLAYER TO GAME");
            System.out.println("PRESS 3 TO PLAY GAME");
            System.out.println("PRESS 0 TO EXIT");

            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();

            if (choice == 1) {
                System.out.println("Game name:");
                String name = in.next();
                System.out.println("IP address");
                String ipAddress = in.next();
                System.out.println("PORT");
                int port = in.nextInt();
                Game newGame = new Game(name, ipAddress, port);
                games.add(newGame);
                saveGame(newGame);
            }
            else if (choice == 2) {
                System.out.println("CHOOSE GAME:");
                System.out.println(games);
                Game game = games.get(in.nextInt());
                System.out.println("Nickname:");
                String name = in.next();
                System.out.println("Rating:");
                double rating = in.nextDouble();
                game.addPlayer(new Player(name, rating));
                saveGame(game);
            }
            else if (choice == 3) {
                System.out.println("PRESS 3 TO PLAY GAMES");
                System.out.println(games);
            }
            else if (choice == 0) {
                break;
            }
        }
    }

    public static void saveGame(Game game) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:\\USER\\Bitlab\\general\\2nd module\\src\\serialization\\lab\\settings.data"));
            outputStream.writeObject(game);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Game> getGames() {
        ArrayList<Game> games = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream((new FileInputStream("D:\\USER\\Bitlab\\general\\2nd module\\src\\serialization\\lab\\settings.data")));
            games = (ArrayList<Game>)inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return games;
    }
}
