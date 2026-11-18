package _01_Java_Basics._23_Arrays_And_Methods;

import java.util.Arrays;

/**
 * Lesson 23: Arrays and Methods
 * Demonstrates:
 * 1. In-place array mutation when passing an array reference to a method
 * 2. Why reassigning `arr = new int[...]` inside a method does NOT affect the caller
 * 3. Returning a brand-new transformed array (Non-destructive / Pure function style)
 * 4. Variable-length arguments (`varargs`: `int...`)
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 23: ARRAYS AND METHODS                  ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. IN-PLACE ARRAY MUTATION (Shared Heap Reference)
        // WHY: `prices` in main() and `target` in applyTenPercentBonus() hold
        // copies of the SAME Heap memory address. Mutating `target[i]` mutates `prices[i]`!
        // -----------------------------------------------------------------
        System.out.println("--- [1] In-Place Mutation via Shared Array Reference ---");
        int[] scores = {70, 80, 90};
        System.out.println("In main() BEFORE addCurveInPlace : " + Arrays.toString(scores));

        addCurveInPlace(scores, 5);

        System.out.println("In main() AFTER addCurveInPlace  : " + Arrays.toString(scores)
                + " (Mutated on Heap!)");
        System.out.println();

        // -----------------------------------------------------------------
        // 2. REASSIGNING THE PARAMETER REFERENCE VS. MUTATING ELEMENTS
        // WHY: Reassigning `arr = new int[]{...}` only changes where the local
        // variable `arr` points; `scores` in main() still points to the original array!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Reassigning Parameter Reference vs. Mutating Elements ---");
        attemptArrayReplacement(scores);
        System.out.println("In main() AFTER replacement try  : " + Arrays.toString(scores)
                + " (Still points to original array!)");
        System.out.println();

        // -----------------------------------------------------------------
        // 3. RETURNING A NEW ARRAY FROM A METHOD (Non-Destructive Reversal)
        // -----------------------------------------------------------------
        System.out.println("--- [3] Returning a Brand-New Array from a Method ---");
        int[] originalData = {10, 20, 30, 40, 50};
        int[] reversedCopy = createReversedArray(originalData);

        System.out.println("Original Array (Unchanged)       : " + Arrays.toString(originalData));
        System.out.println("Returned Reversed Copy           : " + Arrays.toString(reversedCopy));
        System.out.println();

        // -----------------------------------------------------------------
        // 4. VARIABLE-LENGTH ARGUMENTS (varargs: `int... values`)
        // -----------------------------------------------------------------
        System.out.println("--- [4] Varargs (`int... values`) ---");
        System.out.println("sumVarargs(10, 20)               = " + sumVarargs(10, 20));
        System.out.println("sumVarargs(5, 10, 15, 20, 25)    = " + sumVarargs(5, 10, 15, 20, 25));
    }

    /**
     * Mutates the caller's array in-place by adding `bonusPoints` to every element.
     */
    public static void addCurveInPlace(int[] target, int bonusPoints) {
        for (int i = 0; i < target.length; i++) {
            target[i] += bonusPoints;
        }
    }

    /**
     * Demonstrates that pointing the local parameter `arr` at a new array object
     * does NOT redirect the caller's reference variable in `main()`.
     */
    public static void attemptArrayReplacement(int[] arr) {
        arr = new int[]{0, 0, 0}; // Only changes local reference variable `arr`!
        System.out.println("Inside attemptArrayReplacement   : " + Arrays.toString(arr));
    }

    /**
     * Allocates, populates, and returns a new reversed array without modifying `source`.
     */
    public static int[] createReversedArray(int[] source) {
        int[] reversed = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            reversed[i] = source[source.length - 1 - i];
        }
        return reversed;
    }

    /**
     * Accepts any number of `int` arguments via varargs (`int...`).
     */
    public static int sumVarargs(int... values) {
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return sum;
    }
}
