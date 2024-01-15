package wanaprom.sudthipod.lab6;

public class PokerGame extends CardGame implements HasRule {
    // Constructors
    public PokerGame(int numOfCardsPerPlayer) {
        super(numOfCardsPerPlayer);
        super.setGameName("Poker Game");
        super.setNumOfPlayers(4);
    }
    
    public PokerGame() {
        this(0);
    }

    // Game rule
    public void gameRule() {
        System.out.println("Poker Game Rules : ...");
    }
    
    // Play the game method
    public void playGame() {
        System.out.println("Playing " + super.gameName); // Announce the game
    }

    // Override toString() with information about the game
    public String toString() {
        return super.getGameName() + " : " + super.toString();
    }
}
