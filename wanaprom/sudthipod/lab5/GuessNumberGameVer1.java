package wanaprom.sudthipod.lab5;

// Import necessary packages
import java.util.Scanner; // For user input

/**
 * The GuessNumberGameVer1:
 * This game class implements the previous version of the GuessNumberGame from lab4.
 * The game accepts an integer input within the range from 1 to 10 with a maximum of 3 tries.
 * The players need to input the exact same integer in order to win the game.
 * If the players have reached their maximum tries without winning, they lose the game.
 * Replays are not allowed in this version.
 * The game needs to be created as an instance of the class in order to be played. 
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 25/12/2023
 */

public class GuessNumberGameVer1 {
    // Class variables
    protected int minNum, maxNum, maxTries;
    protected int correctNum;
    protected static int numOfGames = 0;
    Scanner input;

    // Class constructor
    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        // Initialize values
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        numOfGames++;
        this.input = new Scanner(System.in);
    }

    public GuessNumberGameVer1(int minNum, int maxNum) {
        this(minNum, maxNum, 3); // Set maxTries to 3
    }

    public GuessNumberGameVer1() {
        this(1, 10); // Set minNum and maxNum to 1 and 10
    }

    // Class methods
    public int getMinNum() {
        return this.minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }
        
    public int getMaxNum() {
        return this.maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxTries() {
        return this.maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    public static int getNumOfGames() {
        return numOfGames;
    }

    // Play the game
    public void playGame() {
        int userGuess; // User input holder
        int numOfTries = 0; // Number of tries for each game

        // Generate a new correct number
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));

        // Start the game loop
        System.out.println("Welcome to a number guessing game!");
        while (true) {
            // Get user input
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ": ");
            userGuess = input.nextInt(); // Assume input is an integer in the range from 1 to 10
            numOfTries++;

            // Judge the answer
            if (userGuess == correctNum) {
                System.out.println("Congratulations!");
                System.out.println("You have tried " + numOfTries + " time" + (numOfTries > 1 ? "s." : "."));
                break;
            } else if (userGuess < correctNum) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }

            // Run out of tries number but still didn't win
            if (numOfTries >= maxTries) {
                System.out.println("You have tried " + numOfTries + " time" + (numOfTries > 1 ? "s." : ".") + " You ran out of guesses.");
                System.out.println("The answer is " + correctNum);
                break;
            }
        }
    }

    // To string utility method
    @Override
    public String toString() {
        return "GuessNumberGameVer1 [minNum=" + minNum + ", maxNum=" + maxNum + ", correctNum=" + correctNum
                + ", maxTries=" + maxTries + ", numOfGames=" + numOfGames + "]";
    }
}
