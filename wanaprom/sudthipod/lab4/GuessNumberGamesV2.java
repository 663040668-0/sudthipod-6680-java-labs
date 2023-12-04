package wanaprom.sudthipod.lab4;

// Import necessary packages
import java.util.Arrays; // For array subset
import java.util.InputMismatchException; // For handle exception
import java.util.Scanner; // For user input

/**
 * The GuessNumberGamesV2:
 * This game sequence starts with configuration for a player to choose the minimum value, maximum value, and maximum number of tries.
 * The game accepts an integer input within the provided range in the configuration (inclusive).
 * The game will generate a random integer within the range received in the configuration.
 * Players need to input the exact same integer in order to win the game.
 * If the players have reached their maximum tries without winning, they lose the game.
 * Players can review their previous guesses by interacting with the post-game prompt.
 * Then they can choose to replay the game or quit by interacting with the prompt.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 04/12/2023
 */

public class GuessNumberGamesV2 {
    static int realAns, min, max, numTries, maxTries;
    static Scanner input = new Scanner(System.in);
    static String[] guesses; // Use String because they're going to be joined

    // Receive input and handle error for int
    static int getUserInputInt(String text, int condition) {
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
                    case 4 -> {
                        // Check if it's in the numTries range
                        if (receivedInt < 1 || receivedInt > numTries) {
                            System.err.println("The number must be between " + 1 + " and " + numTries + ".");
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

    // Receive input and handle error for String
    static String getUserInputString(String text) {
        System.out.print(text);
        String receivedText = input.nextLine();
        if (receivedText.isEmpty()) { // Handle with nextLine() auto returns an empty string
            receivedText = input.nextLine();
        }
        return receivedText.trim().toLowerCase();
    }

    // Game configuration method
    static void configure() {
        min = getUserInputInt("Enter the min value: ", 0);
        max = getUserInputInt("Enter the max value: ", 1);
        maxTries = getUserInputInt("Enter the maximum number of tries: ", 2);
    }

    // Generate answer
    static void genAnswer() {
        realAns = min + (int) (Math.random() * (max - min + 1)); 
    }

    static void postGame() {
        guesses = Arrays.copyOf(guesses, numTries); // Subset the array to the number of tries
        while (true) { 
            String choice = getUserInputString("Enter 'a' to list all guesses, 'g' for specific guess, or any other key to quit the session: ");
            switch (choice) { // Switch use String.equals(). So, this is available in older Java versions
                case "a" -> {
                    System.out.println("All guesses: \n" + String.join(" ", guesses)); // Join guesses with space
                    continue;
                }
                case "g" -> {
                    int guessSelect = getUserInputInt("Enter the number of the guess you want to see (1-"+ numTries + "): ", 4);
                    System.out.println("Guess " + (guessSelect) + ": " + guesses[guessSelect - 1]); // -1 because array index starts from 0
                    continue;
                } 
                default -> {
                    return;
                }
            }
        }
    }

    // Play game on repeatition
    static void playGame() {
        // Game initialization
        numTries = 0; // Reset tries amount
        guesses = new String[maxTries]; // Reset an array to store the guesses
        genAnswer(); // Generate new answer for each game

        // Iterate the game until it's over
        while (true) { 
            // Receive input
            int userAns = getUserInputInt("Enter an integer between " + min + " and " + max + "\n> ", 3);
            guesses[numTries] = userAns + ""; // Store the guess in the array

            // Add number of tries
            numTries++;

            // Judge the answer
            String isPlural = (numTries > 1) ? "s" : ""; // Concatenate "s" if tried more than 1 time
            if (userAns == realAns) { // Win
                System.out.println("Congratulations!");
                System.out.println("You have tried " + numTries + " time" + isPlural + ".");
                break;
            } else if (userAns < realAns) { // Lower than the real answer
                System.out.println("Try a higher number!"); 
            }else { // Higher than the real answer
                System.out.println("Try a lower number!");
            }

            // Run out of tries number but still didn't win
            if (numTries >= maxTries) {
                System.out.println("You have tried " + numTries + " time" + isPlural + ". You ran out of guesses.");
                System.out.println("The answer is " + realAns);
                break;
            }
        }

        postGame(); // Post game prompt
    }

    static void playGames() {
        //Start the games sequence
        while (true) {
            System.out.println("Welcome to a number guessing game!");
            playGame(); // Play game

            //Replay prompt
            String replayAnswer = getUserInputString("Want to play again? (Y or y): ");
            if (!replayAnswer.equals("y")) {
                System.out.println("Thanks you for playing our games. Bye! ;P");
                input.close(); // Close the input
                break;
            } // Else, continue
        }
    }

    public static void main(String[] args) {
        configure();
        playGames();
    }
}
