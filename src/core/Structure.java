package core;

public interface Structure<T> {
    /**
     * Returns the number of elements in the structure.
     * @return number of elements
     */
    int size();

    /**
     * Returns true if the structure has no elements.
     * @return true if empty
     */
    default boolean isEmpty(){
        return size() == 0;
    }

    /**
     * Removes all elements from the structure.
     */
    void clear();

    boolean contains(T element);

    void print();
}
