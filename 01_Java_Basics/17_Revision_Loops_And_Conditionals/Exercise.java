package _01_Java_Basics._17_Revision_Loops_And_Conditionals;

import java.util.Scanner;

/**
 * Lesson 17: Revision — Loops and Conditionals — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Classic FizzBuzz Interview Challenge
        // =================================================================
        System.out.println("=== Problem 1: Classic FizzBuzz Challenge ===");

        int n = 15;

        // WHY WE USED THIS WAY:
        // In FizzBuzz, we MUST check `(i % 3 == 0 && i % 5 == 0)` FIRST in our `if-else if`
        // ladder! Because `if-else if` stops at the first true branch, checking `i % 3 == 0`
        // first would make 15 print "Fizz" instead of "FizzBuzz".
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // =================================================================
        // Problem 2 (Medium): Prime Number Finder in Range
        // =================================================================
        System.out.println("\n=== Problem 2: Prime Number Finder in Range ===");

        int start = 10;
        int end = 30;
        System.out.print("Primes [" + start + ".." + end + "]: ");

        // WHY WE USED THIS WAY:
        // 1. Outer loop tests each candidate number `num` from `start` to `end`.
        // 2. `boolean isPrime = true;` is declared INSIDE the outer loop so it resets for each `num`.
        // 3. Inner loop only needs to test divisors up to `d * d <= num` (square root of `num`),
        //    and uses `break;` to stop immediately as soon as any factor is found!
        for (int num = start; num <= end; num++) {
            if (num < 2) {
                continue;
            }
            boolean isPrime = true;
            for (int d = 2; d * d <= num; d++) {
                if (num % d == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // =================================================================
        // Problem 3 (Hard): Mini-ATM Transaction Log Analyzer
        // =================================================================
        System.out.println("\n=== Problem 3: Mini-ATM Transaction Log Analyzer ===");

        Scanner input = new Scanner(System.in);

        double balance = 300.0;
        int approvedCount = 0;
        int declinedCount = 0;
        boolean isRunning = true;

        // WHY WE USED THIS WAY:
        // - `while (isRunning)` prompts the user for a transaction type ("DEP", "WITH", or "END").
        // - `if (type.equals("END")) break;` exits cleanly when the sentinel word is entered.
        // - `input.nextLine()` after `input.nextDouble()` flushes the leftover newline so the
        //   next iteration's `input.nextLine()` reads the transaction type cleanly!
        while (isRunning) {
            System.out.print("Enter transaction type (DEP, WITH, or END): ");
            String type = input.nextLine();

            if (type.equals("END")) {
                isRunning = false;
                break;
            }

            System.out.print("Enter transaction amount: ");
            double amount = input.nextDouble();
            input.nextLine(); // Flush leftover newline after nextDouble()!

            if (amount <= 0) {
                declinedCount++;
                continue;
            }

            switch (type) {
                case "DEP" -> {
                    balance += amount;
                    approvedCount++;
                }
                case "WITH" -> {
                    if (amount <= balance) {
                        balance -= amount;
                        approvedCount++;
                    } else {
                        declinedCount++;
                    }
                }
                default -> declinedCount++;
            }
        }
        input.close();

        System.out.printf("Final Balance: $%.2f | Approved: %d | Declined: %d%n",
                balance, approvedCount, declinedCount);
    }
}
