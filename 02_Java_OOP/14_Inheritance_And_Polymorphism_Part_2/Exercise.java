package _02_Java_OOP._14_Inheritance_And_Polymorphism_Part_2;

/**
 * Lesson 14: Inheritance and Polymorphism (Part 2) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Polymorphic Shape2D[] Area Calculator ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Polymorphic Method Parameter ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Safe Downcasting with Java 17 instanceof ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // Upcasting `CircleShape` and `RectangleShape` into a `Shape2D[]` array lets us
        // calculate the total area of heterogeneous shapes in a single uniform loop!
        Shape2D[] shapes = {
            new CircleShape(5.0),
            new RectangleShape(10.0, 4.0)
        };

        double totalArea = 0.0;
        for (Shape2D shape : shapes) {
            double area = shape.calculateArea(); // Dynamic Method Dispatch at runtime!
            totalArea += area;
            System.out.printf("%-19s : %.2f%n",
                    shape.getClass().getSimpleName() + " Area", area);
        }
        System.out.printf("Total Combined Area : %.2f%n", totalArea);
    }

    public static void solveProblem2() {
        PaymentMethod card = new CreditCardPayment();
        PaymentMethod wallet = new DigitalWalletPayment();

        // WHY WE USED THIS WAY:
        // `executeCheckout` accepts the parent type `PaymentMethod`. We can pass ANY
        // subclass of `PaymentMethod` into it without writing `if-else` checks!
        executeCheckout(card, 149.99);
        executeCheckout(wallet, 45.00);
    }

    public static void executeCheckout(PaymentMethod method, double amount) {
        method.charge(amount);
    }

    public static void solveProblem3() {
        MediaFile[] playlist = {
            new AudioTrack("Synthwave.mp3"),
            new VideoClip("JavaTutorial.mp4", "4K")
        };

        // WHY WE USED THIS WAY:
        // `play()` is defined on `MediaFile`, so we can call `media.play()` on every element.
        // However, `enableSubtitles()` only exists on `VideoClip`! Using Java 17 pattern
        // matching `if (media instanceof VideoClip video)` safely checks the runtime type
        // and downcasts in one step without risking a `ClassCastException`.
        for (MediaFile media : playlist) {
            media.play();
            if (media instanceof VideoClip video) {
                video.enableSubtitles();
            }
        }
    }
}

// -----------------------------------------------------------------
// Problem 1 Classes
// -----------------------------------------------------------------
class Shape2D {
    public double calculateArea() {
        return 0.0;
    }
}

class CircleShape extends Shape2D {
    private double radius;

    public CircleShape(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }
}

class RectangleShape extends Shape2D {
    private double width;
    private double height;

    public RectangleShape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return this.width * this.height;
    }
}

// -----------------------------------------------------------------
// Problem 2 Classes
// -----------------------------------------------------------------
class PaymentMethod {
    public void charge(double amount) {
        System.out.printf("Charged $%.2f%n", amount);
    }
}

class CreditCardPayment extends PaymentMethod {
    @Override
    public void charge(double amount) {
        double cashback = amount * 0.02;
        System.out.printf("[CreditCard] Charged $%.2f (2%% Cashback earned: $%.2f)%n",
                amount, cashback);
    }
}

class DigitalWalletPayment extends PaymentMethod {
    @Override
    public void charge(double amount) {
        System.out.printf("[ApplePay]   Charged $%.2f via biometric token%n", amount);
    }
}

// -----------------------------------------------------------------
// Problem 3 Classes
// -----------------------------------------------------------------
class MediaFile {
    private String fileName;

    public MediaFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void play() {
        System.out.println("Playing media: " + this.fileName);
    }
}

class AudioTrack extends MediaFile {
    public AudioTrack(String fileName) {
        super(fileName);
    }

    @Override
    public void play() {
        System.out.println("Playing audio stream: " + getFileName());
    }
}

class VideoClip extends MediaFile {
    private String resolution;

    public VideoClip(String fileName, String resolution) {
        super(fileName);
        this.resolution = resolution;
    }

    @Override
    public void play() {
        System.out.println("Playing video stream: " + getFileName() + " (" + this.resolution + ")");
    }

    public void enableSubtitles() {
        System.out.println("  -> Subtitles enabled for " + this.resolution + " video: " + getFileName());
    }
}
