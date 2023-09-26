import java.util.Locale;

public class StringDemoFinal {
    public static void main(String[] args) {

        // two forms of instantiation
        String city1 = new String ("Cleveland"); // because Strings are objects
        String city2 = "Boulder"; // shorthand

        // concatenation
        System.out.println("I lived in " + city1 + " but now I live in " + city2.toUpperCase());

        // length
        System.out.println("Length of '" + city1 + "': " + city1.length());
        System.out.println("Length of '" + city2 + "': " + city2.length());

        // charAt
        System.out.println("The first letter of " + city1 + " is " + city1.charAt(0));
        System.out.println("The last letter of " + city1 + " is " + city1.charAt(city1.length() - 1));

        // for loop with charAt()
        for (int i = 0; i < city1.length(); i++) {
            System.out.println(city1.charAt(i));
        }

        // indexOf()
        int landStart = city1.indexOf("land");
        System.out.println("'land' starts at index " + landStart);

        landStart = city2.indexOf("land");
        System.out.println("'land' starts at index " + landStart);

        if (city1.indexOf("land") > 0) {
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
        String firstHalf = city1.substring(0, city1.length() / 2); // (0, 4)
        System.out.println(firstHalf);


        // substring (int)

        // last three letters
        String lastThree = city1.substring(city1.length() - 3);
        System.out.println(lastThree);

        // last half
        String lastHalf = city1.substring(city1.length() / 2); //(5)
        System.out.println(lastHalf);

        // split

        String numbers = "3 5 7 9";
        String[] numberStrings = numbers.split(" ");
        int sum = 0;

        for (int i = 0; i < numberStrings.length; i++){
            sum += Integer.parseInt(numberStrings[i]);
        }

        System.out.println("The sum: " + sum);


    }
}
