# Practice Sheet: Lesson 05 — Input and Variables (Part 1)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/05_Input_And_Variables_Part_1/Exercise.java) to practice declaring primitive variables, choosing appropriate data types, and parsing input with `Scanner`.

---

## Problem 1: Choosing the Right Primitive Type (Easy)
### Description
Declare and initialize four variables with the exact types and values below, then print each one:
1. A `byte` named `dayOfMonth` initialized to `28`.
2. A `long` named `distanceToSunKm` initialized to `149_600_000_000L`.
3. A `float` named `batteryVoltage` initialized to `3.75f`.
4. A `char` named `bloodGroup` initialized to `'O'`.

### Expected Output
```
Day of Month       : 28
Distance to Sun    : 149600000000 km
Battery Voltage    : 3.75 V
Blood Group        : O
```
### Edge-Case Hints
- Don't forget the `L` suffix on the `long` literal and the `f` suffix on the `float` literal!

---

## Problem 2: Parsing Sensor Telemetry with `Scanner` (Medium)
### Description
Inside `solveProblem2()`, a `Scanner` is already connected to the input string `"Sensor-A1 42 23.65 true"`.
Use `scanner.next()`, `scanner.nextInt()`, `scanner.nextDouble()`, and `scanner.nextBoolean()` in the right order to read:
1. `sensorId` (`String`)
2. `readingCount` (`int`)
3. `temperatureCelsius` (`double`)
4. `isOnline` (`boolean`)
Print the parsed values in the format below.

### Expected Output
```
Sensor ID   : Sensor-A1
Readings    : 42
Temperature : 23.65 C
Online      : true
```
### Edge-Case Hints
- The order of `scanner.nextXxx()` calls must match the exact order of tokens in the input string!

---

## Problem 3: Integer Overflow Demonstration (Hard)
### Description
An `int` has a maximum value of `Integer.MAX_VALUE` (`2147483647`).
1. Store `Integer.MAX_VALUE` in an `int` variable named `maxInt`.
2. Add `1` to `maxInt` (`int overflowedInt = maxInt + 1;`) and print it—observe how 32-bit signed arithmetic wraps around to `Integer.MIN_VALUE` (`-2147483648`)!
3. Fix the overflow by storing `long safeResult = (long) maxInt + 1L;` in a `long` variable and print `safeResult`.

### Expected Output
```
Max int value          : 2147483647
After int + 1 (Wrap!)  : -2147483648
Using long + 1L (Safe) : 2147483648
```
### Edge-Case Hints
- Notice why casting `(long) maxInt` before adding `1L` is critical: if you write `long safe = maxInt + 1;`, the `int` addition overflows *before* being widened to `long`!
