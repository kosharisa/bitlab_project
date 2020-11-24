package threads.paprica.operations;

public class Operation extends Thread {

    private String operationName;
    private int operationTime;

    public Operation(String operationName, int operationTime) {
        this.operationName = operationName;
        this.operationTime = operationTime;
    }

    @Override
    public void run() {
        System.out.println("Operation \"" + operationName + "\": started");
        for (int i = 1; i <= operationTime; i++) {
            System.out.println("Operation \"" + operationName + "\": " + i);
        }
        System.out.println("Operation \"" + operationName + "\": finished");
    }
}
