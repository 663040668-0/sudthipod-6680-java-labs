package wanaprom.sudthipod.lab6;

/**
 * GuessNumberGameVer2:
 * This game class is an extension of the GuessNumberGameVer1.
 * The class implements the HasRule interface.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 16/01/2024
 */

public class GuessNumberGameVer2 extends GuessNumberGameVer1 implements HasRule {
    // Constructors
    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }
    
    public GuessNumberGameVer2(int minNum, int maxNum) {
        super(minNum, maxNum);
    }
    
    public GuessNumberGameVer2() {
        super();
    }

    // Game rules
    @Override
    public void gameRule() {
        System.out.println(super.getGameName() + " Rules : ...");
    }
    
    // Play the game method
    @Override
    public void playGame() { // Why do we need to override this method?
        System.out.println("Playing " + super.getGameName() + " Version 2"); // Announce the game

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
    public String toString() { // @Override keyword is not also needed here
        return super.getGameName() + " Version 2 : " + super.toString();
    }
}
