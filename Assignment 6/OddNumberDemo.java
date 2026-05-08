// Name   : Prakarsh Shende
// Roll No: 21
// Experiment 5: Exception Handling
// Program: OddNumberException

// Custom Exception
class OddNumberException extends Exception {
    OddNumberException(String msg) {
        super(msg);
    }
}

// Class to check number
class NumberChecker {
    void checkEven(int num) throws OddNumberException {
        if (num % 2 != 0) {
            throw new OddNumberException("Number is odd");
        }
        System.out.println(num + " is even");
    }
}

// Main class
public class OddNumberDemo {
    public static void main(String[] args) {

        NumberChecker nc = new NumberChecker();
        int numbers[] = {4, 7, 12, 9};

        for (int n : numbers) {
            try {
                nc.checkEven(n);
            } 
            catch (OddNumberException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}