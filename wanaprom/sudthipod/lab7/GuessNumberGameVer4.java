package wanaprom.sudthipod.lab7;

import wanaprom.sudthipod.lab5.GuessNumberGameVer3;

/**
 * GuessNumberGameVer4:
 * This game class is an extension of the GuessNumberGameVer3 from lab5.
 * The game will override toString method to display information about the game
 * and the game instances will be sorted by the number of tries and random number range
 * from the hardest to the easiest.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 22/01/2024
 */

 public class GuessNumberGameVer4 extends GuessNumberGameVer3 {
    // Use super's constructors 
    public GuessNumberGameVer4(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    public GuessNumberGameVer4(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    public GuessNumberGameVer4() {
        super();
    }

    // Override toString() to sort the game instances
    @Override
    public String toString() {
        return "GuessNumberGameVer4 (" +
        "min:" + super.getMinNum() + ", " +
        "max:" + super.getMaxNum() + ", " +
        "max tries:" + super.getMaxTries() + ")";
    }
 }