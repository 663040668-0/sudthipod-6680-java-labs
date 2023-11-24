package wanaprom.sudthipod.lab2;

/**
 * The PrimitiveDataType Program:
 * This program takes no argument but need to provide infomation into the variables
 * which are <studentId> and <firstName>
 *
 * and generates output:
 * Student ID : <studentId>
 * First Name : <firstName>
 * Byte Value : <lastTwoDigits>
 * Short Value : <lastThreeDigits>
 * Int Value : <lastSixDigits>
 * Long Value : <lastEightDigits>
 * Float Value : <lastThreeDigitsDecimal>
 * Double Value : <lastEightDigitsDecimal>
 * Char Value : <firstLetter>
 * Boolean Value : <islastDigitOdd>
 *
 * Author : Sudthipod Wanaprom
 * ID : 663040668-0
 * Sec : 2
 *
 * Lastest Update : 24/11/2023
 */

// Main class
public class PrimitiveDataType {

    // Function to return last specific digits of the string
    public static String getLastDigits(String targetString, int digits) {
        return targetString.substring(targetString.length() - digits, targetString.length());
    }

    // Main method
    public static void main(String[] args) {
        // Declare infomation in variables
        String studentId = "663040668-0";
        System.out.println("Student ID : " + studentId);
        studentId = studentId.replaceAll("-", ""); // Remove dash symbol

        String firstName = "Sudthipod";
        System.out.println("First Name : " + firstName);

        // Declare and assign variables
        byte lastTwoDigits = Byte.parseByte(getLastDigits(studentId, 2));
        short lastThreeDigits = Short.parseShort(getLastDigits(studentId, 3));
        int lastSixDigits = Integer.parseInt(getLastDigits(studentId, 6));
        long lastEightDigits = Long.parseLong(getLastDigits(studentId, 8));
        float lastThreeDigitsDecimal = Float.parseFloat("0." + getLastDigits(studentId, 3));
        double lastEightDigitsDecimal = Double.parseDouble("0." + getLastDigits(studentId, 8));
        char firstLetter = firstName.charAt(0);
        boolean islastDigitOdd = (lastTwoDigits % 2 != 0);

        // Display primitive values
        System.out.println("Byte Value : " + lastTwoDigits);
        System.out.println("Short Value : " + lastThreeDigits);
        System.out.println("Int Value : " + lastSixDigits);
        System.out.println("Long Value : " + lastEightDigits);
        System.out.println("Float Value : " + lastThreeDigitsDecimal);
        System.out.println("Double Value : " + lastEightDigitsDecimal);
        System.out.println("Char Value : " + firstLetter);
        System.out.println("Boolean Value : " + islastDigitOdd);
    }
}
