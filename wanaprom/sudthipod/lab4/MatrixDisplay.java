package wanaprom.sudthipod.lab4;

import java.util.InputMismatchException; // For handle exception
import java.util.Scanner; // For user input

/**
 * The MatrixDisplay program:
 * This game sequence starts with configuration for a player to choose the minimum value, maximum value, and maximum number of tries.
 * The game accepts an integer input within the provided range in the configuration (inclusive).
 * The game will generate a random integer within the range received in the configuration.
 * Players need to input the exact same integer in order to win the game.
 * If the players have reached their maximum tries without winning, they lose the game.
 * Players can review their previous guesses by interacting with the post-game prompt.
 * On post-game prompt exit, the game will log the answer, number of tries, and win/lose status.
 * Then they can choose to replay the game or quit by interacting with the prompt.
 * If they quit, the game will terminate with a statistics report.
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 04/12/2023
 */

public class MatrixDisplay {
    static Scanner input = new Scanner(System.in);

    static int getUserInputInt(String text, int condition) {
        while (true) {
            try {
                System.out.print(text);
                int receivedInt = input.nextInt();
                // Normally return value
                return receivedInt;
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter an integer.");
                input.nextLine(); // Reset the input to avoid overflow
            }
        }
    }
    public static void main(String[] args) {
        int rowsNum, columnsNum;
        while (true) { 
            rowsNum = getUserInputInt("Enter the number of rows: ",1);
            columnsNum = getUserInputInt("Enter the number of columns: ",1);
            // Check if the number of rows and columns are greater than 0
            if (rowsNum <= 0 || columnsNum <= 0) {
                System.err.println("Both rows and columns must be greater than 0. Please try again.");
            } else {
                break;
            }
        }

        int[][] matrix = new int[rowsNum][columnsNum]; // Create a matrix as a 2D array

        // Row-wise input iteration
        for (int i = 0; i < rowsNum; i++) {
            for (int j = 0; j < columnsNum; j++) {
                matrix[i][j] = getUserInputInt("Enter element [" + i + "][" + j + "]: ",0);
            }
        }

        // Display the matrix
        for (int i = 0; i < rowsNum; i++) {
            for (int j = 0; j < columnsNum; j++) {
                System.out.print(matrix[i][j] + " "); // Print each element inline
            }
            System.out.println(); // Move to next line
        }
    }
}
