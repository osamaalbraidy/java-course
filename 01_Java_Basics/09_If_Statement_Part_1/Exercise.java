package _01_Java_Basics._09_If_Statement_Part_1;

/**
 * Lesson 09: If Statement (Part 1) — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Even or Odd Number Classifier
        // =================================================================
        System.out.println("=== Problem 1: Even or Odd Number Classifier ===");

        // WHY WE USED THIS WAY:
        // Any integer divisible by 2 leaves a remainder of 0 (`number % 2 == 0`).
        // An `if-else` statement guarantees that exactly one of the two branches runs.
        int number1 = 42;
        if (number1 % 2 == 0) {
            System.out.println("Number " + number1 + " is EVEN.");
        } else {
            System.out.println("Number " + number1 + " is ODD.");
        }

        int number2 = 77;
        if (number2 % 2 == 0) {
            System.out.println("Number " + number2 + " is EVEN.");
        } else {
            System.out.println("Number " + number2 + " is ODD.");
        }

        // =================================================================
        // Problem 2 (Medium): E-Commerce Free Shipping Threshold
        // =================================================================
        System.out.println("\n=== Problem 2: E-Commerce Free Shipping Threshold ===");

        // WHY WE USED THIS WAY:
        // The rule says free shipping applies when `cartSubtotal` is "at least $50.00",
        // so we use `>= 50.00` (greater than or equal to) rather than `> 50.00` to make
        // sure an order of exactly $50.00 gets free shipping!
        double cartSubtotal1 = 35.00;
        double shippingFee1;
        if (cartSubtotal1 >= 50.00) {
            shippingFee1 = 0.00;
        } else {
            shippingFee1 = 9.99;
        }
        double finalTotal1 = cartSubtotal1 + shippingFee1;
        System.out.printf("Subtotal: $%.2f | Shipping: $%.2f | Total: $%.2f%n",
                cartSubtotal1, shippingFee1, finalTotal1);

        double cartSubtotal2 = 50.00;
        double shippingFee2;
        if (cartSubtotal2 >= 50.00) {
            shippingFee2 = 0.00;
        } else {
            shippingFee2 = 9.99;
        }
        double finalTotal2 = cartSubtotal2 + shippingFee2;
        System.out.printf("Subtotal: $%.2f | Shipping: $%.2f | Total: $%.2f%n",
                cartSubtotal2, shippingFee2, finalTotal2);

        // =================================================================
        // Problem 3 (Hard): Case-Insensitive Coupon Code Validator
        // =================================================================
        System.out.println("\n=== Problem 3: Case-Insensitive Coupon Code Validator ===");

        // WHY WE USED THIS WAY:
        // We never compare Strings with `==` because `==` checks memory addresses.
        // Using `.equalsIgnoreCase("SAVE20")` compares the actual characters while
        // accepting any capitalization ("save20", "Save20", "SAVE20").
        String enteredCoupon1 = "save20";
        double orderAmount1 = 100.0;
        if (enteredCoupon1.equalsIgnoreCase("SAVE20")) {
            double discountedPrice = orderAmount1 * 0.80;
            System.out.println("Coupon '" + enteredCoupon1 + "' VALID -> Final Price: $" + discountedPrice);
        } else {
            System.out.println("Coupon '" + enteredCoupon1 + "' INVALID -> Final Price: $" + orderAmount1);
        }

        String enteredCoupon2 = "WELCOME10";
        double orderAmount2 = 100.0;
        if (enteredCoupon2.equalsIgnoreCase("SAVE20")) {
            double discountedPrice = orderAmount2 * 0.80;
            System.out.println("Coupon '" + enteredCoupon2 + "' VALID -> Final Price: $" + discountedPrice);
        } else {
            System.out.println("Coupon '" + enteredCoupon2 + "' INVALID -> Final Price: $" + orderAmount2);
        }
    }
}
