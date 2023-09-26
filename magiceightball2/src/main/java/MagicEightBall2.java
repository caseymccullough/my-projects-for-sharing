/**
 MagicEightBall2.java
 Mr. Casey McCullough
 Last Modified 8/21/2023
 Provides Eerily Accurate Answers to Boolean Questions
 */

import java.util.Scanner;
import java.util.Random;

public class MagicEightBall2 {

    public static void main(String args[]) {

        Random generator = new Random();
        Scanner sc = new Scanner (System.in);
        String userInput;

        int randNum;

        String [] responses = {

                "Outlook Good", // responses[0]
                "Outlook Not So Good", // responses[1]
                "My Reply Is No",
                "Don't Count On It",
                "Mr. M says no way",
                "You May Rely On It",
                "Ask Again Later",
                "Most Likely",
                "Cannot Predict Now",
                "Yes",
                "Yes Definitely",
                "Better Not Tell You Now",
                "It Is Certain",
                "Very Doubtful",
                "It Is Decidedly So",
                "Concentrate and Ask Again",
                "Signs Point to Yes",
                "My Sources Say No",
                "Without a Doubt",
                "Reply Hazy, Try Again",
                "As I See It, Yes",
                "Everybody Thinks So",
                "That's a Strange Question.",
                "You don't know that?",
                "Oh, good one!",
                "I refuse to tell you",
                "No.  Hell no.",
                "Let me get back to you on that",
                "You must be joking.  That is not a question.",
                "I don't want to answer that question",
                "I can't even . . . "
        };

        System.out.println("WELCOME TO THE MAGIC EIGHT BALL SIMULATOR 2.0!!");
        System.out.println("FEATURING ARRAYS!!");
        System.out.println ("Full of sage advice for those too cheap to buy an actual Magic Eight Ball!");

        System.out.print("\nI see that you have travelled far to get here.  \nPlease enter your question: ");

        userInput = sc.nextLine();

        System.out.print("\" "+ userInput + "\"" + " . . . let me see . . .  \n\n");

        randNum = generator.nextInt(responses.length);

        System.out.println (responses[randNum]);

    }

}


