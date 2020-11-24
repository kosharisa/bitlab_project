package threads.lab;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ThreadGroup group = new ThreadGroup("race");
        double distance = 1000;
        Car car1 = new Car(group, "Porreri", 100, distance);
        Car car2 = new Car(group, "Mercedes", 50, distance);
        Car car3 = new Car(group, "Forsche", 20, distance);
        Car car4 = new Car(group, "Ferrari", 80, distance);
        Car car5 = new Car(group, "Smth", 90, distance);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        for (Car car : cars) {
            car.start();
        }

        while (group.activeCount() != 0) {
        }

        cars.sort(new CompareByTime());

        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Place " + (i + 1) + ": " + cars.get(i).getName() + " - " + cars.get(i).getRaceTime());
        }
    }
}
