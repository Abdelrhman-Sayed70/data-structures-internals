package linear.array;

public abstract class AbstractArray<T> implements DynamicArray<T> {
    protected Object[] data;
    protected int size;
    protected static final int DEFAULT_CAPACITY = 10;

    public AbstractArray(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Capacity must be non-negative");

        data = new Object[initialCapacity];
        size = 0;
    }

    public AbstractArray() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            data[i] = null;

        size = 0;
    }

    protected void ensureCapacity(int minCapacity) {
        if (data.length >= minCapacity)
            return;

        grow(minCapacity);
    }

    private void grow(int minCapacity) {
        int newCapacity = Math.max(minCapacity, data.length * 2);
        Object [] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    protected void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }


    /**
     * Check that index to add element in is valid.
     * Index can be in the range: 0 to size (not size - 1). Size means it will insert at the end of the array
     * @param index index that new element will be added on
     */
    protected void checkIndexForAdd(int index){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
}
