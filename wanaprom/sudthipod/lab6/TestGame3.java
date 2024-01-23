package wanaprom.sudthipod.lab6;

/**
 * TestGame3:
 * This program is for testing the third part in lab 6.
 *
 * Student: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 */

public class TestGame3 {
    public static void main(String[] args) {
        //CardGame game1 = new CardGame(); Will throw error
        PokerGame game2 = new PokerGame();
        System.out.println(game2);
        game2.playGame();
        game2.gameRule();
        PokerGame game4 = new PokerGame(10);
        System.out.println(game4);
        // game2.setUpBoard();
        DungeonsAndDragonsGame game3 = new DungeonsAndDragonsGame();
        System.out.println(game3);
        game3.playGame();
        game3.gameRule();
        game3.setUpBoard();
        game3.rollDice();
        DungeonsAndDragonsGame game5 = new DungeonsAndDragonsGame(3);
        System.out.println(game5);
    }


}
