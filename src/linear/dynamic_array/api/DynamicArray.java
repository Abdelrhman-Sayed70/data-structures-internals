package linear.dynamic_array.api;

import core.Appendable;
import core.IndexAccessible;
import core.LinearStructure;
import core.Structure;

public interface DynamicArray<T> extends Structure<T>, LinearStructure<T>, IndexAccessible<T>, Appendable<T> {
    /**
     * Returns the current capacity of the dynamic array.
     * Capacity is the internal size of the underlying storage
     * and is always >= current size.
     *
     * @return the current capacity
     */
    int capacity();
}
