package _01_Java_Basics._09_If_Statement_Part_1;

/**
 * Lesson 09: If Statement (Part 1)
 * Demonstrates:
 * 1. All 6 relational operators (==, !=, <, <=, >, >=)
 * 2. Single-branch `if` and two-branch `if-else` statements
 * 3. Comparing Strings safely with .equals() vs. the `==` reference trap
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     LESSON 09: IF STATEMENT (PART 1)             ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. ALL 6 RELATIONAL OPERATORS (Produce boolean true/false)
        // -----------------------------------------------------------------
        int x = 15;
        int y = 20;

        System.out.println("--- [1] Relational Operators (x = 15, y = 20) ---");
        System.out.println("x == y (Equal to)                 : " + (x == y));
        System.out.println("x != y (Not equal to)             : " + (x != y));
        System.out.println("x <  y (Less than)                : " + (x < y));
        System.out.println("x <= 15 (Less than or equal to)   : " + (x <= 15));
        System.out.println("x >  y (Greater than)             : " + (x > y));
        System.out.println("y >= 20 (Greater than or equal to): " + (y >= 20));
        System.out.println();

        // -----------------------------------------------------------------
        // 2. SINGLE-BRANCH `if` AND TWO-BRANCH `if-else`
        // Problem: Bank ATM Withdrawal & Free Shipping Eligibility
        // -----------------------------------------------------------------
        System.out.println("--- [2] Bank ATM Withdrawal Check (if-else) ---");
        double accountBalance = 500.00;
        double withdrawalRequest = 350.00;

        // Single-branch `if`: Apply a VIP notice if balance is at least $500
        if (accountBalance >= 500.00) {
            System.out.println("[VIP Notice] Zero ATM fee applied for balance >= $500.00.");
        }

        // Two-branch `if-else`: Either approve and deduct, or reject
        if (withdrawalRequest <= accountBalance) {
            accountBalance -= withdrawalRequest;
            System.out.printf("[APPROVED] Dispensed $%.2f. New Balance: $%.2f%n",
                    withdrawalRequest, accountBalance);
        } else {
            System.out.printf("[DECLINED] Insufficient funds! Requested $%.2f, Available: $%.2f%n",
                    withdrawalRequest, accountBalance);
        }
        System.out.println();

        // -----------------------------------------------------------------
        // 3. COMPARING STRINGS: .equals() VS. `==`
        // WHY: `new String("ADMIN")` allocates a distinct Heap object.
        // `==` compares memory addresses (false!), whereas `.equals()` compares characters (true!).
        // -----------------------------------------------------------------
        System.out.println("--- [3] String Comparison: .equals() vs. == ---");
        String expectedRole = "ADMIN";
        String runtimeUserRole = new String("ADMIN"); // Distinct object in Heap memory

        if (expectedRole == runtimeUserRole) {
            System.out.println("Using `==`       : Matched");
        } else {
            System.out.println("Using `==`       : FAILED! (Different memory addresses)");
        }

        if (expectedRole.equals(runtimeUserRole)) {
            System.out.println("Using `.equals()`: MATCHED! (Identical character content)");
        }
    }
}
