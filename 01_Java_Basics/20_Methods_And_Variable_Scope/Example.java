package _01_Java_Basics._20_Methods_And_Variable_Scope;

/**
 * Lesson 20: Methods and Variable Scope
 * Demonstrates:
 * 1. Class-level (`static`) scope vs. Method-local scope
 * 2. Block & Loop scope (`if` and `for` blocks)
 * 3. Variable Shadowing (and resolving shadowed static fields via `ClassName.fieldName`)
 * 4. Independent stack frames across method calls
 */
public class Example {

    // CLASS-LEVEL (STATIC) SCOPE: Visible to every method inside Example
    private static String systemMode = "PRODUCTION_CLUSTER";
    private static int globalRequestCount = 0;

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 20: METHODS AND VARIABLE SCOPE          ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. METHOD-LOCAL SCOPE VS. INDEPENDENT METHOD STACK FRAMES
        // WHY: `localId` inside main() and `localId` inside processRequest()
        // live in completely separate stack frames and never collide!
        // -----------------------------------------------------------------
        System.out.println("--- [1] Method-Local Scope & Stack Isolation ---");
        int localId = 100;
        System.out.println("In main() before call     : localId = " + localId
                + " | globalRequestCount = " + globalRequestCount);

        processRequest(500);

        System.out.println("In main() after call      : localId = " + localId
                + " | globalRequestCount = " + globalRequestCount);
        System.out.println();

        // -----------------------------------------------------------------
        // 2. BLOCK & LOOP SCOPE (Variables Die at Closing Curly Brace `}`)
        // -----------------------------------------------------------------
        System.out.println("--- [2] Block Scope & Loop Scope ---");
        boolean isDebugEnabled = true;

        if (isDebugEnabled) {
            // `debugToken` is born here and dies at the closing `}` of this `if` block!
            String debugToken = "DBG-9941-X";
            System.out.println("Inside `if` block         : debugToken = " + debugToken);
        }
        // System.out.println(debugToken); // <-- COMPILE ERROR: debugToken is out of scope here!

        // Because `i` is scoped strictly inside each `for` loop, two sequential `for`
        // loops can both declare `int i` without conflicting!
        System.out.print("First `for` loop (`int i`): ");
        for (int i = 1; i <= 3; i++) {
            System.out.print(i + " ");
        }
        System.out.print("| Second `for` loop (`int i`): ");
        for (int i = 10; i <= 30; i += 10) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        // -----------------------------------------------------------------
        // 3. VARIABLE SHADOWING
        // WHY: When a local variable has the same name as a class-level field,
        // the nearer (local) scope shadows (hides) the class-level variable.
        // -----------------------------------------------------------------
        System.out.println("--- [3] Variable Shadowing Resolution ---");
        System.out.println("Before local declaration  : systemMode         = " + systemMode);

        // Declaring a local variable with the same name SHADOWS `Example.systemMode`
        String systemMode = "LOCAL_SANDBOX_OVERRIDE";

        System.out.println("Unqualified `systemMode`  : systemMode         = " + systemMode + " (Local wins!)");
        System.out.println("Qualified `Example.field` : Example.systemMode = " + Example.systemMode + " (Class field!)");
    }

    /**
     * Helper method with its own isolated local scope.
     */
    public static void processRequest(int localId) {
        // `localId` here is a parameter local to `processRequest` (completely separate from main's `localId`)
        globalRequestCount++; // Updates the shared class-level static variable
        System.out.println("Inside processRequest()   : localId = " + localId
                + " | globalRequestCount = " + globalRequestCount);
    }
}
