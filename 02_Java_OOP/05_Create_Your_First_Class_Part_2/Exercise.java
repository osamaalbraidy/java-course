package _02_Java_OOP._05_Create_Your_First_Class_Part_2;

/**
 * Lesson 05: Create Your First Class (Part 2) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Student Profile Getters & GPA Validation ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: SmartLock Read-Only & Clamped Setters ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Computed Getters in HotelReservation ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        StudentProfile student = new StudentProfile();
        student.setName("Elena");
        student.setGpa(3.85);
        student.setGpa(4.8);   // Rejected by setter validation
        student.setGpa(-1.2);  // Rejected by setter validation
        System.out.printf("Student: %s | Validated GPA: %.2f%n", student.getName(), student.getGpa());
    }

    public static void solveProblem2() {
        SmartLock lock = new SmartLock("LOCK-990");
        lock.setLocked(true);
        lock.setBatteryLevel(150); // Clamps to 100
        System.out.printf("Serial: %s | Locked: %b | Battery: %d%%%n",
                lock.getSerialNumber(), lock.isLocked(), lock.getBatteryLevel());

        lock.setLocked(false);
        lock.setBatteryLevel(-20); // Clamps to 0
        System.out.printf("Serial: %s | Locked: %b | Battery: %d%%%n",
                lock.getSerialNumber(), lock.isLocked(), lock.getBatteryLevel());
    }

    public static void solveProblem3() {
        HotelReservation res = new HotelReservation();
        res.setGuestName("Marcus Vance");
        res.setNights(4);
        res.setNightlyRate(200.00);
        // Test invalid setters that should be ignored:
        res.setNights(0);
        res.setNightlyRate(10.00);

        System.out.printf("Guest: %s | Nights: %d | Subtotal: $%.2f | Total (w/ 12%% Tax): $%.2f%n",
                res.getGuestName(), res.getNights(), res.getSubtotal(), res.getTotalWithTax());
    }
}

class StudentProfile {
    private String name;
    private double gpa;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getGpa() {
        return gpa;
    }

    // WHY WE USED THIS WAY:
    // By placing the range check `newGpa >= 0.0 && newGpa <= 4.0` inside `setGpa`,
    // invalid values like 4.8 or -1.2 are rejected before they can corrupt `this.gpa`!
    public void setGpa(double newGpa) {
        if (newGpa >= 0.0 && newGpa <= 4.0) {
            this.gpa = newGpa;
        } else {
            System.out.println("Invalid GPA (" + newGpa + ")! Must be between 0.0 and 4.0.");
        }
    }
}

class SmartLock {
    private final String serialNumber; // Read-only: has a Getter, NO Setter
    private boolean locked;
    private int batteryLevel;

    public SmartLock(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    // WHY WE USED THIS WAY:
    // Clamping inside the setter ensures `batteryLevel` is always constrained to [0..100].
    public void setBatteryLevel(int level) {
        if (level < 0) {
            this.batteryLevel = 0;
        } else if (level > 100) {
            this.batteryLevel = 100;
        } else {
            this.batteryLevel = level;
        }
    }
}

class HotelReservation {
    private String guestName = "Guest";
    private int nights = 1;
    private double nightlyRate = 100.0;

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.guestName = name.trim();
        }
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        if (nights >= 1 && nights <= 30) {
            this.nights = nights;
        }
    }

    public double getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(double rate) {
        if (rate >= 50.0) {
            this.nightlyRate = rate;
        }
    }

    // WHY WE USED THIS WAY:
    // Computing `subtotal` and `totalWithTax` dynamically inside getters avoids storing
    // redundant fields that could become stale when `nights` or `nightlyRate` changes!
    public double getSubtotal() {
        return nights * nightlyRate;
    }

    public double getTotalWithTax() {
        return getSubtotal() * 1.12;
    }
}
