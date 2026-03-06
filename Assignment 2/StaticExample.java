// Experiment 2
// Demonstration of static variable, static method and static block

public class StaticExample {
    static int number;

    static {
        System.out.println("Static block executed");
        number = 10;
    }

    static void show() {
        System.out.println("Static method called");
        System.out.println("Value of number = " + number);
    }

    public static void main(String[] args) {

        System.out.println("Main method started");
        show();
        number = 20;
        System.out.println("Updated value of number = " + number);
    }
}