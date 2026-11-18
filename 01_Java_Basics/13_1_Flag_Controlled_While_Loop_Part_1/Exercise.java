package _01_Java_Basics._13_1_Flag_Controlled_While_Loop_Part_1;

import java.util.Scanner;

/**
 * Lesson 13.1: Flag-Controlled While Loop (Part 1) — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // =================================================================
        // Problem 1 (Easy): Exam Score Validation Loop
        // =================================================================
        System.out.println("=== Problem 1: Exam Score Validation Loop ===");

        // WHY WE USED THIS WAY:
        // Because we don't know how many invalid scores a user might enter before typing a
        // valid one, we use a boolean flag (`isValidScore = false`) and loop `while (!isValidScore)`.
        // As soon as a valid score (0..100) is entered, `isValidScore` flips to `true` and exits!
        boolean isValidScore = false;
        while (!isValidScore) {
            System.out.print("Enter exam score (0 - 100): ");
            int score = input.nextInt();

            if (score >= 0 && score <= 100) {
                isValidScore = true;
                System.out.println("Accepted valid exam score: " + score);
            } else {
                System.out.println("Invalid score (" + score + "). Must be 0..100.");
            }
        }

        // =================================================================
        // Problem 2 (Medium): Thermostat Stabilization Flag
        // =================================================================
        System.out.println("\n=== Problem 2: Thermostat Stabilization Flag ===");

        int currentTemp = 30;
        int targetTemp = 22;
        boolean isStabilized = false;

        // WHY WE USED THIS WAY:
        // The flag `isStabilized` models the state of the hardware cooling system.
        // The loop continues cooling by 2C per cycle until `currentTemp <= targetTemp`
        // flips `isStabilized = true`.
        while (!isStabilized) {
            currentTemp -= 2;
            System.out.println("Cooling... Current Temp: " + currentTemp + "C");
            if (currentTemp <= targetTemp) {
                isStabilized = true;
                System.out.println("Thermostat stabilized at " + currentTemp + "C!");
            }
        }

        // =================================================================
        // Problem 3 (Hard): Password Strength Validator Loop
        // =================================================================
        System.out.println("\n=== Problem 3: Password Strength Validator Loop ===");

        // Flush leftover newline from `input.nextInt()` above before calling `input.nextLine()`
        input.nextLine();

        boolean isStrongPassword = false;

        // WHY WE USED THIS WAY:
        // `while (!isStrongPassword)` keeps prompting the user with `input.nextLine()`
        // and rejecting short passwords (`length() < 10`) until a strong password flips
        // `isStrongPassword = true`.
        while (!isStrongPassword) {
            System.out.print("Enter a strong password (at least 10 characters): ");
            String candidate = input.nextLine();

            if (candidate.length() >= 10) {
                isStrongPassword = true;
                System.out.println("Password ACCEPTED: \"" + candidate
                        + "\" (Length: " + candidate.length() + ")");
            } else {
                System.out.println("Password REJECTED: \"" + candidate
                        + "\" (Too short: " + candidate.length() + " chars)");
            }
        }

        input.close();
    }
}
