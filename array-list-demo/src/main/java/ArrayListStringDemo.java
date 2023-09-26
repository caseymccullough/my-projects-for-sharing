import java.util.ArrayList;
import java.util.List;

// https://docs.oracle.com/javase/8/docs/api/java/util/List.html

public class ArrayListStringDemo {
    public static void main(String[] args) {

        List <String> names = new ArrayList<>(); // List is an interface

        // put values into the List
        names.add ("Julia");
        names.add("Jorge");
        names.add("Jordan");

        System.out.println("size: " + names.size());

        names.add(0, "Jewel");

        for (String name : names) {
            System.out.println(name);
        }

        String first = names.get(0);

        String last = names.get(names.size() - 1);

        System.out.println("first: " + first);
        System.out.println("last: " + last);

        names.set(0, "New Friend");

        System.out.println("After Jewel is removed");
        for (String name : names) {
            System.out.println(name);
        }






    }



}
