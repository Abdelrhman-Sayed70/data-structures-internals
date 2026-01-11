package linear.linked_list.abstracts;

import linear.linked_list.api.LinkedList;
import linear.linked_list.node.BaseNode;

public abstract class AbstractLinkedList<T, N extends BaseNode<T>> implements LinkedList<T> {
    protected N head;
    protected N tail;
    protected int size;

    public AbstractLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    protected abstract N getNodeAt(int index);
    protected abstract N getNextNode(N node);

    @Override
    public int size(){
        return size;
    }

    @Override
    public T getHeadValue() {
        return head.getData();
    }

    @Override
    public T getTailValue() {
        return tail.getData();
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNodeAt(index).getData();
    }

    @Override
    public void set(int index, T element) {
        getNodeAt(index).setData(element);
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(T element) {
        N current = head;
        int index = 0;

        while (current != null) {
            T currentData = current.getData();

            if (element == null) {
                if (currentData == null)
                    return index;
            } else {
                if (element.equals(currentData))
                    return index;
            }

            index++;
            current = getNextNode(current);
        }

        return -1;
    }

    @Override
    public void clear() {
        N current = head;
        while (current != null) {
            N next = getNextNode(current);
            current.clearLinks();
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    public void setHead(N head) {
        this.head = head;
    }

    public void setTail(N tail) {
        this.tail = tail;
    }

    public N getTail() {
        return tail;
    }

    public N getHead() {
        return head;
    }
}
