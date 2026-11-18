package _01_Java_Basics._22_Arrays;

import java.util.Arrays;
/**
 * Lesson 22: One-Dimensional Arrays
 * Demonstrates:
 * 1. Array allocation with `new` (default values) vs. initializer literals `{...}`
 * 2. Index-based `for` traversal vs. Enhanced `for-each` traversal
 * 3. Finding Min, Max, Sum, and Average in a 1D array
 * 4. Demonstrating bounds checking (`ArrayIndexOutOfBoundsException` guard)
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 22: ONE-DIMENSIONAL ARRAYS              ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. ARRAY DECLARATION, DEFAULT VALUES & INITIALIZER LITERALS
        // -----------------------------------------------------------------
        System.out.println("--- [1] Array Allocation & Default Initialization ---");
        int[] defaultScores = new int[4]; // Automatically filled with 0s on the Heap
        defaultScores[0] = 100;
        defaultScores[3] = 400; // Last valid index is length - 1 (4 - 1 = 3)

        // WHY Arrays.toString(): Printing `defaultScores` directly prints `[I@hashcode`!
        System.out.println("new int[4] (with index 0 & 3 set): " + Arrays.toString(defaultScores));

        double[] cpuTemperatures = {62.5, 68.0, 74.2, 71.8, 65.4, 79.1};
        System.out.println("Array Literal (length = " + cpuTemperatures.length + ")       : "
                + Arrays.toString(cpuTemperatures));
        System.out.println();

        // -----------------------------------------------------------------
        // 2. INDEX-BASED `for` LOOP (When You Need the Index `i` or Mutation)
        // -----------------------------------------------------------------
        System.out.println("--- [2] Index-Based `for` Loop (0 to length - 1) ---");
        for (int i = 0; i < cpuTemperatures.length; i++) {
            System.out.printf("  Core #%d (Index %d) -> %.1f C%n", i + 1, i, cpuTemperatures[i]);
        }
        System.out.println();

        // -----------------------------------------------------------------
        // 3. ENHANCED `for-each` LOOP & STATISTICAL AGGREGATION (Min/Max/Sum)
        // WHY: When we only need to READ every element sequentially, `for (double temp : array)`
        // is cleaner and makes `ArrayIndexOutOfBoundsException` impossible!
        // -----------------------------------------------------------------
        System.out.println("--- [3] Enhanced `for-each` Loop (Min / Max / Avg) ---");
        double sum = 0.0;
        // Initialize min and max to the first element (`[0]`) of the non-empty array!
        double minTemp = cpuTemperatures[0];
        double maxTemp = cpuTemperatures[0];

        for (double temp : cpuTemperatures) {
            sum += temp;
            if (temp < minTemp) {
                minTemp = temp;
            }
            if (temp > maxTemp) {
                maxTemp = temp;
            }
        }

        double averageTemp = sum / cpuTemperatures.length;
        System.out.printf("Min: %.1f C | Max: %.1f C | Average: %.2f C%n%n",
                minTemp, maxTemp, averageTemp);

        // -----------------------------------------------------------------
        // 4. BOUNDS SAFETY & CATCHING `ArrayIndexOutOfBoundsException`
        // -----------------------------------------------------------------
        System.out.println("--- [4] Array Bounds Safety ---");
        int invalidIndex = cpuTemperatures.length; // Index 6 is OUT OF BOUNDS for length 6 (valid: 0..5)
        try {
            System.out.println("Attempting to read cpuTemperatures[" + invalidIndex + "]...");
            double badRead = cpuTemperatures[invalidIndex];
            System.out.println(badRead);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Caught Runtime Exception: " + ex.getClass().getSimpleName()
                    + " -> " + ex.getMessage());
            System.out.println("Rule: Valid indices are always 0 to (array.length - 1)!");
        }
    }
}
