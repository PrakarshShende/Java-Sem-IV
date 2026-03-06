// Experiment 2
// Program to find area of rectangle using class and methods

import java.util.Scanner;

class Area {

    double length, breadth;

    void setDim(double l, double b) {
        length = l;
        breadth = b;
    }

    double getArea() {
        return length * breadth;
    }
}

public class AreaTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Area a = new Area();

        System.out.print("Enter length: ");
        double l = sc.nextDouble();

        System.out.print("Enter breadth: ");
        double b = sc.nextDouble();

        a.setDim(l, b);

        System.out.println("Area of Rectangle = " + a.getArea());

        sc.close();
    }
}