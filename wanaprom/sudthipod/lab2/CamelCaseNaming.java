package wanaprom.sudthipod.lab2;

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
// Main class
public class CamelCaseNaming {
    // Conversion method
    public static String toCamelCase(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1, text.length()).toLowerCase();
    }

    // Main method
    public static void main(String[] args) {
        // Check input requirements
        if (args.length == 2) {
            // Declare variables
            String textA = args[0];
            String textB = args[1];

            // Display output
            System.out.println("Camel Case Result: " + toCamelCase(textA) + toCamelCase(textB));
        } else
            System.err.println("Error: Invalid number of arguments. Please provide exactly two arguments. " + args.length + " was detected.");
    }
}
