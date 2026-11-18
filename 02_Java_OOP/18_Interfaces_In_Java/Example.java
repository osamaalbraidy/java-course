package _02_Java_OOP._18_Interfaces_In_Java;

/**
 * Lesson 18: Interfaces in Java
 * Demonstrates:
 * 1. Declaring interfaces (`Rechargeable`, `AutonomousNavigable`) with constants,
 *    `abstract` methods, `default` methods, and `static` methods
 * 2. Implementing MULTIPLE interfaces in a single class (`MarsRover implements Rechargeable, AutonomousNavigable`)
 * 3. Polymorphism through interface references
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 18: INTERFACES IN JAVA                  ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. CALLING STATIC INTERFACE METHODS & CONSTANTS
        // -----------------------------------------------------------------
        System.out.println("--- [1] Interface Constants & Static Helper Methods ---");
        System.out.println("Max Safe Charge Constant : " + Rechargeable.MAX_BATTERY_PERCENT + "%");
        System.out.println("Is 48V fast-charge valid?: " + Rechargeable.isFastChargeSupported(48));
        System.out.println();

        // -----------------------------------------------------------------
        // 2. MULTIPLE INTERFACE INHERITANCE (`implements A, B`)
        // WHY: `AutonomousDrone` implements BOTH `Rechargeable` and `AutonomousNavigable`,
        // acquiring both capabilities!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Multiple Interface Implementation ---");
        AutonomousDrone drone = new AutonomousDrone("SkyHawk-7", 35);
        drone.printBatteryHealth();             // Inherited `default` method from Rechargeable!
        drone.recharge(50);                     // Implemented `abstract` method from Rechargeable
        drone.navigateToCoordinates(37.7749, -122.4194); // Implemented from AutonomousNavigable
        System.out.println();

        // -----------------------------------------------------------------
        // 3. POLYMORPHISM across UNRELATED CLASSES via an Interface!
        // WHY: `AutonomousDrone` (an aircraft) and `WirelessEarbuds` (audio gear)
        // do NOT share a parent class, yet BOTH implement `Rechargeable`!
        // -----------------------------------------------------------------
        System.out.println("--- [3] Interface Polymorphism Across Unrelated Classes ---");
        Rechargeable[] chargingDock = {
            drone,
            new WirelessEarbuds("AirPods Pro", 15)
        };

        for (Rechargeable device : chargingDock) {
            device.recharge(100);
            device.printBatteryHealth();
        }
    }
}

/**
 * INTERFACE #1: Represents any device that can be recharged.
 */
interface Rechargeable {
    // Implicitly `public static final`
    int MAX_BATTERY_PERCENT = 100;

    // Implicitly `public abstract`
    void recharge(int addedPercent);

    int getBatteryPercent();

    // Java 8+ `default` method: inherited automatically by all implementing classes!
    default void printBatteryHealth() {
        System.out.println("  [Battery Check] Current charge is " + getBatteryPercent()
                + "% / " + MAX_BATTERY_PERCENT + "%.");
    }

    // Java 8+ `static` method: called directly on the interface `Rechargeable.isFastChargeSupported(...)`
    static boolean isFastChargeSupported(int voltage) {
        return voltage >= 20;
    }
}

/**
 * INTERFACE #2: Represents any vehicle capable of GPS waypoint navigation.
 */
interface AutonomousNavigable {
    void navigateToCoordinates(double latitude, double longitude);
}

/**
 * Implements TWO interfaces (`Rechargeable` AND `AutonomousNavigable`).
 */
class AutonomousDrone implements Rechargeable, AutonomousNavigable {
    private String callSign;
    private int batteryPercent;

    public AutonomousDrone(String callSign, int batteryPercent) {
        this.callSign = callSign;
        this.batteryPercent = batteryPercent;
    }

    @Override
    public void recharge(int addedPercent) {
        this.batteryPercent = Math.min(MAX_BATTERY_PERCENT, this.batteryPercent + addedPercent);
        System.out.println("  [Drone " + this.callSign + "] Recharged to " + this.batteryPercent + "%.");
    }

    @Override
    public int getBatteryPercent() {
        return this.batteryPercent;
    }

    @Override
    public void navigateToCoordinates(double latitude, double longitude) {
        System.out.printf("  [Drone %s] Flying autonomously to GPS (%.4f, %.4f).%n",
                this.callSign, latitude, longitude);
    }
}

/**
 * Completely unrelated class that ALSO implements `Rechargeable`.
 */
class WirelessEarbuds implements Rechargeable {
    private String model;
    private int batteryPercent;

    public WirelessEarbuds(String model, int batteryPercent) {
        this.model = model;
        this.batteryPercent = batteryPercent;
    }

    @Override
    public void recharge(int addedPercent) {
        this.batteryPercent = Math.min(MAX_BATTERY_PERCENT, this.batteryPercent + addedPercent);
        System.out.println("  [Earbuds " + this.model + "] Case charged to " + this.batteryPercent + "%.");
    }

    @Override
    public int getBatteryPercent() {
        return this.batteryPercent;
    }
}
