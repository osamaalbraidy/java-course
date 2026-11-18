# Practice Sheet: Lesson 07 — Arithmetic Operators (Part 1)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/07_Arithmetic_Operators_Part_1/Exercise.java) to master `/`, `%`, and integer vs. floating-point arithmetic.

---

## Problem 1: Exact Batting Average Calculator (Easy)
### Description
A baseball player got `int hits = 45;` in `int atBats = 160;` attempts.
1. Compute the integer division result `int truncatedRatio = hits / atBats;` (to see why `int / int` fails for ratios).
2. Compute the exact batting average `double battingAverage = (double) hits / atBats;`.
3. Print both values, formatting `battingAverage` to 3 decimal places (`%.3f`).

### Expected Output
```
Hits / At-Bats (int)    : 0
Exact Batting Average   : 0.281
```
### Edge-Case Hints
- Cast `hits` to `(double)` *before* the `/` operator, not the whole `(double) (hits / atBats)`.

---

## Problem 2: Vending Machine Coin Dispenser (Medium)
### Description
Given an amount in cents (`int totalCents = 193;`), use `/` and `%` to break it down into the minimum number of US coins:
- **Quarters** (`25` cents)
- **Dimes** (`10` cents)
- **Nickels** (`5` cents)
- **Pennies** (`1` cent)

### Expected Output
```
Total Change : 193 cents
Quarters (25): 7
Dimes    (10): 1
Nickels   (5): 1
Pennies   (1): 3
```
### Edge-Case Hints
- After computing `int quarters = remaining / 25;`, update `remaining = remaining % 25;` before calculating dimes!

---

## Problem 3: Sum of Digits of a 4-Digit Pin Code (Hard)
### Description
Given a 4-digit security PIN `int pin = 7395;`, extract each of the 4 digits using only integer division (`/`) and modulo (`%`) (no loops or String conversions), then calculate and print their sum ($7 + 3 + 9 + 5 = 24$).

### Expected Output
```
PIN Code      : 7395
Digits        : 7, 3, 9, 5
Sum of Digits : 24
```
### Edge-Case Hints
- `thousands = pin / 1000`
- `hundreds = (pin / 100) % 10`
- `tens = (pin / 10) % 10`
- `ones = pin % 10`
