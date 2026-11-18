package _01_Java_Basics._10_If_Statement_Part_2;

/**
 * Lesson 10: If Statement (Part 2)
 * Demonstrates:
 * 1. Multi-branch `else if` ladders (ordered from most specific to least specific)
 * 2. Logical operators (`&&`, `||`, `!`) and Short-Circuit Evaluation
 * 3. Nested `if` statements vs. Compound conditions
 * 4. The Ternary Operator (`? :`)
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     LESSON 10: IF STATEMENT (PART 2)             ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. MULTI-WAY BRANCHING WITH AN `else if` LADDER
        // WHY: Once a branch evaluates to `true`, Java executes that block and skips
        // all remaining `else if` / `else` blocks.
        // -----------------------------------------------------------------
        System.out.println("--- [1] Academic Grade Classifier (else-if Ladder) ---");
        int examScore = 86;
        char letterGrade;
        String feedback;

        if (examScore < 0 || examScore > 100) {
            letterGrade = '?';
            feedback = "Invalid score! Must be in range [0..100].";
        } else if (examScore >= 90) {
            letterGrade = 'A';
            feedback = "Outstanding mastery!";
        } else if (examScore >= 80) {
            // We don't need `examScore < 90` here because the `>= 90` check above was already false!
            letterGrade = 'B';
            feedback = "Strong performance!";
        } else if (examScore >= 70) {
            letterGrade = 'C';
            feedback = "Satisfactory competence.";
        } else if (examScore >= 60) {
            letterGrade = 'D';
            feedback = "Minimum passing grade.";
        } else {
            letterGrade = 'F';
            feedback = "Needs improvement; please schedule tutoring.";
        }

        System.out.println("Exam Score   : " + examScore);
        System.out.println("Letter Grade : " + letterGrade + " (" + feedback + ")");
        System.out.println();

        // -----------------------------------------------------------------
        // 2. LOGICAL OPERATORS (&&, ||, !) & SHORT-CIRCUIT GUARDING
        // -----------------------------------------------------------------
        System.out.println("--- [2] Logical Operators & Short-Circuit Evaluation ---");
        int applicantAge = 26;
        int creditScore = 740;
        boolean hasBankruptcy = false;

        // Must be 21+, credit score >= 700, AND NOT have a bankruptcy record
        if (applicantAge >= 21 && creditScore >= 700 && !hasBankruptcy) {
            System.out.println("Loan Status  : [APPROVED] Prime Interest Rate Unlocked.");
        } else {
            System.out.println("Loan Status  : [REVIEW] Manual underwriting required.");
        }

        // Short-Circuit Guard Example: Avoiding Division by Zero
        // WHY: Because `itemsCount > 0` is false, `&&` short-circuits and NEVER evaluates `(totalCost / itemsCount)`!
        int itemsCount = 0;
        int totalCost = 500;
        if (itemsCount > 0 && (totalCost / itemsCount) > 50) {
            System.out.println("High average item cost.");
        } else {
            System.out.println("Short-Circuit: Safely skipped `(totalCost / 0)` division!");
        }
        System.out.println();

        // -----------------------------------------------------------------
        // 3. NESTED `if` STATEMENTS (Specific Diagnostic Feedback)
        // -----------------------------------------------------------------
        System.out.println("--- [3] Nested `if` Server Deployment Check ---");
        boolean testsPassing = true;
        boolean securityScanClean = false;

        if (testsPassing) {
            System.out.println("Step 1: Unit & Integration Tests [PASSED]");
            if (securityScanClean) {
                System.out.println("Step 2: Security Scan [PASSED] -> Deploying to Production!");
            } else {
                System.out.println("Step 2: Security Scan [FAILED] -> Deployment blocked by vulnerability check.");
            }
        } else {
            System.out.println("Step 1: Unit Tests [FAILED] -> Fix failing tests before security scan.");
        }
        System.out.println();

        // -----------------------------------------------------------------
        // 4. TERNARY CONDITIONAL OPERATOR (? :)
        // -----------------------------------------------------------------
        System.out.println("--- [4] Ternary Operator (? :) ---");
        int serverLatencyMs = 45;
        String healthBadge = (serverLatencyMs < 100) ? "HEALTHY (Green)" : "DEGRADED (Amber)";
        System.out.println("Latency " + serverLatencyMs + "ms -> Status: " + healthBadge);
    }
}
