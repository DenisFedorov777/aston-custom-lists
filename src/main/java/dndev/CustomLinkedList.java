package dndev;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Public class implementation of custom LinkedList
 *
 * @author dndev
 * @version 1.0
 */
public class CustomLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * Implementation of a custom method for adding an element
     * Appends the specified element to the end of this list.
     *
     * <p>This method is equivalent to {@link #add}.
     *
     * @param element the element to add
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Implementation of a custom method for adding an element to a specified position.
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException - if the index is out of range ( index < 0 || index > size() )
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
        } else {
            Node<T> newNode = new Node<>(element);
            Node<T> current = getNode(index);
            Node<T> prev = current.prev;

            newNode.prev = prev;
            newNode.next = current;
            if (prev != null) {
                prev.next = newNode;
            } else {
                head = newNode;
            }
            current.prev = newNode;
            size++;
        }
    }

    /** Implementation of a custom sorting method using Comparator.
     * Sorts this list according to the order induced by the specified
     * {@link Comparator}.  The sort is <i>stable</i>: this method must not
     *  reorder equal elements.*/
    public void sort(Comparator<? super T> comparator) {
        List<T> list = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        list.sort(comparator);

        current = head;
        for (T element : list) {
            current.data = element;
            current = current.next;
        }
    }

    /**
     * Implementation of a custom method for getting an element from a specified location
     */
    public T get(int index) {
        return getNode(index).data;
    }

    /**
     * Implementation of a custom method for removing an element from a specified location in the list
     * @param index
     */
    public void remove(int index) {
        Node<T> current = getNode(index);
        Node<T> prev = current.prev;
        Node<T> next = current.next;

        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
        current.prev = null;
        current.next = null;
        size--;
    }

    /**
     * Implementation of a custom method for clearing the list and removing all elements
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}