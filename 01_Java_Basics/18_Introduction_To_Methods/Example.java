package _01_Java_Basics._18_Introduction_To_Methods;

/**
 * Lesson 18: Introduction to Methods
 * Demonstrates:
 * 1. Declaring and invoking reusable `public static void` methods
 * 2. Visualizing the JVM LIFO Call Stack when methods call other methods
 * 3. Using an early `return;` statement inside a `void` method
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 18: INTRODUCTION TO METHODS             ");
        System.out.println("==================================================\n");

        // 1. Invoking a reusable void method multiple times (DRY principle)
        System.out.println("--- [1] Reusable Void Methods (DRY Principle) ---");
        printSectionDivider();
        System.out.println("  System Health Report: ALL SERVICES ONLINE");
        printSectionDivider();
        System.out.println();

        // 2. Visualizing the JVM LIFO Call Stack: main() -> bootServer() -> connectDatabase()
        System.out.println("--- [2] JVM Call Stack Execution Flow (LIFO) ---");
        System.out.println("[Stack Depth 1] Inside main() -> Calling bootServer()...");
        bootServer();
        System.out.println("[Stack Depth 1] Back inside main() after bootServer() returned!\n");

        // 3. Using `return;` in a void method to exit early
        System.out.println("--- [3] Early Exit from a Void Method (`return;`) ---");
        runMaintenanceTask();
    }

    /**
     * Reusable void helper method: prints a formatted horizontal divider.
     */
    public static void printSectionDivider() {
        System.out.println("+------------------------------------------------+");
    }

    /**
     * Demonstrates nested method calls on the JVM Call Stack.
     */
    public static void bootServer() {
        System.out.println("  [Stack Depth 2] Entered bootServer() -> Calling connectDatabase()...");
        connectDatabase();
        System.out.println("  [Stack Depth 2] Resumed bootServer() -> Server listening on port 8080.");
    }

    /**
     * Deepest method in our call chain; pops off the stack first!
     */
    public static void connectDatabase() {
        System.out.println("    [Stack Depth 3] Entered connectDatabase() -> Pool initialized.");
        System.out.println("    [Stack Depth 3] Exiting connectDatabase() (Popping frame)...");
    }

    /**
     * Demonstrates how `return;` (with no value) exits a `void` method immediately.
     */
    public static void runMaintenanceTask() {
        boolean isMaintenanceWindowOpen = false;

        if (!isMaintenanceWindowOpen) {
            System.out.println("  [Guard Clause] Maintenance window is CLOSED. Exiting method early via `return;`.");
            return; // Immediately exits runMaintenanceTask() and pops its stack frame!
        }

        // This line will not run when isMaintenanceWindowOpen is false
        System.out.println("  Running heavy disk defragmentation...");
    }
}
