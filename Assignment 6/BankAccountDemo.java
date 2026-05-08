// Name   : Prakarsh Shende
// Roll No: 21
// Experiment 5: Exception Handling (Bank Account)

// -------- Custom Exception for Low Balance --------
class LowBalanceException extends Exception {
    LowBalanceException(String msg) {
        super(msg);
    }
}

// -------- Custom Exception for Negative Amount --------
class NegativeNumberException extends Exception {
    NegativeNumberException(String msg) {
        super(msg);
    }
}

// -------- BankAccount Class --------
class BankAccount {
    String name;
    int accNo;
    double balance;

    BankAccount(String name, int accNo, double balance) {
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    void deposit(double amount) throws NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Negative amount not allowed");
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) throws LowBalanceException, NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Negative amount not allowed");
        }
        if (amount > balance) {
            throw new LowBalanceException("Insufficient Balance");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

// -------- Main Class --------
public class BankAccountDemo {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount("Prakarsh Shende", 101, 5000);

        acc.showBalance();

        try {
            acc.deposit(2000);
            acc.withdraw(1500);
            acc.withdraw(10000);   // will cause exception
        }
        catch (LowBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        catch (NegativeNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        acc.showBalance();
    }
}