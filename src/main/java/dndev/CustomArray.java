package dndev;

/**
 * Implementation of a custom interface class that extends class methods Iterable
 */
public interface CustomArray<E> extends Iterable<E> {

    /**
     * Adding an element
     * @param e
     */
    void add(E e);

    /**
     * Changing an element at a specified index
     * @param index
     * @param e
     */
    void set(int index, E e);

    /**
     * Adding an element at a specified index
     * @param index
     * @param e
     */
    void add(int index, E e);

    /**
     * Getting an element by index
     * @param index
     */
    E get(int index);

    /**
     * Removing an element by index
     * @param index
     */
    void remove(int index);

    /**
     * Removing all items
     */
    void clear();

    /**
     * Implementing a sorting method using Comparator
     */
    void sort();

    /**
     * Method returning the number of array elements
     * @return the number of elements in this list
     */
    int size();
}
