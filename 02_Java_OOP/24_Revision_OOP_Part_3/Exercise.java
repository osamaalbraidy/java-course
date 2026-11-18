package _02_Java_OOP._24_Revision_OOP_Part_3;

/**
 * Lesson 24: Revision OOP (Part 3) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: OrderLifecycle Enum with Exception Guard ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Refundable & Taxable Interfaces ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: CurrencyCode Enum + Interface + Custom Exception ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // Combining an `enum` with `IllegalStateException` prevents invalid state transitions
        // (such as shipping an order that was already cancelled!).
        try {
            OrderLifecycle status = OrderLifecycle.CREATED;
            status = OrderLifecycle.PAID;
            status = shipOrder(status);
            System.out.println("Order #501 transitioned: CREATED -> PAID -> " + status);

            shipOrder(OrderLifecycle.CANCELLED);
        } catch (IllegalStateException ex) {
            System.out.println("Blocked illegal transition: " + ex.getMessage());
        }
    }

    public static OrderLifecycle shipOrder(OrderLifecycle current) {
        if (current == OrderLifecycle.CANCELLED) {
            throw new IllegalStateException("Cannot ship a CANCELLED order!");
        }
        return OrderLifecycle.SHIPPED;
    }

    public static void solveProblem2() {
        DigitalSubscription sub1 = new DigitalSubscription("Pro IDE License", 99.00, 5);
        DigitalSubscription sub2 = new DigitalSubscription("Cloud Add-on", 49.00, 30);

        System.out.printf("Subscription Tax (8%%) : $%.2f%n", sub1.calculateTax());

        try {
            sub1.processRefund();
            sub2.processRefund();
        } catch (RefundWindowExpiredException ex) {
            System.out.println("Refund Denied         : " + ex.getMessage());
        }
    }

    public static void solveProblem3() {
        InternationalGateway gateway = new StripeGateway();

        try {
            gateway.authorize(500.00, CurrencyCode.EUR);
            gateway.authorize(12_000.00, CurrencyCode.GBP);
        } catch (FraudRiskException ex) {
            System.out.println("[Fraud Alert]   " + ex.getMessage());
        }
    }
}

// -----------------------------------------------------------------
// Problem 1 Enum
// -----------------------------------------------------------------
enum OrderLifecycle {
    CREATED,
    PAID,
    SHIPPED,
    CANCELLED
}

// -----------------------------------------------------------------
// Problem 2 Interfaces, Exception & Class
// -----------------------------------------------------------------
class RefundWindowExpiredException extends Exception {
    public RefundWindowExpiredException(String message) {
        super(message);
    }
}

interface Taxable {
    double TAX_RATE = 0.08;

    double calculateTax();
}

interface Refundable {
    int MAX_REFUND_DAYS = 14;

    void processRefund() throws RefundWindowExpiredException;
}

class DigitalSubscription implements Taxable, Refundable {
    private String planName;
    private double price;
    private int daysSincePurchase;

    public DigitalSubscription(String planName, double price, int daysSincePurchase) {
        this.planName = planName;
        this.price = price;
        this.daysSincePurchase = daysSincePurchase;
    }

    @Override
    public double calculateTax() {
        return this.price * TAX_RATE;
    }

    @Override
    public void processRefund() throws RefundWindowExpiredException {
        if (this.daysSincePurchase > MAX_REFUND_DAYS) {
            throw new RefundWindowExpiredException("Refund window (" + MAX_REFUND_DAYS
                    + " days) expired! Purchased " + this.daysSincePurchase + " days ago.");
        }
        System.out.printf("Refund Approved       : Refunded $%.2f for %s (Purchased %d days ago)%n",
                this.price, this.planName, this.daysSincePurchase);
    }
}

// -----------------------------------------------------------------
// Problem 3 Enum, Interface, Custom Exception & Implementation
// -----------------------------------------------------------------
enum CurrencyCode {
    USD(1.00),
    EUR(1.08),
    GBP(1.27);

    private final double usdExchangeRate;

    CurrencyCode(double usdExchangeRate) {
        this.usdExchangeRate = usdExchangeRate;
    }

    public double toUsd(double amount) {
        return amount * this.usdExchangeRate;
    }
}

class FraudRiskException extends Exception {
    public FraudRiskException(String message) {
        super(message);
    }
}

interface InternationalGateway {
    double MAX_USD_LIMIT = 10_000.00;

    void authorize(double amount, CurrencyCode currency) throws FraudRiskException;
}

class StripeGateway implements InternationalGateway {
    @Override
    public void authorize(double amount, CurrencyCode currency) throws FraudRiskException {
        double usdEquivalent = currency.toUsd(amount);
        if (usdEquivalent > MAX_USD_LIMIT) {
            throw new FraudRiskException(String.format(
                    "Blocked %.2f %s ($%.2f USD exceeds $%.2f limit!)",
                    amount, currency.name(), usdEquivalent, MAX_USD_LIMIT));
        }
        System.out.printf("[StripeGateway] Approved %.2f %s ($%.2f USD equivalent)%n",
                amount, currency.name(), usdEquivalent);
    }
}
