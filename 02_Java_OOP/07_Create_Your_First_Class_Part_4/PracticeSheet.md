# Practice Sheet: Lesson 07 — Create Your First Class (Part 4: UML to Java)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/07_Create_Your_First_Class_Part_4/Exercise.java) to practice translating UML class diagrams into full Java classes.

---

## Problem 1: UML Visibility & Member Decoder (Easy)
### Description
In `solveProblem1()`, translate the following 4 UML member notations into their exact Java declarations and print them:
1. `- accountId : long`
2. `+ DEPOSIT_LIMIT : double` *(underlined / static constant)*
3. `# validatePin(pin : int) : boolean`
4. `+ getBalance() : double`

### Expected Output
```
UML: - accountId : long                 -> Java: private long accountId;
UML: + DEPOSIT_LIMIT : double (static)  -> Java: public static final double DEPOSIT_LIMIT;
UML: # validatePin(pin : int) : boolean -> Java: protected boolean validatePin(int pin)
UML: + getBalance() : double            -> Java: public double getBalance()
```
### Edge-Case Hints
- Remember: `-` = `private`, `+` = `public`, `#` = `protected`.

---

## Problem 2: Implementing the `RectangleUML` Diagram (Medium)
### Description
Translate the following UML Class Diagram into the `RectangleUML` class inside `Exercise.java`:
```
+--------------------------------------------+
|               RectangleUML                 |
+--------------------------------------------+
| - width  : double                          |
| - height : double                          |
+--------------------------------------------+
| + RectangleUML(width: double, height: double)|
| + getArea() : double                       |
| + getPerimeter() : double                  |
| + isSquare() : boolean                     |
| + toString() : String                      |
+--------------------------------------------+
```
- `isSquare()` returns `true` if `width == height`.
- `toString()` returns `String.format("Rectangle[%.1f x %.1f | Area: %.1f | Perimeter: %.1f | Square: %b]", width, height, getArea(), getPerimeter(), isSquare())`.

### Expected Output
```
Rectangle[10.0 x 5.0 | Area: 50.0 | Perimeter: 30.0 | Square: false]
Rectangle[6.0 x 6.0 | Area: 36.0 | Perimeter: 24.0 | Square: true]
```
### Edge-Case Hints
- When `System.out.println(r1)` is called on an object, Java automatically invokes `r1.toString()`.

---

## Problem 3: Full UML Translation — `SubscriptionPlan` (Hard)
### Description
Translate this UML Class Diagram into the `SubscriptionPlan` class in `Exercise.java`:
```
+---------------------------------------------------------+
|                    SubscriptionPlan                     |
+---------------------------------------------------------+
| - subscriberEmail : String                              |
| - monthlyCost     : double                              |
| - activeUsers     : int                                 |
| - annualBilling   : boolean                             |
+---------------------------------------------------------+
| + SubscriptionPlan(email: String, monthlyCost: double,  |
|                    users: int, annual: boolean)         |
| + addSeats(additionalUsers: int) : void                 |
| - calculateSeatSurcharge() : double                     |
| + calculateTotalAnnualCost() : double                   |
+---------------------------------------------------------+
```
Business Rules:
- `calculateSeatSurcharge()` (`private`): The first 5 users are included free. Every user above 5 costs `$10.00/month` (`(activeUsers - 5) * 10.0` if `activeUsers > 5`, else `0.0`).
- `calculateTotalAnnualCost()` (`public`):
  - `double totalMonthly = monthlyCost + calculateSeatSurcharge();`
  - `double yearly = totalMonthly * 12;`
  - If `annualBilling` is `true`, apply a 15% discount (`yearly * 0.85`), else return `yearly`.

### Expected Output
```
Monthly Plan (8 seats) Annual Cost : $960.00
Annual Plan  (8 seats) Annual Cost : $816.00
```
### Edge-Case Hints
- For `monthlyCost = 50.0` and `8` seats: surcharge is `(8 - 5) * 10.0 = 30.0`, so `totalMonthly = 80.0`, `yearly = 960.0` (and with 15% annual billing discount: `960.0 * 0.85 = 816.0`).
