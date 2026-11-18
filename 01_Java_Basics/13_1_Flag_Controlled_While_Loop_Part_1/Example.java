package _01_Java_Basics._13_1_Flag_Controlled_While_Loop_Part_1;

import java.util.Scanner;

/**
 * Lesson 13.1: Flag-Controlled While Loop (Part 1)
 * Demonstrates:
 * 1. Using a boolean flag (`!isValidPort`) to drive an Input Validation Loop with `Scanner(System.in)`
 * 2. Using a boolean flag (`!isTargetFound`) in a Secret Number Guessing Game
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 13.1: FLAG-CONTROLLED WHILE LOOP (PART 1) ");
        System.out.println("==================================================\n");

        Scanner input = new Scanner(System.in);

        // -----------------------------------------------------------------
        // 1. INPUT VALIDATION LOOP WITH A BOOLEAN FLAG
        // Scenario: Prompt the user to configure a server port (valid range: 1024..65535).
        // -----------------------------------------------------------------
        System.out.println("--- [1] Server Port Input Validation Loop ---");

        boolean isValidPort = false; // 1. Initialize flag to false
        int configuredPort = 0;

        while (!isValidPort) { // 2. Test flag at start of each iteration
            System.out.print("Enter server port (1024 - 65535): ");
            int candidatePort = input.nextInt();

            if (candidatePort >= 1024 && candidatePort <= 65535) {
                configuredPort = candidatePort;
                isValidPort = true; // 3. Flip flag to true -> loop will exit cleanly!
                System.out.println("  [Accepted] Port " + configuredPort + " is valid!");
            } else {
                System.out.println("  [Rejected] Port " + candidatePort
                        + " is outside allowed range [1024..65535]. Try again.");
            }
        }
        System.out.println("Server successfully bound to port: " + configuredPort);
        System.out.println();

        // -----------------------------------------------------------------
        // 2. SECRET NUMBER GUESSING GAME WITH A BOOLEAN FLAG
        // -----------------------------------------------------------------
        System.out.println("--- [2] Flag-Controlled Secret Number Guessing Game ---");
        int secretNumber = 42;
        boolean isTargetFound = false;
        int attempts = 0;

        while (!isTargetFound) {
            System.out.print("Guess the secret number (1 - 100): ");
            int currentGuess = input.nextInt();
            attempts++;

            if (currentGuess == secretNumber) {
                System.out.println("  Attempt #" + attempts + " (" + currentGuess + ") -> CORRECT! Target found!");
                isTargetFound = true; // Flips flag so the while loop terminates!
            } else if (currentGuess < secretNumber) {
                System.out.println("  Attempt #" + attempts + " (" + currentGuess + ") -> Too Low!");
            } else {
                System.out.println("  Attempt #" + attempts + " (" + currentGuess + ") -> Too High!");
            }
        }

        System.out.println("Game exited after " + attempts + " attempts.");
        input.close();
    }
}
