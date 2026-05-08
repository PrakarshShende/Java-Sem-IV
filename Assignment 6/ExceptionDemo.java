// Name   : Prakarsh Shende
// Roll No: 21
// Experiment 5: Exception Handling Program
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String msg) {
        super(msg);
    }
}

class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient Balance");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    void showBalance() {
        System.out.println("Balance: " + balance);
    }
}

public class ExceptionDemo {
    public static void main(String[] args) {

        // ArithmeticException example
        try {
            int a = 10, b = 0;
            int c = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception Occurred");
        }

        // ArrayIndexOutOfBoundsException example
        try {
            int arr[] = {1,2,3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds");
        }

        // Custom Exception example
        BankAccount acc = new BankAccount(500);

        try {
            acc.deposit(200);
            acc.withdraw(800);
        }
        catch (InsufficientFundsException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }

        acc.showBalance();
    }
}