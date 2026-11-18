package _01_Java_Basics._22_Arrays;

import java.util.Arrays;

/**
 * Lesson 22: One-Dimensional Arrays — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Count Above-Average Scores ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Reverse Traversal & Even-Index Doubling ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Second Largest Element in One Pass ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        int[] examScores = {72, 88, 95, 64, 81, 90, 70};

        // WHY WE USED THIS WAY:
        // Since we only need to READ every score in forward order (without modifying elements
        // or needing array indices), the enhanced `for-each` loop (`for (int score : examScores)`)
        // is the cleanest and safest choice.
        int sum = 0;
        for (int score : examScores) {
            sum += score;
        }
        double average = (double) sum / examScores.length;

        int aboveAvgCount = 0;
        for (int score : examScores) {
            if (score > average) {
                aboveAvgCount++;
            }
        }

        System.out.printf("Class Average : %.2f | Scores Above Average : %d%n",
                average, aboveAvgCount);
    }

    public static void solveProblem2() {
        int[] values = {10, 20, 30, 40, 50, 60};

        // WHY WE USED THIS WAY:
        // 1. A `for-each` loop can only iterate forward and cannot mutate array slots.
        // 2. For reverse traversal, we use an index-based `for` loop starting at the last
        //    valid index (`values.length - 1`) down to `0` (`i >= 0; i--`).
        // 3. To double elements at even indices (`0, 2, 4`), we need the index `i` and
        //    must assign directly into `values[i] *= 2;`.
        System.out.print("Reverse Order     : ");
        for (int i = values.length - 1; i >= 0; i--) {
            System.out.print(values[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                values[i] *= 2;
            }
        }
        System.out.println("Doubled Even Idx  : " + Arrays.toString(values));
    }

    public static void solveProblem3() {
        int[] prices = {45, 120, 89, 195, 150, 99};

        // WHY WE USED THIS WAY:
        // Finding both `largest` and `secondLargest` in a single O(N) pass avoids sorting the array:
        // - Whenever we find a new `largest` (`p > largest`), the old `largest` becomes the
        //   new `secondLargest` (`secondLargest = largest;`) before we update `largest = p;`.
        // - Otherwise, if `p` is between `secondLargest` and `largest`, we update `secondLargest = p;`.
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int p : prices) {
            if (p > largest) {
                secondLargest = largest;
                largest = p;
            } else if (p > secondLargest && p != largest) {
                secondLargest = p;
            }
        }

        System.out.println("Largest Price : $" + largest
                + " | Second Largest Price : $" + secondLargest);
    }
}
