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
 *
 * Lastest Update : 24/11/2023
 */

// Main class
public class Patient {
    // Main method
    public static void main(String[] args) {
        // Declare variables
        String patientName = args[0];
        String patientAge = args[1];
        String patientGender = args[2];

        // Check input requirements
        if (args.length == 3) {
            System.out.println("Patient's name : " + patientName);
            System.out.println("Age : " + patientAge);
            System.out.println("Gender : " + patientGender);
        } else
            System.err.println("Error: Invalid number of arguments. Please provide exactly three arguments. " + args.length + " was detected.");
    }
}
