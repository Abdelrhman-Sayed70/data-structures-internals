package linear.linked_list.api;

import core.IndexAccessibleStructure;
import core.LinearStructure;
import core.Structure;

public interface LinkedList <T> extends Structure<T>, LinearStructure<T>, IndexAccessibleStructure<T> {
    void addFirst(T element);
    void addLast(T element);
    T removeFirst();
    T removeLast();
    T getHeadValue();
    T getTailValue();
}
