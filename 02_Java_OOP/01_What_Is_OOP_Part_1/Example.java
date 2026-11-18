package _02_Java_OOP._01_What_Is_OOP_Part_1;

/**
 * Lesson 01: What Is OOP? (Part 1)
 * Demonstrates:
 * 1. Defining a Class Blueprint (`Drone`) with State (fields) and Behavior (methods)
 * 2. Instantiating multiple independent Objects (`droneAlpha`, `droneBravo`) using `new`
 * 3. Proving that mutating one object's state does not affect other instances
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 01: WHAT IS OOP? (PART 1)               ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. INSTANTIATING OBJECTS FROM THE `DeliveryDrone` CLASS BLUEPRINT
        // WHY: `DeliveryDrone` is the blueprint; `droneAlpha` and `droneBravo`
        // are two separate physical instances allocated on the JVM Heap.
        // -----------------------------------------------------------------
        System.out.println("--- [1] Creating Independent Object Instances ---");
        DeliveryDrone droneAlpha = new DeliveryDrone();
        droneAlpha.callSign = "ALPHA-01";
        droneAlpha.batteryPercent = 100;
        droneAlpha.altitudeMeters = 0;

        DeliveryDrone droneBravo = new DeliveryDrone();
        droneBravo.callSign = "BRAVO-02";
        droneBravo.batteryPercent = 65;
        droneBravo.altitudeMeters = 0;

        droneAlpha.reportTelemetry();
        droneBravo.reportTelemetry();
        System.out.println();

        // -----------------------------------------------------------------
        // 2. INVOKING OBJECT BEHAVIOR (Mutating Individual Instance State)
        // WHY: Calling `droneAlpha.ascend(120)` only modifies `droneAlpha`'s
        // altitude and battery; `droneBravo` stays on the ground at 0m!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Triggering Behavior on Individual Instances ---");
        droneAlpha.ascend(120);
        droneBravo.ascend(45);
        droneBravo.recharge();

        System.out.println("\n--- [3] Telemetry After Independent Operations ---");
        droneAlpha.reportTelemetry();
        droneBravo.reportTelemetry();
    }
}

/**
 * CLASS BLUEPRINT: Defines the State (fields) and Behavior (methods)
 * that every DeliveryDrone object will possess.
 */
class DeliveryDrone {
    // 1. STATE (Instance Fields — each object gets its own copy on the Heap)
    String callSign;
    int batteryPercent;
    int altitudeMeters;

    // 2. BEHAVIOR (Instance Methods — operate on this specific drone's state)
    void ascend(int meters) {
        altitudeMeters += meters;
        batteryPercent -= 15; // Climbing consumes 15% battery
        System.out.println("  [" + callSign + "] Ascended +" + meters
                + "m -> Now at " + altitudeMeters + "m (Battery: " + batteryPercent + "%)");
    }

    void recharge() {
        batteryPercent = 100;
        System.out.println("  [" + callSign + "] Recharged battery to 100%!");
    }

    void reportTelemetry() {
        System.out.printf("  Telemetry [%s] -> Altitude: %3dm | Battery: %3d%%%n",
                callSign, altitudeMeters, batteryPercent);
    }
}
