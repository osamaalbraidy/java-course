# Practice Sheet: Lesson 23 — Revision OOP (Part 2: Inheritance & Polymorphism)

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/23_Revision_OOP_Part_2/Exercise.java).

---

## Problem 1: Abstract `ShippingShipment` Hierarchy (Easy)
### Description
Create an `abstract class ShippingShipment` (`trackingId`, `weightKg`, `public abstract double calculatePostage();`) and two concrete subclasses:
- `GroundShipment extends ShippingShipment`: costs `$5.00 + (weightKg * 1.50)`.
- `OvernightAirShipment extends ShippingShipment`: costs `$25.00 + (weightKg * 4.25)`.
Store both in a `ShippingShipment[]` array and print their postage costs.

### Expected Output
```
Shipment [TRK-100 | GroundShipment]       -> Postage: $20.00
Shipment [TRK-101 | OvernightAirShipment] -> Postage: $67.50
```

---

## Problem 2:Extending Parent Logic with `super.` in `SmartAppliance` (Medium)
### Description
In `SmartAppliance`, `public double calculateDailyKwh()` returns `baseWatts * hoursPerDay / 1000.0`.
In `SmartRefrigerator extends SmartAppliance`, override `calculateDailyKwh()` to call `super.calculateDailyKwh()` and add `0.85 kWh` if `iceMakerActive` is `true`.

### Expected Output
```
Standard Appliance Daily Energy : 2.40 kWh
Smart Fridge (w/ Ice Maker)     : 3.25 kWh
```

---

## Problem 3: Polymorphic Fleet Inspection & `instanceof` Downcasting (Hard)
### Description
Given an abstract `FleetVehicle` class and two subclasses (`CargoTruck` with `void weighAxleLoad()`, and `PassengerBus` with `void checkEmergencyExits()`), iterate through a `FleetVehicle[]` array, call the polymorphic `runEngineDiagnostic()`, and use Java 17 `instanceof` pattern matching to invoke the subclass-specific safety check!

### Expected Output
```
[CargoTruck #T-90] Engine telemetry nominal.
  -> [Axle Scale] Verified 18-wheeler load: 32.5 tons
[PassengerBus #B-12] Engine telemetry nominal.
  -> [Safety Check] Verified all 6 emergency exits on Bus #B-12
```
