package _01_Java_Basics._15_For_Loop_Statement;

/**
 * Lesson 15: For Loop Statement
 * Demonstrates:
 * 1. Standard `for` loop variations (counting up, counting down, stepping by 5)
 * 2. Nested `for` loops: 5x5 Multiplication Grid
 * 3. Classic Star Pattern Printing (Right Triangle & Centered Pyramid)
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     LESSON 15: FOR LOOP STATEMENT                ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. SINGLE `for` LOOP VARIATIONS
        // -----------------------------------------------------------------
        System.out.println("--- [1] Standard `for` Loop Variations ---");

        System.out.print("Counting Up (1 to 5)       : ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("Counting Down (10 to 2)    : ");
        for (int i = 10; i >= 2; i -= 2) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        // -----------------------------------------------------------------
        // 2. NESTED `for` LOOPS: 5x5 MULTIPLICATION TABLE
        // WHY: For every 1 iteration of the outer loop (`row`), the inner
        // loop (`col`) completes all 5 of its iterations.
        // -----------------------------------------------------------------
        System.out.println("--- [2] Nested `for` Loops: 5x5 Multiplication Table ---");
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= 5; col++) {
                System.out.printf("%4d", row * col);
            }
            System.out.println(); // Newline after each row completes
        }
        System.out.println();

        // -----------------------------------------------------------------
        // 3. PATTERN PRINTING WITH NESTED `for` LOOPS
        // -----------------------------------------------------------------
        System.out.println("--- [3] Pattern A: Right-Angled Triangle (Height 4) ---");
        int height = 4;
        for (int row = 1; row <= height; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("--- [4] Pattern B: Centered Star Pyramid (Height 4) ---");
        for (int row = 1; row <= height; row++) {
            // Inner Loop 1: Print leading spaces (height - row)
            for (int space = 1; space <= (height - row); space++) {
                System.out.print(" ");
            }
            // Inner Loop 2: Print odd number of stars (2 * row - 1)
            for (int star = 1; star <= (2 * row - 1); star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
