package _02_Java_OOP._06_Create_Your_First_Class_Part_3;

/**
 * Lesson 06: Create Your First Class (Part 3) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Fixing Shadowed Setters in EmployeeBadge ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Comparing Two Instances Using `this` ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Fluent PizzaOrder Builder (`return this;`) ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        EmployeeBadge badge = new EmployeeBadge();
        badge.setFullName("Dr. Alan Grant");
        badge.setDepartment("Paleontology");
        System.out.println("Badge -> Name: " + badge.getFullName() + " | Department: " + badge.getDepartment());
    }

    public static void solveProblem2() {
        Watch watchA = new Watch("Omega", 6500.0);
        Watch watchB = new Watch("Seiko", 450.0);

        System.out.println("Is Omega ($6500.0) more expensive than Seiko ($450.0)? "
                + watchA.isMoreExpensiveThan(watchB));
        System.out.println("Is Seiko ($450.0) more expensive than Omega ($6500.0)? "
                + watchB.isMoreExpensiveThan(watchA));
    }

    public static void solveProblem3() {
        // WHY WE USED THIS WAY:
        // Because `setSize`, `setCrust`, and `addTopping` each return `this` (the current
        // `PizzaOrder` instance), we can chain all 4 calls in a single fluent statement!
        PizzaOrder order = new PizzaOrder()
                .setSize("Large")
                .setCrust("Thin")
                .addTopping(2.50)
                .addTopping(3.00);
        order.printSummary();
    }
}

class EmployeeBadge {
    private String fullName;
    private String department;

    // WHY WE USED THIS WAY:
    // Because the parameter `fullName` has the exact same name as the instance field,
    // writing `fullName = fullName;` assigns the parameter to itself!
    // Prefixing `this.fullName` targets the object's instance field on the Heap.
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }
}

class Watch {
    private String brand;
    private double price;

    public Watch(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    // WHY WE USED THIS WAY:
    // `this.price` refers to the Watch on which the method was called (`watchA`),
    // while `otherWatch.price` refers to the Watch passed as the argument (`watchB`).
    public boolean isMoreExpensiveThan(Watch otherWatch) {
        return this.price > otherWatch.price;
    }
}

class PizzaOrder {
    private String size = "Medium";
    private String crust = "Regular";
    private int toppingCount = 0;
    private double basePrice = 12.00;

    public PizzaOrder setSize(String size) {
        this.size = size;
        return this;
    }

    public PizzaOrder setCrust(String crust) {
        this.crust = crust;
        return this;
    }

    public PizzaOrder addTopping(double toppingPrice) {
        this.toppingCount++;
        this.basePrice += toppingPrice;
        return this;
    }

    public void printSummary() {
        System.out.printf("Pizza [Size: %s | Crust: %s | Toppings: %d | Total: $%.2f]%n",
                this.size, this.crust, this.toppingCount, this.basePrice);
    }
}
