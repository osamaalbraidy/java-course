package _02_Java_OOP._20_Exception_Handling;

/**
 * Lesson 20: Exception Handling
 * Demonstrates:
 * 1. `try - catch - finally` with multiple specific catch blocks
 * 2. Throwing (`throw`) a built-in `IllegalArgumentException` for invalid inputs
 * 3. Defining, declaring (`throws`), throwing (`throw`), and catching a Custom Checked Exception
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 20: EXCEPTION HANDLING                  ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. `try - catch - finally` WITH MULTIPLE CATCH BLOCKS
        // WHY: When an exception occurs on a line inside `try`, Java jumps
        // immediately to the matching `catch` block, then ALWAYS runs `finally`,
        // and continues executing the rest of `main()` without crashing!
        // -----------------------------------------------------------------
        System.out.println("--- [1] try-catch-finally Flow ---");
        String[] rawTokens = {"100", "0", "not_a_number"};

        for (String token : rawTokens) {
            System.out.println("Processing token: \"" + token + "\"");
            try {
                int divisor = Integer.parseInt(token); // May throw NumberFormatException
                int result = 500 / divisor;            // May throw ArithmeticException (/ by zero)
                System.out.println("  [Success] 500 / " + divisor + " = " + result);
            } catch (NumberFormatException ex) {
                System.out.println("  [Caught NumberFormatException] \"" + token + "\" is not a valid integer!");
            } catch (ArithmeticException ex) {
                System.out.println("  [Caught ArithmeticException] Cannot divide 500 by zero!");
            } finally {
                // `finally` ALWAYS executes on every pass (success or exception)!
                System.out.println("  [Finally Block] Token audit step completed.\n");
            }
        }

        // -----------------------------------------------------------------
        // 2. CUSTOM CHECKED EXCEPTION (`throw` AND `throws`)
        // WHY: Creating a custom `InsufficientBalanceException extends Exception`
        // forces callers at compile time to handle overdraft scenarios explicitly!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Custom Checked Exception (`throw` & `throws`) ---");
        EscrowAccount escrow = new EscrowAccount("ESC-900", 1000.00);

        try {
            escrow.releaseFunds(400.00);  // Succeeds -> $600 left
            escrow.releaseFunds(850.00);  // Throws InsufficientBalanceException!
            System.out.println("This line is skipped because 850.00 threw an exception!");
        } catch (InsufficientBalanceException ex) {
            System.out.println("  [Caught Custom Exception] " + ex.getMessage());
            System.out.printf("  [Recovery Info] Shortfall was: $%.2f%n", ex.getShortfallAmount());
        }
    }
}

/**
 * Custom Checked Exception: Extends `java.lang.Exception` (not RuntimeException),
 * so the compiler enforces `throws InsufficientBalanceException` and `try-catch`!
 */
class InsufficientBalanceException extends Exception {
    private final double shortfallAmount;

    public InsufficientBalanceException(String message, double shortfallAmount) {
        super(message); // Passes the error message up to `java.lang.Exception`
        this.shortfallAmount = shortfallAmount;
    }

    public double getShortfallAmount() {
        return shortfallAmount;
    }
}

class EscrowAccount {
    private String accountId;
    private double balance;

    public EscrowAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    /**
     * Note the difference:
     * - `throws` in the method signature warns callers this method can throw a Checked Exception.
     * - `throw new ...` inside the method body actually creates and throws the exception object!
     */
    public void releaseFunds(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Release amount must be positive: " + amount);
        }
        if (amount > this.balance) {
            double shortfall = amount - this.balance;
            throw new InsufficientBalanceException(
                    "Escrow " + this.accountId + " has $" + this.balance
                    + ", cannot release $" + amount + "!",
                    shortfall);
        }
        this.balance -= amount;
        System.out.printf("  [Escrow %s] Released $%.2f (Remaining: $%.2f)%n",
                this.accountId, amount, this.balance);
    }
}
