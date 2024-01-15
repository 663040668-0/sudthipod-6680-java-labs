package wanaprom.sudthipod.lab6;

/**
 * Game abstract class:
 * This class defines the common features of the games in lab6.
 * It is an abstract class that cannot be instantiated.
 * Will be inherited by GuesseNumberGame, RockPaperScissorGame, and MonopolyGame
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 15/01/2024
 */

public abstract class Game {
    // Class attributes
    protected String gameName;
    protected int numOfPlayers; // Number of players needed to play the game

    //Constructors
    public Game(String gameName, int numOfPlayers) {
        // Takes two arguments
        this.gameName = gameName;
        this.numOfPlayers = numOfPlayers;
    }

    public Game() {
        // Takes no arguments
        this("unknown game", 0);
    }

    // Getters and setters
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    // Class methods
    public abstract void playGame(); // Abstract tells the subclass to implement the method

    // Override methods
    @Override
    public abstract String toString(); // Abstract tells the subclass to implement the method
}
