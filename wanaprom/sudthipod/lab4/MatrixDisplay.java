package wanaprom.sudthipod.lab4;

import java.util.InputMismatchException; // For handle exception
import java.util.Scanner; // For user input

/**
 * The MatrixDisplay program:
 * This program display a matrix of any size with user input in each element
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 05/12/2023
 */

public class MatrixDisplay {
    static Scanner input = new Scanner(System.in);

    static int getUserInputInt(String text) {
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
            rowsNum = getUserInputInt("Enter the number of rows: ");
            columnsNum = getUserInputInt("Enter the number of columns: ");
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
                matrix[i][j] = getUserInputInt("Enter element [" + i + "][" + j + "]: ");
            }
        }

        // Display the matrix
        System.out.println("Displaying the matrix:");
        for (int i = 0; i < rowsNum; i++) {
            for (int j = 0; j < columnsNum; j++) {
                System.out.print(matrix[i][j] + " "); // Print each element inline
            }
            System.out.println(); // Move to next line
        }
    }
}
