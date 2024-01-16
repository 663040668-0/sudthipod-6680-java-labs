package wanaprom.sudthipod.lab6;

/**
 * MonopolyGameVer2:
 * This game class is an extension of the MonopolyGame.
 * The class implements the HasRule, UseBoard, and UseDice interface.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 16/01/2024
 */

public class MonopolyGameVer2 extends MonopolyGame implements HasRule, UseBoard, UseDice {
    // Constructors
    public MonopolyGameVer2() {
        super();
    }
    
    public MonopolyGameVer2(String[] gamePieces) {
        super(gamePieces);
    }

    // Game rules
    @Override
    public void gameRule() {
        System.out.println("Monopoly Rules : ...");
    }
    
    // Set up the board
    @Override
    public void setUpBoard() {
        System.out.println("Set up monopoly board");
    }

    // Roll the dice
    @Override
    public void rollDice() {
        System.out.println("Roll 2 dices for monopoly game");
    }

    // Play the game method
    @Override
    public void playGame() { // Why do we need to override this method?
        System.out.println("Playing " + super.getGameName() + " Version 2"); // Announce the game

        /* Gameplay is unnecessary for now

        // Each player presents their properties
        for (int i = 0; i < super.numOfPlayers; i++) {
            System.out.println("Player" + (i + 1) + " has " + this.gamePieces[i]);
        }

        */
    }

    // Override toString() with information about the game
    @Override
    public String toString() { // @Override keyword is not also needed here
        return super.getGameName() + " Version 2 : " + super.toString();
    }
}
