// Experiment 3
// Program to demonstrate multiple inheritance using interfaces

import java.util.Scanner;

interface Student {
    void getRoll();
}

interface Marks {
    void getMarks();
}

class Result implements Student, Marks {

    int rollNo;
    int sub1, sub2;

    Scanner sc = new Scanner(System.in);

    public void getRoll() {
        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextInt();
    }

    public void getMarks() {
        System.out.print("Enter marks of Subject 1: ");
        sub1 = sc.nextInt();

        System.out.print("Enter marks of Subject 2: ");
        sub2 = sc.nextInt();
    }

    void display() {
        int total = sub1 + sub2;

        System.out.println("\nRoll Number: " + rollNo);
        System.out.println("Subject 1 Marks: " + sub1);
        System.out.println("Subject 2 Marks: " + sub2);
        System.out.println("Total Marks: " + total);
    }
}

public class StudentT {

    public static void main(String[] args) {

        Result r = new Result();

        r.getRoll();
        r.getMarks();
        r.display();
    }
}