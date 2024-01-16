package wanaprom.sudthipod.lab6;

/**
 * RockPaperScissorGameVer2:
 * This game class is an extension of the RockPaperScissorGame.
 * The class implements the HasRule interface.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 16/01/2024
 */

public class RockPaperScissorGameVer2 extends RockPaperScissorGame implements HasRule {
    // Constructors
    public RockPaperScissorGameVer2() {
        super();
    }
    
    public RockPaperScissorGameVer2(String player1Choice, String player2Choice) {
        super(player1Choice, player2Choice);
    }
    
    // Game rules
    @Override
    public void gameRule() {
        System.out.println("Rock Paper Scissor Rules : ...");
    }

    // Play the game method
    @Override
    public void playGame() { // Why do we need to override this method?
        System.out.println("Playing " + super.getGameName() + " Version 2"); // Announce the game

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
    @Override
    public String toString() { // @Override keyword is not also needed here
        return super.getGameName() + " Version 2 : " + super.toString();
    }
}
