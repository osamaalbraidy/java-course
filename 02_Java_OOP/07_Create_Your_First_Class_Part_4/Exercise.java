package _02_Java_OOP._07_Create_Your_First_Class_Part_4;

/**
 * Lesson 07: Create Your First Class (Part 4: UML to Java) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: UML Visibility & Member Decoder ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Implementing RectangleUML ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Full UML Translation — SubscriptionPlan ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // Maps standard UML visibility prefixes (`-`, `+`, `#`) and `name : Type` syntax
        // into standard Java `modifier Type name` declarations.
        System.out.println("UML: - accountId : long                 -> Java: private long accountId;");
        System.out.println("UML: + DEPOSIT_LIMIT : double (static)  -> Java: public static final double DEPOSIT_LIMIT;");
        System.out.println("UML: # validatePin(pin : int) : boolean -> Java: protected boolean validatePin(int pin)");
        System.out.println("UML: + getBalance() : double            -> Java: public double getBalance()");
    }

    public static void solveProblem2() {
        RectangleUML r1 = new RectangleUML(10.0, 5.0);
        RectangleUML r2 = new RectangleUML(6.0, 6.0);
        System.out.println(r1);
        System.out.println(r2);
    }

    public static void solveProblem3() {
        SubscriptionPlan monthlyPlan = new SubscriptionPlan("team@startup.io", 50.0, 5, false);
        monthlyPlan.addSeats(3); // Now 8 seats

        SubscriptionPlan annualPlan = new SubscriptionPlan("enterprise@corp.io", 50.0, 5, true);
        annualPlan.addSeats(3); // Now 8 seats

        System.out.printf("Monthly Plan (8 seats) Annual Cost : $%.2f%n", monthlyPlan.calculateTotalAnnualCost());
        System.out.printf("Annual Plan  (8 seats) Annual Cost : $%.2f%n", annualPlan.calculateTotalAnnualCost());
    }
}

class RectangleUML {
    private double width;
    private double height;

    public RectangleUML(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2.0 * (width + height);
    }

    public boolean isSquare() {
        return width == height;
    }

    // WHY WE USED THIS WAY:
    // Overriding `toString()` allows `System.out.println(r1)` to print a clean summary
    // of the rectangle's state instead of `RectangleUML@hashcode`.
    @Override
    public String toString() {
        return String.format("Rectangle[%.1f x %.1f | Area: %.1f | Perimeter: %.1f | Square: %b]",
                width, height, getArea(), getPerimeter(), isSquare());
    }
}

class SubscriptionPlan {
    private String subscriberEmail;
    private double monthlyCost;
    private int activeUsers;
    private boolean annualBilling;

    public SubscriptionPlan(String email, double monthlyCost, int users, boolean annual) {
        this.subscriberEmail = email;
        this.monthlyCost = monthlyCost;
        this.activeUsers = users;
        this.annualBilling = annual;
    }

    public void addSeats(int additionalUsers) {
        if (additionalUsers > 0) {
            this.activeUsers += additionalUsers;
        }
    }

    // Translated from UML `- calculateSeatSurcharge() : double` (`-` means `private`)
    private double calculateSeatSurcharge() {
        if (this.activeUsers > 5) {
            return (this.activeUsers - 5) * 10.0;
        }
        return 0.0;
    }

    public double calculateTotalAnnualCost() {
        double totalMonthly = this.monthlyCost + calculateSeatSurcharge();
        double yearly = totalMonthly * 12.0;
        return this.annualBilling ? (yearly * 0.85) : yearly;
    }
}
