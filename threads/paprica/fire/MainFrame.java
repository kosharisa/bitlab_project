package threads.paprica.fire;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("FIRE");
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("#");
        label.setSize(50, 50);
        label.setLocation(100, 100);
        add(label);

        JButton fireButton = new JButton("FIRE");
        fireButton.setSize(150, 50);
        fireButton.setLocation(150, 350);
        add(fireButton);
        fireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MyThread myThread = new MyThread(label);
                myThread.start();
            }
        });

        setVisible(true);
    }
}
