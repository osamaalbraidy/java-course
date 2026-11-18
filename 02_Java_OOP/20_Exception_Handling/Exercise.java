package _02_Java_OOP._20_Exception_Handling;

/**
 * Lesson 20: Exception Handling — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Resilient Array & String Parser ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Input Validation with IllegalArgumentException ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Custom Checked Exception (OutOfStockException) ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        String[] data = {"25", "abc", "0"};

        parseAndDivide(data, 0);
        parseAndDivide(data, 1);
        parseAndDivide(data, 2);
        parseAndDivide(data, 9);
    }

    public static void parseAndDivide(String[] items, int index) {
        // WHY WE USED THIS WAY:
        // Separate `catch` blocks let us give specific diagnostic feedback for each failure
        // mode (bad index vs. non-integer text vs. divide-by-zero), and `finally` guarantees
        // the audit log is printed whether the `try` block succeeded or threw an exception!
        System.out.print("Index " + index + " -> ");
        try {
            String raw = items[index];
            int num = Integer.parseInt(raw);
            int result = 100 / num;
            System.out.print("Result: " + result);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.print("Caught ArrayIndexOutOfBoundsException: Invalid index " + index);
        } catch (NumberFormatException ex) {
            System.out.print("Caught NumberFormatException: Cannot parse \"" + items[index] + "\"");
        } catch (ArithmeticException ex) {
            System.out.print("Caught ArithmeticException: Division by zero");
        } finally {
            System.out.println(" | [Finally: Operation logged]");
        }
    }

    public static void solveProblem2() {
        // WHY WE USED THIS WAY:
        // Throwing `IllegalArgumentException` when a method receives an out-of-range
        // parameter fails fast and communicates the exact contract violation to the caller.
        try {
            registerUserAge("Alice", 25);
            registerUserAge("Tommy", 12);
        } catch (IllegalArgumentException ex) {
            System.out.println("Registration blocked -> " + ex.getMessage());
        }
    }

    public static void registerUserAge(String username, int age) {
        if (age < 18 || age > 120) {
            throw new IllegalArgumentException(
                    "Age " + age + " is outside legal registration range [18..120]!");
        }
        System.out.println("Registered user: " + username + " (Age: " + age + ")");
    }

    public static void solveProblem3() {
        WarehouseInventory gpuStock = new WarehouseInventory("RTX-4090", 5);

        // WHY WE USED THIS WAY:
        // Because `OutOfStockException` extends `Exception` (a Checked Exception), the
        // Java compiler forces callers of `reserveItems` to wrap the call in `try-catch`!
        try {
            gpuStock.reserveItems(3); // Succeeds (2 left)
            gpuStock.reserveItems(5); // Throws OutOfStockException!
        } catch (OutOfStockException ex) {
            System.out.println("Order Failed -> OutOfStockException: " + ex.getMessage());
        }
    }
}

/**
 * Custom Checked Exception (`extends Exception`).
 */
class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class WarehouseInventory {
    private String itemName;
    private int availableStock;

    public WarehouseInventory(String itemName, int availableStock) {
        this.itemName = itemName;
        this.availableStock = availableStock;
    }

    public void reserveItems(int requested) throws OutOfStockException {
        if (requested > this.availableStock) {
            throw new OutOfStockException("Cannot reserve " + requested + " of "
                    + this.itemName + " (Only " + this.availableStock + " in stock)");
        }
        this.availableStock -= requested;
        System.out.println("Reserved " + requested + " units of " + this.itemName
                + " (Remaining stock: " + this.availableStock + ")");
    }
}
