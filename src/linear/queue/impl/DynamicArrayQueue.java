package linear.queue.impl;

import linear.queue.abstracts.AbstractArrayQueue;

public class DynamicArrayQueue<T> extends AbstractArrayQueue<T> {
    public DynamicArrayQueue() {
        super(DEFAULT_CAPACITY);
    }

    public DynamicArrayQueue(int capacity) {
        super(capacity);
    }

    @Override
    protected void ensureCapacityForEnqueue() {
        if (isFull())
            grow();
    }

    private void  grow() {
        int newCapacity = capacity() * 2;

        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            int index = (frontIndex + i) % capacity();
            newData[i] = data[index];
        }

        data = newData;
        frontIndex = 0;
        rearIndex = size;
    }
}
