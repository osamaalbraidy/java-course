package _01_Java_Basics._13_2_Flag_Controlled_While_Loop_Part_2;

import java.util.Scanner;

/**
 * Lesson 13.2: Flag-Controlled While Loop (Part 2)
 * Demonstrates:
 * 1. Sentinel-controlled + Flag-controlled loop (excluding the sentinel from sum/count)
 * 2. Multi-condition while loop (combining Boolean Flags, Sentinels, and Max Item limits)
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 13.2: FLAG-CONTROLLED WHILE LOOP (PART 2) ");
        System.out.println("==================================================\n");

        Scanner input = new Scanner(System.in);

        // -----------------------------------------------------------------
        // 1. SENTINEL + FLAG LOOP: Classroom Gradebook Aggregator
        // Sentinel = -1 (Signals end of grade entries).
        // WHY: We check for the sentinel BEFORE adding to sum or incrementing count!
        // -----------------------------------------------------------------
        System.out.println("--- [1] Sentinel-Controlled Gradebook (-1 to Stop) ---");
        final int SENTINEL = -1;

        boolean endOfGrades = false;
        int totalScore = 0;
        int studentCount = 0;

        while (!endOfGrades) {
            System.out.print("Enter student grade (0-100, or -1 to finish): ");
            int score = input.nextInt();

            if (score == SENTINEL) {
                endOfGrades = true; // Sentinel detected! Flip flag and DO NOT add -1 to totalScore!
                System.out.println("  [Sentinel -1 Detected] Closing gradebook input.");
            } else if (score >= 0 && score <= 100) {
                totalScore += score;
                studentCount++;
                System.out.println("  Recorded Grade #" + studentCount + ": " + score);
            } else {
                System.out.println("  [Ignored] Out-of-range grade: " + score);
            }
        }

        // Guard against division by zero in case the first input was -1!
        if (studentCount > 0) {
            double classAverage = (double) totalScore / studentCount;
            System.out.printf("Summary -> Students: %d | Total: %d | Average: %.2f%n%n",
                    studentCount, totalScore, classAverage);
        } else {
            System.out.println("Summary -> No valid grades were entered.\n");
        }

        // -----------------------------------------------------------------
        // 2. MULTI-CONDITION WHILE LOOP: Smart Budget Checkout Cart
        // Stops if:
        //   Condition A: Cashier enters sentinel price 0.0 (checkout complete)
        //   Condition B: Adding item would exceed the $100.00 gift card budget flag
        //   Condition C: Express lane item limit (MAX_EXPRESS_ITEMS = 5) is reached
        // -----------------------------------------------------------------
        System.out.println("--- [2] Multi-Condition Express Lane Checkout ---");
        final double BUDGET_LIMIT = 100.00;
        final int MAX_EXPRESS_ITEMS = 5;
        final double CHECKOUT_SENTINEL = 0.0;

        double cartTotal = 0.0;
        int itemCount = 0;
        boolean checkoutFinished = false;
        boolean budgetReached = false;

        while (!checkoutFinished && !budgetReached && itemCount < MAX_EXPRESS_ITEMS) {
            System.out.print("Enter item price (or 0.0 to checkout): ");
            double price = input.nextDouble();

            if (price == CHECKOUT_SENTINEL) {
                checkoutFinished = true;
                System.out.println("  [Sentinel 0.0] Customer finished scanning.");
            } else if (cartTotal + price > BUDGET_LIMIT) {
                budgetReached = true;
                System.out.printf("  [Budget Flag] Item ($%.2f) would exceed $%.2f budget! Stopping scan.%n",
                        price, BUDGET_LIMIT);
            } else {
                cartTotal += price;
                itemCount++;
                System.out.printf("  Scanned Item #%d: $%.2f (Running Total: $%.2f)%n",
                        itemCount, price, cartTotal);
            }
        }

        System.out.printf("Final Express Receipt -> Items: %d | Total Charged: $%.2f%n", itemCount, cartTotal);
        input.close();
    }
}
