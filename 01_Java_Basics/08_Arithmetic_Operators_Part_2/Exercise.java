package _01_Java_Basics._08_Arithmetic_Operators_Part_2;

/**
 * Lesson 08: Arithmetic Operators (Part 2) — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Pre- vs. Post-Increment Trace
        // =================================================================
        System.out.println("=== Problem 1: Pre- vs. Post-Increment Trace ===");

        int x = 5;
        int y = 5;

        // WHY WE USED THIS WAY:
        // - `++x` (Pre-increment) increments `x` to 6 FIRST, then multiplies `6 * 2 = 12`.
        // - `y++` (Post-increment) uses `y`'s old value (5) FIRST (`5 * 2 = 10`), and
        //   then increments `y` to 6 afterward.
        int a = ++x * 2;
        int b = y++ * 2;

        System.out.println("Pre-increment  -> a: " + a + ", x: " + x);
        System.out.println("Post-increment -> b: " + b + ", y: " + y);

        // =================================================================
        // Problem 2 (Medium): Wallet Balance Tracker with Compound Assignments
        // =================================================================
        System.out.println("\n=== Problem 2: Wallet Balance Tracker ===");

        int balance = 200;

        // WHY WE USED THIS WAY:
        // Compound assignment operators (`+=`, `-=`, `*=`, `/=`, `%=`) update `balance`
        // in place cleanly without repeating `balance = balance ...` on every line.
        balance += 75; // 200 + 75 = 275
        System.out.println("After += 75 : " + balance);

        balance -= 35; // 275 - 35 = 240
        System.out.println("After -= 35 : " + balance);

        balance *= 2;  // 240 * 2  = 480
        System.out.println("After *= 2  : " + balance);

        balance /= 3;  // 480 / 3  = 160
        System.out.println("After /= 3  : " + balance);

        balance %= 50; // 160 % 50 = 10
        System.out.println("After %= 50 : " + balance);

        // =================================================================
        // Problem 3 (Hard): Fixing Precedence Bugs with Parentheses
        // =================================================================
        System.out.println("\n=== Problem 3: Fixing Precedence Bugs with Parentheses ===");

        double v1 = 12.0, v2 = 18.0, v3 = 30.0;
        double t1 = 2.0, t2 = 3.0;

        // WHY WE USED THIS WAY:
        // Division (`/`) has higher precedence than addition (`+`).
        // Without parentheses, `v3 / 3.0 / t1` is evaluated first (30 / 3 / 2 = 5.0),
        // and then added to `12.0 + 18.0 + 5.0 + 3.0 = 38.0`!
        // Wrapping `(v1 + v2 + v3)` and `(t1 + t2)` in parentheses forces the additions
        // to happen before the divisions: `(60.0 / 3.0) / 5.0 = 4.0`.
        double buggy = v1 + v2 + v3 / 3.0 / t1 + t2;
        double correct = ((v1 + v2 + v3) / 3.0) / (t1 + t2);

        System.out.println("Without Parentheses (Buggy)  : " + buggy);
        System.out.println("With Parentheses (Correct)   : " + correct);
    }
}
