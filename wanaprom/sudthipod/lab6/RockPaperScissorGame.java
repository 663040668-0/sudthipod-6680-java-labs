package wanaprom.sudthipod.lab6;

/**
 * RockPaperScissorGame:
 * This game class is an extension of the abstract Game class with the game name "Rock Paper Scissor Game"
 * and need 2 players.
 * The game accepts a String from each user and compares them in order to determine the winner.
 * In following order:
 * Rock > Scissor
 * Scissor > Paper
 * Paper > Rock
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 15/01/2024
 */

public class RockPaperScissorGame extends Game {
    // Class attributes
    protected String player1Choice, player2Choice;

    // Constructors
    public RockPaperScissorGame(String player1Choice, String player2Choice) {
        super("Rock Paper Scissor Game", 2);
        this.player1Choice = player1Choice;
        this.player2Choice = player2Choice;
    }

    public RockPaperScissorGame() {
        this("rock", "rock");
    }

    // Getters and setters
    public String getPlayer1Choice() {
        return player1Choice;
    }

    public void setPlayer1Choice(String player1Choice) {
        this.player1Choice = player1Choice;
    }

    public String getPlayer2Choice() {
        return player2Choice;
    }

    public void setPlayer2Choice(String player2Choice) {
        this.player2Choice = player2Choice;
    }

    // Play the game method
    public void playGame() { // @Override keyword is not needed here
        System.out.println("Playing " + super.gameName); // Announce the game

        /* Gameplay is unnecessary for now

        // Compare the choices
        if (player1Choice.equalsIgnoreCase(player2Choice)) { // Tie
            System.out.println("It's a tie!");
        } else if ((player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("scissors")) ||
                   (player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("rock")) ||
                   (player1Choice.equalsIgnoreCase("scissors") && player2Choice.equalsIgnoreCase("paper"))) {
            // Only consider winning cases
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
        
        */
    }

    // Override toString() with information about the game
    public String toString() { // @Override keyword is not also needed here
        return super.toString() +
                " { " +
                "player1Choice='" + this.player1Choice + "', " +
                "player2Choice='" + this.player2Choice +
                "' }";
    }
}
