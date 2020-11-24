package GUI.students;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentPage extends JPanel {

    private MainFrame parent;

    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel facultyLabel;
    private JLabel groupLabel;

    private JTextField nameField;
    private JTextField surnameField;
    private JComboBox facultyBox;
    private JTextField groupField;

    private JButton addButton;
    private JButton backButton;

    private String[] faculties = {"Engineering", "Economics", "Programming"};

    public AddStudentPage(MainFrame parent) {

        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        nameLabel = new JLabel("NAME:");
        nameLabel.setSize(100, 25);
        nameLabel.setLocation(100, 100);
        add(nameLabel);

        surnameLabel = new JLabel("SURNAME:");
        surnameLabel.setSize(100, 25);
        surnameLabel.setLocation(100, 150);
        add(surnameLabel);

        facultyLabel = new JLabel("FACULTY:");
        facultyLabel.setSize(100, 25);
        facultyLabel.setLocation(100, 200);
        add(facultyLabel);

        groupLabel = new JLabel("GROUP:");
        groupLabel.setSize(150, 25);
        groupLabel.setLocation(100, 250);
        add(groupLabel);

        nameField = new JTextField();
        nameField.setSize(150, 25);
        nameField.setLocation(200, 100);
        add(nameField);

        surnameField = new JTextField();
        surnameField.setSize(150, 25);
        surnameField.setLocation(200, 150);
        add(surnameField);

        facultyBox = new JComboBox(faculties);
        facultyBox.setSize(150, 25);
        facultyBox.setLocation(200, 200);
        add(facultyBox);

        groupField = new JTextField();
        groupField.setSize(150, 25);
        groupField.setLocation(200, 250);
        add(groupField);

        addButton = new JButton("ADD");
        addButton.setSize(100, 30);
        addButton.setLocation(100, 350);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!nameField.getText().equals("") && !surnameField.getText().equals("") && !groupField.getText().equals(" ")) {
                    Students newStudent = new Students(nameField.getText(), surnameField.getText(), (String)facultyBox.getSelectedItem(), groupField.getText());
                    Students.addStudent(newStudent);
                    nameField.setText("");
                    surnameField.setText("");
                    facultyBox.setSelectedIndex(0);
                    groupField.setText("");

                    parent.getListStudentsPage().appendInArea(newStudent.toString());
                }
            }
        });

        backButton = new JButton("BACK");
        backButton.setSize(100, 30);
        backButton.setLocation(250, 350);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAddStudentPage().setVisible(false);
                parent.getMainMenu().setVisible(true);
            }
        });
    }
}