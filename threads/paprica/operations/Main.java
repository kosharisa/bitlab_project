package threads.paprica.operations;

import threads.paprica.operations.Operation;

public class Main {

    public static void main(String[] args) {

        Operation operation1 = new Operation("Hi", 5);
        Operation operation2 = new Operation("Ssup", 3);
        Operation operation3 = new Operation("Good", 10);
        Operation operation4 = new Operation("Well", 4);
        Operation operation5 = new Operation("Buy", 7);

        operation1.start();
        operation2.start();
        operation3.start();
        operation4.start();
        operation5.start();
    }
}
