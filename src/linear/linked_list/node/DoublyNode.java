package linear.linked_list.node;

public class DoublyNode<T> extends BaseNode<T> {
    protected DoublyNode<T> prev;
    protected DoublyNode<T> next;

    public DoublyNode(T data) {
        super(data);
        this.prev = null;
        this.next = null;
    }

    @Override
    public void clearLinks() {
        prev = next = null;
    }

    public DoublyNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyNode<T> prev) {
        this.prev = prev;
    }

    public DoublyNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyNode<T> next) {
        this.next = next;
    }
}
