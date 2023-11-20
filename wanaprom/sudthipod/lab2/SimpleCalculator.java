package wanaprom.sudthipod.lab2;

/**
 * The SimpleCalculator Program:
 * This program accepts three arguments and calculate for the result.
 * Input expected: <a> <b> <operator>
 * where <a> and <b> are "integers"
 * and <operator> is a Mathematic operator.
 * Valid operators: ( '+', '-', 'x', '/' )
 * 
 * Expected output:
 * <a><operator><b>=<result>
 * 
 * Exclusive operators and division by zero are the exceptions
 * 
 * Author : Sudthipod Wanaprom
 * ID : 663040668-0
 * Sec : 2
 */

// Import classes or packages
import java.util.Scanner;

// Main class
public class SimpleCalculator {
    // Main method
    public static void main(String[] args) {
        // Declare variables and constants
        final byte ARGS_COUNT = 3;

        // Initial the input receiver
        Scanner sc = new Scanner(System.in);

        // Receive user's input and split the string
        System.out.print("Input: ");
        String[] tokenizedInput = sc.nextLine().split(" ");

        // Check input requirements
        int args_detected = tokenizedInput.length;
        if (args_detected == ARGS_COUNT) {
            // Declare variables
            int a = Integer.parseInt(tokenizedInput[0]);
            int b = Integer.parseInt(tokenizedInput[1]);
            String operator = tokenizedInput[2];

            // Check the operator
            switch (operator) {
                case "+":
                    System.out.println(a + operator + b + "=" + (a + b));
                    break;

                case "-":
                    System.out.println(a + operator + b + "=" + (a - b));
                    break;

                case "x":
                    System.out.println(a + operator + b + "=" + (a * b));
                    break;

                case "/":
                    if (b != 0)
                        System.out.println(a + operator + b + "=" + (a / b));
                    else
                        System.err.println("Error: Division by zero is not allowed.");
                    break;

                default:
                    System.err.println("Error: Invalid operator. Please use '+', '-', 'x', or '/'.");
                    break;
            }
        } else
            System.err.println("Error: Invalid number of arguments. Please provide exactly three arguments. "
                    + args_detected + " was detected.");

        // Close Scanner
        sc.close();
    }
}
