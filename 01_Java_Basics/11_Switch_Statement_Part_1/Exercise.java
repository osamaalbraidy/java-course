package _01_Java_Basics._11_Switch_Statement_Part_1;

/**
 * Lesson 11: Switch Statement (Part 1) — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Day of the Week Mapper
        // =================================================================
        System.out.println("=== Problem 1: Day of the Week Mapper ===");

        int dayNumber = 5;

        // WHY WE USED THIS WAY:
        // When matching a single `int` variable (`dayNumber`) against fixed constants (1..7),
        // a `switch` statement jumps directly to the matching `case` label.
        // Every `case` ends with `break;` so execution doesn't fall through to the next day!
        switch (dayNumber) {
            case 1:
                System.out.println("Day 1 : Monday");
                break;
            case 2:
                System.out.println("Day 2 : Tuesday");
                break;
            case 3:
                System.out.println("Day 3 : Wednesday");
                break;
            case 4:
                System.out.println("Day 4 : Thursday");
                break;
            case 5:
                System.out.println("Day 5 : Friday");
                break;
            case 6:
                System.out.println("Day 6 : Saturday");
                break;
            case 7:
                System.out.println("Day 7 : Sunday");
                break;
            default:
                System.out.println("Day " + dayNumber + " : Invalid day number");
                break;
        }

        // =================================================================
        // Problem 2 (Medium): Four-Function Calculator with `switch (operator)`
        // =================================================================
        System.out.println("\n=== Problem 2: Four-Function Calculator ===");

        double num1 = 15.0;
        char operator = '/';
        double num2 = 4.0;

        // WHY WE USED THIS WAY:
        // Switching on `char operator` dispatches each arithmetic symbol cleanly,
        // and nesting an `if (num2 == 0)` check inside `case '/':` guards against
        // division by zero before performing `num1 / num2`.
        switch (operator) {
            case '+':
                System.out.printf("%.1f %c %.1f = %.2f%n", num1, operator, num2, (num1 + num2));
                break;
            case '-':
                System.out.printf("%.1f %c %.1f = %.2f%n", num1, operator, num2, (num1 - num2));
                break;
            case '*':
                System.out.printf("%.1f %c %.1f = %.2f%n", num1, operator, num2, (num1 * num2));
                break;
            case '/':
                if (num2 == 0.0) {
                    System.out.println(num1 + " / " + num2 + " -> Error: Cannot divide by zero!");
                } else {
                    System.out.printf("%.1f %c %.1f = %.2f%n", num1, operator, num2, (num1 / num2));
                }
                break;
            default:
                System.out.println("Error: Unknown operator '" + operator + "'");
                break;
        }

        // =================================================================
        // Problem 3 (Hard): Fixing a Broken ATM Dispenser `switch`
        // =================================================================
        System.out.println("\n=== Problem 3: Fixing a Broken ATM Dispenser switch ===");

        int menuChoice = 1;

        // WHY WE USED THIS WAY:
        // In a traditional `switch`, `case` labels are only entry jump targets!
        // Without `break;` at the end of `case 1:`, choosing option 1 would also execute
        // `case 2:`, `case 3:`, and `default:`. Adding `break;` isolates each branch.
        switch (menuChoice) {
            case 1:
                System.out.println("Choice " + menuChoice + " -> [ATM] Displaying Current Account Balance...");
                break;
            case 2:
                System.out.println("Choice " + menuChoice + " -> [ATM] Opening Cash Deposit Slot...");
                break;
            case 3:
                System.out.println("Choice " + menuChoice + " -> [ATM] Dispensing Cash Withdrawal...");
                break;
            default:
                System.out.println("Choice " + menuChoice + " -> [ATM] Invalid Menu Selection.");
                break;
        }
    }
}
