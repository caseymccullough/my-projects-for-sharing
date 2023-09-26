import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class App {
    private final Scanner sc = new Scanner(System.in);
    private final String FILE_PATH = "src/main/data/runner_data.txt";
    private static int nextId;

    private Map <Integer, Runner> runners = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        App app = new App();
        app.loadRunners();
        app.run();
    }

    private void loadRunners() throws FileNotFoundException {
        File dataFile = new File(FILE_PATH);
        try (Scanner fileReader = new Scanner(dataFile)) {
            nextId = Integer.parseInt(fileReader.nextLine());
            System.out.println("next id: " + nextId);
            while (fileReader.hasNextLine()) {
                String lineOfInput = fileReader.nextLine();
                String[] runnerData = lineOfInput.split("\\s+");
                String firstName = runnerData[0];
                String lastName = runnerData[1];
                int bibNumber = Integer.parseInt(runnerData[2]);
                Runner runner = new Runner(firstName, lastName, bibNumber);
                runners.put (bibNumber, runner);
            }
        } catch (FileNotFoundException e) {
            // Could not find the file at the specified path
            System.out.println("The runner data file was not found at " + dataFile.getAbsolutePath());
        }
    }

    private Runner generateRunner() {
        String firstName = null;
        String lastName = null;
        do {
            System.out.print("Enter runner's first name: ");
            firstName = sc.nextLine();
        } while (firstName == null || firstName.isBlank());
        do {
            System.out.print("Enter runner's last name: ");
            lastName = sc.nextLine();
        } while (lastName == null || lastName.isBlank());

        return new Runner(firstName, lastName, getNextId());
    }

    private void addRunnerToFile(Runner runner) {
        try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(FILE_PATH, true))) {
            String runnerString = "\n" + runner.getFirstName() + '\t' + runner.getLastName() + '\t' + runner.getBibNumber();
            dataOutput.print(runnerString);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing.");
        }
    }

    private void removeRunner (int bibNumber) {

    }

    private void run() {

        while (true) {
            // Main menu loop
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
            if (mainMenuSelection == 1) {
                // display all runners
                for (Map.Entry<Integer, Runner> runner : runners.entrySet()) {
                    System.out.println(runner);
                }

            } else if (mainMenuSelection == 2) {
                System.out.println("Add new runners here");
                Runner newRunner = generateRunner();
                System.out.println("Adding new runner:");
                System.out.println(newRunner);
                runners.put(newRunner.getBibNumber(), newRunner);
                System.out.println("adding runner to file");
                addRunnerToFile(newRunner);
            } else if (mainMenuSelection == 0) {
                break;
            }
        }
    }


    // UI methods

    private static int getNextId() {
        nextId++;
        return nextId;
    }

    private void printMainMenu() {
        System.out.println("1: Display all runners");
        System.out.println("2: Add a runner");
        System.out.println("0: Exit");
        System.out.println();
    }

    private int promptForMenuSelection(String prompt) {
        System.out.println(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;

    }

}
