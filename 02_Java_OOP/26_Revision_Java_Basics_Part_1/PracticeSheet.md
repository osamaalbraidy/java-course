# Practice Sheet: Lesson 26 — Cumulative Review (Java Basics + OOP)

Review the cumulative problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/26_Revision_Java_Basics_Part_1/Exercise.java).

---

## Problem 1: Basics Review — 2D Matrix Row/Column Analytics & Method Overloading (Easy)
### Description
Write two overloaded `analyzeSales` methods:
1. `analyzeSales(int[] dailySales)`: returns the average of a 1D array.
2. `analyzeSales(int[][] weeklyGrid)`: uses nested loops to compute the grand total across all rows and columns.

### Expected Output
```
1D Daily Average : $150.00
2D Weekly Total  : $1,200
```

---

## Problem 2: OOP + Basics Review — `SensorPacket` Parser with Exception Recovery (Medium)
### Description
Parse an array of raw telemetry strings (`"TEMP:24.5"`, `"TEMP:INVALID"`, `"HUMIDITY:60.0"`) inside a `try-catch (NumberFormatException)` loop, converting valid strings into encapsulated `SensorReading` objects stored in an `ArrayList<SensorReading>`.

### Expected Output
```
[Skipped Corrupted Packet] "TEMP:INVALID"
Valid Packets Parsed: 2 -> [TEMP=24.5, HUMIDITY=60.0]
```

---

## Problem 3: Full-Stack Synthesis — E-Commerce Order Engine (Basics + All 4 OOP Pillars) (Hard)
### Description
Combine an `enum CustomerTier { STANDARD(0.0), VIP(0.15) }`, an `interface Discountable`, an `abstract class OrderLineItem`, and an `ArrayList<OrderLineItem>` to compute a complete itemized invoice with tier discounts and tax!

### Expected Output
```
  Line #1: PhysicalBook (Java 17 Masterclass) -> $53.99 (Includes $4.00 shipping)
  Line #2: DigitalCourse (OOP Architecture)   -> $85.00 (15% VIP Discount applied)
Final Invoice Total: $138.99
```
