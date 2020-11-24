package threads.paprica.fire;

import javax.swing.*;

public class MyThread extends Thread {

    private JLabel label;

    public MyThread(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        for (int i = 100; i <= 400; i++) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            label.setLocation(i, 100);
        }
    }
}
