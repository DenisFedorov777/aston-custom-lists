package dndev;

import java.util.Comparator;

public interface CustomArray<E> extends Iterable<E> {
    void add(E e);
    void set(int index, E e);
    void add(int index, E e);
    E get(int index);
    void remove(int index);
    void clear();
    void sort();
    int size();
}
