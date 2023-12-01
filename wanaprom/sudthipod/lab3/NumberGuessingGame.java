package wanaprom.sudthipod.lab3;

/**
 * The NumberGuessingGame:
 * This game accepts an integer argument in the range from 1 to 20 (inclusive).
 * The game will random an integer in the aforementioned range.
 * Players need to input the exact same integer in order to win the game.
 * Players have maximum try attempts of 5. Otherwise, they'll lose the game.
 *
 * Author : Sudthipod Wanaprom
 * ID : 663040668-0
 * Sec : 2
 *
 * Lastest Update : 01/12/2023
 */

// Import necessary packages
import java.util.InputMismatchException; // For randomization
import java.util.Scanner; // For handle exception

public class NumberGuessingGame {
    // Declare input variable
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Declare variables and constants
        final int MIN_NUM = 1;
        final int MAX_NUM = 20;
        final int MAX_TRIES = 5;
        int realAns = MIN_NUM + (int)( Math.random() * (MAX_NUM - MIN_NUM + 1) );
        int numTries = 0;

        // Start the game
        System.out.println("Welcome to a number guessing game!");
        while (true) {
            // Receive input
            System.out.print("Enter an integer between " + MIN_NUM + " and " + MAX_NUM + "\n> ");
            int userAns;
            try {
                userAns = input.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter an integer.");
                input.nextLine();
                continue;
            }

            // Add number of tries
            numTries++;
            
            // Judge the answer
            String isPlural = (numTries > 1) ? "s" : ""; // Concastenate "s" if tried more than 1 time
            if (userAns == realAns) { // Win
                System.out.println("Congratulations!");
                System.out.println("You have tried " + numTries + " time" + isPlural + ".");
                break;
            } else if (userAns < realAns) // Lower than the real answer
                System.out.println("Try a higher number!");
            else // Higher than the real answer
                System.out.println("Try a lower number!");

            // Run out of tries number but still didn't win
            if (numTries >= MAX_TRIES) {
                System.out.println("You have tried " + numTries + " time" + isPlural + ". You ran out of guesses.");
                System.out.println("The answer is " + realAns);
                break;
            }
        }

        //Close the input
        input.close();
    }
}
