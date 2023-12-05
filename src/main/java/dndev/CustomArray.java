package dndev;

import java.util.Comparator;

/**
 * Implementation of a custom interface class that extends class methods Iterable
 */
public interface CustomArray<E> {

    /**
     * Adding an element
     */
    void add(E e);

    /**
     * Changing an element at a specified index
     */
    void set(int index, E e);

    /**
     * Adding an element at a specified index
     */
    void add(int index, E e);

    /**
     * Getting an element by index
     */
    E get(int index);

    /**
     * Removing an element by index
     */
    void remove(int index);

    /**
     * Removing all items
     */
    void clear();

    /**
     * Implementing a sorting method using Comparator
     */
    void sort(Comparator<? super E> comparator);

    /**
     * Method returning the number of array elements
     *
     * @return the number of elements in this list
     */
    int size();
}
