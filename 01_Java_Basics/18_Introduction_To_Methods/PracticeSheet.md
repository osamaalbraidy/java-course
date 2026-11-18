# Practice Sheet: Lesson 18 — Introduction to Methods

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/18_Introduction_To_Methods/Exercise.java) to practice declaring and calling `void` methods and tracing the JVM Call Stack.

---

## Problem 1: Reusable Receipt Header & Footer Methods (Easy)
### Description
Create two `public static void` methods (`printHeader()` and `printFooter()`) and call them from `solveProblem1()`:
1. `printHeader()` prints:
   ```
   ==============================
        JAVA COFFEE ROASTERS     
   ==============================
   ```
2. `printFooter()` prints:
   ```
   ------------------------------
     Thank you for your visit!   
   ------------------------------
   ```
3. Inside `solveProblem1()`, call `printHeader()`, then print `"  Item: Cold Brew      $4.50"`, then call `printFooter()`.

### Edge-Case Hints
- Declare `printHeader()` and `printFooter()` at the class level (outside `main` and `solveProblem1`), not nested inside another method!

---

## Problem 2: Call Stack Trace Simulation (Medium)
### Description
Create three `public static void` methods (`stepA()`, `stepB()`, `stepC()`) where:
- `solveProblem2()` calls `stepA()`.
- `stepA()` prints `"1. Starting stepA"`, calls `stepB()`, and then prints `"5. Finishing stepA"`.
- `stepB()` prints `"2. Starting stepB"`, calls `stepC()`, and then prints `"4. Finishing stepB"`.
- `stepC()` prints `"3. Inside stepC (Deepest stack frame)"`.

### Expected Output
```
1. Starting stepA
2. Starting stepB
3. Inside stepC (Deepest stack frame)
4. Finishing stepB
5. Finishing stepA
```
### Edge-Case Hints
- Observe how the numbered output `1 -> 2 -> 3 -> 4 -> 5` proves Last-In, First-Out (LIFO) stack unwinding!

---

## Problem 3: Modular ASCII Rocket Builder (Hard)
### Description
Decompose drawing an ASCII rocket into three reusable `public static void` methods:
1. `drawCone()`: prints a 2-line nose cone:
   ```
     /\
    /  \
   ```
2. `drawBox()`: prints a 3-line fuselage box:
   ```
   +----+
   |    |
   +----+
   ```
3. Inside `solveProblem3()`, build a 2-stage rocket by calling:
   `drawCone()`, then `drawBox()`, then `drawBox()`, then `drawCone()` (as the exhaust nozzle).

### Edge-Case Hints
- Remember that a backslash `\` inside a Java String must be escaped as `\\`!
