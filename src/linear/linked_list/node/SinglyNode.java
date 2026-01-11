package linear.linked_list.node;

public class SinglyNode<T> extends BaseNode<T> {
    protected SinglyNode<T> next;

    public SinglyNode(T data) {
        super(data);
        this.next = null;
    }

    @Override
    public void clearLinks() {
        next = null;
    }

    public SinglyNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyNode<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }
}
