package _01_Java_Basics._16_Break_And_Continue_Statements;

/**
 * Lesson 16: Break and Continue Statements
 * Demonstrates:
 * 1. `continue` for skipping invalid/filtered records during batch processing
 * 2. `break` for early exit once a search target is found
 * 3. Labeled `break` (`outerLoop:`) to exit nested 2D loops cleanly
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 16: BREAK AND CONTINUE STATEMENTS       ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. `continue`: SKIPPING CORRUPTED SENSOR READINGS
        // WHY: `continue` lets us filter out bad items at the top of a loop
        // ("guard clause") without deeply nesting the valid processing logic.
        // -----------------------------------------------------------------
        System.out.println("--- [1] Using `continue` to Skip Negative Sensor Noise ---");
        int[] sensorReadings = {24, -999, 26, -1, 25, 27};
        int validSum = 0;
        int validCount = 0;

        for (int i = 0; i < sensorReadings.length; i++) {
            int reading = sensorReadings[i];

            if (reading < 0) {
                System.out.println("  [Skipped] Index " + i + " has corrupted value: " + reading);
                continue; // Jumps straight to `i++` for the next iteration!
            }

            validSum += reading;
            validCount++;
            System.out.println("  [Processed] Index " + i + " valid reading: " + reading + "C");
        }
        System.out.println("Valid Readings: " + validCount + " | Sum: " + validSum + "C\n");

        // -----------------------------------------------------------------
        // 2. `break`: EARLY EXIT ON FIRST MATCH (Prime Number Check)
        // WHY: Once we find a single divisor of N, we know N is composite;
        // testing any further divisors is wasted CPU work!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Using `break` for Early Termination (Divisor Search) ---");
        int candidate = 91; // 91 = 7 * 13
        int firstDivisor = -1;

        for (int d = 2; d * d <= candidate; d++) {
            System.out.println("  Testing divisor d = " + d + "...");
            if (candidate % d == 0) {
                firstDivisor = d;
                System.out.println("  -> Found divisor " + d + "! Breaking out of loop early.");
                break; // Stops checking 8, 9, ... immediately!
            }
        }
        System.out.println("Result: " + candidate + " is divisible by " + firstDivisor + ".\n");

        // -----------------------------------------------------------------
        // 3. LABELED `break`: EXITING NESTED LOOPS AT ONCE
        // WHY: An unlabeled `break` inside the inner loop would only exit the
        // column loop and keep running the next row! `break matrixSearch;` exits both!
        // -----------------------------------------------------------------
        System.out.println("--- [3] Labeled `break` in a 2D Warehouse Grid ---");
        int targetItemCode = 777;
        int[][] warehouseGrid = {
            {101, 102, 103},
            {201, 777, 203},
            {301, 302, 777}
        };

        matrixSearch: // Label attached to the outer loop
        for (int aisle = 0; aisle < warehouseGrid.length; aisle++) {
            for (int bin = 0; bin < warehouseGrid[aisle].length; bin++) {
                int currentItem = warehouseGrid[aisle][bin];
                System.out.println("  Scanning Aisle " + aisle + ", Bin " + bin + " -> Item " + currentItem);
                if (currentItem == targetItemCode) {
                    System.out.println("  [FOUND] Target " + targetItemCode
                            + " located at Aisle " + aisle + ", Bin " + bin + "! Exiting entire grid search.");
                    break matrixSearch; // Exits BOTH inner and outer loops!
                }
            }
        }
    }
}
