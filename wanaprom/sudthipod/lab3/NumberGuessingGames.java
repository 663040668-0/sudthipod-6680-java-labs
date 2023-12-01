package wanaprom.sudthipod.lab3;

/**
 * The NumberGuessingGames: This games sequence starts with configuration for a
 * player to choose min value, max value, and maximum number of tries. The game
 * accepts an integer input in the optional range provided in the configuration
 * (inclusive). The game will random an integer in the provided range. Players
 * need to input the exact same integer in order to win the game. If the players
 * have reach their maximum try attempts, they lose the game. Player can either
 * decide to replay the game or quit by interact with the prompt.
 *
 * Author : Sudthipod Wanaprom ID : 663040668-0 Sec : 2
 *
 * Lastest Update : 01/12/2023
 */

// Import necessary packages
import java.util.InputMismatchException; // For randomization
import java.util.Scanner; // For handle exception

public class NumberGuessingGames {

    // Declare variables and constants
    static int realAns, min, max, numTries, maxTries;
    static Scanner input = new Scanner(System.in);

    // Receive input and handle error
    static int getUserInput(String text, int condition) {
        while (true) {
            try {
                System.out.print(text);
                int receivedInt = input.nextInt();
                // Check for required condition
                switch (condition) {
                    case 1 -> {
                        // Check if max isn't less than min
                        if (receivedInt < min) {
                            System.err.println("The max value must be at least equal to the min value.");
                            continue;
                        }
                    }
                    case 2 -> {
                        // Check for positive integer
                        if (receivedInt <= 0) {
                            System.err.println("The maximum number of tries must be greater than 0.");
                            continue;
                        }
                    }
                    case 3 -> {
                        // Check if it's in the min and max range
                        if (receivedInt < min || receivedInt > max) {
                            System.err.println("The number must be between " + min + " and " + max + ".");
                            continue;
                        }
                    }
                    default -> {
                        // Check nothing
                    }
                }

                // Normally return value
                return receivedInt;
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter an integer.");
                input.nextLine(); // Reset the input to avoid overflow
            }
        }
    }

    // Game configuration method
    static void configure() {
        min = getUserInput("Enter the min value: ", 0);
        max = getUserInput("Enter the max value: ", 1);
        maxTries = getUserInput("Enter the maximum number of tries: ", 2);
    }

    // Number randomization method
    static void genAnswer() {
        realAns = min + (int) (Math.random() * (max - min + 1));
    }

    // Gameplay method
    static void playGame() {
        // Start the game
        while (true) {
            // Receive input
            int userAns;
            userAns = getUserInput("Enter an integer between " + min + " and " + max + "\n> ", 3);

            // Add number of tries
            numTries++;

            // Judge the answer
            String isPlural = (numTries > 1) ? "s" : ""; // Concastenate "s" if tried more than 1 time
            if (userAns == realAns) { // Win
                System.out.println("Congratulations!");
                System.out.println("You have tried " + numTries + " time" + isPlural + ".");
                break;
            } else if (userAns < realAns) // Lower than the real answer
            {
                System.out.println("Try a higher number!"); 
            }else // Higher than the real answer
            {
                System.out.println("Try a lower number!");
            }

            // Run out of tries number but still didn't win
            if (numTries >= maxTries) {
                System.out.println("You have tried " + numTries + " time" + isPlural + ". You ran out of guesses.");
                System.out.println("The answer is " + realAns);
                break;
            }
        }
    }

    //Games sequence method
    static void playGames() {
        //Start the games sequence
        while (true) {
            System.out.println("Welcome to a number guessing game!");
            numTries = 0; // Reset tries amount
            playGame();

            //Replay prompt
            System.out.print("Want to play again? (Y or y): ");
            input.nextLine();
            String promptAnswer = input.nextLine().toLowerCase();
            if (!promptAnswer.equals("y")) {
                System.out.println("Thanks you for playing our games. Bye! ;P");
                input.close(); // Close the input
                break;
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        configure();
        genAnswer();
        playGames();
    }
}
