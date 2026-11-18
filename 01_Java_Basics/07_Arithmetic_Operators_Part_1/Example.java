package _01_Java_Basics._07_Arithmetic_Operators_Part_1;

/**
 * Lesson 07: Arithmetic Operators (Part 1)
 * Demonstrates:
 * 1. The 5 basic operators (+, -, *, /, %)
 * 2. Integer division truncation vs. floating-point division
 * 3. Practical applications of Modulo (%): unit conversion & digit extraction
 * 4. Division by zero behavior (int vs. double)
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 07: ARITHMETIC OPERATORS (PART 1)       ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. THE 5 BASIC ARITHMETIC OPERATORS
        // -----------------------------------------------------------------
        int a = 17;
        int b = 5;

        System.out.println("--- [1] Basic Arithmetic with a = 17, b = 5 ---");
        System.out.println("Addition       (a + b) : " + (a + b)); // 22
        System.out.println("Subtraction    (a - b) : " + (a - b)); // 12
        System.out.println("Multiplication (a * b) : " + (a * b)); // 85
        System.out.println("Int Division   (a / b) : " + (a / b)); // 3 (truncates .4)
        System.out.println("Modulo / Rem   (a % b) : " + (a % b)); // 2 (17 = 5*3 + 2)
        System.out.println();

        // -----------------------------------------------------------------
        // 2. INTEGER DIVISION TRAP VS. FLOATING-POINT DIVISION
        // WHY: In Java, `int / int` is ALWAYS an `int`, even if stored in a `double`!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Integer vs. Floating-Point Division ---");
        int totalPoints = 95;
        int examCount = 2;

        double buggyAverage = totalPoints / examCount; // 95 / 2 = 47 -> widened to 47.0!
        double correctAverage = (double) totalPoints / examCount; // 95.0 / 2 = 47.5

        System.out.println("Buggy   (totalPoints / examCount)          : " + buggyAverage);
        System.out.println("Correct ((double) totalPoints / examCount) : " + correctAverage);
        System.out.println();

        // -----------------------------------------------------------------
        // 3. PRACTICAL MODULO (%) USE CASES
        // -----------------------------------------------------------------
        System.out.println("--- [3] Practical Modulo (%) Applications ---");

        // Use Case A: Converting total seconds into Hours, Minutes, and Seconds
        int totalSeconds = 7384;
        int hours = totalSeconds / 3600;
        int remainingAfterHours = totalSeconds % 3600;
        int minutes = remainingAfterHours / 60;
        int seconds = remainingAfterHours % 60;

        System.out.printf("Time Conversion : %,d seconds = %02dh : %02dm : %02ds%n",
                totalSeconds, hours, minutes, seconds);

        // Use Case B: Peeling off digits of a 3-digit number (e.g., 489)
        int code = 489;
        int onesDigit = code % 10;          // 489 % 10 = 9
        int tensDigit = (code / 10) % 10;   // 48 % 10  = 8
        int hundredsDigit = code / 100;     // 489 / 100 = 4

        System.out.printf("Digit Extraction: %d -> Hundreds: %d, Tens: %d, Ones: %d%n%n",
                code, hundredsDigit, tensDigit, onesDigit);

        // -----------------------------------------------------------------
        // 4. DIVISION BY ZERO: INTEGER VS. IEEE 754 FLOATING-POINT
        // -----------------------------------------------------------------
        System.out.println("--- [4] Division by Zero Behavior ---");
        System.out.println("10.0 / 0.0 (double) : " + (10.0 / 0.0)); // Infinity
        System.out.println("0.0 / 0.0  (double) : " + (0.0 / 0.0));  // NaN (Not a Number)
        System.out.println("10 / 0     (int)    : Throws java.lang.ArithmeticException: / by zero");
    }
}
