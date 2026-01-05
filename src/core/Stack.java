package core;

public interface Stack<T> extends LinearStructure<T>{
    /**
     * Pushes an element onto the top of the stack.
     *
     * @param element the element to be pushed
     */
    void push(T element);

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the removed top element
     * @throws RuntimeException if the stack is empty
     */
    T pop();

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the top element
     * @throws RuntimeException if the stack is empty
     */
    T top();
}
