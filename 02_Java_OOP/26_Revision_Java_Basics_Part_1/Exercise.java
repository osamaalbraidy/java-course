package _02_Java_OOP._26_Revision_Java_Basics_Part_1;

import java.util.ArrayList;

/**
 * Lesson 26: Cumulative Review (Java Basics + OOP) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Overloaded 1D & 2D Array Analytics ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Resilient Telemetry Packet Parser ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Full-Stack E-Commerce Order Synthesis ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        int[] daily = {100, 150, 200};
        int[][] weekly = {
            {100, 150, 200},
            {250, 200, 300}
        };

        // WHY WE USED THIS WAY:
        // Method Overloading lets us use the same intuitive name (`analyzeSales`) for both
        // a 1D array (`int[]`) and a 2D matrix (`int[][]`).
        System.out.printf("1D Daily Average : $%.2f%n", analyzeSales(daily));
        System.out.printf("2D Weekly Total  : $%,d%n", analyzeSales(weekly));
    }

    public static double analyzeSales(int[] dailySales) {
        int sum = 0;
        for (int sale : dailySales) {
            sum += sale;
        }
        return (double) sum / dailySales.length;
    }

    public static int analyzeSales(int[][] weeklyGrid) {
        int total = 0;
        for (int[] row : weeklyGrid) {
            for (int cell : row) {
                total += cell;
            }
        }
        return total;
    }

    public static void solveProblem2() {
        String[] rawPackets = {"TEMP:24.5", "TEMP:INVALID", "HUMIDITY:60.0"};
        ArrayList<SensorReading> validReadings = new ArrayList<>();

        // WHY WE USED THIS WAY:
        // Placing the `try-catch` block INSIDE the `for-each` loop allows the parser to
        // catch and log the corrupted `"TEMP:INVALID"` packet while continuing to process
        // the remaining valid packets into the `ArrayList`!
        for (String packet : rawPackets) {
            try {
                int colonIdx = packet.indexOf(':');
                String type = packet.substring(0, colonIdx);
                double val = Double.parseDouble(packet.substring(colonIdx + 1));
                validReadings.add(new SensorReading(type, val));
            } catch (NumberFormatException ex) {
                System.out.println("[Skipped Corrupted Packet] \"" + packet + "\"");
            }
        }

        System.out.println("Valid Packets Parsed: " + validReadings.size() + " -> " + validReadings);
    }

    public static void solveProblem3() {
        ArrayList<OrderLineItem> cart = new ArrayList<>();
        cart.add(new PhysicalBookItem("Java 17 Masterclass", 49.99, 4.00));
        cart.add(new DigitalCourseItem("OOP Architecture", 100.00, CustomerTier.VIP));

        double grandTotal = 0.0;
        int lineNum = 1;
        for (OrderLineItem item : cart) {
            double price = item.calculateFinalPrice();
            grandTotal += price;
            System.out.printf("  Line #%d: %s%n", lineNum++, item.getLineSummary());
        }
        System.out.printf("Final Invoice Total: $%.2f%n", grandTotal);
    }
}

// -----------------------------------------------------------------
// Problem 2 Class
// -----------------------------------------------------------------
class SensorReading {
    private String sensorType;
    private double value;

    public SensorReading(String sensorType, double value) {
        this.sensorType = sensorType;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.sensorType + "=" + this.value;
    }
}

// -----------------------------------------------------------------
// Problem 3 Enum, Abstract Class & Subclasses
// -----------------------------------------------------------------
enum CustomerTier {
    STANDARD(0.0),
    VIP(0.15);

    private final double discountRate;

    CustomerTier(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}

abstract class OrderLineItem {
    private String title;
    protected double basePrice;

    public OrderLineItem(String title, double basePrice) {
        this.title = title;
        this.basePrice = basePrice;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFinalPrice();

    public abstract String getLineSummary();
}

class PhysicalBookItem extends OrderLineItem {
    private double shippingFee;

    public PhysicalBookItem(String title, double basePrice, double shippingFee) {
        super(title, basePrice);
        this.shippingFee = shippingFee;
    }

    @Override
    public double calculateFinalPrice() {
        return this.basePrice + this.shippingFee;
    }

    @Override
    public String getLineSummary() {
        return String.format("PhysicalBook (%s) -> $%.2f (Includes $%.2f shipping)",
                getTitle(), calculateFinalPrice(), this.shippingFee);
    }
}

class DigitalCourseItem extends OrderLineItem {
    private CustomerTier tier;

    public DigitalCourseItem(String title, double basePrice, CustomerTier tier) {
        super(title, basePrice);
        this.tier = tier;
    }

    @Override
    public double calculateFinalPrice() {
        return this.basePrice * (1.0 - this.tier.getDiscountRate());
    }

    @Override
    public String getLineSummary() {
        int pct = (int) Math.round(this.tier.getDiscountRate() * 100);
        return String.format("DigitalCourse (%s)   -> $%.2f (%d%% %s Discount applied)",
                getTitle(), calculateFinalPrice(), pct, this.tier.name());
    }
}
