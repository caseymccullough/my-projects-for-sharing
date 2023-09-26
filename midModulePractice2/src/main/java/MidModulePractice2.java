public class MidModulePractice2 {
    public static void main(String[] args) {
        // make calls that test your static methods

        String[] speech = {"Four", "score", "and", "seven", "years", "ago"};
        displayStringArray(speech);

    }

    // Define static methods
    /*
        1. In the console, show each element in the String array in a comma-separated list
        Bonus: eliminate the tailing comma after the last item.
    */
    public static void displayStringArray(String[] strings){
        for (String string : strings){
            System.out.print(string + ", ");
        }

    }
}
