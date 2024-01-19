package wanaprom.sudthipod.lab6;

/**
 * TestGame2:
 * This program is for testing the second part in lab 6.
 * **Also added the word game to RockPaperScissor.
 *
 * Student: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 */

public class TestGame2 {
    public static void main(String[] args) {
        GuessNumberGameVer2 game1 = new GuessNumberGameVer2();
        System.out.println(game1);

        GuessNumberGameVer2 game2 = new GuessNumberGameVer2(1, 20, 7);
        System.out.println(game2);
        game2.playGame();
        game2.gameRule();

        MonopolyGameVer2 game3 = new MonopolyGameVer2();
        System.out.println(game3);

        MonopolyGameVer2 game4 = new MonopolyGameVer2(new String[] { "Thimble", "Cat", "Racecar", "Boot" });
        System.out.println(game4);
        game4.playGame();
        game4.setUpBoard();
        game4.gameRule();
        game4.rollDice();

        RockPaperScissorGameVer2 game5 = new RockPaperScissorGameVer2();
        System.out.println(game5);
        
        RockPaperScissorGameVer2 game6 = new RockPaperScissorGameVer2("paper", "rock");
        game6.playGame();
        game6.gameRule();

        Game game7 = new GuessNumberGameVer1();
        System.out.println(game7);
        game7 = new GuessNumberGameVer2();
        System.out.println(game7);
        game7 = new MonopolyGame();
        System.out.println(game7);
        game7 = new MonopolyGameVer2();
        System.out.println(game7);

    }

}