package wanaprom.sudthipod.lab2;

/**
 * The Patient Program:
 * This program accepts three arguments which are patient infomation
 * and displays patient infomation.
 * The arguments must be separated by spaces
 * The output should be:
 * Patient's name : <patientName>
 * Age : <patientAge>
 * Gender : <patientGender>
 * 
 * Author : Sudthipod Wanaprom
 * ID : 663040668-0
 * Sec : 2
 */

// Import classes or packages
import java.util.Scanner;

// Main method
public class Patient {
    public static void main(String[] args) {
        // Declare variables and constants
        final byte ARGS_COUNT = 3;

        // Initial the input receiver
        Scanner sc = new Scanner(System.in);

        // Receive user's input and split the string
        System.out.print("Patient infomation: ");
        String[] tokenizedInput = sc.nextLine().split(" (?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)"); // The easiest way

        // Check input requirements
        int args_detected = tokenizedInput.length;
        if (args_detected == ARGS_COUNT) {
            System.out.println("Patient's name : " + tokenizedInput[0].substring(1, tokenizedInput[0].length() - 1));
            System.out.println("Age : " + tokenizedInput[1]);
            System.out.println("Gender : " + tokenizedInput[2]);
        } else
            System.err.println("Error: Invalid number of arguments. Please provide exactly three arguments. "
                    + args_detected + " was detected.");

        // Close the scanner
        sc.close();
    }
}
