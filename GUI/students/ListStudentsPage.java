package GUI.students;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListStudentsPage extends JPanel {

    private MainFrame parent;

    private JTextArea studentsArea;
    private JLabel label;
    private JButton backButton;

    public ListStudentsPage(MainFrame parent) {

        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        label = new JLabel("LIST OF STUDENTS:");
        label.setSize(300, 30);
        label.setLocation(100, 50);
        add(label);

        studentsArea = new JTextArea();
        studentsArea.setSize(300, 250);
        studentsArea.setLocation(100, 85);
        add(studentsArea);
        studentsArea.setEditable(false);

        backButton = new JButton("BACK");
        backButton.setSize(100, 25);
        backButton.setLocation(200, 370);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getListStudentsPage().setVisible(false);
                parent.getMainMenu().setVisible(true);
            }
        });
    }

    public void appendInArea(String studentInfo) {
        studentsArea.append(studentInfo);
    }
}
