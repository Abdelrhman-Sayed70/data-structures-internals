package core;

public interface IndexAccessibleStructure<T> extends LinearStructure<T> {
    /**
     * Returns the element at the specified index.
     * @param index the position
     * @return element at index
     */
    T get(int index);

    /**
     * Sets/replaces the element at the specified index.
     * @param index the position
     * @param element element to set
     */
    void set(int index, T element);

    /**
     * Removes element at the specified index, shifting subsequent elements.
     * @param index position to remove
     * @return removed element
     */
    T remove(int index);

    /**
     * Inserts element at the specified index, shifting subsequent elements.
     * @param index position to insert
     * @param element element to insert
     */
    void add(int index, T element);

    /**
     * Returns the index of the first occurrence of the element,
     * or -1 if not found.
     * @param element element to search
     * @return index of element, or -1 if not found
     */
    int indexOf(T element);

    void add(T element);

    default void checkIndex(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
    }

    default void checkIndexForAdd(int index){
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
    }
}
