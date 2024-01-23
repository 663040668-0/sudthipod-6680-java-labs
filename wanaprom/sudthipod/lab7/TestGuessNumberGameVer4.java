package wanaprom.sudthipod.lab7;

/**
 * TestGuessNumberGameVer4:
 * Testing toString() method in GuessNumberGameVer4.
 *
 * Student: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 */

public class TestGuessNumberGameVer4 {
    public static void main(String[] args) {
        GuessNumberGameVer4 game1 = new GuessNumberGameVer4(1, 10, 3);
        GuessNumberGameVer4 game2 = new GuessNumberGameVer4(1, 10, 5);
        GuessNumberGameVer4 game3 = new GuessNumberGameVer4(1, 5, 5);

        System.out.println(game1);
        System.out.println(game2);
        System.out.println(game3);
    }
}
