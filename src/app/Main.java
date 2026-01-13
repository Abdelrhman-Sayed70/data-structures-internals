package app;

import core.Stack;
import linear.queue.api.Queue;
import linear.queue.impl.SinglyLinkedListQueueImpl;
import linear.stack.impl.ArrayStack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new SinglyLinkedListQueueImpl<>();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.print(); // Front -> 10 20 30 <- Rear

        System.out.println(q.dequeue()); // 10
        System.out.println(q.front());   // 20

        q.print(); // Front -> 20 30 <- Rear
    }
}