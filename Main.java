package third;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list  = new LinkedList<>();
        System.out.println(list.isEmpty() +" "+ list.size());
        System.out.println();

        list.addLast(8);
        list.addFirst(0);
        list.addLast(2);
        System.out.println(list.isEmpty() +" "+ list.size());
        list.printValues();
        System.out.println();

        list.addFirst(3);
        list.addLast(5);
        System.out.println(list.isEmpty() +" "+ list.size());
        list.printValues();
        System.out.println();

        list.addAtIndex(0 , 12);
        list.addAtIndex(list.size() , 15);
        System.out.println(list.isEmpty() +" "+ list.size());
        list.printValues();
        System.out.println();

        list.removeByIndex(2);
        list.removeByValue(2);
        System.out.println(list.isEmpty() +" "+ list.size());
        list.printValues();
        System.out.println();

        System.out.println(list.getIndexOf(5));

        System.out.println(list.getByIndex(4));

        for (int number : list)
            System.out.println("number: " + number);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
        //System.out.println(iterator.next());

    }
    public static void info(LinkedList<String> list){
        System.out.println("is empty:" + list.isEmpty());
        System.out.println("size:" + list.size());
        list.printValues();

    }
}
