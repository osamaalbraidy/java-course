package _02_Java_OOP._03_What_Is_OOP_Part_3;

/**
 * Lesson 03: What Is OOP? (Part 3) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Architectural Design Principles ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: CloudBackupService Abstraction ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: High-Cohesion ShippingBox & PostageCalculator ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        System.out.println("Encapsulation  : Hides internal state using private fields and controlled public methods");
        System.out.println("Abstraction    : Hides complex multi-step implementation details behind a simple API");
        System.out.println("High Cohesion  : Ensures each class has a single, well-focused responsibility");
        System.out.println("Loose Coupling : Minimizes how much one class depends on the internal details of another");
    }

    public static void solveProblem2() {
        CloudBackupService service = new CloudBackupService();
        // WHY WE USED THIS WAY:
        // Thanks to Abstraction, the caller invokes ONE high-level method (`backupDirectory`),
        // without having to manually orchestrate compression, encryption, and uploading!
        service.backupDirectory("/var/www/app");
    }

    public static void solveProblem3() {
        // WHY WE USED THIS WAY:
        // High Cohesion separates physical box geometry (`ShippingBox`) from postal rate
        // rules (`PostageCalculator`). If postal rates change tomorrow, we only edit `PostageCalculator`!
        ShippingBox box = new ShippingBox(20.0, 10.0, 8.0, 4.0);
        PostageCalculator calculator = new PostageCalculator();
        double cost = calculator.calculateShippingCost(box);

        System.out.printf("Box Volume: %.1f cm3 | Weight: %.1f kg | Shipping Cost: $%.2f%n",
                box.calculateVolume(), box.getWeightKg(), cost);
    }
}

class CloudBackupService {
    public void backupDirectory(String folderPath) {
        System.out.println("Starting Backup for " + folderPath + ":");
        compressFiles(folderPath);
        encryptArchive();
        uploadToCloud();
    }

    // Private helper methods hide the internal mechanics from external callers
    private void compressFiles(String folderPath) {
        System.out.println("  1. Compressing " + folderPath + " into archive.zip...");
    }

    private void encryptArchive() {
        System.out.println("  2. Encrypting archive with AES-256...");
    }

    private void uploadToCloud() {
        System.out.println("  3. Uploading encrypted archive to cloud bucket -> DONE!");
    }
}

class ShippingBox {
    private double length;
    private double width;
    private double height;
    private double weightKg;

    public ShippingBox(double length, double width, double height, double weightKg) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weightKg = weightKg;
    }

    public double calculateVolume() {
        return length * width * height;
    }

    public double getWeightKg() {
        return weightKg;
    }
}

class PostageCalculator {
    public double calculateShippingCost(ShippingBox box) {
        double cost = 5.00 + (box.getWeightKg() * 2.50);
        if (box.calculateVolume() > 1000.0) {
            cost += 10.00;
        }
        return cost;
    }
}
