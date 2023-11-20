import java.util.Scanner;
/**
 * @author Yesui Dovchinsuren
 */

public class BaseConversion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Base Conversion Program");

            System.out.print("Choose conversion method Base-Conversion or Digit Conversion to Character (Please enter either c or d, respectfully): ");
            String methodChoice = scan.next().toLowerCase();
            System.out.print("Enter an integer: ");
            int base10Num = scan.nextInt();

            String result = "";
            if (methodChoice.equals("c")) {
                System.out.print("Enter the base: ");
                int base = scan.nextInt();
                result = convert(base10Num, base);
            } else if (methodChoice.equals("d")) {
                result = convertDigit(base10Num);
            } else {
                System.out.println("Invalid method choice. Please enter either 'c' or 'd'.");
                continue; // Skip the rest of the loop and ask for input again
            }

            System.out.println("Result: " + result);
            System.out.print("Do you want to convert another number? (Y/N): ");
            String answer = scan.next().toLowerCase();

            if (answer.equals("N")) {
                break;
            }
        }
        scan.close();
    }

    private static String convert(int num, int base) {
        if (base < 2 || base > 16) {
            return "Invalid base! Please enter a base between 2 and 16.";
        }
        // Base case
        if (num < base) {
            return convertDigit(num);
        } else {
            // Recursive case
            int quotient = num / base;
            int remainder = num % base;

            return convert(quotient, base) + convertDigit(remainder);
        }
    }

    private static String convertDigit(int digit) {
        // Convert a single digit to its corresponding character
        if (digit >= 0 && digit <= 9) {
            return String.valueOf(digit);
        } else if (digit >= 10 && digit <= 15) {
            return String.valueOf((char) ('A' + digit - 10));
        } else {
            return "Invalid digit! Please enter a digit between 0 and 15";
        }
    }
}
