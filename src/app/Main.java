package app;

import core.Stack;
import linear.stack.impl.ArrayStack;

public class Main {
    public static void main(String[] args) {
// Create a stack of integers
        Stack<Integer> stack = new ArrayStack<>();

        System.out.println("== Testing push ==");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.print(); // Expected: TOP -> 40 -> 30 -> 20 -> 10 -> BOTTOM

        System.out.println("\n== Testing peek ==");
        System.out.println("Peek: " + stack.top()); // Expected: 40

        System.out.println("\n== Testing pop ==");
        System.out.println("Popped: " + stack.pop()); // Expected: 40
        stack.print(); // Expected: TOP -> 30 -> 20 -> 10 -> BOTTOM

        System.out.println("Popped: " + stack.pop()); // Expected: 30
        stack.print(); // Expected: TOP -> 20 -> 10 -> BOTTOM

        System.out.println("\n== Testing size and isEmpty ==");
        System.out.println("Size: " + stack.size()); // Expected: 2
        System.out.println("Is empty: " + stack.isEmpty()); // Expected: false

        System.out.println("\n== Testing clear ==");
        stack.clear();
        System.out.println("Size after clear: " + stack.size()); // Expected: 0
        System.out.println("Is empty after clear: " + stack.isEmpty()); // Expected: true

        // Test popping from empty stack
        System.out.println("\n== Testing pop on empty stack ==");
        try {
            stack.pop(); // Should throw IllegalStateException
        } catch (IllegalStateException e) {
            System.out.println("Caught exception as expected: " + e.getMessage());
        }
    }
}