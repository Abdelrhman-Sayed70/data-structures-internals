package linear.linked_list.node;

public abstract class BaseNode<T> {
    protected T data;

    public BaseNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public abstract void clearLinks();
}
