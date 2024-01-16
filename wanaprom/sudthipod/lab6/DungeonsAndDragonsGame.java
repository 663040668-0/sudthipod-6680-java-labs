package wanaprom.sudthipod.lab6;

/**
 * DungeonsAndDragonsGame
 * This game class is an extension of the abstract CardGame class with the game name "Dungeons And Dragons Game"
 * and need 3 players.
 * This game class also implements the HasRule, UseBoard, and UseDice interface.
 * The gameplay is still unavailable.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 16/01/2024
 */

public class DungeonsAndDragonsGame extends CardGame implements HasRule, UseBoard, UseDice {
    // Constructors
    public DungeonsAndDragonsGame(int numOfCardsPerPlayer) {
        super(numOfCardsPerPlayer);
        super.setGameName("Dungeons And Dragons Game");
        super.setNumOfPlayers(3);
    }
    
    public DungeonsAndDragonsGame() {
        this(6);
    }

    // Game rule
    public void gameRule() {
        System.out.println(super.getGameName() + " Rules : ...");
    }

    // Set up the board
    public void setUpBoard() {
        System.out.println("Setting up board for " + super.getGameName());
    }

    // Roll the dice
    public void rollDice() {
        System.out.println("Roll 2 dices for " + super.getGameName());
    }
    
    // Play the game method
    @Override
    public void playGame() {
        System.out.println("Playing " + super.getGameName()); // Announce the game
    }

    // Override toString() with information about the game
    @Override
    public String toString() {
        return super.getGameName() + " : " + super.toString();
    }
}
