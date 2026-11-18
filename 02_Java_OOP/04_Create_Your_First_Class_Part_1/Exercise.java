package _02_Java_OOP._04_Create_Your_First_Class_Part_1;

/**
 * Lesson 04: Create Your First Class (Part 1) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Default Instance Field Inspector ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Configuring LaptopAsset & Upgrading RAM ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: CircleBlueprint Class ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // When `new LaptopAsset()` allocates memory on the Heap, the JVM automatically
        // initializes unconfigured instance fields to default values (`null`, `0`, `0.0`, `false`).
        LaptopAsset rawLaptop = new LaptopAsset();
        System.out.println("Default modelName     : " + rawLaptop.modelName);
        System.out.println("Default ramGb         : " + rawLaptop.ramGb);
        System.out.println("Default purchasePrice : " + rawLaptop.purchasePrice);
        System.out.println("Default isAssigned    : " + rawLaptop.isAssigned);
    }

    public static void solveProblem2() {
        LaptopAsset laptop = new LaptopAsset();
        laptop.modelName = "ThinkPad X1";
        laptop.ramGb = 16;
        laptop.purchasePrice = 1499.99;
        laptop.isAssigned = true;

        laptop.printSpecs();
        laptop.doubleRam();
        laptop.printSpecs();
    }

    public static void solveProblem3() {
        CircleBlueprint circle = new CircleBlueprint();
        circle.radius = 5.0;
        circle.color = "Crimson";

        System.out.printf("%s Circle (r=%.1f)  -> Area: %.2f%n",
                circle.color, circle.radius, circle.getArea());

        circle.scale(2.0);
        System.out.printf("%s Circle (r=%.1f) -> Area: %.2f | Circumference: %.2f%n",
                circle.color, circle.radius, circle.getArea(), circle.getCircumference());
    }
}

class LaptopAsset {
    String modelName;
    int ramGb;
    double purchasePrice;
    boolean isAssigned;

    void doubleRam() {
        ramGb *= 2;
    }

    void printSpecs() {
        System.out.printf("Laptop: %s | RAM: %dGB | Price: $%.2f | Assigned: %b%n",
                modelName, ramGb, purchasePrice, isAssigned);
    }
}

class CircleBlueprint {
    double radius;
    String color;

    // WHY WE USED THIS WAY:
    // Because `radius` is an instance field of `CircleBlueprint`, `getArea()`,
    // `getCircumference()`, and `scale()` can read and update `radius` directly!
    double getArea() {
        return 3.14159 * radius * radius;
    }

    double getCircumference() {
        return 2 * 3.14159 * radius;
    }

    void scale(double factor) {
        radius *= factor;
    }
}
