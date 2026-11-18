package _01_Java_Basics._06_Input_And_Variables_Part_2;

import java.util.Scanner;

/**
 * Lesson 06: Input and Variables (Part 2)
 * Demonstrates:
 * 1. Implicit Widening vs. Explicit Narrowing Type Casting
 * 2. Immutable Constants with the `final` keyword
 * 3. Solving the Scanner `nextInt()` -> `nextLine()` newline buffer quirk with `new Scanner(System.in)`
 */
public class Example {

    // Class-level constant (static final) using UPPER_SNAKE_CASE convention
    public static final double SPEED_OF_LIGHT_KM_S = 299_792.458;

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 06: INPUT AND VARIABLES (PART 2)        ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. IMPLICIT WIDENING VS. EXPLICIT NARROWING TYPE CASTING
        // -----------------------------------------------------------------
        System.out.println("--- [1] Type Casting: Widening vs. Narrowing ---");

        // A. Implicit Widening (int -> long -> double): Done automatically by javac
        int invoiceDollars = 250;
        double widenedDouble = invoiceDollars; // 250 becomes 250.0 automatically
        System.out.println("Implicit Widening (int -> double) : " + invoiceDollars + " -> " + widenedDouble);

        // B. Explicit Narrowing (double -> int): Requires (int) cast; truncates decimal!
        double exactMeasurement = 99.95;
        int truncatedInt = (int) exactMeasurement; // Chops off .95 -> 99
        long roundedLong = Math.round(exactMeasurement); // Rounds to nearest integer -> 100
        System.out.println("Explicit Narrowing (double -> int): " + exactMeasurement + " -> " + truncatedInt + " (Truncated!)");
        System.out.println("Math.round() Comparison           : " + exactMeasurement + " -> " + roundedLong + " (Rounded)");

        // C. Narrowing Overflow (int -> byte)
        // WHY: byte holds -128..127. 130 wraps around 2's complement binary to -126!
        int outOfByteRange = 130;
        byte wrappedByte = (byte) outOfByteRange;
        System.out.println("Narrowing Overflow (int 130->byte): " + outOfByteRange + " -> " + wrappedByte);
        System.out.println();

        // -----------------------------------------------------------------
        // 2. CONSTANTS WITH `final`
        // WHY: `final` prevents accidental reassignment and documents intent.
        // -----------------------------------------------------------------
        System.out.println("--- [2] Constants with `final` ---");
        final int MAX_API_RETRIES = 5;
        final double VAT_RATE = 0.20;
        // MAX_API_RETRIES = 10; // <-- Uncommenting this causes a compile-time error!

        System.out.println("Constant MAX_API_RETRIES     : " + MAX_API_RETRIES);
        System.out.println("Constant VAT_RATE            : " + VAT_RATE);
        System.out.println("Constant SPEED_OF_LIGHT_KM_S : " + SPEED_OF_LIGHT_KM_S);
        System.out.println();

        // -----------------------------------------------------------------
        // 3. THE SCANNER BUFFER QUIRK: nextInt() followed by nextLine()
        // WHY: `input.nextInt()` reads the integer but leaves the Enter key's `\n`
        // in the keyboard buffer. Calling `input.nextLine()` once flushes that `\n`
        // so we can read the user's full name and job title cleanly!
        // -----------------------------------------------------------------
        System.out.println("--- [3] Solving the Scanner nextInt() + nextLine() Buffer Trap ---");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Employee ID (int): ");
        int employeeId = input.nextInt();

        // FIX: Consume the leftover newline character after nextInt()!
        input.nextLine();

        System.out.print("Enter Full Name: ");
        String fullName = input.nextLine();

        System.out.print("Enter Job Title: ");
        String jobTitle = input.nextLine();

        System.out.println("Parsed Employee -> ID: " + employeeId
                + " | Name: \"" + fullName + "\" | Role: \"" + jobTitle + "\"");

        input.close();
    }
}
