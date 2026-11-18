package _01_Java_Basics._03_Your_First_Program_In_Java;

/**
 * Lesson 03: Your First Program In Java — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Signature Anatomy Explainer
        // =================================================================
        System.out.println("=== Problem 1: Signature Anatomy Explainer ===");

        // WHY WE USED THIS WAY:
        // Each keyword in `public static void main(String[] args)` fulfills a specific
        // requirement of the JVM launcher when starting a Java program.
        System.out.println("public     : Visible to the JVM from anywhere");
        System.out.println("static     : Belongs to the class itself; no object needed");
        System.out.println("void       : Returns nothing when execution finishes");
        System.out.println("main       : Entry-point method name searched by the JVM");
        System.out.println("String[]   : Array of command-line text arguments");

        // =================================================================
        // Problem 2 (Medium): Fixing Broken Syntax
        // =================================================================
        System.out.println("\n=== Problem 2: Fixing Broken Syntax ===");

        // WHY WE USED THIS WAY:
        // 1. Fixed `system` -> `System` (Java class names are case-sensitive) and added the missing `;`.
        // 2. Added double quotes `"..."` around the text literal so Java treats it as a String, not variables.
        // 3. Fixed `.Out.Println` -> `.out.println` (fields and methods use lowerCamelCase).
        System.out.println("Line 1: Case sensitivity matters!");
        System.out.println("Line 2: Quotes matter!");
        System.out.println("Line 3: Method casing matters!");

        // =================================================================
        // Problem 3 (Hard): Command-Line Argument Echo Simulator
        // =================================================================
        System.out.println("\n=== Problem 3: Command-Line Argument Echo Simulator ===");

        // WHY WE USED THIS WAY:
        // Before reading `args[0]`, we MUST check if `args.length == 0`.
        // If no CLI arguments were passed, `args` is an empty array of length 0, and
        // accessing `args[0]` without checking would crash with `ArrayIndexOutOfBoundsException`.
        if (args.length == 0) {
            System.out.println("Arguments count: 0 (Default Mode)");
        } else {
            System.out.println("Arguments count: " + args.length + " | First arg: " + args[0]);
        }

        // Simulating a second run where 2 command-line arguments were passed:
        String[] simulatedArgs = {"--env=prod", "--port=9090"};
        if (simulatedArgs.length == 0) {
            System.out.println("Arguments count: 0 (Default Mode)");
        } else {
            System.out.println("Arguments count: " + simulatedArgs.length
                    + " | First arg: " + simulatedArgs[0]);
        }
    }
}
