package _01_Java_Basics._13_While_Loop_Statement;

/**
 * Lesson 13: While Loop Statement — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Multiplication Table Generator
        // =================================================================
        System.out.println("=== Problem 1: Multiplication Table Generator ===");

        int number = 7;

        // WHY WE USED THIS WAY:
        // A counter-controlled `while` loop requires 3 parts:
        // 1. Initialize counter `int i = 1;` before the loop
        // 2. Test continuation condition `while (i <= 5)`
        // 3. Increment `i++` at the end of the body so the loop advances and terminates!
        int i = 1;
        while (i <= 5) {
            System.out.println(number + " x " + i + " = " + (number * i));
            i++;
        }

        // =================================================================
        // Problem 2 (Medium): Factorial Accumulator (n!)
        // =================================================================
        System.out.println("\n=== Problem 2: Factorial Accumulator ===");

        int n = 6;

        // WHY WE USED THIS WAY:
        // 1. We initialize our multiplicative accumulator `factorial = 1L` (NOT 0, because
        //    multiplying by 0 would keep the product at 0 forever!).
        // 2. We use `long` instead of `int` because factorials grow very rapidly (13! overflows `int`).
        long factorial = 1L;
        int step = 1;
        while (step <= n) {
            factorial *= step;
            step++;
        }
        System.out.println(n + "! = " + factorial);

        // =================================================================
        // Problem 3 (Hard): Digit Reverser Algorithm with `while`
        // =================================================================
        System.out.println("\n=== Problem 3: Digit Reverser Algorithm ===");

        int originalNumber = 12345;
        int workingNum = originalNumber;
        int reversed = 0;

        // WHY WE USED THIS WAY:
        // We don't need to convert a number to a String to reverse it!
        // On each pass of `while (workingNum > 0)`:
        // - `workingNum % 10` peels off the rightmost digit (e.g., 5, then 4, then 3...)
        // - `reversed = (reversed * 10) + lastDigit` shifts previously collected digits left
        //   by one decimal place and appends the new digit
        // - `workingNum /= 10` removes the rightmost digit until `workingNum` reaches 0.
        while (workingNum > 0) {
            int lastDigit = workingNum % 10;
            reversed = (reversed * 10) + lastDigit;
            workingNum /= 10;
        }

        System.out.println("Original: " + originalNumber + " -> Reversed: " + reversed);
    }
}
