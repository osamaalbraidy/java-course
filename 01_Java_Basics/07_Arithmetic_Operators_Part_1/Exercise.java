package _01_Java_Basics._07_Arithmetic_Operators_Part_1;

/**
 * Lesson 07: Arithmetic Operators (Part 1) — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Exact Batting Average Calculator
        // =================================================================
        System.out.println("=== Problem 1: Exact Batting Average Calculator ===");

        int hits = 45;
        int atBats = 160;

        // WHY WE USED THIS WAY:
        // In Java, dividing two `int` variables (`hits / atBats`) performs integer division,
        // which truncates `0.28125` down to `0`!
        // By casting `(double) hits` BEFORE the `/` operator, `hits` becomes `45.0`,
        // forcing Java to promote `atBats` to `160.0` and perform exact floating-point division.
        int truncatedRatio = hits / atBats;
        double battingAverage = (double) hits / atBats;

        System.out.println("Hits / At-Bats (int)    : " + truncatedRatio);
        System.out.printf("Exact Batting Average   : %.3f%n", battingAverage);

        // =================================================================
        // Problem 2 (Medium): Vending Machine Coin Dispenser
        // =================================================================
        System.out.println("\n=== Problem 2: Vending Machine Coin Dispenser ===");

        int totalCents = 193;
        int remaining = totalCents;

        // WHY WE USED THIS WAY:
        // Greedy coin change uses `/` (integer division) to find how many whole coins of a
        // denomination fit into `remaining`, followed by `%` (modulo) to keep only the
        // leftover cents for the next smaller coin denomination!
        int quarters = remaining / 25; // 193 / 25 = 7 quarters
        remaining = remaining % 25;    // 193 % 25 = 18 cents left

        int dimes = remaining / 10;    // 18 / 10  = 1 dime
        remaining = remaining % 10;    // 18 % 10  = 8 cents left

        int nickels = remaining / 5;   // 8 / 5    = 1 nickel
        int pennies = remaining % 5;   // 8 % 5    = 3 pennies left

        System.out.println("Total Change : " + totalCents + " cents");
        System.out.println("Quarters (25): " + quarters);
        System.out.println("Dimes    (10): " + dimes);
        System.out.println("Nickels   (5): " + nickels);
        System.out.println("Pennies   (1): " + pennies);

        // =================================================================
        // Problem 3 (Hard): Sum of Digits of a 4-Digit Pin Code
        // =================================================================
        System.out.println("\n=== Problem 3: Sum of Digits of a 4-Digit Pin Code ===");

        int pin = 7395;

        // WHY WE USED THIS WAY:
        // Base-10 positional math lets us isolate any digit using `/` (to shift digits right)
        // and `% 10` (to extract the rightmost digit):
        // - `7395 / 1000`      -> `7` (thousands place)
        // - `(7395 / 100) % 10` -> `73 % 10`  = `3` (hundreds place)
        // - `(7395 / 10) % 10`  -> `739 % 10` = `9` (tens place)
        // - `7395 % 10`         -> `5` (ones place)
        int thousands = pin / 1000;
        int hundreds = (pin / 100) % 10;
        int tens = (pin / 10) % 10;
        int ones = pin % 10;

        int digitSum = thousands + hundreds + tens + ones;

        System.out.println("PIN Code      : " + pin);
        System.out.println("Digits        : " + thousands + ", " + hundreds + ", " + tens + ", " + ones);
        System.out.println("Sum of Digits : " + digitSum);
    }
}
