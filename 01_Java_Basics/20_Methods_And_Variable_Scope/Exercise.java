package _01_Java_Basics._20_Methods_And_Variable_Scope;

/**
 * Lesson 20: Methods and Variable Scope — Exercise Solutions
 */
public class Exercise {

    // Class-level static variables (Visible across all methods in Exercise)
    static int taxRatePercent = 8;
    static int totalApiCalls = 0;

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Fixing an Out-of-Scope `if`-Block Variable
        // =================================================================
        System.out.println("=== Problem 1: Fixing an Out-of-Scope Block Variable ===");
        solveProblem1(150);
        solveProblem1(45);

        // =================================================================
        // Problem 2 (Medium): Resolving Variable Shadowing
        // =================================================================
        System.out.println("\n=== Problem 2: Resolving Variable Shadowing ===");
        solveProblem2();

        // =================================================================
        // Problem 3 (Hard): Shared Static Counter vs. Local Counter
        // =================================================================
        System.out.println("\n=== Problem 3: Shared Static Counter vs. Local Counter ===");
        solveProblem3();
    }

    public static void solveProblem1(int orderTotal) {
        // WHY WE USED THIS WAY:
        // A variable declared inside `{ ... }` of an `if` block dies at the closing `}`!
        // By declaring `String discountLabel;` BEFORE the `if-else` statement, it stays in
        // method-level scope so we can print it after the `if-else` block finishes.
        String discountLabel;
        if (orderTotal >= 100) {
            discountLabel = "VIP_20_PERCENT";
        } else {
            discountLabel = "STANDARD_5_PERCENT";
        }
        System.out.println("Order $" + orderTotal + " -> " + discountLabel);
    }

    public static void solveProblem2() {
        // WHY WE USED THIS WAY:
        // Declaring a local variable `int taxRatePercent = 15;` shadows (hides) the
        // class-level `static int taxRatePercent = 8;`.
        // - Referring to `taxRatePercent` unqualified uses the nearest (local) scope (`15`).
        // - Qualifying with the class name `Exercise.taxRatePercent` accesses the shadowed
        //   class-level variable (`8`)!
        int taxRatePercent = 15;
        System.out.println("Local Special Tax Rate  : " + taxRatePercent + "%");
        System.out.println("Global Default Tax Rate : " + Exercise.taxRatePercent + "%");
    }

    public static void solveProblem3() {
        totalApiCalls = 0;
        simulateEndpointHit("/login");
        simulateEndpointHit("/orders");
        simulateEndpointHit("/logout");
    }

    public static void simulateEndpointHit(String endpointName) {
        // WHY WE USED THIS WAY:
        // - `totalApiCalls` has class-level `static` lifetime, so it retains its value
        //   across calls (`1 -> 2 -> 3`).
        // - `localPayloadBytes` has method-local scope and lifetime: it is created fresh
        //   at `256` on every call, incremented to `384`, and destroyed when the method returns!
        totalApiCalls++;
        int localPayloadBytes = 256;
        localPayloadBytes += 128;

        System.out.println("Hit " + endpointName + " | Call #" + totalApiCalls
                + " | Local Payload: " + localPayloadBytes + "B");
    }
}
