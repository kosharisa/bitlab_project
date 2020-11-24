package collections.paprica;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Kageyama", 9, 15));
        players.add(new Player("Hinata", 10, 15));
        players.add(new Player("Nishinoya", 11, 16));

        double avgPrice = 0;
        int totalAge = 0;
        for (Player player : players) {
            totalAge += player.getAge();
            avgPrice += player.getPrice();
        }
        avgPrice /= players.size() + 1;

        System.out.println(avgPrice + "\n" + totalAge);
    }
}
