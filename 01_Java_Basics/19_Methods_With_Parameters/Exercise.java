package _01_Java_Basics._19_Methods_With_Parameters;

/**
 * Lesson 19: Methods with Parameters — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Rectangle Area & Perimeter Methods
        // =================================================================
        System.out.println("=== Problem 1: Rectangle Area & Perimeter Methods ===");

        double width = 8.5;
        double height = 4.0;

        // WHY WE USED THIS WAY:
        // Passing `width` and `height` as arguments into value-returning methods (`double`)
        // lets us capture the computed results in `area` and `perimeter` variables for formatting.
        double area = calculateArea(width, height);
        double perimeter = calculatePerimeter(width, height);
        System.out.printf("Rectangle (%.1f x %.1f) -> Area: %.2f | Perimeter: %.2f%n",
                width, height, area, perimeter);

        // =================================================================
        // Problem 2 (Medium): Boolean Predicate `isValidTriangle`
        // =================================================================
        System.out.println("\n=== Problem 2: Boolean Predicate isValidTriangle ===");

        // WHY WE USED THIS WAY:
        // A method that returns `boolean` (a predicate method) encapsulates a complex
        // condition (`(a + b > c) && (a + c > b) && (b + c > a)`) behind a self-documenting name!
        System.out.println("Sides (3, 4, 5)  Valid Triangle? " + isValidTriangle(3, 4, 5));
        System.out.println("Sides (2, 3, 10) Valid Triangle? " + isValidTriangle(2, 3, 10));

        // =================================================================
        // Problem 3 (Hard): Pass-by-Value vs. Returning the Updated Value
        // =================================================================
        System.out.println("\n=== Problem 3: Pass-by-Value vs. Return Assignment ===");

        int playerPoints = 100;
        System.out.println("Initial Player Points          : " + playerPoints);

        // WHY WE USED THIS WAY:
        // 1. `addBonusBroken(playerPoints, 50)` receives a COPY of `100` on the stack;
        //    modifying that local copy inside a `void` method leaves `playerPoints` in `main` at `100`!
        // 2. To update a primitive variable in the caller, the method must `return` the new `int`
        //    and the caller must reassign `playerPoints = addBonusFixed(playerPoints, 50);`.
        addBonusBroken(playerPoints, 50);
        System.out.println("After addBonusBroken(100, 50)  : " + playerPoints
                + " (Unchanged due to Pass-by-Value)");

        playerPoints = addBonusFixed(playerPoints, 50);
        System.out.println("After addBonusFixed(100, 50)   : " + playerPoints
                + " (Updated via Return Value)");
    }

    public static double calculateArea(double width, double height) {
        return width * height;
    }

    public static double calculatePerimeter(double width, double height) {
        return 2.0 * (width + height);
    }

    public static boolean isValidTriangle(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0
                && (a + b > c)
                && (a + c > b)
                && (b + c > a);
    }

    public static void addBonusBroken(int points, int bonus) {
        points += bonus; // Modifies ONLY the local parameter copy!
    }

    public static int addBonusFixed(int points, int bonus) {
        return points + bonus; // Sends the computed sum back to the caller!
    }
}
