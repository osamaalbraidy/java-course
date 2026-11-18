package _01_Java_Basics._13_2_Flag_Controlled_While_Loop_Part_2;

import java.util.Scanner;

/**
 * Lesson 13.2: Flag-Controlled While Loop (Part 2) — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // =================================================================
        // Problem 1 (Easy): Charity Donation Tracker (Sentinel 0)
        // =================================================================
        System.out.println("=== Problem 1: Charity Donation Tracker (Sentinel 0) ===");

        boolean isFinished = false;
        int totalDonations = 0;
        int donorCount = 0;

        // WHY WE USED THIS WAY:
        // We check `if (amount == 0)` (the sentinel value) BEFORE adding to `totalDonations`
        // or incrementing `donorCount`. That way the sentinel `0` only stops the loop and is
        // never counted as a donor!
        while (!isFinished) {
            System.out.print("Enter donation amount (or 0 to finish): ");
            int amount = input.nextInt();

            if (amount == 0) {
                isFinished = true;
            } else {
                totalDonations += amount;
                donorCount++;
            }
        }
        System.out.println("Donors: " + donorCount + " | Total Raised: $" + totalDonations);

        // =================================================================
        // Problem 2 (Medium): Server Log Error Monitor (Sentinel or Threshold)
        // =================================================================
        System.out.println("\n=== Problem 2: Server Log Error Monitor ===");

        // Flush leftover newline from `input.nextInt()` above before using `input.nextLine()`
        input.nextLine();

        boolean endOfStream = false;
        boolean criticalThresholdReached = false;
        int totalLogsRead = 0;
        int errorCount = 0;

        // WHY WE USED THIS WAY:
        // By combining `!endOfStream && !criticalThresholdReached` in the `while` header
        // (De Morgan's Law), the loop continues only while NEITHER stop condition has occurred,
        // and exits immediately as soon as EITHER "EOF" is entered OR 3 errors are detected!
        while (!endOfStream && !criticalThresholdReached) {
            System.out.print("Enter log tag (INFO, WARN, ERROR, or EOF to stop): ");
            String tag = input.nextLine();

            if (tag.equals("EOF")) {
                endOfStream = true;
            } else {
                totalLogsRead++;
                if (tag.equals("ERROR")) {
                    errorCount++;
                    if (errorCount == 3) {
                        criticalThresholdReached = true;
                        System.out.println("ALERT: 3 errors detected! Halting log scan.");
                    }
                }
            }
        }
        System.out.println("Logs Processed: " + totalLogsRead + " | Errors Found: " + errorCount);

        // =================================================================
        // Problem 3 (Hard): Multi-Condition ATM PIN Lockout System
        // =================================================================
        System.out.println("\n=== Problem 3: Multi-Condition ATM PIN Lockout System ===");

        final int SECRET_PIN = 4321;
        final int CANCEL_SENTINEL = -1;
        final int MAX_ATTEMPTS = 3;

        boolean isUnlocked = false;
        boolean isCancelled = false;
        int attempts = 0;

        // WHY WE USED THIS WAY:
        // An ATM prompt has 3 distinct exit conditions:
        // 1. Correct PIN entered (`isUnlocked` flag)
        // 2. User pressed Cancel (`isCancelled` flag via `-1` sentinel)
        // 3. Brute-force protection (`attempts < MAX_ATTEMPTS` counter cap)
        while (!isUnlocked && !isCancelled && attempts < MAX_ATTEMPTS) {
            System.out.print("Enter 4-digit PIN (or -1 to cancel): ");
            int enteredPin = input.nextInt();

            if (enteredPin == CANCEL_SENTINEL) {
                isCancelled = true;
                System.out.println("[Cancelled] User pressed Cancel (-1).");
            } else {
                attempts++;
                if (enteredPin == SECRET_PIN) {
                    isUnlocked = true;
                    System.out.println("[Unlocked] PIN accepted on attempt #" + attempts + "!");
                } else {
                    System.out.println("[Failed] Wrong PIN (" + enteredPin
                            + ") - Attempt " + attempts + "/" + MAX_ATTEMPTS);
                }
            }
        }

        if (!isUnlocked && !isCancelled && attempts == MAX_ATTEMPTS) {
            System.out.println("[LOCKED] Account locked after 3 failed attempts!");
        }

        input.close();
    }
}
