package _02_Java_OOP._05_Create_Your_First_Class_Part_2;

/**
 * Lesson 05: Create Your First Class (Part 2) — Getters & Setters
 * Demonstrates:
 * 1. Standard JavaBeans Getter (`getXxx`, `isXxx`) and Setter (`setXxx`) conventions
 * 2. Read-only properties (Getter with NO Setter)
 * 3. Defensive input validation inside Setters
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 05: GETTERS, SETTERS & VALIDATION         ");
        System.out.println("==================================================\n");

        // 1. Creating an ECommerceProduct and configuring via Setters
        System.out.println("--- [1] Validating Inputs Inside Setters ---");
        ECommerceProduct product = new ECommerceProduct("SKU-10492");

        // Valid setter calls:
        product.setProductName("Wireless Noise-Canceling Headphones");
        product.setUnitPrice(299.99);
        product.setDiscountPercent(20);
        product.setInStock(true);

        // Invalid setter calls (Caught and blocked by setter validation!):
        System.out.println("Testing invalid setter inputs:");
        product.setProductName("   ");   // Rejected: blank name
        product.setUnitPrice(-45.00);    // Rejected: negative price
        product.setDiscountPercent(95);  // Rejected: discount > 80% max limit
        System.out.println();

        // 2. Reading State via Getters (`getXxx`, `isXxx`, and computed Getter)
        System.out.println("--- [2] Reading State via Getters ---");
        System.out.println("Product SKU (Read-Only) : " + product.getSku());
        System.out.println("Product Name            : " + product.getProductName());
        System.out.printf("Base Unit Price         : $%.2f%n", product.getUnitPrice());
        System.out.println("Discount Percent        : " + product.getDiscountPercent() + "%");
        System.out.printf("Final Sale Price (Comp) : $%.2f%n", product.getFinalSalePrice());
        System.out.println("In Stock (isInStock)    : " + product.isInStock());
    }
}

/**
 * Encapsulated Domain Class demonstrating Getters, Setters, Read-Only fields,
 * and defensive validation rules.
 */
class ECommerceProduct {
    private final String sku; // Read-only field: has a Getter, NO Setter!
    private String productName;
    private double unitPrice;
    private int discountPercent;
    private boolean inStock;

    public ECommerceProduct(String sku) {
        this.sku = sku;
        this.productName = "Unnamed Product";
        this.unitPrice = 1.00;
        this.discountPercent = 0;
        this.inStock = false;
    }

    // READ-ONLY GETTER (No setSku method exists!)
    public String getSku() {
        return sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            System.out.println("  [Setter Blocked] Product name cannot be null or blank!");
            return;
        }
        this.productName = newName.trim();
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double newPrice) {
        if (newPrice <= 0.0) {
            System.out.printf("  [Setter Blocked] Unit price ($%.2f) must be strictly positive!%n", newPrice);
            return;
        }
        this.unitPrice = newPrice;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int newDiscount) {
        if (newDiscount < 0 || newDiscount > 80) {
            System.out.println("  [Setter Blocked] Discount (" + newDiscount
                    + "%) must be between 0% and 80%!");
            return;
        }
        this.discountPercent = newDiscount;
    }

    // Standard JavaBeans getter for boolean starts with `is`
    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    // Computed Getter: calculates value dynamically from internal fields
    public double getFinalSalePrice() {
        return unitPrice * (1.0 - (discountPercent / 100.0));
    }
}
