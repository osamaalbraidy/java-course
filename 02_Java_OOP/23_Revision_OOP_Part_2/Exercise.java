package _02_Java_OOP._23_Revision_OOP_Part_2;

/**
 * Lesson 23: Revision OOP (Part 2) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Abstract ShippingShipment Hierarchy ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Extending Parent Logic with super ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Polymorphic Fleet Inspection & Downcasting ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // Declaring `calculatePostage()` as `abstract` in `ShippingShipment` lets us
        // store both ground and air shipments in one `ShippingShipment[]` array and invoke
        // the right pricing formula via runtime polymorphism!
        ShippingShipment[] shipments = {
            new GroundShipment("TRK-100", 10.0),
            new OvernightAirShipment("TRK-101", 10.0)
        };

        for (ShippingShipment s : shipments) {
            s.printLabel();
        }
    }

    public static void solveProblem2() {
        SmartAppliance heater = new SmartAppliance(1000, 2.4);
        SmartRefrigerator fridge = new SmartRefrigerator(100, 24.0, true);

        System.out.printf("Standard Appliance Daily Energy : %.2f kWh%n", heater.calculateDailyKwh());
        System.out.printf("Smart Fridge (w/ Ice Maker)     : %.2f kWh%n", fridge.calculateDailyKwh());
    }

    public static void solveProblem3() {
        FleetVehicle[] fleet = {
            new CargoTruck("T-90", 32.5),
            new PassengerBus("B-12", 6)
        };

        // WHY WE USED THIS WAY:
        // We call the shared `runEngineDiagnostic()` polymorphically on every `FleetVehicle`,
        // and use Java 17 `instanceof` pattern matching to safely invoke child-only methods!
        for (FleetVehicle v : fleet) {
            v.runEngineDiagnostic();
            if (v instanceof CargoTruck truck) {
                truck.weighAxleLoad();
            } else if (v instanceof PassengerBus bus) {
                bus.checkEmergencyExits();
            }
        }
    }
}

// -----------------------------------------------------------------
// Problem 1 Classes
// -----------------------------------------------------------------
abstract class ShippingShipment {
    private String trackingId;
    protected double weightKg;

    public ShippingShipment(String trackingId, double weightKg) {
        this.trackingId = trackingId;
        this.weightKg = weightKg;
    }

    public abstract double calculatePostage();

    public void printLabel() {
        System.out.printf("Shipment [%s | %-20s] -> Postage: $%.2f%n",
                this.trackingId, this.getClass().getSimpleName(), calculatePostage());
    }
}

class GroundShipment extends ShippingShipment {
    public GroundShipment(String trackingId, double weightKg) {
        super(trackingId, weightKg);
    }

    @Override
    public double calculatePostage() {
        return 5.00 + (this.weightKg * 1.50);
    }
}

class OvernightAirShipment extends ShippingShipment {
    public OvernightAirShipment(String trackingId, double weightKg) {
        super(trackingId, weightKg);
    }

    @Override
    public double calculatePostage() {
        return 25.00 + (this.weightKg * 4.25);
    }
}

// -----------------------------------------------------------------
// Problem 2 Classes
// -----------------------------------------------------------------
class SmartAppliance {
    private double watts;
    private double hoursPerDay;

    public SmartAppliance(double watts, double hoursPerDay) {
        this.watts = watts;
        this.hoursPerDay = hoursPerDay;
    }

    public double calculateDailyKwh() {
        return (this.watts * this.hoursPerDay) / 1000.0;
    }
}

class SmartRefrigerator extends SmartAppliance {
    private boolean iceMakerActive;

    public SmartRefrigerator(double watts, double hoursPerDay, boolean iceMakerActive) {
        super(watts, hoursPerDay);
        this.iceMakerActive = iceMakerActive;
    }

    // WHY WE USED THIS WAY:
    // Calling `super.calculateDailyKwh()` reuses the parent's watt-hour formula and adds
    // the 0.85 kWh ice-maker load on top!
    @Override
    public double calculateDailyKwh() {
        double baseKwh = super.calculateDailyKwh();
        return this.iceMakerActive ? (baseKwh + 0.85) : baseKwh;
    }
}

// -----------------------------------------------------------------
// Problem 3 Classes
// -----------------------------------------------------------------
abstract class FleetVehicle {
    protected String unitId;

    public FleetVehicle(String unitId) {
        this.unitId = unitId;
    }

    public final void runEngineDiagnostic() {
        System.out.println("[" + this.getClass().getSimpleName() + " #"
                + this.unitId + "] Engine telemetry nominal.");
    }
}

class CargoTruck extends FleetVehicle {
    private double loadTons;

    public CargoTruck(String unitId, double loadTons) {
        super(unitId);
        this.loadTons = loadTons;
    }

    public void weighAxleLoad() {
        System.out.println("  -> [Axle Scale] Verified 18-wheeler load: " + this.loadTons + " tons");
    }
}

class PassengerBus extends FleetVehicle {
    private int exitCount;

    public PassengerBus(String unitId, int exitCount) {
        super(unitId);
        this.exitCount = exitCount;
    }

    public void checkEmergencyExits() {
        System.out.println("  -> [Safety Check] Verified all " + this.exitCount
                + " emergency exits on Bus #" + this.unitId);
    }
}
