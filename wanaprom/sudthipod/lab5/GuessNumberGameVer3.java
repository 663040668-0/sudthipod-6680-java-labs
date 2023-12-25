package wanaprom.sudthipod.lab5;

import java.text.DecimalFormat; // For formatting decimals

/**
 * The GuessNumberGameVer3:
 * This game class inherited from GuessNumberGameVer2.
 * Additional features are guesses statistics displays, and error command handling.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 25/12/2023
 */

public class GuessNumberGameVer3 extends GuessNumberGameVer2 {
    // Class constructor (send to super class)
    public GuessNumberGameVer3(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    public GuessNumberGameVer3(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    public GuessNumberGameVer3() {
        super();
    }

    // Class methods
    // When input 'v' or 'V'
    public void guessAverage() {
        int sumGuess = super.guesses[0];
        for (int i = 1; i < super.numGuesses; i++) {
            sumGuess += super.guesses[i];
        }
        System.out.println("Average = " + new DecimalFormat("#.##").format((float) sumGuess / super.numGuesses));
    }

    // When input 'm' or 'M'
    public void guessMin() {
        // Compare each guesses
        int minGuess = super.guesses[0];
        for (int i = 1; i < super.numGuesses; i++) {
            minGuess = Math.min(minGuess, super.guesses[i]);
        }
        System.out.println("Min = " + minGuess);
    }

    // When input 'x' or 'X'
    public void guessMax() {
        // Compare each guesses
        int maxGuess = super.guesses[0];
        for (int i = 1; i < super.numGuesses; i++) {
            maxGuess = Math.max(maxGuess, super.guesses[i]);
        }
        System.out.println("Max = " + maxGuess);
    }

    // Game loops sequence
    @Override // To add more options
    public void playGames() {
        boolean isPlaying = true; // Exit when isPlaying is false
        while (isPlaying) {
            // Start the games sequence
            playGame();

            // Post-game prompt
            while (true) {
                System.out.println("If you want to play again, type 'y' to continue or 'q' to quit.");
                System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on a specific play.");
                System.out.println("Type 'v' to see the average guesses, 'm' to show the minimum of the guesses, or 'x' to show the maximum of the guesses:");
                
                String choice = input.next();
                if (choice.equalsIgnoreCase("q")) {
                    System.out.println("Thanks for playing, bye!");
                    isPlaying = false;
                    break;
                } else if (choice.equalsIgnoreCase("y")) {
                    super.guesses = new int[MAX_GUESSES]; // Reset the guesses array
                    super.numGuesses = 0; // Reset the number of guesses
                    break;
                } else if (choice.equalsIgnoreCase("a")) {
                    showGuesses();
                } else if (choice.equalsIgnoreCase("g")) {
                    showSpecific();
                } else if (choice.equalsIgnoreCase("v")) {
                    guessAverage();
                } else if (choice.equalsIgnoreCase("m")) {
                    guessMin();
                } else if (choice.equalsIgnoreCase("x")) {
                    guessMax();
                } else {
                    System.err.println("Error: Invalid command.");
                }
            }
        }
    }
}
