package collections.lab;

import java.util.ArrayList;
import java.util.Comparator;

public class BankApplication {

    private String name;
    private ArrayList<Account> accounts = new ArrayList<>();

    public BankApplication(String name) {
        this.name = name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(int index) {
        accounts.remove(index);
    }

    public Account getMaxAccount() {
        Account maxAccount = null;
        for (Account account : accounts) {
            if (maxAccount.getBalance() < account.getBalance()) {
                maxAccount = account;
            }
        }
        return maxAccount;
    }

    public double getAverageBalance() {
        double averageBalance = 0;
        for (Account account : accounts) {
            averageBalance += account.getBalance();
        }
        averageBalance /= accounts.size() + 1;
        return averageBalance;
    }

    public double getTotalBalance() {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public int totalAccounts() {
        return accounts.size() + 1;
    }

    public String getBankData() {
        return "Name: " + name + " Total Accounts: " + totalAccounts() + " Total Balance: " + getTotalBalance() + " Average Balance: " + getAverageBalance();
    }

}
