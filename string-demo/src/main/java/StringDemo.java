import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // two forms of instantiation
        String city1 = new String("Cleveland");

        String city2 = "Boulder";

        // concatenation
        System.out.println("I lived in " + city1 + " but now live in " + city2.toUpperCase());

        // length
        System.out.println("Length of '" + city1 + "': " + city1.length());

        // charAt (int)
        System.out.println("The first letter in '" + city1 + "` is " + city1.charAt(0));
        System.out.println("The last letter of " + city1 + " is " + city1.charAt(city1.length() - 1));

        // for loop with charAt()
        for (int i = 0; i < city1.length(); i++) {
            System.out.println(city1.charAt(i));
        }

        // indexOf()


        int landStart = city2.indexOf("land");
        System.out.println("'land' starts at index " + landStart);

        if (city2.indexOf("land") > 0) {
            System.out.println("'land' starts at index " + landStart);
        } else {
            System.out.println("'land' not found");
        }

        // substring(int, int)
        // inclusive on the front int, exclusive on the second.

        // first three letters
        String firstThree = city1.substring(0, 3);
        System.out.println(firstThree);

        // first half
        String firstHalf = city1.substring(0, city1.length()  / 2); // (0, 4)
        System.out.println(firstHalf);

        // substring (int)

        // last three letters
        String lastThree = city1.substring(city1.length() - 3);
        System.out.println(lastThree);

        // last half
        String lastHalf = city1.substring(city1.length() / 2);
        System.out.println(lastHalf);

        // split()

        String numbers = "3 5 7 9";
        int sum = 0;

        String[] numberStrings = numbers.split(" ");

        for (int i = 0; i < numberStrings.length; i++) {
            sum += Integer.parseInt(numberStrings[i]);
        }
        System.out.println("SUM: " + sum);





    }
}
