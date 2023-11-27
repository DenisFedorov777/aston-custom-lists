package dndev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        CustomArrayImpl<String> array = new CustomArrayImpl<>();
        array.add("Bob");
        array.add("John");
        array.add("Biba");
        array.add("Tom");
        System.out.println(array.size());

        System.out.println(array);
        array.sort();
        System.out.println("-- сортировка------");
        System.out.println(array);
        array.remove(0);
        System.out.println("----------------------------");
        System.out.println(array);
        System.out.println("----------------------------");
        array.set(2, "Mag");
        System.out.println(array);
        System.out.println("----------------------------");
        array.clear();
        System.out.println(array);
        System.out.println(array.isEmpty());

        LinkedList<Integer> lists = new LinkedList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(6);
        lists.add(7);
        lists.remove(0);
        System.out.println(lists);
    }
}