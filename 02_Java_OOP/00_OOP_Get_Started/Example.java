package _02_Java_OOP._00_OOP_Get_Started;

/**
 * Lesson 00: OOP — Get Started
 * Demonstrates:
 * 1. The fragility of Procedural Programming (loose parallel variables/arrays)
 * 2. The clarity and safety of Object-Oriented Programming (bundling State + Behavior)
 * 3. A preview of how Encapsulation protects object state from corruption
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   MODULE 2 - LESSON 00: OOP GET STARTED          ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. THE PROCEDURAL APPROACH (Disconnected Data & Functions)
        // WHY IT SCALES POORLY: If we have 5 attributes per bank account, we
        // have to juggle 5 separate variables or parallel arrays!Nothing stops
        // accidental corruption like `procBalance = -99999.0`.
        // -----------------------------------------------------------------
        System.out.println("--- [1] Procedural Style (Loose Variables) ---");
        String procOwner = "Alice";
        double procBalance = 500.00;

        procBalance = proceduralDeposit(procBalance, 150.00);
        System.out.printf("Procedural Account -> Owner: %s | Balance: $%.2f%n%n", procOwner, procBalance);

        // -----------------------------------------------------------------
        // 2. THE OBJECT-ORIENTED APPROACH (State + Behavior Bundled Together)
        // WHY IT SCALES: Each `SmartBankAccount` object encapsulates its own
        // owner and balance, and enforces business rules inside its methods!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Object-Oriented Style (Encapsulated Objects) ---");
        SmartBankAccount aliceAccount = new SmartBankAccount("Alice", 500.00);
        SmartBankAccount bobAccount = new SmartBankAccount("Bob", 1200.00);

        aliceAccount.deposit(150.00);
        bobAccount.withdraw(300.00);
        bobAccount.withdraw(5000.00); // Safely blocked by internal OOP validation!

        aliceAccount.printSummary();
        bobAccount.printSummary();
    }

    // Procedural helper function operating on raw primitives
    public static double proceduralDeposit(double currentBalance, double amount) {
        return currentBalance + amount;
    }
}

/**
 * Supporting OOP Class: Bundles State (`owner`, `balance`) and Behavior (`deposit`, `withdraw`)
 * into a single self-protecting unit.
 */
class SmartBankAccount {
    // STATE (Encapsulated private fields — cannot be corrupted from outside)
    private String owner;
    private double balance;

    // Constructor: Initializes the object when created with `new`
    public SmartBankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    // BEHAVIOR (Methods that operate on this object's own internal state)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("  [OOP Deposit]  +%6.2f into %s's account.%n", amount, owner);
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.printf("  [OOP Blocked]  %s cannot withdraw $%.2f (Balance is only $%.2f)!%n",
                    owner, amount, balance);
        } else if (amount > 0) {
            balance -= amount;
            System.out.printf("  [OOP Withdraw] -%6.2f from %s's account.%n", amount, owner);
        }
    }

    public void printSummary() {
        System.out.printf("  [OOP Account]  Owner: %-8s | Balance: $%,.2f%n", owner, balance);
    }
}
