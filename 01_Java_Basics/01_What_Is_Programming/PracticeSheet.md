# Practice Sheet: Lesson 01 — What Is Programming?

Complete the exercises in [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/01_What_Is_Programming/Exercise.java) to practice translating human problem statements into deterministic algorithms.

---

## Problem 1: Temperature Conversion Algorithm (Easy)
### Description
Design and implement an algorithm following the **IPO (Input → Process → Output)** pattern that converts a temperature of `100.0` degrees Celsius into Fahrenheit and Kelvin.
- Formula for Fahrenheit:
  $$F = (C \times 1.8) + 32$$
- Formula for Kelvin:
  $$K = C + 273.15$$

### Expected Output
```
Celsius Input     : 100.0
Fahrenheit Output : 212.0
Kelvin Output     : 373.15
```
### Edge-Case Hints
- Make sure you multiply `celsius * 1.8` before adding `32`.

---

## Problem 2: Fixing a Flawed Algorithm — Order of Steps (Medium)
### Description
A junior developer wrote an algorithm to swap the values of two variables (`cupA = 10` and `cupB = 20`) by writing:
```java
cupA = cupB;
cupB = cupA;
```
Explain in a comment why this algorithm fails (both cups end up with `20`), and implement the **correct 3-step swap algorithm** using a temporary variable `tempCup`.

### Expected Output
```
Before Swap -> cupA: 10, cupB: 20
After Swap  -> cupA: 20, cupB: 10
```
### Edge-Case Hints
- Think of two physical glasses of juice: to swap their contents without mixing them, you need an empty third glass (`tempCup`).

---

## Problem 3: ASCII & Binary Decoder (Hard)
### Description
In computer memory, every character in the word `"JAVA"` is stored as a numeric ASCII code and binary sequence. For each distinct character `'J'`, `'A'`, and `'V'`, print its decimal ASCII code (by casting `(int) ch`) and its 8-bit binary representation using `Integer.toBinaryString(ch)`.

### Expected Output
```
Char 'J' | Decimal: 74 | Binary: 1001010
Char 'A' | Decimal: 65 | Binary: 1000001
Char 'V' | Decimal: 86 | Binary: 1010110
```
### Edge-Case Hints
- Casting a `char` to `(int)` reveals its underlying numeric Unicode/ASCII value.
