// Experiment 3
// Employee class hierarchy

class Employee {

    String name, address, jobTitle;
    double salary;

    Employee(String n, String a, double s, String j) {
        name = n;
        address = a;
        salary = s;
        jobTitle = j;
    }

    double calculateBonus() {
        return salary * 0.10;
    }

    void report() {
        System.out.println(jobTitle + " " + name + " performance is good.");
    }

    void display() {
        System.out.println("\nName: " + name);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {

    Manager(String n, String a, double s) {
        super(n, a, s, "Manager");
    }

    double calculateBonus() {
        return salary * 0.20;
    }
}

class Developer extends Employee {

    Developer(String n, String a, double s) {
        super(n, a, s, "Developer");
    }

    double calculateBonus() {
        return salary * 0.15;
    }
}

class Programmer extends Employee {

    Programmer(String n, String a, double s) {
        super(n, a, s, "Programmer");
    }

    double calculateBonus() {
        return salary * 0.12;
    }
}

public class Company {

    public static void main(String[] args) {

        Manager m = new Manager("Rahul", "Delhi", 80000);
        Developer d = new Developer("Anita", "Mumbai", 60000);
        Programmer p = new Programmer("Karan", "Chennai", 50000);
        m.display();
        System.out.println("Bonus: " + m.calculateBonus());
        m.report();
        d.display();
        System.out.println("Bonus: " + d.calculateBonus());
        d.report();
        p.display();
        System.out.println("Bonus: " + p.calculateBonus());
        p.report();
    }
}