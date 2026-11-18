# Practice Sheet: Lesson 21 — Method Overloading

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/21_Methods_Overloading/Exercise.java) to practice overloading methods by parameter count, type, and order.

---

## Problem 1: Overloaded `add` Calculator (Easy)
### Description
Implement three overloaded versions of `add`:
1. `public static int add(int a, int b)` $\rightarrow$ returns `a + b`
2. `public static int add(int a, int b, int c)` $\rightarrow$ returns `a + b + c`
3. `public static double add(double a, double b)` $\rightarrow$ returns `a + b`
Call all three in `solveProblem1()` and print their results.

### Expected Output
```
add(10, 20)       = 30
add(10, 20, 30)   = 60
add(12.5, 7.25)   = 19.75
```
### Edge-Case Hints
- Notice that `add(int, int)` and `add(double, double)` have the same number of parameters (2), so Java distinguishes them by parameter data types!

---

## Problem 2: Overloaded Discount Pricing (`double` vs. `int` Percentage) (Medium)
### Description
In e-commerce, discounts might be applied as:
1. A flat dollar coupon: `applyDiscount(double price, double flatDollarOff)` $\rightarrow$ returns `price - flatDollarOff`
2. An integer percentage off: `applyDiscount(double price, int percentOff)` $\rightarrow$ returns `price * (1.0 - percentOff / 100.0)`
3. A default 10% loyalty discount (1 parameter): `applyDiscount(double price)` $\rightarrow$ delegates to `applyDiscount(price, 10)`!

Implement all three overloads and test them in `solveProblem2()` on a `$200.00` item.

### Expected Output
```
Flat $35.00 Off ($200.00, 35.0) : $165.00
25% Off         ($200.00, 25)   : $150.00
Default 10% Off ($200.00)       : $180.00
```
### Edge-Case Hints
- Passing `35.0` (a `double`) calls `applyDiscount(double, double)`, whereas passing `25` (an `int`) calls `applyDiscount(double, int)`!

---

## Problem 3: Overloading by Parameter Order (`formatTag`) (Hard)
### Description
Implement two overloaded versions of `formatTag` that take the same types (`String` and `int`) in **opposite order**:
1. `public static String formatTag(String label, int id)` $\rightarrow$ returns `label + "#" + id`
2. `public static String formatTag(int id, String label)` $\rightarrow$ returns `"[" + id + ":" + label + "]"`
Test both in `solveProblem3()`.

### Expected Output
```
formatTag("USER", 101) -> USER#101
formatTag(101, "USER") -> [101:USER]
```
### Edge-Case Hints
- `(String, int)` and `(int, String)` have distinct ordered parameter type lists, making them valid overloads!
