package server_and_threads.lab;

import javax.swing.*;
import java.net.Socket;

public class MainFrame extends JFrame {

    private ConnectionMenu connectionMenu;
    private CommunicationMenu communicationMenu;
    private Socket socket;

    public MainFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Client - Server");
        setSize(500, 500);
        setLayout(null);

        connectionMenu = new ConnectionMenu(this);
        connectionMenu.setVisible(true);
        add(connectionMenu);

        communicationMenu = new CommunicationMenu(this);
        communicationMenu.setVisible(false);
        add(communicationMenu);
    }

    public ConnectionMenu getConnectionMenu() {
        return connectionMenu;
    }

    public CommunicationMenu getCommunicationMenu() {
        return communicationMenu;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
