package _01_Java_Basics._05_Input_And_Variables_Part_1;

import java.util.Scanner;

/**
 * Lesson 05: Input and Variables (Part 1)
 * Demonstrates:
 * 1. All 8 Primitive Data Types + String reference type
 * 2. Numeric underscores (Java 7+) and literal suffixes (L, f)
 * 3. Reading user input from the console using `new Scanner(System.in)`
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 05: INPUT AND VARIABLES (PART 1)        ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. JAVA'S 8 PRIMITIVE DATA TYPES
        // WHY: Each primitive type occupies a fixed number of bits in memory,
        // letting developers balance memory footprint against numeric range.
        // -----------------------------------------------------------------
        byte cpuCores = 16;                          // 8-bit signed integer (-128 to 127)
        short serverPort = 8080;                     // 16-bit signed integer (-32,768 to 32,767)
        int activeUsers = 1_250_000;                 // 32-bit signed integer (underscores improve readability!)
        long globalTransactions = 9_876_543_210L;    // 64-bit signed integer (Note mandatory 'L' suffix)

        float cpuLoadPercent = 64.75f;               // 32-bit IEEE 754 floating-point (Note mandatory 'f' suffix)
        double accountBalance = 145_892.49;          // 64-bit IEEE 754 floating-point (Default for decimals)

        char currencySymbol = '$';                   // 16-bit Unicode character (Single quotes '')
        boolean isProductionReady = true;            // Logical true or false

        // Non-primitive Reference Type: String
        String serviceName = "OrderProcessingEngine"; // Enclosed in double quotes ""

        System.out.println("--- [1] All 8 Primitive Types + String ---");
        System.out.println("byte    (1B) : cpuCores           = " + cpuCores);
        System.out.println("short   (2B) : serverPort         = " + serverPort);
        System.out.println("int     (4B) : activeUsers        = " + activeUsers);
        System.out.println("long    (8B) : globalTransactions = " + globalTransactions);
        System.out.println("float   (4B) : cpuLoadPercent     = " + cpuLoadPercent + "%");
        System.out.println("double  (8B) : accountBalance     = " + currencySymbol + accountBalance);
        System.out.println("char    (2B) : currencySymbol     = '" + currencySymbol + "'");
        System.out.println("boolean (1B) : isProductionReady  = " + isProductionReady);
        System.out.println("String (Ref) : serviceName        = \"" + serviceName + "\"");
        System.out.println();

        // -----------------------------------------------------------------
        // 2. INSPECTING PRIMITIVE MEMORY LIMITS VIA WRAPPER CONSTANTS
        // -----------------------------------------------------------------
        System.out.println("--- [2] Primitive Type Ranges ---");
        System.out.printf("byte   range : %d to %d%n", Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("short  range : %,d to %,d%n", Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("int    range : %,d to %,d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("long   range : %,d to %,d%n", Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println();

        // -----------------------------------------------------------------
        // 3. READING CONSOLE INPUT WITH `new Scanner(System.in)`
        // WHY: `Scanner` connects to `System.in` (keyboard input) and provides
        // methods like `nextLine()`, `nextInt()`, and `nextDouble()` to read typed values.
        // -----------------------------------------------------------------
        System.out.println("--- [3] Reading Console Input with Scanner ---");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = input.nextLine();

        System.out.print("Enter student age: ");
        int studentAge = input.nextInt();

        System.out.print("Enter student GPA: ");
        double studentGpa = input.nextDouble();

        System.out.printf("Parsed Student Record -> Name: %s | Age: %d | GPA: %.2f%n",
                studentName, studentAge, studentGpa);

        // Always close the scanner when done
        input.close();
    }
}
