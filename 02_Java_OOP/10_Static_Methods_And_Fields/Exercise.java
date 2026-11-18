package _02_Java_OOP._10_Static_Methods_And_Fields;

/**
 * Lesson 10: Static Methods and Fields — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Auto-Incrementing Invoice ID Generator ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Stateless GeometryUtils Utility Class ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Shared Static Interest Rate & Static Block ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // Each `new Invoice(...)` reads and increments the class-level `static` counter
        // `nextInvoiceNumber`, guaranteeing every invoice gets a unique sequential ID (#1001, #1002, #1003).
        Invoice inv1 = new Invoice("Acme Corp", 1200.00);
        Invoice inv2 = new Invoice("Globex Inc", 850.50);
        Invoice inv3 = new Invoice("Initech LLC", 3400.00);

        System.out.println(inv1);
        System.out.println(inv2);
        System.out.println(inv3);
        System.out.println("Total Invoices Created (Static Count): "
                + Invoice.getTotalInvoicesCreated());
    }

    public static void solveProblem2() {
        // WHY WE USED THIS WAY:
        // Pure mathematical formulas only depend on their input parameters, not on object state.
        // Making them `public static` on `GeometryUtils` lets us call them directly via the
        // class name (just like `Math.sqrt()`), without wasting memory creating an object!
        System.out.println("Golden Ratio Constant      : " + GeometryUtils.GOLDEN_RATIO);
        System.out.printf("Circle Area (r=5.0)        : %.2f%n", GeometryUtils.circleArea(5.0));
        System.out.printf("Cylinder Volume (r=5, h=10): %.2f%n", GeometryUtils.cylinderVolume(5.0, 10.0));
        System.out.printf("Hypotenuse (a=3.0, b=4.0)  : %.2f%n", GeometryUtils.hypotenuse(3.0, 4.0));
    }

    public static void solveProblem3() {
        SavingsVault alice = new SavingsVault("Alice", 10_000.00);
        SavingsVault bob = new SavingsVault("Bob", 20_000.00);

        System.out.printf("Before Rate Hike -> Alice Yearly Interest: $%.2f | Bob Yearly Interest: $%.2f%n",
                alice.calculateYearlyInterest(), bob.calculateYearlyInterest());

        // WHY WE USED THIS WAY:
        // Because `annualInterestRate` is `static`, updating it ONCE on the `SavingsVault` class
        // immediately updates the interest rate seen by BOTH `alice` and `bob`!
        SavingsVault.updateGlobalInterestRate(0.055);

        System.out.printf("After 5.5%% Hike  -> Alice Yearly Interest: $%.2f | Bob Yearly Interest: $%.2f%n",
                alice.calculateYearlyInterest(), bob.calculateYearlyInterest());
    }
}

class Invoice {
    // Shared across all Invoice instances
    private static int nextInvoiceNumber = 1001;
    private static int totalInvoicesCreated = 0;

    // Unique to each Invoice instance
    private final int invoiceId;
    private String clientName;
    private double amount;

    public Invoice(String clientName, double amount) {
        this.invoiceId = nextInvoiceNumber++;
        totalInvoicesCreated++;
        this.clientName = clientName;
        this.amount = amount;
    }

    public static int getTotalInvoicesCreated() {
        return totalInvoicesCreated;
    }

    @Override
    public String toString() {
        return String.format("Invoice #%d | Client: %-13s | Amount: $%.2f",
                this.invoiceId, this.clientName, this.amount);
    }
}

class GeometryUtils {
    public static final double GOLDEN_RATIO = 1.61803;

    // Private constructor prevents `new GeometryUtils()`
    private GeometryUtils() {
    }

    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double cylinderVolume(double radius, double height) {
        return circleArea(radius) * height;
    }

    public static double hypotenuse(double a, double b) {
        return Math.sqrt((a * a) + (b * b));
    }
}

class SavingsVault {
    private static double annualInterestRate;

    // Static initializer block runs once when SavingsVault is first loaded into memory
    static {
        annualInterestRate = 0.04;
        System.out.println("[Static Block] Initialized global SavingsVault interest rate to 4.0%");
    }

    private String holderName;
    private double balance;

    public SavingsVault(String holderName, double balance) {
        this.holderName = holderName;
        this.balance = balance;
    }

    public static void updateGlobalInterestRate(double newRate) {
        if (newRate >= 0.0) {
            annualInterestRate = newRate;
        }
    }

    public double calculateYearlyInterest() {
        // Instance method CAN access both instance field (`this.balance`) and static field (`annualInterestRate`)
        return this.balance * annualInterestRate;
    }
}
