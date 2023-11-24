package wanaprom.sudthipod.lab2.upgraded;

/**
 * The CamelCaseNaming Program:
 * This program accepts two arguments then convert to a CamelCaseNaming string
 * Expected input: <textA> <textB>
 *
 * Assume <textA> = "abcd" and <textB> = "ABCD"
 * Output expected:
 * Camel Case Result: AbcdAbcd
 *
 * Author : Sudthipod Wanaprom
 * ID : 663040668-0
 * Sec : 2
 */

// Import necessary packages
import java.util.Scanner;

// Main class
public class CamelCaseNaming {
    // Conversion method
    public static String toCamelCase(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1, text.length()).toLowerCase();
    }

    // Main method
    public static void main(String[] args) {
        // Declare variables and constants
        final byte ARGS_COUNT = 2;

        // Initial the input receiver
        Scanner sc = new Scanner(System.in);

        // Receive user's input and split the string
        System.out.print("Input: ");
        String[] tokenizedInput = sc.nextLine().split(" ");

        // Check input requirements
        int args_detected = tokenizedInput.length;
        if (args_detected == ARGS_COUNT) {
            // Declare variables
            String textA = tokenizedInput[0];
            String textB = tokenizedInput[1];

            // Display output
            System.out.println("Camel Case Result: " + toCamelCase(textA) + toCamelCase(textB));
        } else
            System.err.println("Error: Invalid number of arguments. Please provide exactly two arguments. "
                    + args_detected + " was detected.");

        // Close Scanner
        sc.close();
    }
}
