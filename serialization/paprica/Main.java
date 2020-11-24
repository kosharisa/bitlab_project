package serialization.paprica;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = getStudents();

        while (true) {
            System.out.println("PRESS [1] TO ADD STUDENT");
            System.out.println("PRESS [2] TO LIST STUDENTS");
            System.out.println("PRESS [0] TO EXIT");

            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();

            if (choice == 1) {
                System.out.println("Name:");
                String name = in.next();
                System.out.println("Surname:");
                String surname = in.next();
                Student newStudent = new Student(name, surname);

                while (true) {
                    System.out.println("PRESS [1] TO ADD SUBJECT");
                    System.out.println("PRESS [0] TO GO TO MAIN MENU");
                    int choice2 = in.nextInt();
                    addStudent(students, newStudent);
                    if (choice2 == 1) {
                        System.out.println("Name:");
                        name = in.next();
                        System.out.println("Credits:");
                        int credits = in.nextInt();
                        newStudent.addSubject(name, credits);
                    }
                    if (choice2 == 0)
                        break;
                }
            }
            if (choice == 2) {
                System.out.println(students);
            }

            if (choice == 0)
                break;
        }
    }

    public static void addStudent(ArrayList<Student> students, Student student) {
        students.add(student);
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:\\USER\\Bitlab\\general\\2nd module\\src\\serialization\\paprica\\memory.dat"));
            outputStream.writeObject(students);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:\\USER\\Bitlab\\general\\2nd module\\src\\serialization\\paprica\\memory.dat"));
            students = (ArrayList<Student>)inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
