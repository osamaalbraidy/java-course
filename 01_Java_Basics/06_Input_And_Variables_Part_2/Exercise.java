package _01_Java_Basics._06_Input_And_Variables_Part_2;

import java.util.Scanner;

/**
 * Lesson 06: Input and Variables (Part 2) — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Explicit Narrowing & Fractional Cents
        // =================================================================
        System.out.println("=== Problem 1: Explicit Narrowing & Fractional Cents ===");

        double totalAmount = 47.89;

        // WHY WE USED THIS WAY:
        // 1. Explicit narrowing `(int) totalAmount` truncates (chops off) the `.89` decimal
        //    part, giving us the exact whole dollars (`47`).
        // 2. Subtracting `wholeDollars` leaves the fractional dollars (`0.89`), which we
        //    multiply by 100 and wrap in `Math.round(...)` before casting to `(int)`.
        int wholeDollars = (int) totalAmount;
        int cents = (int) Math.round((totalAmount - wholeDollars) * 100);

        System.out.println("Original Amount : $" + totalAmount);
        System.out.println("Whole Dollars   : " + wholeDollars);
        System.out.println("Remaining Cents : " + cents);

        // =================================================================
        // Problem 2 (Medium): Circle Geometry with final Constants
        // =================================================================
        System.out.println("\n=== Problem 2: Circle Geometry with final Constants ===");

        // WHY WE USED THIS WAY:
        // 1. `final` locks `PI` so it can never be accidentally modified later in the method.
        // 2. When multiplying `double PI` by `int radius`, Java implicitly widens `radius`
        //    to `double` (`7.0`) so the area calculation preserves full decimal precision.
        // 3. `(int) area` demonstrates narrowing truncation (153.94 -> 153).
        final double PI = 3.14159;
        int radius = 7;

        double area = PI * radius * radius;
        int truncatedArea = (int) area;
        double circumference = 2 * PI * radius;

        System.out.println("Radius              : " + radius);
        System.out.printf("Exact Area          : %.2f%n", area);
        System.out.println("Truncated Area (int): " + truncatedArea);
        System.out.printf("Circumference       : %.2f%n", circumference);

        // =================================================================
        // Problem 3 (Hard): Fixing the Scanner Buffer Bug
        // =================================================================
        System.out.println("\n=== Problem 3: Fixing the Scanner Buffer Bug ===");

        Scanner input = new Scanner(System.in);

        // WHY WE USED THIS WAY:
        // `input.nextInt()` and `input.nextDouble()` read only the numbers and leave the
        // Enter key's newline `\n` sitting in the keyboard buffer!
        // Calling an extra `input.nextLine()` right after `input.nextDouble()` consumes that
        // leftover `\n` so the next `input.nextLine()` waits for and reads the full street address!
        System.out.print("Enter Order ID: ");
        int orderId = input.nextInt();

        System.out.print("Enter Shipping Cost: ");
        double shippingCost = input.nextDouble();

        input.nextLine(); // Flush the leftover '\n' after nextDouble()!

        System.out.print("Enter Delivery Address: ");
        String deliveryAddress = input.nextLine();

        System.out.println("Order ID         : " + orderId);
        System.out.println("Shipping Cost    : $" + shippingCost);
        System.out.println("Delivery Address : " + deliveryAddress);

        input.close();
    }
}
