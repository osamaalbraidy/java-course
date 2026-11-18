package _01_Java_Basics._08_Arithmetic_Operators_Part_2;

/**
 * Lesson 08: Arithmetic Operators (Part 2)
 * Demonstrates:
 * 1. Prefix (++x) vs. Postfix (x++) increment and decrement
 * 2. Compound assignment operators (+=, -=, *=, /=, %=) and implicit casting
 * 3. Operator precedence and associativity rules
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 08: ARITHMETIC OPERATORS (PART 2)       ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. PREFIX (++x) VS. POSTFIX (x++) INCREMENT
        // -----------------------------------------------------------------
        System.out.println("--- [1] Pre-Increment (++x) vs. Post-Increment (x++) ---");

        int a = 10;
        int preResult = ++a; // Step 1: a becomes 11. Step 2: preResult gets 11.
        System.out.println("After `int preResult = ++a;` (started at 10)  -> preResult = "
                + preResult + ", a = " + a);

        int b = 10;
        int postResult = b++; // Step 1: postResult gets 10. Step 2: b becomes 11.
        System.out.println("After `int postResult = b++;` (started at 10) -> postResult = "
                + postResult + ", b = " + b);
        System.out.println();

        // -----------------------------------------------------------------
        // 2. COMPOUND ASSIGNMENT OPERATORS (+=, -=, *=, /=, %=)
        // -----------------------------------------------------------------
        System.out.println("--- [2] Compound Assignment Operators ---");
        int score = 100;
        System.out.println("Initial score          : " + score);

        score += 25; // 100 + 25 = 125
        System.out.println("After score += 25      : " + score);

        score -= 15; // 125 - 15 = 110
        System.out.println("After score -= 15      : " + score);

        score *= 2;  // 110 * 2  = 220
        System.out.println("After score *= 2       : " + score);

        score /= 4;  // 220 / 4  = 55
        System.out.println("After score /= 4       : " + score);

        score %= 10; // 55 % 10  = 5
        System.out.println("After score %= 10      : " + score);

        // Compound assignment with a right-hand expression:
        // WHY: `x *= 2 + 3` is evaluated as `x = x * (2 + 3)`, NOT `(x * 2) + 3`!
        int multiplierTest = 10;
        multiplierTest *= 2 + 3;
        System.out.println("10 *= (2 + 3) evaluates: " + multiplierTest + " (RHS evaluated first!)");

        // Implicit narrow cast inside compound assignment on byte/short:
        byte smallCounter = 100;
        smallCounter += 20; // Compiles cleanly as: smallCounter = (byte)(smallCounter + 20)
        System.out.println("byte smallCounter += 20: " + smallCounter);
        System.out.println();

        // -----------------------------------------------------------------
        // 3. OPERATOR PRECEDENCE & ASSOCIATIVITY
        // -----------------------------------------------------------------
        System.out.println("--- [3] Operator Precedence ---");
        // Multiplication (*), Division (/), and Modulo (%) happen BEFORE Addition (+) and Subtraction (-)
        // Equal-precedence operators (*, /, %) evaluate Left-to-Right.
        int expr1 = 10 + 20 * 3;          // 10 + 60 = 70
        int expr2 = (10 + 20) * 3;        // 30 * 3  = 90
        int expr3 = 100 / 5 * 2 + 14 % 4; // ((100 / 5) * 2) + (14 % 4) = (20 * 2) + 2 = 42

        System.out.println("10 + 20 * 3            = " + expr1);
        System.out.println("(10 + 20) * 3          = " + expr2);
        System.out.println("100 / 5 * 2 + 14 % 4   = " + expr3);
    }
}
