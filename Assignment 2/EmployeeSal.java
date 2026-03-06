// Experiment No: 2
// Program: Employee Salary Management

import java.util.Scanner;

class Employee {

    private String firstName;
    private String lastName;
    private double monthlySalary;

    Employee(String f, String l, double s) {
        firstName = f;
        lastName = l;

        if (s > 0)
            monthlySalary = s;
        else
            monthlySalary = 0.0;
    }

    double getSalary() {
        return monthlySalary;
    }

    String getName() {
        return firstName;
    }

    void setSalary(double s) {
        if (s > 0)
            monthlySalary = s;
    }
}

public class EmployeeSal {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee 1 details (FirstName LastName Salary):");
        Employee e1 = new Employee(sc.next(), sc.next(), sc.nextDouble());

        System.out.println("Enter Employee 2 details (FirstName LastName Salary):");
        Employee e2 = new Employee(sc.next(), sc.next(), sc.nextDouble());

        System.out.println("\nYearly Salary:");
        System.out.println(e1.getName() + " = " + (e1.getSalary() * 12));
        System.out.println(e2.getName() + " = " + (e2.getSalary() * 12));

        e1.setSalary(e1.getSalary() * 1.10);
        e2.setSalary(e2.getSalary() * 1.10);

        System.out.println("\nAfter 10% Raise:");
        System.out.println(e1.getName() + " = " + (e1.getSalary() * 12));
        System.out.println(e2.getName() + " = " + (e2.getSalary() * 12));
        sc.close();
    }
}