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

// Main class
public class SimpleCalculator {
    // Main method
    public static void main(String[] args) {
        // Check input requirements
        if (args.length == 3) {
            // Declare variables
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            String operator = args[2];

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
                    + args.length + " was detected.");
    }
}
