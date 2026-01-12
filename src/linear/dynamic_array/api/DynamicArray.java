package linear.dynamic_array.api;

import core.IndexAccessibleStructure;
import core.LinearStructure;
import core.Structure;

public interface DynamicArray<T> extends Structure<T>, LinearStructure<T>, IndexAccessibleStructure<T> {
    /**
     * Returns the current capacity of the dynamic array.
     * Capacity is the internal size of the underlying storage
     * and is always >= current size.
     *
     * @return the current capacity
     */
    int capacity();
}
