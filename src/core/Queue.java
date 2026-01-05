package core;

public interface Queue<T> extends LinearStructure<T> {
    /**
     * Inserts an element at the rear of the queue.
     *
     * @param element the element to be added
     */
    void enqueue(T element);

    /**
     * Removes and returns the front element of the queue.
     *
     * @return the removed front element
     * @throws RuntimeException if the queue is empty
     */
    T dequeue();

    /**
     * Returns the front element of the queue without removing it.
     *
     * @return the front element
     * @throws RuntimeException if the queue is empty
     */
    T front();
}
