package server_and_threads.lab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class ConnectionMenu extends JPanel {

    private MainFrame parent;

    private JTextField ipField;
    private JTextField portField;
    private JButton connectButton;

    public ConnectionMenu(MainFrame parent) {
        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        ipField = new JTextField();
        ipField.setSize(300, 30);
        ipField.setLocation(100, 100);
        add(ipField);

        portField = new JTextField();
        portField.setSize(300, 30);
        portField.setLocation(100, 200);
        add(portField);

        connectButton = new JButton("CONNECT");
        connectButton.setSize(100, 50);
        connectButton.setLocation(200, 350);
        add(connectButton);
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (ipField.getText() != "" && portField.getText() != "") {
                        Socket socket = new Socket(ipField.getText(), Integer.parseInt(portField.getText()));
                        parent.setSocket(socket);
                        parent.getCommunicationMenu().setVisible(true);
                        setVisible(false);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
