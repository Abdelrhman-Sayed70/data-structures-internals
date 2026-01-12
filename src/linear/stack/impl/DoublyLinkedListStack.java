package linear.stack.impl;

import core.Stack;
import linear.linked_list.abstracts.AbstractLinkedList;
import linear.linked_list.impl.DoublyLinkedListImpl;
import linear.linked_list.node.DoublyNode;

public class DoublyLinkedListStack<T> implements Stack<T> {
    /**
     * Internal storage for the stack.
     *
     * Declared as `final` to ensure that the reference to the internal
     * DoublyLinkedList instance cannot be reassigned after construction.
     *
     * This guarantees:
     *  - The stack always uses the same internal storage instance.
     *  - Safer and more predictable behavior.
     *  - Prevents accidental reassignment bugs.
     *
     * Note: `final` does NOT make the list immutable — the elements of the
     * list can still be modified (push/pop operations are allowed).
     */
    private final DoublyLinkedListImpl<T> linkedList;

    public DoublyLinkedListStack() {
        linkedList = new DoublyLinkedListImpl<>();
    }

    @Override
    public void push(T element) {
        linkedList.addLast(element);
    }

    @Override
    public T pop() {
        if (linkedList.isEmpty())
            throw new IllegalStateException("Stack is empty");

        return linkedList.removeLast();
    }

    @Override
    public T top() {
        if (linkedList.isEmpty())
            throw new IllegalStateException("Stack is empty");

        return linkedList.getTailValue();
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
        System.out.println("TOP");

        DoublyNode<T> current = linkedList.getTail();

        while (current != null) {
            System.out.println(current.getData());
            current = current.getPrev();
        }

        System.out.println("BOTTOM");
    }
}
