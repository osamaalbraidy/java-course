# Practice Sheet: Lesson 06 — Input and Variables (Part 2)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/06_Input_And_Variables_Part_2/Exercise.java) to master explicit/implicit type casting, `final` constants, and fixing the `Scanner` newline buffer trap.

---

## Problem 1: Explicit Narrowing & Fractional Cents Extraction (Easy)
### Description
Given a product price `double totalAmount = 47.89;`:
1. Use explicit narrowing `(int)` to extract the whole dollar portion (`int wholeDollars = (int) totalAmount;`).
2. Extract the remaining cents as an integer by computing `int cents = (int) Math.round((totalAmount - wholeDollars) * 100);`.
3. Print both the whole dollars and the cents.

### Expected Output
```
Original Amount : $47.89
Whole Dollars   : 47
Remaining Cents : 89
```
### Edge-Case Hints
- Floating-point subtraction (`47.89 - 47`) can produce `0.8900000000000006` in IEEE 754 binary, which is why wrapping `Math.round(...)` before `(int)` guarantees accuracy.

---

## Problem 2: Circle Geometry with `final` Constants (Medium)
### Description
1. Declare a `final double PI = 3.14159;`.
2. Given a circle radius `int radius = 7;`, implicitly widen `radius` into a `double` calculation to compute:
   - $\text{Area} = \text{PI} \times r \times r$
   - $\text{Circumference} = 2 \times \text{PI} \times r$
3. Print the radius, area, and circumference formatted to 2 decimal places (`%.2f`), and also print `(int) area` to show the truncated integer area.

### Expected Output
```
Radius              : 7
Exact Area          : 153.94
Truncated Area (int): 153
Circumference       : 43.98
```
### Edge-Case Hints
- Use `UPPER_SNAKE_CASE` for `final` constants (`final double PI = 3.14159;`).

---

## Problem 3: Fixing the `Scanner` Buffer Bug (Hard)
### Description
In `solveProblem3()`, a `Scanner` reads from the multi-line string:
`"505\n49.99\n123 Main Street, Apt 4B\n"`
1. Read `int orderId` using `scanner.nextInt()`.
2. Read `double shippingCost` using `scanner.nextDouble()`.
3. Properly clear the leftover newline character `\n` from the buffer using `scanner.nextLine()`.
4. Read the full multi-word street address `String deliveryAddress` using `scanner.nextLine()`.
5. Print all three values cleanly.

### Expected Output
```
Order ID         : 505
Shipping Cost    : $49.99
Delivery Address : 123 Main Street, Apt 4B
```
### Edge-Case Hints
- Without the extra `scanner.nextLine()` call after `nextDouble()`, `deliveryAddress` will read `""` (empty string) instead of `"123 Main Street, Apt 4B"`!
