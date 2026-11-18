package _01_Java_Basics._14_Do_While_Loop_Statement;

import java.util.Scanner;

/**
 * Lesson 14: Do-While Loop Statement — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // =================================================================
        // Problem 1 (Easy): Dice Roll Until Six (`do-while`)
        // =================================================================
        System.out.println("=== Problem 1: Dice Roll Until Six ===");

        int rollCount = 0;
        int roll;

        // WHY WE USED THIS WAY:
        // You must roll a die AT LEAST ONCE before you can check whether it landed on 6!
        // A post-test `do-while (roll != 6);` loop guarantees the first roll happens inside
        // the `do` block before testing `roll != 6` at the bottom.
        do {
            rollCount++;
            System.out.print("Enter dice roll #" + rollCount + " (1 - 6): ");
            roll = input.nextInt();
            System.out.println("Roll #" + rollCount + ": " + roll);
        } while (roll != 6);

        System.out.println("Rolled a 6 after " + rollCount + " rolls!");

        // =================================================================
        // Problem 2 (Medium): "Continue Playing? (y/n)" Game Loop
        // =================================================================
        System.out.println("\n=== Problem 2: Continue Playing (y/n) Game Loop ===");

        // Flush leftover newline after `input.nextInt()` above before using `input.nextLine()`
        input.nextLine();

        int roundsPlayed = 0;
        String response;

        // WHY WE USED THIS WAY:
        // Every "Play Again? (y/n)" loop is a classic `do-while` scenario because the
        // player always plays Round #1 first, and is asked whether to continue at the end
        // of each round.
        do {
            roundsPlayed++;
            System.out.print("Completed Game Round #" + roundsPlayed + " | Play again? (y/n): ");
            response = input.nextLine();
        } while (response.equalsIgnoreCase("y"));

        System.out.println("Game Over! Total rounds played: " + roundsPlayed);

        // =================================================================
        // Problem 3 (Hard): Menu-Driven Unit Converter CLI
        // =================================================================
        System.out.println("\n=== Problem 3: Menu-Driven Unit Converter CLI ===");

        int option;

        // WHY WE USED THIS WAY:
        // An interactive CLI menu must display options and read the user's choice at least
        // once before checking `while (option != 0);`. Combining `do-while` with `switch`
        // is the standard Java pattern for menu-driven console applications.
        do {
            System.out.print("Menu (1: km->miles | 2: kg->lbs | 0: Exit): ");
            option = input.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter kilometers: ");
                    double km = input.nextDouble();
                    double miles = km * 0.621371;
                    System.out.printf("%.1f km = %.2f miles%n", km, miles);
                }
                case 2 -> {
                    System.out.print("Enter kilograms: ");
                    double kg = input.nextDouble();
                    double lbs = kg * 2.20462;
                    System.out.printf("%.1f kg = %.2f lbs%n", kg, lbs);
                }
                case 0 -> System.out.println("Converter closed.");
                default -> System.out.println("Invalid option!");
            }
        } while (option != 0);

        input.close();
    }
}
