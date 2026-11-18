package _01_Java_Basics._18_Introduction_To_Methods;

/**
 * Lesson 18: Introduction to Methods — Exercise Solutions
 *
 * NOTE: Starting in Lesson 18, we now use custom `public static void` methods!
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Reusable Receipt Header & Footer ===");
        // WHY WE USED THIS WAY:
        // Decomposing the receipt into `printHeader()` and `printFooter()` follows the
        // DRY (Don't Repeat Yourself) principle—any receipt in the app can reuse these methods!
        printHeader();
        System.out.println("  Item: Cold Brew      $4.50");
        printFooter();

        System.out.println("\n=== Problem 2: Call Stack Trace Simulation ===");
        // WHY WE USED THIS WAY:
        // Calling `stepA()` pushes `stepA` onto the JVM Call Stack, which pushes `stepB`,
        // which pushes `stepC`. Because the Call Stack is LIFO (Last-In, First-Out),
        // `stepC` finishes first (line 3), then `stepB` resumes and finishes (line 4),
        // and finally `stepA` resumes and finishes (line 5)!
        stepA();

        System.out.println("\n=== Problem 3: Modular ASCII Rocket Builder ===");
        // WHY WE USED THIS WAY:
        // Instead of copy-pasting 10 `println` statements to draw a rocket, we define
        // `drawCone()` and `drawBox()` once and call them in sequence!
        drawCone();
        drawBox();
        drawBox();
        drawCone();
    }

    // -----------------------------------------------------------------
    // Problem 1 Helper Methods
    // -----------------------------------------------------------------
    public static void printHeader() {
        System.out.println("==============================");
        System.out.println("     JAVA COFFEE ROASTERS     ");
        System.out.println("==============================");
    }

    public static void printFooter() {
        System.out.println("------------------------------");
        System.out.println("  Thank you for your visit!   ");
        System.out.println("------------------------------");
    }

    // -----------------------------------------------------------------
    // Problem 2 Helper Methods (Demonstrating LIFO Call Stack)
    // -----------------------------------------------------------------
    public static void stepA() {
        System.out.println("1. Starting stepA");
        stepB();
        System.out.println("5. Finishing stepA");
    }

    public static void stepB() {
        System.out.println("2. Starting stepB");
        stepC();
        System.out.println("4. Finishing stepB");
    }

    public static void stepC() {
        System.out.println("3. Inside stepC (Deepest stack frame)");
    }

    // -----------------------------------------------------------------
    // Problem 3 Helper Methods (Modular ASCII Drawing)
    // -----------------------------------------------------------------
    public static void drawCone() {
        System.out.println("  /\\");
        System.out.println(" /  \\");
    }

    public static void drawBox() {
        System.out.println("+----+");
        System.out.println("|    |");
        System.out.println("+----+");
    }
}
