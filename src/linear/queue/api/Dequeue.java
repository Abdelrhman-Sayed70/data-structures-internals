package linear.queue.api;

public interface Dequeue<T> extends Queue<T> {
    void pushBack(T element);
    void pushFront(T element);
    T popBack();
    T popFront();
    T back();

    @Override
    default void enqueue(T element) {
        pushBack(element);
    }

    @Override
    default T dequeue() {
        return popFront();
    }
}
