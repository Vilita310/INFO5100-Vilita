package hwtochapter9;

import java.util.ArrayList;
import java.util.List;

// Class representing a student with ID, first name, and last name
class Student {
    private int studentID;
    private String firstName;
    private String lastName;

    public Student(int studentID, String firstName, String lastName) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter for studentID
    public int getStudentID() {
        return studentID;
    }

    // Returns a string representation of the student
    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + firstName + " " + lastName;
    }
}

// Class representing an engineering class with a list of students
class EngClass {
    private List<Student> students;

    public EngClass() {
        students = new ArrayList<>();
    }

    // Adds a student to the class
    public void addStudent(Student student) {
        students.add(student);
    }

    // Deletes a student from the class by studentID
    public void deleteStudent(int studentID) {
        students.removeIf(student -> student.getStudentID() == studentID);
    }

    // Prints all students in the class
    public void printStudents() {
        System.out.println("Students in the class:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

// Main class to demonstrate functionality
public class hwtochapter9 {
    public static void main(String[] args) {
        EngClass engClass = new EngClass();
        engClass.addStudent(new Student(1, "Vilita", "Jing"));
        engClass.addStudent(new Student(2, "Alie", "Smith"));
        engClass.printStudents();

        engClass.deleteStudent(1);
        engClass.printStudents();
    }
}
