package _01_Java_Basics._01_What_Is_Programming;

/**
 * Lesson 01: What Is Programming? — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Temperature Conversion Algorithm (IPO Model)
        // =================================================================
        System.out.println("=== Problem 1: Temperature Conversion Algorithm ===");

        // WHY WE USED THIS WAY:
        // Every deterministic algorithm follows the IPO (Input -> Process -> Output) sequence:
        // 1. Input: Define the known starting value (`celsius`)
        // 2. Process: Apply the conversion formulas in exact mathematical order
        // 3. Output: Display the results after all calculations are complete
        double celsius = 100.0;
        double fahrenheit = (celsius * 1.8) + 32.0;
        double kelvin = celsius + 273.15;

        System.out.println("Celsius Input     : " + celsius);
        System.out.println("Fahrenheit Output : " + fahrenheit);
        System.out.println("Kelvin Output     : " + kelvin);

        // =================================================================
        // Problem 2 (Medium): Variable Swap Algorithm
        // =================================================================
        System.out.println("\n=== Problem 2: Variable Swap Algorithm ===");

        int cupA = 10;
        int cupB = 20;
        System.out.println("Before Swap -> cupA: " + cupA + ", cupB: " + cupB);

        // WHY WE USED THIS WAY:
        // If we wrote `cupA = cupB;` directly, the original value of `cupA` (10) would be
        // overwritten and lost forever (both variables would become 20!).
        // By introducing a third temporary variable (`tempCup`), we save `cupA`'s original
        // value first before overwriting `cupA` with `cupB`.
        int tempCup = cupA; // Step 1: Save cupA's 10 into tempCup
        cupA = cupB;        // Step 2: Copy cupB's 20 into cupA
        cupB = tempCup;     // Step 3: Restore the saved 10 from tempCup into cupB

        System.out.println("After Swap  -> cupA: " + cupA + ", cupB: " + cupB);

        // =================================================================
        // Problem 3 (Hard): ASCII & Binary Decoder
        // =================================================================
        System.out.println("\n=== Problem 3: ASCII & Binary Decoder ===");

        char ch1 = 'J';
        char ch2 = 'A';
        char ch3 = 'V';

        // WHY WE USED THIS WAY:
        // In source code, humans read characters like 'J', 'A', and 'V', but CPU hardware
        // only stores numeric codes in binary (0s and 1s).
        // Casting `(int) ch` reveals the character's base-10 ASCII/Unicode number, and
        // `Integer.toBinaryString(ch)` shows the exact base-2 binary bits stored in memory.
        System.out.println("Char '" + ch1 + "' | Decimal: " + (int) ch1
                + " | Binary: " + Integer.toBinaryString(ch1));
        System.out.println("Char '" + ch2 + "' | Decimal: " + (int) ch2
                + " | Binary: " + Integer.toBinaryString(ch2));
        System.out.println("Char '" + ch3 + "' | Decimal: " + (int) ch3
                + " | Binary: " + Integer.toBinaryString(ch3));
    }
}
