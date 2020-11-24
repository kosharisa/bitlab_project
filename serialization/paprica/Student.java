package serialization.paprica;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;

public class Student implements Serializable {

    private String name;
    private String surname;
    private AbstractList<Subject> subjects = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void addSubject(String name, int credits) {
        subjects.add(new Subject(name, credits));
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
