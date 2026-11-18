package _01_Java_Basics._21_Methods_Overloading;

/**
 * Lesson 21: Method Overloading (Compile-Time Polymorphism)
 * Demonstrates:
 * 1. Overloading by parameter count (arity), parameter types, and parameter order
 * 2. Delegating overloaded methods to emulate default parameters
 * 3. Automatic compile-time type promotion (`int` -> `long` -> `double`)
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 21: METHOD OVERLOADING                  ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. OVERLOADING BY PARAMETER TYPES AND COUNT (Geometry Area API)
        // WHY: Callers use one intuitive verb (`calculateArea`) regardless of
        // whether they are measuring a square, rectangle, or circle!
        // -----------------------------------------------------------------
        System.out.println("--- [1] Overloaded `calculateArea` Methods ---");
        System.out.printf("Square    (side = 5)            : %.2f%n", calculateArea(5));
        System.out.printf("Rectangle (width = 6, height=4) : %.2f%n", calculateArea(6, 4));
        System.out.printf("Circle    (radius = 3.5)        : %.2f%n%n", calculateArea(3.5));

        // -----------------------------------------------------------------
        // 2. OVERLOADING TO EMULATE DEFAULT PARAMETERS (Delegation Pattern)
        // WHY: Java doesn't support `sendNotification(msg, retries = 3)`, so
        // the 1-arg overload simply calls the 2-arg overload with the default!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Emulating Default Parameters via Overloading ---");
        sendNotification("Database backup completed");        // Uses default priority "INFO" & 1 retry
        sendNotification("High memory usage (88%)", "WARN");  // Uses default 1 retry
        sendNotification("Disk full on Node-3!", "CRITICAL", 3);
        System.out.println();

        // -----------------------------------------------------------------
        // 3. AUTOMATIC TYPE PROMOTION IN OVERLOADED CALLS
        // Notice we only defined `inspectNumeric(long)` and `inspectNumeric(double)`.
        // Passing a `byte`, `short`, `char`, or `int` promotes to `long`!
        // -----------------------------------------------------------------
        System.out.println("--- [3] Automatic Type Promotion ---");
        byte b = 12;
        char c = 'A'; // ASCII 65
        int i = 1000;
        float f = 9.5f;

        inspectNumeric(b); // byte  -> widened to long
        inspectNumeric(c); // char  -> widened to long (65L)
        inspectNumeric(i); // int   -> widened to long
        inspectNumeric(f); // float -> widened to double
    }

    // Overload 1: 1 int parameter (Square)
    public static double calculateArea(int side) {
        return side * side;
    }

    // Overload 2: 2 int parameters (Rectangle)
    public static double calculateArea(int width, int height) {
        return width * height;
    }

    // Overload 3: 1 double parameter (Circle)
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // 1-parameter overload delegates to 3-parameter overload
    public static void sendNotification(String message) {
        sendNotification(message, "INFO", 1);
    }

    // 2-parameter overload delegates to 3-parameter overload
    public static void sendNotification(String message, String severity) {
        sendNotification(message, severity, 1);
    }

    // Primary 3-parameter implementation
    public static void sendNotification(String message, String severity, int maxRetries) {
        System.out.printf("  [%s] (Retries: %d) -> %s%n", severity, maxRetries, message);
    }

    // Type promotion targets:
    public static void inspectNumeric(long value) {
        System.out.println("  Matched inspectNumeric(long)   with value: " + value);
    }

    public static void inspectNumeric(double value) {
        System.out.println("  Matched inspectNumeric(double) with value: " + value);
    }
}
