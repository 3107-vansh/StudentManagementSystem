package com.sms;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private static int idCounter = 1000;
    private String name;
    private int studentID;
    private List<String> courses;
    private double balance;

    // Constructor
    public Student(String name) {
        this.name = name;
        this.studentID = idCounter++;
        this.courses = new ArrayList<>();
        this.balance = 0;
    }

    // Enroll in a course
    public void enroll(String course, double fee) {
        courses.add(course);
        balance += fee;
        System.out.println(name + " enrolled in " + course + ". Fee added: " + fee);
    }

    // Pay tuition fees
    public void payFees(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(name + " paid " + amount + ". Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Show student details
    public void showStatus() {
        System.out.println("\nStudent ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Enrolled Courses: " + courses);
        System.out.println("Balance Due: " + balance);
    }

    // Getter method for Student ID
    public int getStudentID() {
        return studentID;
    }
}
