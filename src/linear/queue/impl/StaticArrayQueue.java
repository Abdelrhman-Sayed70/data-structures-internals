package linear.queue.impl;

import linear.queue.abstracts.AbstractArrayQueue;

public class StaticArrayQueue<T> extends AbstractArrayQueue<T> {

    public StaticArrayQueue(int capacity) {
        super(capacity);
    }

    public StaticArrayQueue() {
        super(DEFAULT_CAPACITY);
    }

    @Override
    protected void ensureCapacityForEnqueue() {
        if (isFull())
            throw new RuntimeException("Queue is full");
    }
}
