import java.util.Scanner;

public class RaceRunner {

    final static double RACE_DISTANCE = 6.2; // miles

    public static void main(String[] args) {

        String runner1Name;
        String runner2Name;
        String runner1City;
        String runner2City;
        String runner1State;
        String runner2State;
        int runner1TimeInSeconds;
        int runner2TimeInSeconds;

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Race Runner v. 1.0");

        // Get information for runner #1
        System.out.println("Please enter information for runner #1: ");
        System.out.print("Name: ");
        runner1Name = input.nextLine();
        System.out.print("City: ");
        runner1City = input.nextLine();
        System.out.print("State: ");
        runner1State = input.nextLine();
        System.out.print("Time: ");
        runner1TimeInSeconds = Integer.parseInt(input.nextLine());

        // Get information for runner #2
        System.out.println("Please enter information for runner #2: ");
        System.out.print("Name: ");
        runner2Name = input.nextLine();
        System.out.println("Time: ");
        runner2TimeInSeconds = input.nextInt();
        System.out.print("City: ");
        runner2City = input.nextLine();
        System.out.print("State: ");
        runner2State = input.nextLine();

        System.out.println("Results");
        String runner1Info = runner1Name + "\t" + runner1City + ", " + runner1State + "\t" + runner1TimeInSeconds;
        String runner2Info = runner2Name + "\t" + runner2City + ", " + runner2State + "\t" + runner2TimeInSeconds;

        System.out.println(runner1Info);
        System.out.println(runner2Info);






    }
}
