package linear.stack.impl;

import core.Stack;
import linear.linked_list.impl.SinglyLinkedListImpl;

public class SinglyLinkedListStack<T> implements Stack<T> {
    /**
     * Internal storage for the stack.
     *
     * Declared as `final` to ensure the reference cannot be reassigned
     * after construction. The stack always uses the same list instance.
     */
    private final SinglyLinkedListImpl<T> linkedList;

    public SinglyLinkedListStack() {
        this.linkedList = new SinglyLinkedListImpl<>();
    }

    @Override
    public void push(T element) {
        linkedList.addFirst(element);
    }

    @Override
    public T pop() {
        if (linkedList.isEmpty())
            throw new IllegalStateException("Stack is empty");

        return linkedList.removeFirst();
    }

    @Override
    public T top() {
        if (linkedList.isEmpty())
            throw new IllegalStateException("Stack is empty");

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
        linkedList.print();
    }
}
