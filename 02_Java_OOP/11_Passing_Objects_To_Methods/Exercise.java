package _02_Java_OOP._11_Passing_Objects_To_Methods;

/**
 * Lesson 11: Passing Objects to Methods — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Mutating an Object Inside a Method ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Object-to-Object Combat Interaction ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Returning a New Vector2D Object ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        ProductItem monitor = new ProductItem("Gaming Monitor", 400.00);
        System.out.println("Before Discount : " + monitor);

        // WHY WE USED THIS WAY:
        // Passing `monitor` passes a copy of its Heap memory address into `applySaleDiscount`.
        // Calling `item.setPrice(...)` inside the method mutates the shared Heap object directly!
        applySaleDiscount(monitor, 25.0);

        System.out.println("After 25% Off   : " + monitor);
    }

    public static void applySaleDiscount(ProductItem item, double percentOff) {
        if (item != null && percentOff > 0 && percentOff <= 100) {
            double discountedPrice = item.getPrice() * (1.0 - (percentOff / 100.0));
            item.setPrice(discountedPrice);
        }
    }

    public static void solveProblem2() {
        CombatUnit paladin = new CombatUnit("Paladin", 100, 35);
        CombatUnit dragon = new CombatUnit("Red Dragon", 120, 40);

        // WHY WE USED THIS WAY:
        // Passing the `dragon` object reference into `paladin.attack(dragon)` allows
        // `paladin` (`this`) to read its own `attackPower` and reduce `dragon`'s `health`!
        paladin.attack(dragon);
        paladin.attack(dragon);
    }

    public static void solveProblem3() {
        Vector2D v1 = new Vector2D(3.0, 4.0);
        Vector2D v2 = new Vector2D(7.0, -1.5);

        // WHY WE USED THIS WAY:
        // Instead of mutating `v1`, `v1.add(v2)` allocates and returns a brand-new `Vector2D`
        // object (`v3`), keeping `v1` and `v2` completely untouched!
        Vector2D v3 = v1.add(v2);

        System.out.println("Vector v1           : " + v1);
        System.out.println("Vector v2           : " + v2);
        System.out.println("Returned v3 = v1+v2 : " + v3);
        System.out.println("v1 Unchanged        : " + v1);
    }
}

class ProductItem {
    private String name;
    private double price;

    public ProductItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0.0) {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return String.format("Product [%s | $%.2f]", this.name, this.price);
    }
}

class CombatUnit {
    private String name;
    private int health;
    private int attackPower;

    public CombatUnit(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void attack(CombatUnit target) {
        if (target != null) {
            target.takeDamage(this.attackPower);
            System.out.println(this.name + " attacks " + target.name + " for "
                    + this.attackPower + " damage! (" + target.name + " HP: " + target.health + ")");
        }
    }
}

class Vector2D {
    private final double x;
    private final double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(this.x + other.x, this.y + other.y);
    }

    @Override
    public String toString() {
        return String.format("(%.1f, %.1f)", this.x, this.y);
    }
}
