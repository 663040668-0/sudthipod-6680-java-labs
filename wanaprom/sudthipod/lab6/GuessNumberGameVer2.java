package wanaprom.sudthipod.lab6;

public class GuessNumberGameVer2 extends GuessNumberGameVer1{
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
    
    // Play the game method

    // Override toString() with information about the game
    @Override
    public String toString() {
        return "{" +
                "gameName='" + super.gameName + "', " +
                "numOfPlayers='" + super.numOfPlayers + "', " +
                "minNum='" + this.minNum + "', " +
                "maxNum='" + this.maxNum + "', " +
                "correctNum='" + this.correctNum + "', " +
                "maxTries='" + this.maxTries + "'" +
                "}";
    }
}
