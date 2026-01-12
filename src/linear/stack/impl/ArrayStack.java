package linear.stack.impl;

import core.Stack;
import linear.dynamic_array.api.DynamicArray;
import linear.dynamic_array.impl.DynamicArrayImpl;

public class ArrayStack<T> implements Stack<T> {
    /**
     * Internal storage for the stack.
     *
     * Declared as `final` to ensure the reference cannot be reassigned
     * after construction. This guarantees predictable behavior while
     * allowing modification of the elements via push/pop.
     */
    private final DynamicArray<T> array;

    public ArrayStack() {
        array = new DynamicArrayImpl<>();
    }

    @Override
    public void push(T element) {
        array.add(element);
    }

    @Override
    public T pop() {
        if (array.isEmpty())
            throw new IllegalStateException("Stack is empty");

        return array.remove(size() - 1);
    }

    @Override
    public T top() {
        if (array.isEmpty())
            throw new IllegalStateException("Stack is empty");

        return array.get(size() - 1);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public void clear() {
        array.clear();
    }

    @Override
    public boolean contains(T element) {
        return array.contains(element);
    }

    @Override
    public void print() {
        System.out.println("TOP");

        for (int i = size() - 1; i >= 0; i--)
            System.out.println(array.get(i));

        System.out.println("BOTTOM");
    }
}
