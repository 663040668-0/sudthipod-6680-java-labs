package wanaprom.sudthipod.lab6;

import java.util.Scanner;

/**
 * GuessNumberGameVer1:
 * This game class implements the previous version of the GuessNumberGameVer1 from lab5.
 * This game class is an extension of the abstract Game class with the game name "Guess Number Game"
 * and need only 1 player.
 * The game accepts an integer input within the range from 1 to 10 with a maximum of 3 tries.
 * The player need to input the exact same integer in order to win the game.
 * If the player have reached their maximum tries without winning, they lose the game.
 * Replays are not allowed in this version.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 15/01/2024
 */

public class GuessNumberGameVer1 extends Game {
    // Class attributes
    protected int minNum, maxNum, maxTries;
    protected int correctNum;
    Scanner input;

    // Constructors
    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        super("Guess Number Game", 1);
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        this.input = new Scanner(System.in);
    }

    public GuessNumberGameVer1(int minNum, int maxNum) {
        this(minNum, maxNum, 3);
    }
    
    public GuessNumberGameVer1() {
        this(1, 10);
    }
    
    // Getters and setters
    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    // Play the game method
    public void playGame() { // @Override keyword is not needed here
        System.out.println("Playing " + super.gameName); // Announce the game

        /* Gameplay is unnecessary for now

        // Initialization
        int numOfTries = 0; // Number of tries for each game
        int userGuess; // User input holder

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
        */
    }

    // Override toString() with information about the game
    @Override
    public String toString() {
        return "{" +
                "gameName='" + super.gameName + "', " +
                "numOfPlayers='" + super.numOfPlayers + "', " +
                "minNum='" + this.minNum + "', " +
                "maxNum='" + this.maxNum + "', " +
                "correctNum='" + this.correctNum + "', " +
                "maxTries='" + this.maxTries + "'" +
                "}";
    }
}
