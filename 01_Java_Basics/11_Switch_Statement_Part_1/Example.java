package _01_Java_Basics._11_Switch_Statement_Part_1;

/**
 * Lesson 11: Switch Statement (Part 1)
 * Demonstrates:
 * 1. Traditional `switch`, `case`, `break`, and `default` with `int`
 * 2. Switching on `char` with compile-time `final` constants
 * 3. What happens when `break` is omitted (Accidental Fall-Through Bug)
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 11: SWITCH STATEMENT (PART 1)           ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. TRADITIONAL `switch` WITH `int` (HTTP Status Code Classifier)
        // WHY: `switch` jumps directly to the matching constant label without
        // evaluating a chain of `if-else` comparisons one by one.
        // -----------------------------------------------------------------
        System.out.println("--- [1] HTTP Status Code Router (switch on int) ---");
        int httpStatus = 404;
        String statusMeaning;

        switch (httpStatus) {
            case 200:
                statusMeaning = "OK - Request succeeded.";
                break; // Exits the switch block immediately
            case 201:
                statusMeaning = "Created - New resource provisioned.";
                break;
            case 400:
                statusMeaning = "Bad Request - Invalid client payload.";
                break;
            case 401:
                statusMeaning = "Unauthorized - Authentication required.";
                break;
            case 404:
                statusMeaning = "Not Found - Endpoint does not exist.";
                break;
            case 500:
                statusMeaning = "Internal Server Error - Unhandled backend crash.";
                break;
            default:
                statusMeaning = "Unknown HTTP Status Code.";
                break;
        }

        System.out.println("HTTP " + httpStatus + " -> " + statusMeaning);
        System.out.println();

        // -----------------------------------------------------------------
        // 2. SWITCHING ON `char` WITH `final` COMPILE-TIME CONSTANTS
        // -----------------------------------------------------------------
        System.out.println("--- [2] Subscription Tier Lookup (switch on char) ---");
        final char TIER_FREE = 'F';
        final char TIER_PRO = 'P';
        final char TIER_ENTERPRISE = 'E';

        char selectedPlan = 'P';

        switch (selectedPlan) {
            case TIER_FREE:
                System.out.println("Plan 'F': Free Tier (5 GB Storage, Community Support)");
                break;
            case TIER_PRO:
                System.out.println("Plan 'P': Pro Tier (500 GB Storage, 24/7 Priority Support)");
                break;
            case TIER_ENTERPRISE:
                System.out.println("Plan 'E': Enterprise Tier (Unlimited Storage, Dedicated Engineer)");
                break;
            default:
                System.out.println("Unrecognized subscription plan code: " + selectedPlan);
                break;
        }
        System.out.println();

        // -----------------------------------------------------------------
        // 3. DEMONSTRATING THE MISSING `break` BUG (Accidental Fall-Through)
        // WHY: `case` labels are just jump entry points, not isolated blocks!
        // Once entered, execution runs downward until it hits `break;` or `}`.
        // -----------------------------------------------------------------
        System.out.println("--- [3] Missing `break` Bug Demonstration ---");
        int option = 1;
        System.out.println("Testing buggy switch with option = 1 (missing break in case 1):");
        switch (option) {
            case 1:
                System.out.println("  -> Executed Case 1 (Forgot break! Falling through...)");
                // Missing break here!
            case 2:
                System.out.println("  -> Executed Case 2 (Accidentally ran because Case 1 had no break!)");
                break;
            default:
                System.out.println("  -> Executed Default");
                break;
        }
    }
}
