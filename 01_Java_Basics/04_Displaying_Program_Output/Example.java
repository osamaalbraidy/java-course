package _01_Java_Basics._04_Displaying_Program_Output;

/**
 * Lesson 04: Displaying Program Output
 * Demonstrates:
 * 1. System.out.print vs. System.out.println
 * 2. Escape sequences (\n, \t, \", \\)
 * 3. String concatenation vs. arithmetic addition traps
 * 4. Formatted output with System.out.printf
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     LESSON 04: DISPLAYING PROGRAM OUTPUT         ");
        System.out.println("==================================================\n");

        // 1. print() vs. println()
        // WHY: print() keeps the cursor on the active line; println() appends a line break.
        System.out.println("--- [1] print() vs. println() ---");
        System.out.print("Loading modules: ");
        System.out.print("[Core] ");
        System.out.print("[Network] ");
        System.out.println("[Security] -> DONE!"); // Ends the line
        System.out.println();

        // 2. Escape Sequences (\n, \t, \", \\)
        // WHY: Certain characters (like double quotes or backslashes) have special meaning in Java
        // syntax and must be escaped with a leading backslash '\'.
        System.out.println("--- [2] Escape Sequences ---");
        System.out.println("Quote Escaping   : James Gosling created \"Java\" in 1995.");
        System.out.println("Path Escaping    : C:\\Program Files\\Java\\jdk-17.0.1\\bin");
        System.out.println("Tab Alignment    : ID\tName\tRole");
        System.out.println("                   101\tAlice\tArchitect");
        System.out.println("Multi-line (\\n)  : Line A\n                   Line B");
        System.out.println();

        // 3. The '+' Operator Trap: Concatenation vs. Addition
        // WHY: Java evaluates '+' left-to-right. Once one operand is a String, '+' becomes
        // String concatenation unless parentheses force arithmetic evaluation first.
        System.out.println("--- [3] Concatenation vs. Addition ---");
        System.out.println("Without parentheses : \"Total: \" + 10 + 25   => " + "Total: " + 10 + 25);
        System.out.println("With parentheses    : \"Total: \" + (10 + 25) => " + "Total: " + (10 + 25));
        System.out.println();

        // 4. Formatted Output with System.out.printf()
        // WHY: printf allows exact column widths, alignment, comma grouping, and decimal rounding.
        System.out.println("--- [4] Professional Invoice Table with printf() ---");
        System.out.printf("%-6s | %-18s | %6s | %12s%n", "ID", "ITEM DESCRIPTION", "QTY", "UNIT PRICE");
        System.out.println("-------+--------------------+--------+-------------");
        System.out.printf("%-6d | %-18s | %6d | $%,11.2f%n", 1001, "Mechanical Keybd", 2, 149.99);
        System.out.printf("%-6d | %-18s | %6d | $%,11.2f%n", 1002, "4K Monitor 27\"", 1, 1299.50);
        System.out.printf("%-6d | %-18s | %6d | $%,11.2f%n", 1003, "USB-C Cable", 5, 12.00);
        System.out.println("-------+--------------------+--------+-------------");
        System.out.printf("%-36s | $%,11.2f (Tax: 8%%)%n", "GRAND TOTAL", 1791.928);
    }
}
