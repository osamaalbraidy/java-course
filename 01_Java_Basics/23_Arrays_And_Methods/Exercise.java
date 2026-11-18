package _01_Java_Basics._23_Arrays_And_Methods;

import java.util.Arrays;

/**
 * Lesson 23: Arrays and Methods — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: In-Place Array Element Swapper ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Non-Destructive Array Clamp ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Filtering Even Numbers into a New Array ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Before Swap : " + Arrays.toString(numbers));

        // WHY WE USED THIS WAY:
        // Passing `numbers` passes a copy of its Heap memory reference into `swapElements`.
        // Because both references point to the exact same array on the Heap, `swapElements`
        // mutates `numbers` in place without needing to return anything (`void`)!
        swapElements(numbers, 0, numbers.length - 1);
        System.out.println("After Swap  : " + Arrays.toString(numbers));
    }

    public static void swapElements(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public static void solveProblem2() {
        int[] rawSignals = {-25, 10, 55, 100, 140};

        // WHY WE USED THIS WAY:
        // When we want to keep the caller's original `rawSignals` array untouched,
        // `createClampedArray` allocates a brand-new `int[]` on the Heap, fills it with
        // the clamped values, and returns the new reference.
        int[] clampedCopy = createClampedArray(rawSignals, 0, 100);

        System.out.println("Original Raw Signals : " + Arrays.toString(rawSignals));
        System.out.println("Clamped Copy [0..100]: " + Arrays.toString(clampedCopy));
    }

    public static int[] createClampedArray(int[] source, int minAllowed, int maxAllowed) {
        int[] clamped = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            if (source[i] < minAllowed) {
                clamped[i] = minAllowed;
            } else if (source[i] > maxAllowed) {
                clamped[i] = maxAllowed;
            } else {
                clamped[i] = source[i];
            }
        }
        return clamped;
    }

    public static void solveProblem3() {
        int[] input = {11, 24, 37, 42, 50, 63, 88};
        int[] evensOnly = extractEvenNumbers(input);

        System.out.println("Input Array  : " + Arrays.toString(input));
        System.out.println("Filtered Even: " + Arrays.toString(evensOnly));
    }

    public static int[] extractEvenNumbers(int[] input) {
        // WHY WE USED THIS WAY:
        // Because standard Java arrays have fixed length, we cannot resize an array after
        // creating it. Therefore, we use a two-pass algorithm:
        // Pass 1 counts how many even numbers exist (`evenCount = 4`) so we can allocate
        // `new int[evenCount]` at the exact required size.
        // Pass 2 copies each even number into `evens[writeIndex++]`.
        int evenCount = 0;
        for (int num : input) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        int[] evens = new int[evenCount];
        int writeIndex = 0;
        for (int num : input) {
            if (num % 2 == 0) {
                evens[writeIndex++] = num;
            }
        }
        return evens;
    }
}
