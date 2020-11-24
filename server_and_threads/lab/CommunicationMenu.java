package server_and_threads.lab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;

public class CommunicationMenu extends JPanel {

    private MainFrame parent;

    private JTextField messageField;
    private JButton sendButton;

    public CommunicationMenu(MainFrame parent) {
        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        messageField = new JTextField();
        messageField.setSize(200, 70);
        messageField.setLocation(150, 200);
        add(messageField);

        sendButton = new JButton("SEND");
        sendButton.setSize(100, 50);
        sendButton.setLocation(200, 350);
        add(sendButton);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(parent.getSocket().getOutputStream());

                    if (messageField.getText() != "") {
                        outputStream.writeObject(messageField.getText());
                        messageField.setText("");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
