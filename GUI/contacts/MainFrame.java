package GUI.contacts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame() {

        Integer[] ages = new Integer[101];

        for (int i = 0; i < ages.length; i++) {
            ages[i] = i;
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BITLAB Application");
        setSize(500, 700);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setSize(100, 30);
        nameLabel.setLocation(100, 100);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setSize(150, 25);
        nameField.setLocation(200, 100);
        add(nameField);


        JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setSize(100, 30);
        phoneLabel.setLocation(100, 150);
        add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setSize(150, 25);
        phoneField.setLocation(200, 150);
        add(phoneField);

        JLabel ageLabel = new JLabel("Age: ");
        ageLabel.setSize(100, 30);
        ageLabel.setLocation(100, 200);
        add(ageLabel);

        JComboBox ageComboBox = new JComboBox(ages);
        ageComboBox.setSize(150, 25);
        ageComboBox.setLocation(200, 200);
        add(ageComboBox);

        JTextArea textArea = new JTextArea();
        textArea.setSize(310, 200);
        textArea.setLocation(70, 310);
        add(textArea);

        JButton button = new JButton("ADD CONTACT");
        button.setLocation(100, 250);
        button.setSize(250, 20);
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!nameField.getText().equals("") && !phoneField.getText().equals("")) {
                    textArea.append(nameField.getText() + "-" + phoneField.getText() + "-" + ageComboBox.getSelectedItem() + " years\n");
                }
            }
        });
        add(button);

        setVisible(true);
    }
}
