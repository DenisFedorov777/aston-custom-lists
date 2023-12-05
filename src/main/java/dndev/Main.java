package dndev;

public class Main {
    public static void main(String[] args) {

        CustomArrayImpl<String> array = new CustomArrayImpl<>();
        array.add("Bob");
        array.add("John");
        array.add("Biba");
        array.add("Tom");
        System.out.println(array.size());

        System.out.println(array);
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
    }
}