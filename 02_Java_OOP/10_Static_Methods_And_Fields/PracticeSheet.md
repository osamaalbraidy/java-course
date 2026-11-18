# Practice Sheet: Lesson 10 — `static` Methods and Fields

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/10_Static_Methods_And_Fields/Exercise.java).

---

## Problem 1: Auto-Incrementing Invoice ID Generator (`static` Counter) (Easy)
### Description
Design an `Invoice` class where:
- A `private static int nextInvoiceNumber = 1001;` tracks the next available ID across the entire class.
- A `private static int totalInvoicesCreated = 0;` counts how many `Invoice` objects have been instantiated.
- Each `new Invoice(String clientName, double amount)` assigns `this.invoiceId = nextInvoiceNumber++;` and increments `totalInvoicesCreated++`.
- Provide a `public static int getTotalInvoicesCreated()` method and test creating 3 invoices in `Exercise.java`.

### Expected Output
```
Invoice #1001 | Client: Acme Corp     | Amount: $1200.00
Invoice #1002 | Client: Globex Inc    | Amount: $850.50
Invoice #1003 | Client: Initech LLC   | Amount: $3400.00
Total Invoices Created (Static Count): 3
```
### Edge-Case Hints
- Notice why `nextInvoiceNumber` and `totalInvoicesCreated` **must** be `static`: if they were instance fields, every new `Invoice` would start over at `#1001` and report a count of `1`!

---

## Problem 2: Stateless `GeometryUtils` Utility Class (Medium)
### Description
Create a utility class `GeometryUtils` with:
- A `public static final double GOLDEN_RATIO = 1.61803;` constant.
- A `private GeometryUtils()` constructor so it cannot be instantiated.
- Three `public static` methods:
  1. `circleArea(double radius)` $\rightarrow$ returns `Math.PI * radius * radius`
  2. `cylinderVolume(double radius, double height)` $\rightarrow$ reuses `circleArea(radius) * height`
  3. `hypotenuse(double a, double b)` $\rightarrow$ returns `Math.sqrt(a * a + b * b)`

### Expected Output
```
Golden Ratio Constant      : 1.61803
Circle Area (r=5.0)        : 78.54
Cylinder Volume (r=5, h=10): 785.40
Hypotenuse (a=3.0, b=4.0)  : 5.00
```
### Edge-Case Hints
- Because all methods in `GeometryUtils` are `static`, we call `GeometryUtils.circleArea(5.0)` directly on the class name without `new GeometryUtils()`.

---

## Problem 3: Shared `BankConfig` Interest Rate & `static` Initializer Block (Hard)
### Description
Create a `SavingsVault` class that holds:
- A shared `private static double annualInterestRate;` initialized inside a `static { ... }` block to `0.04` (4.0%).
- Instance fields `private String holderName;` and `private double balance;`.
- A `public static void updateGlobalInterestRate(double newRate)` method that updates `annualInterestRate` for **all existing and future** `SavingsVault` accounts simultaneously!
- An instance method `public double calculateYearlyInterest()` that returns `this.balance * annualInterestRate`.

### Expected Output
```
[Static Block] Initialized global SavingsVault interest rate to 4.0%
Before Rate Hike -> Alice Yearly Interest: $400.00 | Bob Yearly Interest: $800.00
After 5.5% Hike  -> Alice Yearly Interest: $550.00 | Bob Yearly Interest: $1100.00
```
### Edge-Case Hints
- Changing a single `static` field (`SavingsVault.updateGlobalInterestRate(0.055)`) immediately affects calculations on every `SavingsVault` instance!
