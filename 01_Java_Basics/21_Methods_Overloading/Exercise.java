package _01_Java_Basics._21_Methods_Overloading;

/**
 * Lesson 21: Method Overloading — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Overloaded `add` Calculator
        // =================================================================
        System.out.println("=== Problem 1: Overloaded `add` Calculator ===");

        // WHY WE USED THIS WAY:
        // All three calls use the exact same method name (`add`), and the Java compiler
        // selects the right implementation at compile time based on the number and types
        // of arguments passed!
        System.out.println("add(10, 20)       = " + add(10, 20));
        System.out.println("add(10, 20, 30)   = " + add(10, 20, 30));
        System.out.println("add(12.5, 7.25)   = " + add(12.5, 7.25));

        // =================================================================
        // Problem 2 (Medium): Overloaded Discount Pricing
        // =================================================================
        System.out.println("\n=== Problem 2: Overloaded Discount Pricing ===");

        // WHY WE USED THIS WAY:
        // - Passing `(200.0, 35.0)` matches `applyDiscount(double, double)` (flat dollar off).
        // - Passing `(200.0, 25)` matches `applyDiscount(double, int)` (percentage off).
        // - Passing `(200.0)` matches `applyDiscount(double)`, which delegates to `applyDiscount(price, 10)`!
        System.out.printf("Flat $35.00 Off ($200.00, 35.0) : $%.2f%n", applyDiscount(200.0, 35.0));
        System.out.printf("25%% Off         ($200.00, 25)   : $%.2f%n", applyDiscount(200.0, 25));
        System.out.printf("Default 10%% Off ($200.00)       : $%.2f%n", applyDiscount(200.0));

        // =================================================================
        // Problem 3 (Hard): Overloading by Parameter Order (`formatTag`)
        // =================================================================
        System.out.println("\n=== Problem 3: Overloading by Parameter Order ===");

        // WHY WE USED THIS WAY:
        // Even though both methods take one `String` and one `int`, their ordered parameter
        // type lists `(String, int)` vs. `(int, String)` are distinct signatures!
        System.out.println("formatTag(\"USER\", 101) -> " + formatTag("USER", 101));
        System.out.println("formatTag(101, \"USER\") -> " + formatTag(101, "USER"));
    }

    // Problem 1 Overloads:
    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    // Problem 2 Overloads:
    public static double applyDiscount(double price, double flatDollarOff) {
        return price - flatDollarOff;
    }

    public static double applyDiscount(double price, int percentOff) {
        return price * (1.0 - (percentOff / 100.0));
    }

    public static double applyDiscount(double price) {
        // Delegates to `applyDiscount(double, int)` with default 10% discount
        return applyDiscount(price, 10);
    }

    // Problem 3 Overloads:
    public static String formatTag(String label, int id) {
        return label + "#" + id;
    }

    public static String formatTag(int id, String label) {
        return "[" + id + ":" + label + "]";
    }
}
