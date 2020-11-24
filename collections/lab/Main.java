package collections.lab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        BankApplication kar = new BankApplication("Kar");
        kar.addAccount(new Account("Tob", "Kag", 9000));
        kar.addAccount(new Account("Sh", "Hin", 100));
        kar.addAccount(new Account("Saw", "Dai", 100000));

        BankApplication fuk = new BankApplication("Fuk");
        fuk.addAccount(new Account("Tor", "Bok", 40000));
        fuk.addAccount(new Account("Ei", "Aka", 80000));

        BankApplication nek = new BankApplication("Nek");
        nek.addAccount(new Account("Koz", "Ken", 5000));
        nek.addAccount(new Account("Aw", "Kur", 400));

        ArrayList<BankApplication> allBanks = new ArrayList<>();
        allBanks.add(kar);
        allBanks.add(nek);
        allBanks.add(fuk);

        Collections.sort(allBanks, new CompareByTotal());
        for (BankApplication bankApplication : allBanks) {
            System.out.println(bankApplication.getBankData());
        }
    }
}
