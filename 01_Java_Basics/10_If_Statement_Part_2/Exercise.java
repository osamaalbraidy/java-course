package _01_Java_Basics._10_If_Statement_Part_2;

/**
 * Lesson 10: If Statement (Part 2) — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Movie Ticket Pricing Tier (`else if` Ladder)
        // =================================================================
        System.out.println("=== Problem 1: Movie Ticket Pricing Tier ===");

        // WHY WE USED THIS WAY:
        // In an `else if` ladder, we MUST check invalid ages (`age < 0 || age > 120`) FIRST!
        // If we checked `if (age <= 12)` first, a negative age like `-5` would match `<= 12`
        // and wrongly be sold a Child Ticket!
        int age = 8;
        if (age < 0 || age > 120) {
            System.out.println("Age " + age + " -> Invalid age");
        } else if (age <= 12) {
            System.out.println("Age " + age + " -> Child Ticket: $8.00");
        } else if (age <= 64) {
            System.out.println("Age " + age + " -> Adult Ticket: $14.00");
        } else {
            System.out.println("Age " + age + " -> Senior Ticket: $10.00");
        }

        // Testing the remaining boundary cases (-5, 34, 70):
        int invalidAge = -5;
        if (invalidAge < 0 || invalidAge > 120) {
            System.out.println("Age " + invalidAge + " -> Invalid age");
        } else if (invalidAge <= 12) {
            System.out.println("Age " + invalidAge + " -> Child Ticket: $8.00");
        } else if (invalidAge <= 64) {
            System.out.println("Age " + invalidAge + " -> Adult Ticket: $14.00");
        } else {
            System.out.println("Age " + invalidAge + " -> Senior Ticket: $10.00");
        }

        // =================================================================
        // Problem 2 (Medium): Gregorian Leap Year Validator (`&&` and `||`)
        // =================================================================
        System.out.println("\n=== Problem 2: Gregorian Leap Year Validator ===");

        // WHY WE USED THIS WAY:
        // We combine `&&` (logical AND) and `||` (logical OR) with parentheses:
        // `(year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)`
        // This ensures century years like 1900 are excluded (`% 100 != 0` is false),
        // while 400-year multiples like 2000 are included (`% 400 == 0` is true).
        int year1 = 2024;
        if ((year1 % 4 == 0 && year1 % 100 != 0) || (year1 % 400 == 0)) {
            System.out.println("Year " + year1 + " : LEAP YEAR");
        } else {
            System.out.println("Year " + year1 + " : COMMON YEAR");
        }

        int year2 = 1900;
        if ((year2 % 4 == 0 && year2 % 100 != 0) || (year2 % 400 == 0)) {
            System.out.println("Year " + year2 + " : LEAP YEAR");
        } else {
            System.out.println("Year " + year2 + " : COMMON YEAR");
        }

        int year3 = 2000;
        if ((year3 % 4 == 0 && year3 % 100 != 0) || (year3 % 400 == 0)) {
            System.out.println("Year " + year3 + " : LEAP YEAR");
        } else {
            System.out.println("Year " + year3 + " : COMMON YEAR");
        }

        // =================================================================
        // Problem 3 (Hard): Progressive Income Tax Bracket Calculator
        // =================================================================
        System.out.println("\n=== Problem 3: Progressive Income Tax Calculator ===");

        double income = 120_000.00;
        boolean isMarried = false;
        int rate;

        // WHY WE USED THIS WAY:
        // Using an outer `if / else if / else` ladder for the income bracket and a nested
        // `if (isMarried)` inside each bracket cleanly separates the two decision dimensions
        // without repeating `income > 100000` multiple times.
        if (income > 100_000) {
            if (isMarried) {
                rate = 22;
            } else {
                rate = 28;
            }
        } else if (income >= 40_000) {
            if (isMarried) {
                rate = 12;
            } else {
                rate = 18;
            }
        } else {
            rate = 10;
        }

        // Dividing by `100.0` (a double) avoids integer division (`28 / 100 = 0`)!
        double taxAmount = income * (rate / 100.0);
        System.out.printf("Income: $%,9.2f | Married: %-5b | Rate: %d%% | Tax: $%,8.2f%n",
                income, isMarried, rate, taxAmount);
    }
}
