package _01_Java_Basics._16_Break_And_Continue_Statements;

/**
 * Lesson 16: Break and Continue Statements — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Skip Multiples of 3 (`continue`)
        // =================================================================
        System.out.println("=== Problem 1: Skip Multiples of 3 (continue) ===");

        // WHY WE USED THIS WAY:
        // `continue;` skips the rest of the current loop body and jumps straight to `i++`.
        // Using `if (i % 3 == 0) continue;` at the top of the loop acts as a clean filter
        // so multiples of 3 (3, 6, 9) are never printed.
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // =================================================================
        // Problem 2 (Medium): Stop When Sum Exceeds Limit (`break`)
        // =================================================================
        System.out.println("\n=== Problem 2: Stop When Sum Exceeds Limit (break) ===");

        int threshold = 50;
        int sum = 0;

        // WHY WE USED THIS WAY:
        // Even though the loop header says `i <= 100`, `break;` lets us exit the loop
        // immediately on iteration `i = 10` the moment `sum` (55) exceeds `threshold` (50),
        // saving 90 unnecessary iterations!
        for (int i = 1; i <= 100; i++) {
            sum += i;
            if (sum > threshold) {
                System.out.println("Threshold " + threshold + " exceeded at i = "
                        + i + " (Sum = " + sum + ")");
                break;
            }
        }

        // =================================================================
        // Problem 3 (Hard): Labeled `break` in a 2D Seating Chart
        // =================================================================
        System.out.println("\n=== Problem 3: Labeled break in 2D Seating Chart ===");

        int[][] seats = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };

        // WHY WE USED THIS WAY:
        // An ordinary `break;` inside the inner `seat` loop would only exit the column loop
        // and continue searching Row 2 (booking extra seats!).
        // Attaching the label `seatSearch:` to the outer `row` loop and calling
        // `break seatSearch;` exits BOTH loops simultaneously as soon as Row 1, Seat 1 is found!
        seatSearch:
        for (int row = 0; row < seats.length; row++) {
            for (int seat = 0; seat < seats[row].length; seat++) {
                if (seats[row][seat] == 1) {
                    System.out.println("First available seat booked at Row "
                            + row + ", Seat " + seat);
                    break seatSearch;
                }
            }
        }
    }
}
