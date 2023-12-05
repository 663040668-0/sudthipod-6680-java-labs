package wanaprom.sudthipod.lab4;

import java.util.InputMismatchException; // For handle exception
import java.util.Scanner; // For user input

/**
 * The MatrixOperations program:
 * This program allows the user to create a matrix from options
 * Display the matrix
 * and matrix operations will be performed by the user's choice
 *
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 05/12/2023
 */

public class MatrixOperations {
    static Scanner input = new Scanner(System.in);
    static int selectedOption, rowsNum, columnsNum;
    static int[][] matrix; // Create a empty matrix as a 2D array

    // Get user input
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

    // Create a matrix
    static void makeMatrix() {
        while (true) {
            // Get the number of rows and columns at once if it is a diagonal matrix,
            // otherwise get the number of rows and columns separately
            rowsNum = (selectedOption == 5)
                    ? getUserInputInt("Enter the number of rows and columns for diagonal matrix: ")
                    : getUserInputInt("Enter the number of rows: ");
            columnsNum = (selectedOption == 5) ? rowsNum : getUserInputInt("Enter the number of columns: ");
            // Check if the number of rows and columns are greater than 0
            if (rowsNum <= 0 || columnsNum <= 0) {
                System.err.println("Both rows and columns must be greater than 0. Please try again.");
            } else {
                break;
            }
        }
        matrix = new int[rowsNum][columnsNum]; // Create a matrix as a 2D array
    }

    // Display the matrix
    static void displayMatrix() {
        System.out.println("Displaying the matrix:");
        for (int i = 0; i < rowsNum; i++) {
            for (int j = 0; j < columnsNum; j++) {
                System.out.print(matrix[i][j] + " "); // Print each element inline
            }
            System.out.println(); // Move to next line
        }
    }

    public static void main(String[] args) {
        // Let the user select an initialization method and create the matrix
        while (true) {
            // Print available initialization options
            System.out.println("Select matrix initialization method:");
            System.out.println("1. User Input");
            System.out.println("2. Random Numbers");
            System.out.println("3. All Zeros");
            System.out.println("4. All Ones");
            System.out.println("5. Diagonal Matrix");

            selectedOption = getUserInputInt("Enter choice (1-5): ");
            if (selectedOption >= 1 && selectedOption <= 5) {
                makeMatrix();
                switch (selectedOption) {
                    case 1 -> { // User Input
                        for (int i = 0; i < rowsNum; i++) {
                            for (int j = 0; j < columnsNum; j++) {
                                matrix[i][j] = getUserInputInt("Enter element [" + i + "][" + j + "]: ");
                            }
                        }
                    }
                    case 2 -> { // Random Numbers (0-9)
                        for (int i = 0; i < rowsNum; i++) {
                            for (int j = 0; j < columnsNum; j++) {
                                matrix[i][j] = (int) (Math.random() * 10); // Random number from 0 to 9
                            }
                        }
                    }
                    case 3 -> { // All Zeros
                        // Do nothing because the matrix is already empty
                    }
                    case 4 -> { // All Ones
                        for (int i = 0; i < rowsNum; i++) {
                            for (int j = 0; j < columnsNum; j++) {
                                matrix[i][j] = 1;
                            }
                        }
                    }
                    case 5 -> { // Diagonal Matrix
                        for (int i = 0; i < rowsNum; i++) {
                            matrix[i][i] = 1; // matrix[i][i] = 1, otherwise 0
                        }
                    }
                    default -> {
                        System.err.println("Unknown error. Please try again.");
                        continue;
                    }
                }

                break; // Exit the loop
            } else {
                System.err.println("Invalid choice. Please try again.");
            }
        }

        // Display the matrix   
        displayMatrix();

        // Let the user select an operation
        while (true) {
            // Print available operations
            System.out.println("Choose an operation:");
            System.out.println("1. Transpose Matrix");
            System.out.println("2. Row and Column Sums");
            System.out.println("3. Find Max/Min Value");
            System.out.println("4. Diagonal Display");
            System.out.println("5. Exit");

            selectedOption = getUserInputInt("Enter choice (1-5): ");
            if (selectedOption >= 1 && selectedOption <= 5) {
                switch (selectedOption) {
                    case 1 -> { // Transpose Matrix
                        // Assign new dimensions
                        int newRowsNum = columnsNum; // Prevents assignment overlaping
                        columnsNum = rowsNum;
                        rowsNum = newRowsNum;
                        int[][] transposeMatrix = new int[rowsNum][columnsNum]; // Create a new matrix with the swapped dimensions
                        for (int i = 0; i < rowsNum; i++) {
                            for (int j = 0; j < columnsNum; j++) {
                                transposeMatrix[i][j] = matrix[j][i]; // Swap the rows and columns
                            }
                        }
                        matrix = transposeMatrix; // Replace the original matrix address with the transposed matrix

                        // Display the matrix
                        displayMatrix();
                        continue;
                    }
                    case 2 -> { // Row and Column Sums
                        int firstIterationSize = rowsNum;
                        int secondIterationSize = columnsNum;
                        String iterationName = "Row ";
                        // Iterate through rows and columns, starting with row sums and switching to column sums
                        for (int k = 0; k < 2; k++) {
                            System.out.println(iterationName + "Sums:");
                            for (int i = 0; i < firstIterationSize; i++) {
                                System.out.print(iterationName + (i + 1) + ": ");
                                int sum = 0;
                                for (int j = 0; j < secondIterationSize; j++) {
                                    sum += (iterationName.equals("Row ")) ? matrix[i][j] : matrix[j][i]; // Add the element separately
                                }
                                System.out.println(sum);
                            }
                            
                            // Switch to column sums
                            firstIterationSize = columnsNum;
                            secondIterationSize = rowsNum;
                            iterationName = "Column ";
                        }
                        continue;
                    }
                    case 3 -> { // Find Max/Min Value
                        int max = matrix[0][0]; // Start with the first element
                        int min = matrix[0][0]; // Start with the first element as well
                        for (int i = 0; i < rowsNum; i++) {
                            for (int j = 0; j < columnsNum; j++) {
                                max = Math.max(max, matrix[i][j]); // Find the maximum value by comparing each element
                                min = Math.min(min, matrix[i][j]); // Find the minimum value
                            }
                        }
                        System.out.println("Maximum value: " + max);
                        System.out.println("Minimum value: " + min);
                        continue;
                    }
                    case 4 -> { // Diagonal Display
                        int iterationSize = Math.min(rowsNum, columnsNum); // Use the smallest dimension as the iteration size
                        for (int i = 0; i < iterationSize; i++) {   
                            System.out.print(matrix[i][i] + " ");
                        }
                        System.out.println(); // Move to next line
                        continue;
                    }
                    case 5 -> { // Exit
                        // Do nothing
                    }
                    default -> {
                        System.err.println("Unknown error. Please try again.");
                        continue;
                    }
                }

                break; // Exit the loop
            } else {
                System.err.println("Invalid choice. Please try again.");
            }
        }
    }
}
