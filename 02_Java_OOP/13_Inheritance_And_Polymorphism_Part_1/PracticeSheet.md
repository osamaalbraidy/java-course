# Practice Sheet: Lesson 13 — Inheritance and Polymorphism (Part 1: `extends` & `super`)

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/13_Inheritance_And_Polymorphism_Part_1/Exercise.java).

---

## Problem 1: Vehicle and ElectricCar Inheritance (`extends` & `super`) (Easy)
### Description
Create a parent class `Vehicle` (`brand`, `maxSpeedKmH`) and a child class `ElectricCar extends Vehicle` that adds `batteryCapacityKwh`:
- In `ElectricCar`'s constructor, call `super(brand, maxSpeedKmH)` on line 1, then set `this.batteryCapacityKwh`.
- Call both the inherited `printVehicleInfo()` method and the child's `printBatterySpecs()` method.

### Expected Output
```
Vehicle [Brand: Rivian R1T | Max Speed: 200 km/h]
EV Specs [Brand: Rivian R1T | Battery: 135 kWh]
```
### Edge-Case Hints
- Remember that `super(brand, maxSpeedKmH)` must be the first statement in `ElectricCar`'s constructor!

---

## Problem 2: BankAccount and SavingsAccount (`super` Method Reuse) (Medium)
### Description
Create a base class `BankAccount` (`owner`, `balance`, `deposit(double)`) and a subclass `SavingsAccount extends BankAccount` that adds `interestRate`:
- Implement `public void applyAnnualInterest()` inside `SavingsAccount` that calculates `double interest = getBalance() * interestRate;` and deposits it by calling `super.deposit(interest)`.

### Expected Output
```
Initial Savings Balance         : $1000.00
Interest Earned (5.0%)          : $50.00
Balance After Interest Applied  : $1050.00
```
### Edge-Case Hints
- Because `balance` is `private` in `BankAccount`, `SavingsAccount` reads it via `getBalance()` and adds interest via `super.deposit(interest)`!

---

## Problem 3: 3-Level Multilevel Inheritance Hierarchy (`Device -> Computer -> GamingLaptop`) (Hard)
### Description
Build a 3-level inheritance chain:
1. `ElectronicDevice` (holds `manufacturer`)
2. `Computer extends ElectronicDevice` (chains `super(manufacturer)`, adds `ramGb`)
3. `GamingLaptop extends Computer` (chains `super(manufacturer, ramGb)`, adds `gpuModel`)
Instantiate a `GamingLaptop("ASUS ROG", 32, "RTX 4090")` and print all 3 levels of properties!

### Expected Output
```
GamingLaptop [Maker: ASUS ROG | RAM: 32GB | GPU: RTX 4090]
```
### Edge-Case Hints
- Notice how constructor calls chain upward (`GamingLaptop -> Computer -> ElectronicDevice -> Object`) and execute downward!
