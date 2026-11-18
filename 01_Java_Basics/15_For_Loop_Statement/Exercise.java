package _01_Java_Basics._15_For_Loop_Statement;

/**
 * Lesson 15: For Loop Statement — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Sum of Odd Numbers from 1 to N
        // =================================================================
        System.out.println("=== Problem 1: Sum of Odd Numbers ===");

        int n = 19;
        int oddSum = 0;

        // WHY WE USED THIS WAY:
        // Since we know the exact starting point (1), ending bound (`n`), and step size (`+2`),
        // a `for` loop with `i += 2` visits ONLY odd numbers (`1, 3, 5, ..., 19`) directly
        // in half as many iterations, without needing an `if (i % 2 != 0)` check!
        for (int i = 1; i <= n; i += 2) {
            oddSum += i;
        }
        System.out.println("Sum of odd numbers up to " + n + " : " + oddSum);

        // =================================================================
        // Problem 2 (Medium): Hollow Square Border Pattern
        // =================================================================
        System.out.println("\n=== Problem 2: Hollow Square Border Pattern ===");

        int size = 4;

        // WHY WE USED THIS WAY:
        // To print a 2D grid of `size` rows and `size` columns, we nest two `for` loops:
        // - The outer loop (`row`) controls which horizontal line we are on.
        // - The inner loop (`col`) prints each character across that line.
        // A cell is on the border if and only if it is on the first row (`row == 1`),
        // last row (`row == size`), first column (`col == 1`), or last column (`col == size`).
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                if (row == 1 || row == size || col == 1 || col == size) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println(); // Move to the next line after finishing a row
        }

        // =================================================================
        // Problem 3 (Hard): Inverted Number Staircase Pattern
        // =================================================================
        System.out.println("\n=== Problem 3: Inverted Number Staircase Pattern ===");

        int rows = 5;

        // WHY WE USED THIS WAY:
        // Because the first row needs 5 numbers (`1..5`), the second row needs 4 (`1..4`),
        // and the last row needs 1 (`1`), we count the outer loop DOWN from `r = rows` to `1`
        // (`r--`), and bind the inner loop's upper limit to `c <= r`!
        for (int r = rows; r >= 1; r--) {
            for (int c = 1; c <= r; c++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
