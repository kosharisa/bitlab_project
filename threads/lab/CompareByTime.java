package threads.lab;

import java.util.Comparator;

public class CompareByTime implements Comparator {

    @Override
    public int compare(Object o, Object t1) {
        Car car1 = (Car)o;
        Car car2 = (Car)t1;

        if (car1.getRaceTime() > car2.getRaceTime()) {
            return 1;
        } else if (car1.getRaceTime() < car2.getRaceTime()) {
            return -1;
        }
        return 0;
    }
}
