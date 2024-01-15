package wanaprom.sudthipod.lab6;

/**
 * CardGame abstract class:
 * This class is an extension of the abstract Game class.
 * Specifically used for card games.
 * This class takes an integer argument which is the number of cards per player.
 * In this case, they're DungeonsAndDragons, and Poker.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 15/01/2024
 */

public abstract class CardGame extends Game {
    // Class attributes
    protected int numOfCardsPerPlayer;

    // Constructors
    public CardGame(int numOfCardsPerPlayer) {
        super();
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

    public CardGame() {
        super();
        this.numOfCardsPerPlayer = 0;
    }

    // Getters and setters
    public int getNumOfCardsPerPlayer() {
        return numOfCardsPerPlayer;
    }

    public void setNumOfCardsPerPlayer(int numOfCardsPerPlayer) {
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

    // Play the game method
    @Override
    public abstract void playGame();

    // Override toString() with information about the game
    @Override
    public String toString() {
        return super.toString() + " { " +
                "numOfCardsPerPlayer='" + numOfCardsPerPlayer +
                "' }";
    }

}
