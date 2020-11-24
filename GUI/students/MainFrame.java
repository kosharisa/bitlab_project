package GUI.students;

import javax.swing.*;

public class MainFrame extends JFrame {

    private MainMenu mainMenu;
    private AddStudentPage addStudentPage;
    private ListStudentsPage listStudentsPage;

    public MainFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("STUDENT APPLICATION");
        setSize(500,500);
        setLayout(null);

        mainMenu = new MainMenu(this);
        mainMenu.setVisible(true);
        add(mainMenu);

        addStudentPage = new AddStudentPage(this);
        addStudentPage.setVisible(false);
        add(addStudentPage);

        listStudentsPage = new ListStudentsPage(this);
        listStudentsPage.setVisible(false);
        add(listStudentsPage);
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public AddStudentPage getAddStudentPage() {
        return addStudentPage;
    }

    public ListStudentsPage getListStudentsPage() {
        return listStudentsPage;
    }
}
