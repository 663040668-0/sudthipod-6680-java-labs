package wanaprom.sudthipod.lab7;

import java.util.Comparator;

/**
 * SortByMaxTries:
 * Sort the game instances by the number of tries
 * in order from the hardest to the easiest.
 * (Least number of tries and most random number range is the hardest)
 * (Most number of tries and least random number range is the easiest)
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 23/01/2024
 */

 // Implement Comparator interface
public class SortByMaxTries implements Comparator<GuessNumberGameVer4> {
    // Override compare() method
    @Override
    public int compare(GuessNumberGameVer4 game1, GuessNumberGameVer4 game2) {
        // return <game1's number of tries> - <game2's number of tries> because
        // return < = 0 > if equal
        // return < > 0 > if game1 is greater (harder)
        // return < < 0 > if game1 is smaller (easier)
        return game1.getMaxTries() - game2.getMaxTries();
    }
}
