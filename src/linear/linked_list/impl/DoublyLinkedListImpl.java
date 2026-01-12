package linear.linked_list.impl;

import linear.linked_list.abstracts.AbstractLinkedList;
import linear.linked_list.node.DoublyNode;

public class DoublyLinkedListImpl<T> extends AbstractLinkedList<T, DoublyNode<T>> {
    @Override
    protected DoublyNode<T> getNodeAt(int index) {
        checkIndex(index);

        DoublyNode<T> current;
        if (index < size / 2) {
            // traverse from start
            current = head;
            for (int i = 0; i < index; i++)
                current = current.getNext();
        }
        else {
            // traverse from end
            current = tail;
            for (int i = size - 1; i > index; i--)
                current = current.getPrev();
        }

        return current;
    }

    @Override
    protected DoublyNode<T> getNextNode(DoublyNode<T> node) {
        return node.getNext();
    }

    @Override
    public void addFirst(T element) {
        DoublyNode<T> newNode = new DoublyNode<>(element);

        if (size == 0)
            head = tail = newNode;

        else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }

        size++;
    }

    @Override
    public void addLast(T element) {
        DoublyNode<T> newNode = new DoublyNode<>(element);
        if (size == 0)
            head = tail = newNode;

        else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }

        size++;
    }

    @Override
    public T removeFirst() {
        if (size == 0)
            throw new IllegalStateException("Linked list is empty, no element to remove");

        DoublyNode<T> deletedHead = head;
        if (size == 1)
            head = tail = null;

        else {
            head = deletedHead.getNext();
            deletedHead.setNext(null);
            head.setPrev(null);
        }

        size--;
        return deletedHead.getData();
    }

    @Override
    public T removeLast() {
        if (size == 0)
            throw new IllegalStateException("Linked list is empty, no element to remove");

        DoublyNode<T> deletedTail = tail;

        if (size == 1)
            head = tail = null;

        else {
            tail = tail.getPrev();
            tail.setNext(null);
            deletedTail.setPrev(null);
        }

        size--;
        return deletedTail.getData();
    }

    @Override
    public T remove(int index) {
        checkIndex(index);

        if (index == 0)
            return removeFirst();

        else if (index == size - 1)
            return removeLast();

        DoublyNode<T> deletedNode = getNodeAt(index);
        deletedNode.getPrev().setNext(deletedNode.getNext());
        deletedNode.getNext().setPrev(deletedNode.getPrev());
        deletedNode.setNext(null);
        deletedNode.setPrev(null);

        size--;
        return deletedNode.getData();
    }

    @Override
    public void add(int index, T element) {
        checkIndexForAdd(index);

        if (index == 0)
            addFirst(element);

        else if (index == size)
            addLast(element);

        else {
            DoublyNode<T> newNode = new DoublyNode<>(element);
            DoublyNode<T> toBeMovedNode = getNodeAt(index);

            toBeMovedNode.getPrev().setNext(newNode);
            newNode.setPrev(toBeMovedNode.getPrev());
            newNode.setNext(toBeMovedNode);
            toBeMovedNode.setPrev(newNode);

            size++;
        }
    }
}
