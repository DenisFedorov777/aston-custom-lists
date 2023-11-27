package dndev;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
/**
 * Implementation of custom ArrayList
 * @author dndev
 * @version 1.0
 * */
public class CustomArrayImpl<E> implements CustomArray<E> {

    private int size = 0;
    private int capacity = 0;
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

    public void sort() {
        sort(null);
    }

    private void sort(Comparator<? super E> comparator) {
        if (comparator == null) {
            Arrays.sort(elements, 0, size);
        } else {
            Arrays.sort((E[]) elements, 0, size, comparator);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(elements);
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

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        Iterator<E> it = iterator();
        if (!it.hasNext() || size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (; ; ) {
            E e = it.next();
            if (e == null) {
                sb.delete(sb.length() - 2, sb.length()); //-2
                return sb.append(']').toString();
            }
            sb.append(e == null ? "" : e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }
}
