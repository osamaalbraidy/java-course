package _02_Java_OOP._11_Passing_Objects_To_Methods;

/**
 * Lesson 11: Passing Objects to Methods
 * Demonstrates:
 * 1. Mutating an object's internal state when passed to a method
 * 2. Why reassigning `param = new Object()` inside a method does NOT affect the caller
 * 3. Object-to-Object interaction (`alice.transferTo(bob, 200.00)`)
 * 4. Returning a brand-new Object from a method
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 11: PASSING OBJECTS TO METHODS          ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. MUTATING OBJECT STATE VIA SHARED HEAP REFERENCE
        // WHY: `wallet` and parameter `target` hold copies of the SAME Heap
        // address. Calling `target.addFunds(150)` mutates that single Heap object!
        // -----------------------------------------------------------------
        System.out.println("--- [1] Mutating Object State Inside a Method ---");
        DigitalWallet wallet = new DigitalWallet("Alice", 500.00);
        System.out.println("In main() BEFORE applyLoyaltyBonus : " + wallet);

        applyLoyaltyBonus(wallet, 75.00);

        System.out.println("In main() AFTER applyLoyaltyBonus  : " + wallet + " (State mutated!)");
        System.out.println();

        // -----------------------------------------------------------------
        // 2. REASSIGNING THE PARAMETER REFERENCE (`target = new ...`)
        // WHY: Pointing local parameter `target` at a `new DigitalWallet` only
        // changes where `target` points on the Stack; `wallet` in main() is untouched!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Reassigning Parameter Reference vs. Mutating State ---");
        attemptReferenceSwap(wallet);
        System.out.println("In main() AFTER attemptReferenceSwap: " + wallet + " (Still Alice's wallet!)");
        System.out.println();

        // -----------------------------------------------------------------
        // 3. OBJECT-TO-OBJECT INTERACTION (`alice.transferTo(bob, amount)`)
        // -----------------------------------------------------------------
        System.out.println("--- [3] Passing an Object to Another Object's Method ---");
        DigitalWallet bobWallet = new DigitalWallet("Bob", 200.00);
        wallet.transferTo(bobWallet, 175.00);

        System.out.println("After Transfer -> " + wallet);
        System.out.println("After Transfer -> " + bobWallet);
        System.out.println();

        // -----------------------------------------------------------------
        // 4. RETURNING A NEW OBJECT FROM A METHOD
        // -----------------------------------------------------------------
        System.out.println("--- [4] Returning a New Merged Object from a Method ---");
        DigitalWallet jointWallet = createMergedWallet(wallet, bobWallet);
        System.out.println("Newly Returned Joint Wallet -> " + jointWallet);
    }

    public static void applyLoyaltyBonus(DigitalWallet target, double bonus) {
        if (target != null && bonus > 0) {
            target.deposit(bonus);
        }
    }

    public static void attemptReferenceSwap(DigitalWallet target) {
        // Points local parameter `target` to a brand-new Heap object
        target = new DigitalWallet("Hacker", 999_999.00);
        target.deposit(1.00);
        System.out.println("Inside attemptReferenceSwap        : " + target);
    }

    public static DigitalWallet createMergedWallet(DigitalWallet w1, DigitalWallet w2) {
        String combinedOwner = w1.getOwner() + " & " + w2.getOwner();
        double combinedBalance = w1.getBalance() + w2.getBalance();
        return new DigitalWallet(combinedOwner, combinedBalance);
    }
}

class DigitalWallet {
    private String owner;
    private double balance;

    public DigitalWallet(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public boolean transferTo(DigitalWallet recipient, double amount) {
        if (recipient == null || amount <= 0 || amount > this.balance) {
            return false;
        }
        this.balance -= amount;      // Deduct from THIS wallet (`alice`)
        recipient.deposit(amount);   // Credit the passed-in `recipient` wallet (`bob`)
        System.out.printf("  [Transfer] %s sent $%.2f to %s.%n",
                this.owner, amount, recipient.owner);
        return true;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("Wallet [Owner: %-11s | Balance: $%,.2f]", this.owner, this.balance);
    }
}
