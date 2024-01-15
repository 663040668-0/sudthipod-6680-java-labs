package wanaprom.sudthipod.lab6;

/**
 * MonopolyGame:
 * This game class is an extension of the abstract Game class with the game name "Monopoly Game"
 * and need 4 players.
 * The game accepts a list of String which are shapes or objects.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 15/01/2024
 */

public class MonopolyGame extends Game {
    // Class attributes
    protected String[] gamePieces;

    // Constructors
    public MonopolyGame(String[] gamePieces) {
        super("Monopoly Game", 4);
        this.gamePieces = gamePieces;
    }

    public MonopolyGame() {
        this(new String[]{"car", "top hat", "thimble", "boot"});
    }

    // Getters and setters
    public String[] getGamePieces() {
        return gamePieces;
    }

    public void setGamePieces(String[] gamePieces) {
        this.gamePieces = gamePieces;
    }

    // Play the game method
    public void playGame() { // @Override keyword is not needed here
        System.out.println("Playing " + super.gameName); // Announce the game

        /* Gameplay is unnecessary for now

        // Each player presents their pieces
        for (int i = 0; i < super.numOfPlayers; i++) {
            System.out.println("Player" + (i + 1) + " has brought " + this.gamePieces[i]);
        }

        */
    }

    // Override toString() with information about the game
    @Override
    public String toString() {
        return "{" +
                "gameName='" + super.gameName + "', " +
                "numOfPlayers='" + super.numOfPlayers + "', " +
                "gamePieces='" + String.join(" ", gamePieces) + "'" +
                "}";
    }
}