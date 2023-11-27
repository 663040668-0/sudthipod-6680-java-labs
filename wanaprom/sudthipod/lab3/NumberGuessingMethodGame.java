package wanaprom.sudthipod.lab3;

/**
 * The NumberGuessingMethodGame:
 * This game accepts an integer argument in the range from 1 to 20 (inclusive).
 * The game will random an integer in the aforementioned range.
 * Players need to input the exact same integer in order to win the game.
 * Players have maximum try attempts of 5. Otherwise, they'll lose the game.
 *
 * Author : Sudthipod Wanaprom
 * ID : 663040668-0
 * Sec : 2
 *
 * Lastest Update : 27/11/2023
 */

// Import necessary packages
import java.lang.Math; // For randomization
import java.util.Scanner; // For input
import java.util.InputMismatchException; // For handle exception

public class NumberGuessingMethodGame {
    // Declare variables and constants
    static int realAns;
    static Scanner input = new Scanner(System.in);
    static int numTries = 0;
    final static int MIN_NUM = 1;
    final static int MAX_NUM = 20;
    final static int MAX_TRIES = 5;

    // Number randomization method
    static void genAnswer() {
        realAns = MIN_NUM + (int)( Math.random() * (MAX_NUM - MIN_NUM + 1) );
    }

    // Gameplay method
    static void playGame() {
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
            if (userAns == realAns) { // Win
                System.out.println("Congratulations!");
                System.out.println("You have tried " + numTries + " times.");
                break;
            } else if (userAns < realAns) // Lower than the real answer
                System.out.println("Try a higher number!");
            else // Higher than the real answer
                System.out.println("Try a lower number!");

            // Run out of tries number but still didn't win
            if (numTries >= MAX_TRIES) {
                System.out.println("You have tried " + numTries + " times. You ran out of guesses.");
                System.out.println("The answer is " + realAns);
                break;
            }
        }

        // Close the input
        input.close();
    }

    // Main method
    public static void main(String[] args) {
        genAnswer();
        playGame();
    }
}
