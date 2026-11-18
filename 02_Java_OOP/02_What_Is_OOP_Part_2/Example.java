package _02_Java_OOP._02_What_Is_OOP_Part_2;

/**
 * Lesson 02: What Is OOP? (Part 2) — Encapsulation & Access Modifiers
 * Demonstrates:
 * 1. Why `public` fields are dangerous (Unencapsulated `InsecureWallet`)
 * 2. How `private` fields + `public` methods protect class invariants (`EncryptedVault`)
 * 3. Using `private` helper methods to hide internal implementation details
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 02: ENCAPSULATION & ACCESS MODIFIERS    ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. THE DANGER OF PUBLIC FIELDS (Broken Invariants)
        // -----------------------------------------------------------------
        System.out.println("--- [1] Danger of Unencapsulated `public` Fields ---");
        InsecureWallet brokenWallet = new InsecureWallet();
        // Anyone can corrupt a public field directly with nonsense values!
        brokenWallet.balance = -999_999.99;
        System.out.printf("InsecureWallet public balance corrupted to: $%,.2f%n%n", brokenWallet.balance);

        // -----------------------------------------------------------------
        // 2. PROPER ENCAPSULATION (`private` Fields + `public` Gateway Methods)
        // WHY: `vault.cardNumber` and `vault.creditLimit` are `private`.
        // Uncommenting `vault.creditLimit = 1000000;` below will NOT compile!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Encapsulated PaymentMethod (`private` + `public`) ---");
        PaymentVault vault = new PaymentVault("4532015112834242", 2000.00);

        // vault.cardNumber = "0000"; // <-- COMPILE ERROR: cardNumber has private access!

        System.out.println("Public Masked Card Display : " + vault.getMaskedCardNumber());
        vault.authorizeCharge(450.00);
        vault.authorizeCharge(2500.00); // Rejected by internal invariant check!
        vault.authorizeCharge(-50.00);  // Rejected by internal invariant check!
        System.out.printf("Remaining Available Credit : $%,.2f%n", vault.getAvailableCredit());
    }
}

/**
 * Anti-Pattern: Public mutable fields expose internal state to corruption.
 */
class InsecureWallet {
    public double balance = 100.00;
}

/**
 * Best Practice: Strict Encapsulation
 * - All fields are `private`
 * - Internal helper (`maskNumber`) is `private`
 * - External contract (`authorizeCharge`, `getMaskedCardNumber`) is `public`
 */
class PaymentVault {
    private String cardNumber;
    private double availableCredit;

    public PaymentVault(String cardNumber, double initialCredit) {
        this.cardNumber = cardNumber;
        this.availableCredit = initialCredit;
    }

    public boolean authorizeCharge(double amount) {
        if (amount <= 0) {
            System.out.printf("  [REJECTED] Invalid charge amount ($%.2f). Must be positive.%n", amount);
            return false;
        }
        if (amount > availableCredit) {
            System.out.printf("  [DECLINED] Charge $%.2f exceeds available credit ($%.2f).%n",
                    amount, availableCredit);
            return false;
        }
        availableCredit -= amount;
        System.out.printf("  [APPROVED] Charged $%.2f to card %s.%n", amount, formatLastFour());
        return true;
    }

    public String getMaskedCardNumber() {
        return "****-****-****-" + formatLastFour();
    }

    public double getAvailableCredit() {
        return availableCredit;
    }

    // PRIVATE HELPER METHOD: Only callable by methods inside PaymentVault!
    private String formatLastFour() {
        if (cardNumber == null || cardNumber.length() < 4) {
            return "XXXX";
        }
        return cardNumber.substring(cardNumber.length() - 4);
    }
}
