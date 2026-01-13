package linear.dynamic_array.impl;

import linear.dynamic_array.abstracts.AbstractArray;

public class DynamicArrayImpl<T> extends AbstractArray<T> {
    public DynamicArrayImpl(int initialCapacity) {
        super(initialCapacity);
    }

    public DynamicArrayImpl() {
        super();
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public void add(T element) {
        add(size, element);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        super.checkIndex(index);
        return (T) data[index];
    }

    @Override
    public void set(int index, T element) {
        checkIndex(index);
        data[index] = element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) data[index];

        for(int i = index + 1; i < size; i++)
            data[i - 1] = data[i];

        data[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public void add(int index, T element) {
        checkIndexForAdd(index);
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--)
            data[i] = data[i - 1];

        data[index] = element;
        size++;
    }

    @Override
    public int indexOf(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++)
                if (data[i] == null)
                    return i;
        }
        else {
            for (int i = 0; i < size; i++)
                if (element.equals(data[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++)
            System.out.println(data[i]);
    }
}
