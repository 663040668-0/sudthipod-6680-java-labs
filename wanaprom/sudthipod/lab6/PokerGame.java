package wanaprom.sudthipod.lab6;

/**
 * PokerGame:
 * This game class is an extension of the abstract CardGame class with the game name "Poker Game"
 * and need 4 players.
 * This game class also implements the HasRule interface.
 * The gameplay is still unavailable.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 15/01/2024
 */

public class PokerGame extends CardGame implements HasRule {
    // Constructors
    public PokerGame(int numOfCardsPerPlayer) {
        super(numOfCardsPerPlayer);
        super.setGameName("Poker Game");
        super.setNumOfPlayers(4);
    }
    
    public PokerGame() {
        this(5);
    }

    // Game rule
    public void gameRule() {
        System.out.println("Poker Game Rules : ...");
    }
    
    // Play the game method
    @Override
    public void playGame() {
        System.out.println("Playing " + super.gameName); // Announce the game
    }

    // Override toString() with information about the game
    @Override
    public String toString() {
        return super.getGameName() + " : " + super.toString();
    }
}
