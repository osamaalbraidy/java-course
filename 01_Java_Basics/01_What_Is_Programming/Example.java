package _01_Java_Basics._01_What_Is_Programming;

import java.util.Arrays;

/**
 * Lesson 01: What Is Programming?
 * Demonstrates:
 * 1. Step-by-step Algorithmic execution (Input -> Process -> Output)
 * 2. Source Code vs. Binary (Machine Representation)
 * 3. Comparing Imperative (Procedural) vs. Declarative styles in Java
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     LESSON 01: WHAT IS PROGRAMMING?              ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. ALGORITHMIC THINKING: Input -> Process -> Output (IPO Model)
        // Problem: Calculate the total bill after a 15% discount and 8% tax.
        // -----------------------------------------------------------------
        System.out.println("--- [1] Executing a Deterministic Algorithm (IPO) ---");

        // STEP 1 (INPUT): Define initial known values
        double originalPrice = 120.00;
        double discountRate = 0.15; // 15%
        double taxRate = 0.08;      // 8%

        // STEP 2 (PROCESS): Execute unambiguous mathematical transformations in order
        // WHY order matters: Tax is calculated on the discounted price, not the original price!
        double discountAmount = originalPrice * discountRate;
        double discountedPrice = originalPrice - discountAmount;
        double taxAmount = discountedPrice * taxRate;
        double finalBill = discountedPrice + taxAmount;

        // STEP 3 (OUTPUT): Present the result
        System.out.println("Input Original Price : $" + originalPrice);
        System.out.println("Step A (-15% Disc.)  : $" + discountedPrice);
        System.out.println("Step B (+8% Tax)     : $" + taxAmount);
        System.out.println("Output Final Bill    : $" + finalBill);
        System.out.println();

        // -----------------------------------------------------------------
        // 2. SOURCE CODE VS. MACHINE CODE (Binary Representation)
        // WHY: Humans write base-10 numbers and characters in Source Code,
        // but the CPU hardware only processes base-2 binary (0s and 1s).
        // -----------------------------------------------------------------
        System.out.println("--- [2] Source Code vs. Machine Binary ---");
        int humanNumber = 42;
        char humanLetter = 'J';

        String numberInBinary = Integer.toBinaryString(humanNumber);
        String letterInBinary = Integer.toBinaryString(humanLetter);

        System.out.println("Source Code int  : " + humanNumber + "  --> CPU Binary: " + numberInBinary);
        System.out.println("Source Code char : '" + humanLetter + "' --> ASCII Code: " + (int) humanLetter
                + " --> CPU Binary: " + letterInBinary);
        System.out.println();

        // -----------------------------------------------------------------
        // 3. PROGRAMMING PARADIGMS: Imperative vs. Declarative
        // Problem: Sum all even numbers in a list of scores: {10, 15, 20, 25, 30}
        // -----------------------------------------------------------------
        System.out.println("--- [3] Programming Paradigms in Java ---");
        int[] numbers = {10, 15, 20, 25, 30};

        // Paradigm A: Imperative / Procedural (Tell the computer HOW step-by-step)
        int imperativeSum = 0;
        for (int n : numbers) {
            if (n % 2 == 0) {
                imperativeSum = imperativeSum + n;
            }
        }
        System.out.println("Imperative Paradigm Sum (Step-by-step loop) : " + imperativeSum);

        // Paradigm B: Declarative / Functional (Tell the computer WHAT we want using Java Streams)
        int declarativeSum = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("Declarative Paradigm Sum (Java Stream API)  : " + declarativeSum);
    }
}
