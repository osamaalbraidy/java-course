package _01_Java_Basics._14_Do_While_Loop_Statement;

import java.util.Scanner;

/**
 * Lesson 14: Do-While Loop Statement
 * Demonstrates:
 * 1. Guaranteed minimum 1-iteration execution (post-test vs. pre-test)
 * 2. Building a Menu-Driven CLI Banking Application with `do-while`, `switch`, and `new Scanner(System.in)`
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     LESSON 14: DO-WHILE LOOP STATEMENT           ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. PRE-TEST (`while`) VS. POST-TEST (`do-while`) WHEN CONDITION IS FALSE
        // -----------------------------------------------------------------
        System.out.println("--- [1] Pre-Test (while) vs. Post-Test (do-while) ---");
        int counter = 100;

        while (counter < 10) {
            System.out.println("Inside while loop (Never prints!)");
        }
        System.out.println("Standard `while (100 < 10)` executed 0 times.");

        do {
            System.out.println("Inside `do-while` body -> Executed ONCE even though (100 < 10) is false!");
        } while (counter < 10); // Mandatory semicolon!
        System.out.println();

        // -----------------------------------------------------------------
        // 2. MENU-DRIVEN CLI APPLICATION (Classic `do-while` Use Case)
        // WHY: An interactive menu must display options and read the user's
        // selection at least once before deciding whether to loop or exit.
        // -----------------------------------------------------------------
        System.out.println("--- [2] Menu-Driven CLI Banking Terminal ---");
        Scanner input = new Scanner(System.in);

        double balance = 500.00;
        // IMPORTANT: Declare `choice` OUTSIDE the `do` block so `while (choice != 0)` can access it!
        int choice;

        do {
            System.out.println("\n[BANK MENU] 1: Balance | 2: Deposit | 3: Withdraw | 0: Exit");
            System.out.print("Enter menu option: ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> System.out.printf("  -> Current Balance: $%.2f%n", balance);
                case 2 -> {
                    System.out.print("Enter deposit amount: ");
                    double deposit = input.nextDouble();
                    balance += deposit;
                    System.out.printf("  -> Deposited $%.2f | New Balance: $%.2f%n", deposit, balance);
                }
                case 3 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawal = input.nextDouble();
                    if (withdrawal <= balance) {
                        balance -= withdrawal;
                        System.out.printf("  -> Withdrew $%.2f | New Balance: $%.2f%n", withdrawal, balance);
                    } else {
                        System.out.println("  -> Insufficient funds!");
                    }
                }
                case 0 -> System.out.println("  -> Exiting Banking Terminal. Goodbye!");
                default -> System.out.println("  -> Invalid menu option! Please choose 0-3.");
            }
        } while (choice != 0);

        input.close();
    }
}
