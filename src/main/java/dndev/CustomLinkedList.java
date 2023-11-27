package dndev;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public T get(int index) {
        return getNode(index).data;
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

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}