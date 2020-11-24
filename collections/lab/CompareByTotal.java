package collections.lab;

import java.util.Comparator;

public class CompareByTotal implements Comparator {

    @Override
    public int compare(Object o, Object t1) {
        BankApplication b1 = (BankApplication)o;
        BankApplication b2 = (BankApplication)t1;

        if (b1.getAverageBalance() > b2.getAverageBalance()){
            return 1;
        }else if (b1.getAverageBalance() < b2.getAverageBalance()){
            return -1;
        }
        return 0;
    }
}
