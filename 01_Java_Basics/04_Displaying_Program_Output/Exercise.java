package _01_Java_Basics._04_Displaying_Program_Output;

/**
 * Lesson 04: Displaying Program Output — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Escape Sequence Directory Card
        // =================================================================
        System.out.println("=== Problem 1: Escape Sequence Directory Card ===");

        // WHY WE USED THIS WAY:
        // Using a single `println` statement with escape sequences:
        // - `\"` prints literal double quotes inside a String without ending the String early
        // - `\n` forces a line break to start the next line
        // - `\\` prints a literal backslash for Windows file paths
        // - `\t` inserts horizontal tab stops to space out "Java", "SQL", and "Git"
        System.out.println("Developer : \"Ada Lovelace\"\nWorkspace : C:\\Dev\\Java\\Projects\nSkills    : Java\tSQL\tGit");

        // =================================================================
        // Problem 2 (Medium): Progress Bar with print and println
        // =================================================================
        System.out.println("\n=== Problem 2: Progress Bar with print and println ===");

        // WHY WE USED THIS WAY:
        // `System.out.print()` outputs text WITHOUT a newline so the cursor stays on
        // the exact same line as each piece of the progress bar is appended.
        // The final `System.out.println()` finishes the line and moves the cursor down.
        System.out.print("Downloading SDK: [");
        System.out.print("####");
        System.out.print("####");
        System.out.print("..] ");
        System.out.println(80 + "% Complete");

        // =================================================================
        // Problem 3 (Hard): Formatted Cafe Receipt with printf
        // =================================================================
        System.out.println("\n=== Problem 3: Formatted Cafe Receipt with printf ===");

        // WHY WE USED THIS WAY:
        // `System.out.printf()` uses format specifiers to align columns cleanly:
        // - `%-15s` : Left-aligns (`-`) a String (`s`) padded to 15 characters wide
        // - `%3d`   : Right-aligns an integer (`d`) in a 3-character column
        // - `$%6.2f`: Formats a floating-point number (`f`) to 2 decimal places (`.2`) in 6 chars
        // - `%n`    : Outputs a platform-native newline at the end of each row
        System.out.printf("%-15s | %3s | %7s%n", "ITEM", "QTY", "PRICE");
        System.out.println("----------------+-----+--------");
        System.out.printf("%-15s | %3d | $%6.2f%n", "Espresso", 2, 3.50);
        System.out.printf("%-15s | %3d | $%6.2f%n", "Croissant", 1, 4.25);
        System.out.printf("%-15s | %3d | $%6.2f%n", "Matcha Latte", 3, 5.75);
    }
}
