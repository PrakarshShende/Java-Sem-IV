// Experiment 3
// Program to demonstrate inheritance and method overriding

import java.util.*;

class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Balance: " + balance);
    }

    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
        System.out.println("Balance: " + balance);
    }
}

class SavingAccount extends BankAccount {

    SavingAccount(double balance) {
        super(balance);
    }

    void withdraw(double amount) {
        if (balance - amount < 100) {
            System.out.println("Withdrawal denied! Balance cannot go below 100.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Balance: " + balance);
        }
    }
}

public class BankTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SavingAccount acc = new SavingAccount(500);
        System.out.print("Enter deposit amount: ");
        double d = sc.nextDouble();
        acc.deposit(d);
        System.out.print("Enter withdraw amount: ");
        double w = sc.nextDouble();
        acc.withdraw(w);

        sc.close();
    }
}