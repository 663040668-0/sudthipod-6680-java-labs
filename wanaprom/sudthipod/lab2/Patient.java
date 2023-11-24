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

// Main class
public class Patient {
    // Main method
    public static void main(String[] args) {
        // Check input requirements
        if (args.length == 3) {
            System.out.println("Patient's name : " + args[0]);
            System.out.println("Age : " + args[1]);
            System.out.println("Gender : " + args[2]);
        } else
            System.err.println("Error: Invalid number of arguments. Please provide exactly three arguments. " + args.length + " was detected.");
    }
}
