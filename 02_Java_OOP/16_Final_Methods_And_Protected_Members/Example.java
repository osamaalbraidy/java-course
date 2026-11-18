package _02_Java_OOP._16_Final_Methods_And_Protected_Members;

/**
 * Lesson 16: Final Methods and Protected Members
 * Demonstrates:
 * 1. `protected` fields & methods accessible directly inside subclasses
 * 2. `public final` methods that lock critical security workflows against overriding
 * 3. `final class` (`ImmutableToken`) that cannot be extended by any subclass
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 16: FINAL METHODS & PROTECTED MEMBERS     ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. `protected` ACCESS + `final` METHOD LOCKING
        // WHY: `WireTransferProcessor` inherits `executePayment(amount)` from
        // `BasePaymentGateway`. Because `executePayment` is marked `final`,
        // no subclass can bypass the mandatory fraud and audit steps!
        // -----------------------------------------------------------------
        System.out.println("--- [1] Calling a `final` Method That Uses `protected` Hooks ---");
        WireTransferGateway wireGateway = new WireTransferGateway("SWIFT-US-99");
        wireGateway.executePayment(25_000.00);
        System.out.println();

        // -----------------------------------------------------------------
        // 2. `final` CLASS (Cannot Be Subclassed with `extends`)
        // WHY: Just like `java.lang.String`, marking `ImmutableSecurityToken`
        // as `final class` and all its fields as `private final` makes it 100% immutable!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Using an Immutable `final class` ---");
        ImmutableSecurityToken token = new ImmutableSecurityToken("JWT-884920-XYZ", 3600);
        System.out.println(token);
    }
}

class BasePaymentGateway {
    // `protected` field: directly accessible inside subclasses (`WireTransferGateway`)!
    protected String gatewayId;

    public BasePaymentGateway(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    /**
     * `final` METHOD: Subclasses CANNOT override this method!
     * This guarantees step 1 (Fraud Check) and step 3 (Audit Log) ALWAYS run!
     */
    public final void executePayment(double amount) {
        System.out.println("  [1. Mandatory Security] Running fraud check on Gateway " + this.gatewayId + "...");
        // Calls the `protected` hook method that subclasses ARE allowed to override:
        transmitFunds(amount);
        System.out.println("  [3. Mandatory Compliance] Recorded immutable audit log entry.");
    }

    /**
     * `protected` method: Hidden from unrelated external packages, but designed to be
     * overridden by subclasses!
     */
    protected void transmitFunds(double amount) {
        System.out.printf("  [2. Base Transmission] Transferred $%,.2f%n", amount);
    }
}

class WireTransferGateway extends BasePaymentGateway {

    public WireTransferGateway(String gatewayId) {
        super(gatewayId);
    }

    // Attempting to override `executePayment(double)` here would cause a COMPILE ERROR:
    // "executePayment(double) in WireTransferGateway cannot override executePayment(double)
    //  in BasePaymentGateway; overridden method is final"

    @Override
    protected void transmitFunds(double amount) {
        // Directly accesses `this.gatewayId` because `gatewayId` is `protected` in the parent!
        System.out.printf("  [2. SWIFT Wire Hook]    Wired $%,.2f via gateway %s.%n",
                amount, this.gatewayId);
    }
}

/**
 * `final class`: Cannot be extended by any subclass (`class HackToken extends ImmutableSecurityToken`
 * will fail to compile!).
 */
final class ImmutableSecurityToken {
    private final String tokenValue;
    private final int expiresInSeconds;

    public ImmutableSecurityToken(String tokenValue, int expiresInSeconds) {
        this.tokenValue = tokenValue;
        this.expiresInSeconds = expiresInSeconds;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public int getExpiresInSeconds() {
        return expiresInSeconds;
    }

    @Override
    public String toString() {
        return String.format("ImmutableToken [Value: %s | TTL: %ds]",
                this.tokenValue, this.expiresInSeconds);
    }
}
