package _01_Java_Basics._24_Two_Dimensional_Arrays;

import java.util.Arrays;
/**
 * Lesson 24: Two-Dimensional Arrays
 * Demonstrates:
 * 1. Declaring and printing a 2D rectangular matrix (`Arrays.deepToString`)
 * 2. Row-wise aggregation (Student Exam Averages) vs. Column-wise aggregation (Exam Averages)
 * 3. Square matrix diagonals (Main diagonal & Anti-diagonal)
 * 4. Jagged (uneven row length) 2D arrays
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 24: TWO-DIMENSIONAL ARRAYS              ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. 2D RECTANGULAR ARRAY: 3 Students (Rows) x 4 Exams (Columns)
        // -----------------------------------------------------------------
        int[][] gradebook = {
            {85, 90, 78, 92}, // Row 0: Student 1
            {88, 76, 95, 89}, // Row 1: Student 2
            {92, 94, 88, 96}  // Row 2: Student 3
        };

        System.out.println("--- [1] 2D Array Inspection ---");
        System.out.println("Number of Rows (gradebook.length)       : " + gradebook.length);
        System.out.println("Number of Cols (gradebook[0].length)    : " + gradebook[0].length);
        // WHY Arrays.deepToString(): Arrays.toString() on a 2D array only prints row object references!
        System.out.println("Arrays.deepToString(gradebook)          : " + Arrays.deepToString(gradebook));
        System.out.println();

        // -----------------------------------------------------------------
        // 2. ROW-MAJOR TRAVERSAL (Row Sums) & COLUMN-MAJOR TRAVERSAL (Column Sums)
        // -----------------------------------------------------------------
        System.out.println("--- [2] Row-Wise Student Averages ---");
        for (int row = 0; row < gradebook.length; row++) {
            int rowSum = 0;
            for (int col = 0; col < gradebook[row].length; col++) {
                rowSum += gradebook[row][col];
            }
            double studentAvg = (double) rowSum / gradebook[row].length;
            System.out.printf("  Student #%d Grades: %-18s -> Avg: %.2f%n",
                    row + 1, Arrays.toString(gradebook[row]), studentAvg);
        }
        System.out.println();

        System.out.println("--- [3] Column-Wise Exam Averages ---");
        int numRows = gradebook.length;
        int numCols = gradebook[0].length;
        for (int col = 0; col < numCols; col++) {
            int colSum = 0;
            for (int row = 0; row < numRows; row++) {
                colSum += gradebook[row][col];
            }
            double examAvg = (double) colSum / numRows;
            System.out.printf("  Exam #%d (Column %d) AverageAcross Students: %.2f%n", col + 1, col, examAvg);
        }
        System.out.println();

        // -----------------------------------------------------------------
        // 3. JAGGED ARRAYS (Each Row Has a Different Number of Columns!)
        // WHY: In Java, a 2D array is an array of 1D row references. Using
        // `jagged[r].length` handles uneven rows effortlessly!
        // -----------------------------------------------------------------
        System.out.println("--- [4] Jagged (Ragged) 2D Array Traversal ---");
        int[][] jaggedTriangle = {
            {10},
            {20, 30},
            {40, 50, 60, 70}
        };

        for (int r = 0; r < jaggedTriangle.length; r++) {
            System.out.print("  Row " + r + " (len=" + jaggedTriangle[r].length + "): ");
            for (int c = 0; c < jaggedTriangle[r].length; c++) {
                System.out.print(jaggedTriangle[r][c] + " ");
            }
            System.out.println();
        }
    }
}
