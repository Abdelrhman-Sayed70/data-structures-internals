package linear.queue.impl;

import linear.linked_list.impl.SinglyLinkedListImpl;
import linear.queue.api.Queue;

/**
 * Queue implementation using Singly Linked List.
 *
 * Enqueue  -> addLast   -> O(1)
 * Dequeue  -> removeFirst -> O(1)
 * Front    -> getFirst / get(0) -> O(1)
 *
 * @param <T> element type
 */
public class SinglyLinkedListQueueImpl<T> implements Queue<T> {
    private final SinglyLinkedListImpl<T> linkedList;

    public SinglyLinkedListQueueImpl() {
        linkedList = new SinglyLinkedListImpl<>();
    }

    @Override
    public void enqueue(T element) {
        linkedList.addLast(element);
    }

    @Override
    public T dequeue() {
        if(linkedList.isEmpty())
            throw new IllegalStateException("Queue is empty");

        return linkedList.removeFirst();
    }

    @Override
    public T front() {
        if(linkedList.isEmpty())
            throw new IllegalStateException("Queue is empty");

        return linkedList.getHeadValue();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public void clear() {
        linkedList.clear();
    }

    @Override
    public boolean contains(T element) {
        return linkedList.contains(element);
    }

    @Override
    public void print() {
        System.out.println("Front");
        linkedList.print();
        System.out.println("Rear");
    }
}
