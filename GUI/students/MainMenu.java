package GUI.students;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {

    private MainFrame parent;

    private JButton addStudentPage;
    private JButton listStudentsPage;
    private JButton exitButton;

    public MainMenu(MainFrame parent) {

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        addStudentPage = new JButton("ADD STUDENT");
        addStudentPage.setSize(250,30);
        addStudentPage.setLocation(100,100);
        add(addStudentPage);
        addStudentPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAddStudentPage().setVisible(true);
                parent.getMainMenu().setVisible(false);
            }
        });

        listStudentsPage = new JButton("LIST STUDENTS");
        listStudentsPage.setSize(250,30);
        listStudentsPage.setLocation(100,150);
        add(listStudentsPage);
        listStudentsPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getListStudentsPage().setVisible(true);
                parent.getMainMenu().setVisible(false);
            }
        });

        exitButton = new JButton("EXIT");
        exitButton.setSize(250,30);
        exitButton.setLocation(100,200);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}
