# Practice Sheet: Lesson 17 — `abstract` Class and `abstract` Method

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/17_Abstract_Class_And_Abstract_Method/Exercise.java).

---

## Problem 1: Abstract `EmployeeCompensation` Hierarchy (Easy)
### Description
Create an `abstract class EmployeeCompensation` with:
- Shared field `private String name;` and constructor `public EmployeeCompensation(String name)`.
- Abstract method `public abstract double calculateBiweeklyPay();`.
- Concrete method `public void printPayStub()` that prints `name` and `calculateBiweeklyPay()`.

Create two concrete subclasses:
1. `SalariedEngineer extends EmployeeCompensation` (`annualSalary` $\rightarrow$ returns `annualSalary / 26.0`).
2. `HourlyContractor extends EmployeeCompensation` (`hourlyRate`, `hoursWorked` $\rightarrow$ returns `hourlyRate * hoursWorked`).

### Expected Output
```
Pay Stub -> Name: Elena (Salaried)   | Biweekly Pay: $4,000.00
Pay Stub -> Name: Marcus (Contractor)| Biweekly Pay: $3,400.00
```
### Edge-Case Hints
- Notice how the concrete method `printPayStub()` inside the `abstract` parent class can call the `abstract` method `calculateBiweeklyPay()`!

---

## Problem 2: Abstract `GeometricShape` with Area & Perimeter Contracts (Medium)
### Description
Create an `abstract class GeometricShape` (`color`, `public abstract double getArea();`, `public abstract double getPerimeter();`) and two concrete subclasses:
- `RightTriangle extends GeometricShape` (`base = 3.0`, `height = 4.0`, `hypotenuse = 5.0`)
- `SquareShape extends GeometricShape` (`side = 6.0`)

### Expected Output
```
Blue RightTriangle  -> Area: 6.00 | Perimeter: 12.00
Gold SquareShape    -> Area: 36.00 | Perimeter: 24.00
```
### Edge-Case Hints
- Every concrete subclass must implement **all** abstract methods declared in `GeometricShape` (`getArea()` AND `getPerimeter()`).

---

## Problem 3: Template Method Pattern — `DatabaseMigrationTask` (Hard)
### Description
Create an `abstract class DatabaseMigrationTask` with a `public final void runMigration()` template method that executes:
1. `openTransaction()` (concrete: prints `"  1. [DB] Transaction opened."`)
2. `applySchemaChanges()` (`protected abstract void applySchemaChanges();`)
3. `commitTransaction()` (concrete: prints `"  3. [DB] Transaction committed cleanly."`)

Implement `AddUsersTableMigration extends DatabaseMigrationTask` and run it!

### Expected Output
```
Running Migration: V1__Add_Users_Table
  1. [DB] Transaction opened.
  2. [SQL] CREATE TABLE users (id BIGINT PRIMARY KEY, email VARCHAR(255));
  3. [DB] Transaction committed cleanly.
```
### Edge-Case Hints
- Combining `public final void runMigration()` with `protected abstract void applySchemaChanges()` guarantees that every database migration opens and commits its transaction properly!
