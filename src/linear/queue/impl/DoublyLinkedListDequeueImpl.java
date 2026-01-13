package linear.queue.impl;

import linear.linked_list.impl.DoublyLinkedListImpl;
import linear.queue.api.Dequeue;

public class DoublyLinkedListDequeueImpl<T> implements Dequeue<T> {
    private final DoublyLinkedListImpl<T> linkedList;

    public DoublyLinkedListDequeueImpl() {
        linkedList = new DoublyLinkedListImpl<>();
    }

    @Override
    public void pushBack(T element) {
        linkedList.addLast(element);
    }

    @Override
    public void pushFront(T element) {
        linkedList.addFirst(element);
    }

    @Override
    public T popBack() {
        if (linkedList.isEmpty())
            throw new IllegalStateException("Dequeue is empty");

        return linkedList.removeLast();
    }

    @Override
    public T popFront() {
        if (linkedList.isEmpty())
            throw new IllegalStateException("Dequeue is empty");

        return linkedList.removeFirst();
    }

    @Override
    public T back() {
        if (linkedList.isEmpty())
            throw new IllegalStateException("Dequeue is empty");

        return linkedList.getTailValue();
    }

    @Override
    public T front() {
        if (linkedList.isEmpty())
            throw new IllegalStateException("Dequeue is empty");

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
