package dndev;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Implementation of custom ArrayList
 *
 * @author dndev
 * @version 1.0
 */
public class CustomArrayImpl<E> implements CustomArray<E> {

    private int size;
    private int capacity;
    public static final int DEFAULT_CAPACITY = 10;
    private E[] elements;

    public CustomArrayImpl() {
        capacity = DEFAULT_CAPACITY;
        elements = (E[]) new Object[capacity];
    }

    @Override
    public void add(E e) {
        checkBounds();
        elements[size] = e;
        size++;
    }

    @Override
    public void add(int index, E e) {
        checkBoundsForIndex(index);
        checkBounds();
        for (int i = size - 1; i >= index; i--) {
            elements[i] = elements[i + 1];
        }
        elements[index] = e;
        size++;
    }

    @Override
    public void set(int index, E e) {
        checkBoundsForIndex(index + 1);
        elements[index] = e;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public void remove(int index) {
        try {
            E[] temp = elements;
            elements = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, elements, 0, index);
            int countAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, elements, index, countAfterIndex);
            size--;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public void sort(Comparator<? super E> comparator) {
        if (comparator == null) {
            Arrays.sort(elements, 0, size);
        } else {
            Arrays.sort(elements, 0, size, comparator);
        }
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkBoundsForIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Вы вышли за пределы массива!");
        }
    }

    private void checkBounds() {
        if (size == capacity) {
            incrCapacity();
        }
    }

    private void incrCapacity() {
        capacity = capacity * 3 / 2 + 1;
        E[] newArray = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
            elements[i] = null;
        }
        elements = newArray;
    }
}
