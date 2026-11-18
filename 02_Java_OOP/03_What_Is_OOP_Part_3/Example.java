package _02_Java_OOP._03_What_Is_OOP_Part_3;

/**
 * Lesson 03: What Is OOP? (Part 3) — Abstraction, High Cohesion & Loose Coupling
 * Demonstrates:
 * 1. Abstraction: Hiding a complex 4-step coffee brewing pipeline behind 1 public method
 * 2. High Cohesion & Loose Coupling: Separating `Order`, `TaxService`, and `ReceiptPrinter`
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 03: ABSTRACTION, COHESION & COUPLING      ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. ABSTRACTION IN ACTION (`EspressoMachine`)
        // WHY: `main()` does NOT need to know about water temperature, burr
        // grinders, or 9-bar pressure pumps. It calls ONE high-level method!
        // -----------------------------------------------------------------
        System.out.println("--- [1] Abstraction: High-Level Public API vs. Private Internals ---");
        EspressoMachine machine = new EspressoMachine();
        machine.brewDoubleEspresso(); // 1 simple call triggers 4 complex private steps!
        System.out.println();

        // -----------------------------------------------------------------
        // 2. HIGH COHESION & LOOSE COUPLING IN DOMAIN MODELING
        // Instead of one monolithic "God Class", each class has ONE focused job:
        // - `Order`: Holds item data
        // - `TaxCalculator`: Computes regional tax rules
        // - `ReceiptFormatter`: Renders clean console output
        // -----------------------------------------------------------------
        System.out.println("--- [2] High Cohesion Domain Modeling ---");
        Order customerOrder = new Order("ORD-2026-88", "Enterprise Java Course", 199.00);
        TaxCalculator taxCalculator = new TaxCalculator(0.085); // 8.5% tax rate
        ReceiptFormatter formatter = new ReceiptFormatter();

        double tax = taxCalculator.computeTax(customerOrder.getSubtotal());
        formatter.printReceipt(customerOrder, tax);
    }
}

/**
 * Demonstrates ABSTRACTION:
 * Public surface area: 1 simple method (`brewDoubleEspresso()`).
 * Private hidden mechanics: 4 internal hardware control methods.
 */
class EspressoMachine {

    public void brewDoubleEspresso() {
        System.out.println("User pressed [Brew Double Espresso] button:");
        grindCoffeeBeans(18);
        heatBoilerWater(93);
        engageHighPressurePump(9);
        dispenseShot(36);
        System.out.println("-> Double Espresso is ready! Enjoy.");
    }

    private void grindCoffeeBeans(int grams) {
        System.out.println("  [Internal Step 1] Grinding " + grams + "g of Arabica beans...");
    }

    private void heatBoilerWater(int celsius) {
        System.out.println("  [Internal Step 2] Heating PID boiler to " + celsius + "C...");
    }

    private void engageHighPressurePump(int bars) {
        System.out.println("  [Internal Step 3] Extracting at " + bars + " bars of pressure...");
    }

    private void dispenseShot(int milliliters) {
        System.out.println("  [Internal Step 4] Pouring " + milliliters + "ml espresso shot...");
    }
}

/**
 * High-Cohesion Class #1: Represents ONLY the state of a customer order.
 */
class Order {
    private String orderId;
    private String itemName;
    private double subtotal;

    public Order(String orderId, String itemName, double subtotal) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.subtotal = subtotal;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getSubtotal() {
        return subtotal;
    }
}

/**
 * High-Cohesion Class #2: Responsible ONLY for tax calculation math.
 */
class TaxCalculator {
    private double taxRate;

    public TaxCalculator(double taxRate) {
        this.taxRate = taxRate;
    }

    public double computeTax(double amount) {
        return amount * taxRate;
    }
}

/**
 * High-Cohesion Class #3: Responsible ONLY for formatting and printing receipts.
 */
class ReceiptFormatter {
    public void printReceipt(Order order, double taxAmount) {
        double grandTotal = order.getSubtotal() + taxAmount;
        System.out.printf("Receipt [%s] | Item: %s | Subtotal: $%.2f | Tax: $%.2f | Total: $%.2f%n",
                order.getOrderId(), order.getItemName(), order.getSubtotal(), taxAmount, grandTotal);
    }
}
