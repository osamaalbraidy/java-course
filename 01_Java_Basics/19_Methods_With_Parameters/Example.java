package _01_Java_Basics._19_Methods_With_Parameters;

/**
 * Lesson 19: Methods with Parameters
 * Demonstrates:
 * 1. Parameters vs. Arguments with multiple data types
 * 2. Value-returning methods (`double`, `boolean`, `String`)
 * 3. Proof that Java primitives are strictly Pass-by-Value (copies!)
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 19: METHODS WITH PARAMETERS             ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. PARAMETERS VS. ARGUMENTS & VALUE-RETURNING METHODS
        // -----------------------------------------------------------------
        System.out.println("--- [1] Calling Value-Returning Methods ---");
        // Here 250.00, 0.15, and 0.08 are ARGUMENTS passed into the method's PARAMETERS
        double netTotal = computeOrderTotal(250.00, 0.15, 0.08);
        System.out.printf("Order Total ($250, 15%% disc, 8%% tax) : $%.2f%n", netTotal);

        // Calling a boolean predicate method inside an `if` condition
        int candidateYear = 2024;
        if (isLeapYear(candidateYear)) {
            System.out.println("Year " + candidateYear + " is verified as a Leap Year.");
        }
        System.out.println();

        // -----------------------------------------------------------------
        // 2. COMPOSING METHODS (Passing One Method's Return Value into Another)
        // -----------------------------------------------------------------
        System.out.println("--- [2] Method Composition ---");
        double celsius = 25.0;
        double fahrenheit = celsiusToFahrenheit(celsius);
        String weatherBadge = formatTemperatureReport("Tokyo", celsius, fahrenheit);
        System.out.println(weatherBadge);
        System.out.println();

        // -----------------------------------------------------------------
        // 3. PROOF OF PASS-BY-VALUE IN JAVA
        // WHY: Passing `originalSalary` sends a COPY of 85000 into `attemptSalaryBoost`.
        // Reassigning the parameter inside the method NEVER changes `originalSalary` in main()!
        // -----------------------------------------------------------------
        System.out.println("--- [3] Pass-by-Value Demonstration ---");
        int originalSalary = 85_000;
        System.out.println("1. In main() BEFORE method call       : originalSalary = $" + originalSalary);

        attemptSalaryBoost(originalSalary);

        System.out.println("3. In main() AFTER method call        : originalSalary = $"
                + originalSalary + " (Unchanged!)");
    }

    /**
     * Value-returning method with 3 parameters (`basePrice`, `discountRate`, `taxRate`).
     */
    public static double computeOrderTotal(double basePrice, double discountRate, double taxRate) {
        double discounted = basePrice * (1.0 - discountRate);
        return discounted * (1.0 + taxRate);
    }

    /**
     * Boolean predicate method: returns true if `year` is a Gregorian leap year.
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Converts Celsius to Fahrenheit.
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 1.8) + 32.0;
    }

    /**
     * Formats a multi-parameter weather summary String.
     */
    public static String formatTemperatureReport(String city, double c, double f) {
        return String.format("[%s Weather] %.1f C / %.1f F", city, c, f);
    }

    /**
     * Demonstrates Pass-by-Value: `salaryCopy` is an independent local copy on the stack.
     */
    public static void attemptSalaryBoost(int salaryCopy) {
        salaryCopy = salaryCopy * 2; // Modifies ONLY the local stack copy!
        System.out.println("2. Inside attemptSalaryBoost(copy)    : salaryCopy     = $" + salaryCopy);
    }
}
