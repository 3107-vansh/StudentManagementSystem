package com.sms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Add a new student
    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim(); // Trim to avoid empty spaces

        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty!");
            return;
        }

        Student newStudent = new Student(name);
        students.add(newStudent);
        System.out.println("Student added successfully! (ID: " + newStudent.getStudentID() + ")");
    }

    // Enroll a student in a course
    public void enrollStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = getStudentByID(id);
        if (student == null) return;

        System.out.print("Enter course name: ");
        String course = scanner.nextLine();
        System.out.print("Enter course fee: ");
        double fee = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        student.enroll(course, fee);
    }

    // Pay tuition fees
    public void payFees() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = getStudentByID(id);
        if (student == null) return;

        System.out.print("Enter amount to pay: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        student.payFees(amount);
    }

    // Show student status
    public void showStudentStatus() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = getStudentByID(id);
        if (student != null) {
            student.showStatus();
        }
    }

    // Retrieve student by ID
    private Student getStudentByID(int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        System.out.println("Error: Student not found!");
        return null;
    }
}
