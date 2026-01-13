package linear.linked_list.impl;

import linear.linked_list.abstracts.AbstractLinkedList;
import linear.linked_list.node.SinglyNode;

public class SinglyLinkedListImpl<T> extends AbstractLinkedList<T, SinglyNode<T>> {
    @Override
    public void addFirst(T element) {
        SinglyNode<T> newNode = new SinglyNode<>(element);

        newNode.setNext(head);
        head = newNode;
        if(size == 0)
            tail = newNode;

        size++;
    }

    @Override
    public void addLast(T element) {
        SinglyNode<T> newNode = new SinglyNode<>(element);

        if (size == 0)
            tail = head = newNode;

        else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }


    @Override
    public T removeFirst() {
        if (size == 0)
            throw new IllegalStateException("Linked list is empty, no element to remove");

        SinglyNode<T> oldHead = head;

        if (size == 1)
            head = tail = null;
        else
            head = head.getNext();

        oldHead.setNext(null);
        size--;
        return oldHead.getData();
    }

    @Override
    public T removeLast() {
        if (size == 0)
            throw new IllegalStateException("Linked list is empty, no element to remove");

        SinglyNode<T> oldTail = tail;

        if (size == 1) {
            tail = head = null;
        }
        else {
            SinglyNode<T> prevNode = getNodeAt(size - 2);
            prevNode.setNext(null);
            tail = prevNode;
        }

        size--;
        return oldTail.getData();
    }


    @Override
    public T remove(int index) {
        checkIndex(index);

        if (index == 0)
            return removeFirst();

        else if (index == size - 1)
            return removeLast();

        SinglyNode<T> prevNode = getNodeAt(index - 1);
        SinglyNode<T> deletedNode = prevNode.getNext();

        prevNode.setNext(deletedNode.getNext());
        deletedNode.setNext(null);
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
            SinglyNode<T> newNode = new SinglyNode<>(element);
            SinglyNode<T> prevNode = getNodeAt(index - 1);
            SinglyNode<T> currentNode = prevNode.getNext();

            prevNode.setNext(newNode);
            newNode.setNext(currentNode);
            size++;
        }
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public SinglyNode<T> getNodeAt(int index) {
        checkIndex(index);

        SinglyNode<T> current = head;
        for (int i = 0; i < index; i++)
            current = current.getNext();

        return current;
    }

    @Override
    protected SinglyNode<T> getNextNode(SinglyNode<T> node) {
        return node.getNext();
    }
}
