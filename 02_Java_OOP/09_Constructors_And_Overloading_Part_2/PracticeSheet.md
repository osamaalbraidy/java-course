# Practice Sheet: Lesson 09 — Constructors and Overloading (Part 2: `this()` Chaining)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/09_Constructors_And_Overloading_Part_2/Exercise.java) to master constructor overloading and `this(...)` chaining.

---

## Problem 1: Overloaded `BoxDimensions` Constructors (Cube vs. Rectangular Box) (Easy)
### Description
Complete the `BoxDimensions` class in `Exercise.java` with three constructors chained via `this(...)`:
1. `public BoxDimensions()`: chains to `this(1.0)` (a $1 \times 1 \times 1$ unit cube).
2. `public BoxDimensions(double cubeSide)`: chains to `this(cubeSide, cubeSide, cubeSide)` (a cube where length, width, and height are all `cubeSide`).
3. `public BoxDimensions(double length, double width, double height)`: Master constructor that assigns `this.length`, `this.width`, and `this.height`.

### Expected Output
```
Unit Cube (0-arg)   -> 1.0 x 1.0 x 1.0 (Volume: 1.0)
Cube (side=4.0)     -> 4.0 x 4.0 x 4.0 (Volume: 64.0)
Box (2.0x3.0x5.0)   -> 2.0 x 3.0 x 5.0 (Volume: 30.0)
```
### Edge-Case Hints
- Notice that `this(...)` must be the very first line inside the 0-arg and 1-arg constructors!

---

## Problem 2: Refactoring Duplicate Constructor Logic in `EmployeeAccount` (Medium)
### Description
In `EmployeeAccount`, implement three constructors where the first two chain into the 3-parameter master constructor:
1. `public EmployeeAccount(String name)` $\rightarrow$ chains to `this(name, "General", 50000.0)`
2. `public EmployeeAccount(String name, String department)` $\rightarrow$ chains to `this(name, department, 65000.0)`
3. `public EmployeeAccount(String name, String department, double salary)` $\rightarrow$ Master constructor that assigns all three fields.
Test all three in `solveProblem2()`.

### Expected Output
```
Employee [Name: Maya | Dept: General | Salary: $50000.00]
Employee [Name: Leo | Dept: Engineering | Salary: $65000.00]
Employee [Name: Zoe | Dept: Architecture | Salary: $120000.00]
```
### Edge-Case Hints
- Only the 3-argument constructor should contain `this.name = ...; this.department = ...; this.salary = ...;`.

---

## Problem 3: Chained Constructors with Central Validation (`SmartSensorNode`) (Hard)
### Description
Complete `SmartSensorNode` in `Exercise.java` with 3 overloaded constructors:
1. `public SmartSensorNode(String nodeId)`: chains to `this(nodeId, "Temperature", 60)`.
2. `public SmartSensorNode(String nodeId, String sensorType)`: chains to `this(nodeId, sensorType, 60)`.
3. `public SmartSensorNode(String nodeId, String sensorType, int pollingIntervalSec)`: Master constructor that validates:
   - If `nodeId == null || nodeId.trim().isEmpty()`, set `"NODE-UNKNOWN"`, else `nodeId.trim()`.
   - If `pollingIntervalSec < 5`, clamp to `5` seconds (minimum hardware polling interval), else `pollingIntervalSec`.
Test all three in `solveProblem3()`, including an invalid polling interval (`1` sec) to prove that validation in the master constructor protects all constructors!

### Expected Output
```
Sensor [ID: NODE-101 | Type: Temperature | Poll: 60s]
Sensor [ID: NODE-102 | Type: Humidity | Poll: 60s]
Sensor [ID: NODE-UNKNOWN | Type: Pressure | Poll: 5s]
```
### Edge-Case Hints
- Because the 1-arg and 2-arg constructors chain into the 3-arg master constructor, passing `""` (blank `nodeId`) to ANY constructor automatically gets sanitized to `"NODE-UNKNOWN"`!
