package wanaprom.sudthipod.lab7;

import java.util.Comparator;

/**
 * SortByMaxTriesGuessRange:
 * Sort the game instances by the number of tries and random number range
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
public class SortByMaxTriesGuessRange implements Comparator<GuessNumberGameVer4> {
    // Override compare() method
    @Override
    public int compare(GuessNumberGameVer4 game1, GuessNumberGameVer4 game2) {
        // Check if maxTries is equal
        if (game1.getMaxTries() - game2.getMaxTries() == 0) {
            // Return smaller random number range to be the greater (harder)
            return -((game1.getMaxNum() - game1.getMinNum()) - (game2.getMaxNum() - game2.getMinNum()));
            // Make negative because the range and order will be reversed
        }

        // Else just compare maxTries
        return game1.getMaxTries() - game2.getMaxTries();
    }
}
