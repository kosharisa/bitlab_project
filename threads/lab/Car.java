package threads.lab;

public class Car extends Thread{

    private int speed;
    private double distance;
    private int raceTime;

    public Car(ThreadGroup group, String name, int speed, double distance) {
        super(group, name);
        this.speed = speed;
        this.distance = distance;
    }

    @Override
    public void run() {
        for (int i = 0; i <= distance; i += speed) {
            System.out.println(getName() + " is in " + i + " meters");
            raceTime++;
        }
    }

    public int getRaceTime() {
        return raceTime;
    }

}
