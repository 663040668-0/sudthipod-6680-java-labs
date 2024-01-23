package wanaprom.sudthipod.lab7;

import java.util.*; // For ArrayList and Collections

/**
 * TestGamesProb1:
 * Testing SortByMaxTries class to sort the game instances
 * from the hardest to the easiest.
 *
 * Student: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 */

public class TestGamesProb1 {
    // Create an ArrayList to store objects of GuessNumberGameVer4
    static ArrayList<GuessNumberGameVer4> games = new ArrayList<GuessNumberGameVer4>();

    public static void printGamesList(String msg) {
        System.out.println(msg);
        for (GuessNumberGameVer4 game : games) {
            System.out.println(game);
        }
    }

    public static void initGamesList() {
        games.add(new GuessNumberGameVer4(1, 10, 7));
        games.add(new GuessNumberGameVer4(1, 10, 5));
        games.add(new GuessNumberGameVer4(1, 5, 5));

        printGamesList("===== Unsorted games list: =====");
    }

    public static void sortGamesList() {
        Collections.sort(games, new SortByMaxTries());
        printGamesList("===== Sorted games list: =====");
    }

    public static void main(String[] args) {
        initGamesList();
        sortGamesList();
    }
}
