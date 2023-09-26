public class ArrayUtilities {

    public static void main(String[] args) {
        int [] nums = {2, 5, 7, 11, 32};

        printValues (nums); // method call

        double numsAverage = getAverage(nums); // method call
        System.out.println("Average of nums: " + numsAverage);


    }

    // method definition
    public static void printValues (int [] vals) {
        for (int i = 0; i < vals.length; i++) {
            System.out.println(vals[i]);
        }
    }
    // method definition
    public static double getAverage(int [] vals) {
        double sum = 0.0;
        double average;
        for (int i = 0; i < vals.length; i++) {
            sum += vals[i];
        }
        average = sum / vals.length;
        return average;

    }



}
