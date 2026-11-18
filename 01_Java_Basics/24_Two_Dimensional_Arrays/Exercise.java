package _01_Java_Basics._24_Two_Dimensional_Arrays;

import java.util.Arrays;

/**
 * Lesson 24: Two-Dimensional Arrays — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Sum & Maximum of a 2D Matrix ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Square Matrix Main & Anti-Diagonal Sum ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Matrix Transpose (2x3 -> 3x2) ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        int[][] salesGrid = {
            {120, 150, 90},
            {200, 180, 240}
        };

        // WHY WE USED THIS WAY:
        // Since a 2D array is an "array of 1D row arrays", nested enhanced `for-each`
        // loops (`for (int[] row : salesGrid)` -> `for (int cell : row)`) cleanly visit
        // every cell in every row without risking index out-of-bounds errors.
        int totalSales = 0;
        int highestCell = salesGrid[0][0];

        for (int[] row : salesGrid) {
            for (int cell : row) {
                totalSales += cell;
                if (cell > highestCell) {
                    highestCell = cell;
                }
            }
        }

        System.out.println("Total Matrix Sales : $" + totalSales
                + " | Highest Single Cell : $" + highestCell);
    }

    public static void solveProblem2() {
        int[][] square = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // WHY WE USED THIS WAY:
        // In an N x N square matrix:
        // - The Main Diagonal cells always have `row == col` (`square[i][i]`).
        // - The Anti-Diagonal cells always have `col == (n - 1 - i)` (`square[i][n - 1 - i]`).
        // This lets us sum both diagonals in a SINGLE `for` loop (`O(N)`) instead of a nested loop!
        int n = square.length;
        int mainDiagonalSum = 0;
        int antiDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            mainDiagonalSum += square[i][i];
            antiDiagonalSum += square[i][n - 1 - i];
        }

        System.out.println("Main Diagonal Sum : " + mainDiagonalSum
                + " | Anti-Diagonal Sum : " + antiDiagonalSum);
    }

    public static void solveProblem3() {
        int[][] original = {
            {10, 20, 30},
            {40, 50, 60}
        };

        // WHY WE USED THIS WAY:
        // Transposing flips rows and columns: a 2-row x 3-col matrix becomes a 3-row x 2-col matrix!
        // Therefore, we allocate `new int[original[0].length][original.length]` and assign
        // `transposed[c][r] = original[r][c]`.
        int rows = original.length;
        int cols = original[0].length;
        int[][] transposed = new int[cols][rows];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                transposed[c][r] = original[r][c];
            }
        }

        System.out.println("Original (2x3)   : " + Arrays.deepToString(original));
        System.out.println("Transposed (3x2) : " + Arrays.deepToString(transposed));
    }
}
