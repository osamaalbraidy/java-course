package _01_Java_Basics._03_Your_First_Program_In_Java;

/**
 * Lesson 03: Your First Program In Java
 *
 * This is a Javadoc comment (`/** ... * /`). Professional Java developers use
 * Javadoc above classes and methods to explain the purpose and contract of the code.
 */
public class Example {

    /**
     * The JVM looks for this exact signature as the starting point of execution:
     * - public : Accessible by the JVM launcher from anywhere
     * - static : Callable on the Example class directly without creating an instance
     * - void   : Returns no value back to the caller
     * - main   : The exact entry-point identifier mandated by the Java Language Specification
     * - String[] args : Command-line arguments passed when running `java Example arg0 arg1`
     */
    public static void main(String[] args) {
        // Single-line comment: Statements inside main() execute sequentially from top to bottom.
        System.out.println("==================================================");
        System.out.println("   LESSON 03: YOUR FIRST PROGRAM IN JAVA          ");
        System.out.println("==================================================\n");

        // 1. Inspecting our Class Metadata at Runtime
        // WHY: Every class in Java is represented at runtime by a Class<?> object.
        System.out.println("--- [1] Class & Package Structure ---");
        System.out.println("Simple Class Name    : " + Example.class.getSimpleName());
        System.out.println("Package Name         : " + Example.class.getPackage().getName());
        System.out.println("Fully Qualified Name : " + Example.class.getName());
        System.out.println();

        /*
         * Multi-line block comment:
         * 2. Demonstrating how `String[] args` works.
         * If you run: java Example Alice ProdServer
         * then args.length is 2, args[0] is "Alice", and args[1] is "ProdServer".
         */
        System.out.println("--- [2] Inspecting Command-Line Arguments (String[] args) ---");
        System.out.println("Number of CLI arguments received: " + args.length);

        if (args.length == 0) {
            System.out.println("No CLI arguments were passed.");
            System.out.println("Tip: Try running with arguments, e.g., `java ... Example DevMode 8080`");
        } else {
            for (int i = 0; i < args.length; i++) {
                System.out.println("  args[" + i + "] = " + args[i]);
            }
        }
        System.out.println();

        // 3. Demonstrating top-to-bottom sequential execution
        System.out.println("--- [3] Sequential Execution Flow ---");
        System.out.println("Step 1: JVM loaded Example.class into memory.");
        System.out.println("Step 2: JVM invoked Example.main(String[] args).");
        System.out.println("Step 3: main() reached its closing brace '}'. Program terminating cleanly!");
    }
}
