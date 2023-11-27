package dndev;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Public class implementation Iterator
 *
 * @author dndev
 * @version 1.0
 */
public class ArrayIterator<E> implements Iterator<E> {

    private int index = 0;
    private E[] elements;

    /**
     * Constructor declaration
     */
    public ArrayIterator(E[] elements) {
        this.elements = elements;
    }

    /**
     * Overriding the return next element method
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return index < elements.length;
    }

    /**
     * Overriding a method that returns the next element in an iteration
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() {
        return elements[index++];
    }
}
