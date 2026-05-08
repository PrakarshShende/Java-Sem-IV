// Name   : Prakarsh Shende
// Roll No: 21
// Experiment 5: Exception Handling
// Program: Calculator using DivisionException

import ExceptionHandlingDemo.Calculator;
import ExceptionHandlingDemo.DivisionException;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculator Program");

        // Normal division
        try {
            double result = calc.divide(20, 4);
            System.out.println("20 / 4 = " + result);
        } 
        catch (DivisionException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Division by zero
        try {
            double result = calc.divide(15, 0);
            System.out.println("15 / 0 = " + result);
        } 
        catch (DivisionException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Other operations
        System.out.println("10 + 3 = " + calc.add(10, 3));
        System.out.println("10 - 3 = " + calc.subtract(10, 3));
        System.out.println("10 * 3 = " + calc.multiply(10, 3));

        // User input division
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        try {
            double result = calc.divide(a, b);
            System.out.println("Result: " + result);
        } 
        catch (DivisionException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}