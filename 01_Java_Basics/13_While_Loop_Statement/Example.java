package _01_Java_Basics._13_While_Loop_Statement;

/**
 * Lesson 13: While Loop Statement
 * Demonstrates:
 * 1. The 3 pillars of a counter-controlled while loop (Initialization, Condition, Update)
 * 2. Counting down and stepping by multiples
 * 3. The Accumulator Pattern (Summing 1..N and Compound Interest growth)
 * 4. Pre-test behavior when the initial condition is false
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     LESSON 13: WHILE LOOP STATEMENT              ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. BASIC COUNTER-CONTROLLED WHILE LOOP (1 to 5)
        // -----------------------------------------------------------------
        System.out.println("--- [1] Counter-Controlled While Loop (1 to 5) ---");
        int counter = 1; // 1. Initialization
        while (counter <= 5) { // 2. Continuation Condition
            System.out.println("  Processing Batch #" + counter);
            counter++; // 3. Update (Without this line, the loop runs forever!)
        }
        System.out.println("Loop finished! Final counter value after exit: " + counter);
        System.out.println();

        // -----------------------------------------------------------------
        // 2. COUNTING DOWN & STEPPING BY MULTIPLES
        // -----------------------------------------------------------------
        System.out.println("--- [2] Countdown & Custom Step Increments ---");
        System.out.print("Rocket Launch Countdown : ");
        int secondsLeft = 5;
        while (secondsLeft >= 1) {
            System.out.print(secondsLeft + "... ");
            secondsLeft--; // Decrement step
        }
        System.out.println("LIFTOFF!");

        System.out.print("Even Numbers (2 to 12)  : ");
        int evenNum = 2;
        while (evenNum <= 12) {
            System.out.print(evenNum + " ");
            evenNum += 2; // Step by 2
        }
        System.out.println("\n");

        // -----------------------------------------------------------------
        // 3. THE ACCUMULATOR PATTERN (Summing 1..100 & Compound Interest)
        // WHY: An accumulator variable is declared BEFORE the loop and updated
        // on each iteration to aggregate a final result.
        // -----------------------------------------------------------------
        System.out.println("--- [3] Accumulator Pattern: Sum & Compound Growth ---");
        int n = 1;
        int totalSum = 0; // Accumulator initialized outside the loop
        while (n <= 100) {
            totalSum += n;
            n++;
        }
        System.out.println("Sum of integers from 1 to 100 : " + totalSum);

        // Compound Interest: How many years to double $10,000 at 8% annual return?
        double balance = 10_000.00;
        double targetBalance = 20_000.00;
        double annualRate = 0.08;
        int years = 0;

        while (balance < targetBalance) {
            balance += balance * annualRate;
            years++;
        }
        System.out.printf("Years to double $10,000 at 8%% : %d years (Final Balance: $%,.2f)%n%n",
                years, balance);

        // -----------------------------------------------------------------
        // 4. PRE-TEST BEHAVIOR (Zero Iterations When Initially False)
        // -----------------------------------------------------------------
        System.out.println("--- [4] Pre-Test Behavior (Condition Initially False) ---");
        int tasksRemaining = 0;
        while (tasksRemaining > 0) {
            System.out.println("This line will NEVER execute because 0 > 0 is false.");
        }
        System.out.println("Skipped while loop body cleanly because tasksRemaining == 0.");
    }
}
