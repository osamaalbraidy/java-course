# Practice Sheet: Lesson 00 — OOP: Get Started

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/00_OOP_Get_Started/Exercise.java) to review the 4 Pillars of OOP and transition from procedural thinking to object-oriented thinking.

---

## Problem 1: The 4 Pillars of OOP Matcher (Easy)
### Description
In `solveProblem1()`, print the 4 Pillars of OOP matched with their core engineering purpose in the exact format below:

### Expected Output
```
1. Encapsulation : Bundles data and methods; hides internal state via private fields
2. Abstraction   : Exposes essential behavior while hiding complex implementation details
3. Inheritance   : Allows subclasses to reuse and extend parent class state and behavior
4. Polymorphism  : Enables one common interface to represent multiple runtime forms
```
### Edge-Case Hints
- Check alignment of the colons `:` across all four lines.

---

## Problem 2: Refactoring Parallel Procedural Arrays into Objects (Medium)
### Description
In procedural code, two employees were stored in disconnected variables:
`String emp1Name = "Liam"; double emp1Salary = 70000;`
Using the provided `EmployeePreview` class in `Exercise.java`:
1. Instantiate two `EmployeePreview` objects:
   - `emp1`: `"Liam"`, `70000.0`
   - `emp2`: `"Noah"`, `85000.0`
2. Call `emp1.giveRaise(10.0)` (a 10% raise) and `emp2.giveRaise(5.0)` (a 5% raise).
3. Call `printBadge()` on both objects.

### Expected Output
```
Employee: Liam | Salary: $77000.00
Employee: Noah | Salary: $89250.00
```
### Edge-Case Hints
- Use the `new` keyword to instantiate objects: `EmployeePreview emp1 = new EmployeePreview("Liam", 70000.0);`.

---

## Problem 3: Adding State-Protecting Behavior to `ThermostatPreview` (Hard)
### Description
Inside the package-private `ThermostatPreview` class at the bottom of `Exercise.java`, implement the `setTemperature(int newTemp)` method so that it enforces a safe operating range of **`16` to `30` degrees Celsius (inclusive)**:
- If `newTemp >= 16 && newTemp <= 30`, update `temperature = newTemp;` and print `"Thermostat updated to " + temperature + "C"`.
- Otherwise, reject the change and print `"Rejected unsafe temperature: " + newTemp + "C ( stays at " + temperature + "C)"`.
Test it in `solveProblem3()` by setting `24`, then `45` (unsafe!), then `18`.

### Expected Output
```
Thermostat updated to 24C
Rejected unsafe temperature: 45C ( stays at 24C)
Thermostat updated to 18C
```
### Edge-Case Hints
- Notice how OOP Encapsulation prevents the thermostat from ever reaching a dangerous `45C`!
