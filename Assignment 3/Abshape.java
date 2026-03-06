// Experiment 3
// Program using abstract class Shape

abstract class Shape {
    double dim1, dim2;

    Shape(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    abstract double area();
}

class Rectangle extends Shape {

    Rectangle(double l, double b) {
        super(l, b);
    }

    double area() {
        return dim1 * dim2;
    }
}

class Triangle extends Shape {

    Triangle(double base, double height) {
        super(base, height);
    }

    double area() {
        return 0.5 * dim1 * dim2;
    }
}

public class Abshape {
    public static void main(String[] args) {

        Rectangle r = new Rectangle(5, 4);
        Triangle t = new Triangle(6, 3);

        System.out.println("Area of Rectangle = " + r.area());
        System.out.println("Area of Triangle = " + t.area());
    }
}