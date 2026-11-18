# Practice Sheet: Lesson 19 — Methods with Parameters

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/19_Methods_With_Parameters/Exercise.java) to practice parameters, return types, and pass-by-value behavior.

---

## Problem 1: Rectangle Area & Perimeter Calculator Methods (Easy)
### Description
Implement two value-returning methods:
1. `public static double calculateArea(double width, double height)` $\rightarrow$ returns `width * height`.
2. `public static double calculatePerimeter(double width, double height)` $\rightarrow$ returns `2 * (width + height)`.
In `solveProblem1()`, call both methods for `width = 8.5` and `height = 4.0` and print the results.

### Expected Output
```
Rectangle (8.5 x 4.0) -> Area: 34.00 | Perimeter: 25.00
```
### Edge-Case Hints
- Make sure both methods use `return` to send the `double` result back to `solveProblem1()`.

---

## Problem 2: Boolean Predicate Method `isValidTriangle` (Medium)
### Description
By the Triangle Inequality Theorem, three side lengths `a`, `b`, and `c` can form a valid triangle if and only if all three sides are positive **and** the sum of any two sides is strictly greater than the third side:
$$(a + b > c) \land (a + c > b) \land (b + c > a)$$
Implement `public static boolean isValidTriangle(int a, int b, int c)` and test it in `solveProblem2()` with `(3, 4, 5)` and `(2, 3, 10)`.

### Expected Output
```
Sides (3, 4, 5)  Valid Triangle? true
Sides (2, 3, 10) Valid Triangle? false
```
### Edge-Case Hints
- You can return the boolean expression directly: `return (a + b > c) && (a + c > b) && (b + c > a);`.

---

## Problem 3: Pass-by-Value vs. Returning the Updated Value (Hard)
### Description
A developer tried to write `void addBonusBroken(int points, int bonus)` that did `points += bonus;`, wondering why the caller's `playerPoints` variable stayed at `100`.
Implement `public static int addBonusFixed(int points, int bonus)` that **returns** `points + bonus`, and reassign `playerPoints = addBonusFixed(playerPoints, 50);` in `solveProblem3()`.

### Expected Output
```
Initial Player Points          : 100
After addBonusBroken(100, 50)  : 100 (Unchanged due to Pass-by-Value)
After addBonusFixed(100, 50)   : 150 (Updated via Return Value)
```
### Edge-Case Hints
- Because Java is strictly pass-by-value for primitives, the only way for a method to update a caller's local `int` variable is to **return** the new `int` and assign it back!
