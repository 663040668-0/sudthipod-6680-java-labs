package wanaprom.sudthipod.lab3;

/**
 * The ConfigurableNumberGuessingGame:
 * This game starts with configuration for a player to choose min value, max value, and maximum number of tries.
 * The game accepts an integer input in the optional range provided in the configuration (inclusive).
 * The game will random an integer in the provided range.
 * Players need to input the exact same integer in order to win the game.
 * If the players have reach their maximum try attempts, they lose the game.
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

public class ConfigurableNumberGuessingGame {
    // Declare variables and constants
    static int realAns, min, max, numTries, maxTries;
    static Scanner input = new Scanner(System.in);

    // Receive input and handle error
    static int getUserInput(String text) {
        while (true) {
            try {
                System.out.print(text);
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter an integer.");
                input.nextLine();
                continue;
            }
        }
    }

    // Game configuration method
    static void configure() {
        // Get any integer for min value
        min = getUserInput("Enter the min value: ");

        // Max value must equal or greater than min
        while (true) {
            max = getUserInput("Enter the max value: ");
            if (max < min) {
                System.err.println("The max value must be at least equal to the min value.");
                continue;
            } else
                break;
        }
    
        // Maximum number of tries must be an positive integer
        while (true) {
            maxTries = getUserInput("Enter the maximum number of tries: ");
            if (maxTries <= 0) {
                System.err.println("The maximum number of  tries must be greater than 0.");
                continue;
            } else
                break;
        }
    }

    // Number randomization method
    static void genAnswer() {
        realAns = min + (int) (Math.random() * (max - min + 1));
    }

    // Gameplay method
    static void playGame() {
        // Start the game
        System.out.println("Welcome to a number guessing game!");
        while (true) {
            // Receive input
            int userAns;
            while (true) {
                userAns = getUserInput("Enter an integer between " + min + " and " + max + "\n> ");
                if (userAns < min || userAns > max) {
                    System.err.println("The number must be between " + min + " and " + max + ".");
                    continue;
                } else
                    break;
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
            if (numTries >= maxTries) {
                System.out.println("You have tried " + numTries + " times. You ran out of guesses.");
                System.out.println("The answer is " + realAns + ".");
                break;
            }
        }

        // Close the input
        input.close();
    }

    // Main method
    public static void main(String[] args) {
        configure();
        genAnswer();
        playGame();
    }
}
