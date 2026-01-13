package linear.queue.abstracts;

import linear.queue.api.Queue;

/**
 * Abstract base class for array-based queue implementations using
 * a circular buffer.
 *
 * Shared logic:
 * - Circular indexing
 * - front / rear management
 * - dequeue, front, clear, print
 *
 * Subclasses decide what happens when the array is full:
 * - StaticArrayQueue  -> throws exception
 * - DynamicArrayQueue -> grows the array
 *
 * @param <T> element type
 */
public abstract class AbstractArrayQueue<T> implements Queue<T> {
    protected T [] data;
    protected int frontIndex;
    /**
     * write pointer for the next enqueue operation
     */
    protected int rearIndex;
    protected int size;
    protected static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public AbstractArrayQueue(int capacity){
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity must be greater than zero");

        this.data = (T[]) new Object[capacity];
        this.frontIndex = 0;
        this.rearIndex = 0;
        this.size = 0;
    }

    protected int capacity() {
        return data.length;
    }

    protected boolean isFull() {
        return size == capacity();
    }

    @Override
    public T dequeue() {
        if (size == 0)
            throw new RuntimeException("Queue is empty");

        T element = data[frontIndex];
        data[frontIndex] = null; // Help GC
        frontIndex = (frontIndex + 1) % capacity();
        size--;
        return element;
    }

    @Override
    public T front() {
        if (size == 0)
            throw new IllegalStateException("Queue is empty");

        return data[frontIndex];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity(); i++) {
            data[i] = null;
        }
        frontIndex = 0;
        rearIndex = -1;
        size = 0;
    }

    @Override
    public void print() {
        System.out.print("Queue: [");
        for (int i = 0; i < size; i++) {
            int index = (frontIndex + i) % capacity();
            System.out.print(data[index]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            int index = (frontIndex + i) % capacity();
            if (data[index].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void enqueue(T element){
        ensureCapacityForEnqueue();
        data[rearIndex] = element;
        rearIndex = (rearIndex + 1) % capacity();
        size++;
    }

    /**
     * Ensures that there is space for one more element.
     *
     * Static queue: throws exception if full.
     * Dynamic queue: grows the array.
     */
    protected abstract void ensureCapacityForEnqueue();
}
