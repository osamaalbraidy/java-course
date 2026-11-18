package _01_Java_Basics._12_Switch_Statement_Part_2;

/**
 * Lesson 12: Switch Statement (Part 2)
 * Demonstrates:
 * 1. Intentional fall-through case grouping in traditional `switch`
 * 2. Switching on `String` (with `.toUpperCase()` normalization)
 * 3. Modern Java 17+ `switch` expressions (`case A, B ->` and `yield`)
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 12: SWITCH STATEMENT (PART 2)           ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. INTENTIONAL FALL-THROUGH (Traditional Case Grouping)
        // WHY: Stacking case labels lets multiple inputs share one code block.
        // -----------------------------------------------------------------
        System.out.println("--- [1] Intentional Fall-Through (Vowel/Consonant Check) ---");
        char letter = 'E';
        switch (Character.toUpperCase(letter)) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                System.out.println("Character '" + letter + "' is a VOWEL.");
                break;
            default:
                System.out.println("Character '" + letter + "' is a CONSONANT (or symbol).");
                break;
        }
        System.out.println();

        // -----------------------------------------------------------------
        // 2. SWITCHING ON `String` (Case-Insensitive via .toLowerCase())
        // -----------------------------------------------------------------
        System.out.println("--- [2] Switching on String (CLI Command Router) ---");
        String rawCommand = "  ReStart  ";
        // Trim whitespace and normalize case so "restart", "RESTART", and " ReStart " all match!
        String normalizedCommand = rawCommand.trim().toLowerCase();

        switch (normalizedCommand) {
            case "start":
            case "run":
                System.out.println("Command '" + normalizedCommand + "' -> Starting application server...");
                break;
            case "stop":
            case "shutdown":
                System.out.println("Command '" + normalizedCommand + "' -> Gracefully stopping services...");
                break;
            case "restart":
            case "reload":
                System.out.println("Command '" + normalizedCommand + "' -> Cycling worker processes...");
                break;
            default:
                System.out.println("Unknown command: " + normalizedCommand);
                break;
        }
        System.out.println();

        // -----------------------------------------------------------------
        // 3. MODERN JAVA 17+ SWITCH EXPRESSIONS (`->`, Comma Lists, `yield`)
        // WHY: Eliminates boilerplate `break;` statements, prevents accidental
        // fall-through bugs, and returns a value directly into a variable!
        // -----------------------------------------------------------------
        System.out.println("--- [3] Modern Java 17 Switch Expression (Days in Month) ---");
        int month = 2;
        int year = 2024;

        int daysInMonth = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11           -> 30;
            case 2 -> {
                // Multi-statement block inside a switch expression uses `yield` to return the value
                boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                System.out.println("  [Log] Evaluating February for year " + year + " (Leap: " + isLeap + ")");
                yield isLeap ? 29 : 28;
            }
            default -> -1; // Exhaustiveness required when switch returns a value
        };

        System.out.println("Month " + month + " of " + year + " has " + daysInMonth + " days.");
    }
}
