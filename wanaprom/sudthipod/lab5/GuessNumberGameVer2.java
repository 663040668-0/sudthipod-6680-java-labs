package wanaprom.sudthipod.lab5;

import java.util.InputMismatchException; // For error handling

/**
 * The GuessNumberGameVer2:
 * This game class inherited from GuessNumberGameVer1.
 * Additional features are guesses history, allocate memory space for max guesses array size
 * , and detect if the input is in the range by overriding the playGame() method to the super class.
 * Input error handling is also provided.
 * Replays are allowed in this version.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 25/12/2023
 */

public class GuessNumberGameVer2 extends GuessNumberGameVer1 {
    // Class variables
    protected int[] guesses;
    protected int numGuesses = 0;
    protected final int MAX_GUESSES = 20;

    // Class constructor (send to super class)
    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
        this.guesses = new int[MAX_GUESSES]; // Allocate memory space for the array

        if (maxTries > MAX_GUESSES) {
            System.out.println("Warning: The maximum number of tries is greater than the maximum number of guesses history. Some guesses may be missing from the history.");
        }
    }

    public GuessNumberGameVer2(int minNum, int maxNum) {
        super(minNum, maxNum);
        this.guesses = new int[MAX_GUESSES]; // Allocate memory space for the array
    }

    public GuessNumberGameVer2() {
        super();
        this.guesses = new int[MAX_GUESSES]; // Allocate memory space for the array
    }

    // Class methods
    // Play the game
    @Override
    public void playGame() {
        int userGuess; // User input holder
        boolean isWon = false;

        // Generate a new correct number
        super.correctNum = super.minNum + (int) (Math.random() * ((super.maxNum - super.minNum) + 1));

        // Start the game loop
        System.out.println("Welcome to a number guessing game!");
        while (true) {
            // Get user input
            System.out.print("Enter an integer between " + super.minNum + " and " + super.maxNum + ": ");
            try {
                userGuess = input.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter an integer.");
                input.nextLine();
                continue;
            }
            numGuesses++;

            // Judge the answer
            if (userGuess == super.correctNum) {
                System.out.println("Congratulations!");
                System.out.println("You have tried " + numGuesses + " time" + (numGuesses > 1 ? "s." : "."));
                isWon = true;
            } else if (userGuess < super.correctNum && userGuess >= super.minNum) {
                System.out.println("Try a higher number.");
            } else if (userGuess > super.correctNum && userGuess <= super.maxNum) {
                System.out.println("Try a lower number.");
            } else {
                numGuesses--; // Decrease one try if input is not in the range
                System.out.println("Please enter an integer between " + super.minNum + " and " + super.maxNum + ".");
                continue; // Repeat the prompt so the guess won't be appended to the array
            }

            // Check if the guesses array is full
            if (numGuesses < MAX_GUESSES) {
                guesses[numGuesses - 1] = userGuess; // Append the guess to the array if the input is in the range
            } else {
                System.err.println("Error: The guesses history array is full. Guesses will no longer be appended.");
            }

            // Check if the player has won
            if (isWon) break;

            // Run out of tries number but still didn't win
            if (numGuesses >= super.maxTries) {
                System.out.println("You have tried " + numGuesses + " time" + (numGuesses > 1 ? "s." : ".") + " You ran out of guesses.");
                System.out.println("The answer is " + super.correctNum);
                break;
            }
        }
    }

    // When input 'a' or 'A'
    public void showGuesses() {
        // Print the all the guesses
        for (int i = 0; i < numGuesses; i++) {
            System.out.print(guesses[i] + " ");
        }
        System.out.println(); // End of line
    }

    // When input 'g' or 'G'
    public void showSpecific() {
        while (true) {
            System.out.println("Enter which guess in the range (1-" + numGuesses + ")");
            int guessSelect;
            try {
                guessSelect = input.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter an integer.");
                input.nextLine();
                continue;
            }
            // Check if the input is in the range
            if (guessSelect >= 1 && guessSelect <= numGuesses) {
                System.out.println("Guess " + guessSelect + " is " + guesses[guessSelect - 1]);
                break;
            } else {
                System.err.println("Error: Please enter an integer in the range.");
            }
        }
    }

    // Game loops sequence
    public void playGames() {
        boolean isPlaying = true; // Exit when isPlaying is false
        while (isPlaying) {
            // Start the games sequence
            playGame();

            // Post-game prompt
            while (true) {
                System.out.println("If you want to play again, type 'y' to continue or 'q' to quit.");
                System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on a specific play:");
                
                String choice = input.next();
                if (choice.equalsIgnoreCase("q")) {
                    System.out.println("Thanks for playing, bye!");
                    isPlaying = false;
                    break;
                } else if (choice.equalsIgnoreCase("y")) {
                    guesses = new int[MAX_GUESSES]; // Reset the guesses array
                    numGuesses = 0; // Reset the number of guesses
                    break;
                } else if (choice.equalsIgnoreCase("a")) {
                    showGuesses();
                } else if (choice.equalsIgnoreCase("g")) {
                    showSpecific();
                } else {
                    System.err.println("Error: Invalid command.");
                }
            }
        }
    }
}
