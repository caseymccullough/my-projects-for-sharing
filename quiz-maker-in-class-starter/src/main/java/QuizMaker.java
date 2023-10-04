import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		QuizMaker quizMaker = new QuizMaker();
		quizMaker.run();
	}

	public void run() throws FileNotFoundException {

		File inputFile = null;
		// 1. get correct path
		do {
			System.out.print("Where is the quiz file? ");
			String path = userInput.nextLine();

			inputFile = new File (path);

			// validate the input file
			if (!inputFile.exists()){
				System.out.println("The file doesn't exist");
				inputFile = null;
			} else if (!inputFile.isFile()){
				System.out.println(path + " is not a file");
				inputFile = null;
			}

		} while (inputFile == null);

		// 2. make and populate a list of quiz questions
		List <QuizQuestion> questions = new ArrayList<>();

		try(Scanner fileScanner = new Scanner (inputFile)){
			while (fileScanner.hasNextLine()){
				String lineOfText = fileScanner.nextLine();
				QuizQuestion question = new QuizQuestion(lineOfText);
				questions.add(question);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// 3. Deliver the quiz by displaying the questions along with
		// their possible answers one question at a time. Keep track
		// of the number of questions asked, and the number of correct answers

		int questionsAsked = 0;
		int numberCorrect = 0;

		for (QuizQuestion quizQuestion : questions) {
			questionsAsked++;
			System.out.print("Question #" + questionsAsked + ": ");
			System.out.println(quizQuestion.getQuestion());

			// print possible answers
			String[] possibleAnswers = quizQuestion.getAnswers();
			for (String possibleAnswer : possibleAnswers) {
				System.out.println(possibleAnswer);
			}

			System.out.print("Your answer: ");
			String userAnswer = userInput.nextLine();
			if (quizQuestion.isCorrectAnswer(userAnswer)){
				System.out.println("CORRECT!");
				numberCorrect++;
			} else {
				System.out.println("WRONG!");
			}
		}

		System.out.println("You got " + numberCorrect + " out of " + questionsAsked + " questions");
	}

}
