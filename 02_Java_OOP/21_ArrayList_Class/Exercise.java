package _02_Java_OOP._21_ArrayList_Class;

import java.util.ArrayList;

/**
 * Lesson 21: ArrayList Class — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Task Backlog Manager (ArrayList CRUD) ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: ArrayList<Double> Sensor Filter ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: ArrayList<CartProduct> Shopping Cart ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        ArrayList<String> backlog = new ArrayList<>();

        // WHY WE USED THIS WAY:
        // `ArrayList` provides `.add(item)` to append, `.add(index, item)` to insert and shift,
        // `.set(index, item)` to replace in place, and `.remove(item)` to delete by value!
        backlog.add("Design DB Schema");
        backlog.add("Write REST API");
        backlog.add("Deploy to Cloud");

        backlog.add(1, "Configure Security"); // Shifts "Write REST API" to index 2
        backlog.set(2, "Write GraphQL API");  // Replaces index 2
        backlog.remove("Deploy to Cloud");    // Removes by String value

        System.out.println("Final Backlog (Size: " + backlog.size() + "): " + backlog);
    }

    public static void solveProblem2() {
        ArrayList<Double> readings = new ArrayList<>();
        readings.add(22.5);
        readings.add(-999.0);
        readings.add(24.0);
        readings.add(-999.0);
        readings.add(23.5);

        // WHY WE USED THIS WAY:
        // When removing elements by index inside a loop, iterating BACKWARDS from
        // `readings.size() - 1` down to `0` ensures that shifting elements to the right
        // of `i` never affects the indices we haven't visited yet!
        for (int i = readings.size() - 1; i >= 0; i--) {
            if (readings.get(i) == -999.0) {
                readings.remove(i);
            }
        }

        double sum = 0.0;
        for (double temp : readings) {
            sum += temp;
        }
        double avg = sum / readings.size();

        System.out.println("Cleaned Readings : " + readings);
        System.out.printf("Average Temp     : %.2f C%n", avg);
    }

    public static void solveProblem3() {
        ArrayList<CartProduct> cart = new ArrayList<>();
        cart.add(new CartProduct("Mechanical Keyboard", 120.00, 1));
        cart.add(new CartProduct("USB-C Hub", 45.00, 2));
        cart.add(new CartProduct("Webcam 4K", 95.00, 1));

        // WHY WE USED THIS WAY:
        // Storing `CartProduct` objects in an `ArrayList<CartProduct>` lets us iterate
        // with an enhanced `for-each` loop and call object methods (`getLineTotal()`) directly.
        double grandTotal = 0.0;
        CartProduct highestItem = cart.get(0);

        for (CartProduct item : cart) {
            System.out.printf("  CartItem: %-20s | Qty: %d | Line Total: $%.2f%n",
                    item.getName(), item.getQuantity(), item.getLineTotal());
            grandTotal += item.getLineTotal();
            if (item.getLineTotal() > highestItem.getLineTotal()) {
                highestItem = item;
            }
        }

        System.out.printf("Grand Total: $%.2f | Highest Line Item: %s ($%.2f)%n",
                grandTotal, highestItem.getName(), highestItem.getLineTotal());
    }
}

class CartProduct {
    private String name;
    private double price;
    private int quantity;

    public CartProduct(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getLineTotal() {
        return this.price * this.quantity;
    }
}
