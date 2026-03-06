// Experiment 2
// Program to implement Stack and Queue

import java.util.*;

public class Stackqueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        System.out.print("Enter number of elements for Stack: ");
        int n = sc.nextInt();

        System.out.println("Enter stack elements:");
        for(int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println("Stack: " + stack);
        System.out.println("Pop element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);


        Queue<Integer> queue = new LinkedList<>();

        System.out.print("\nEnter number of elements for Queue: ");
        int m = sc.nextInt();

        System.out.println("Enter queue elements:");
        for(int i = 0; i < m; i++) {
            queue.add(sc.nextInt());
        }

        System.out.println("Queue: " + queue);
        System.out.println("Removed element: " + queue.remove());
        System.out.println("Queue after remove: " + queue);

        sc.close();
    }
}