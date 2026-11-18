# Practice Sheet: Lesson 20 — Exception Handling

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/20_Exception_Handling/Exercise.java).

---

## Problem 1: Resilient Array & String Parser (`try-catch-finally`) (Easy)
### Description
Write a method `parseAndDivide(String[] items, int index)` wrapped in a `try-catch-finally` block that:
1. Reads `String raw = items[index];` (may throw `ArrayIndexOutOfBoundsException`)
2. Parses `int num = Integer.parseInt(raw);` (may throw `NumberFormatException`)
3. Computes `int result = 100 / num;` (may throw `ArithmeticException`)
Test it with valid index `0` (`"25"`), invalid number index `1` (`"abc"`), zero index `2` (`"0"`), and out-of-bounds index `9`.

### Expected Output
```
Index 0 -> Result: 4 | [Finally: Operation logged]
Index 1 -> Caught NumberFormatException: Cannot parse "abc" | [Finally: Operation logged]
Index 2 -> Caught ArithmeticException: Division by zero | [Finally: Operation logged]
Index 9 -> Caught ArrayIndexOutOfBoundsException: Invalid index 9 | [Finally: Operation logged]
```
### Edge-Case Hints
- Notice how all 4 calls complete without crashing the program, and `[Finally: Operation logged]` runs every single time!

---

## Problem 2: Input Validation with `throw new IllegalArgumentException(...)` (Medium)
### Description
Implement `public static void registerUserAge(String username, int age)` that validates `age`:
- If `age < 18 || age > 120`, explicitly `throw new IllegalArgumentException("Age " + age + " is outside legal registration range [18..120]!");`.
- Otherwise, print `"Registered user: " + username + " (Age: " + age + ")"`.
Call it inside a `try-catch` block in `solveProblem2()` for `("Alice", 25)` and `("Tommy", 12)`.

### Expected Output
```
Registered user: Alice (Age: 25)
Registration blocked -> Age 12 is outside legal registration range [18..120]!
```
### Edge-Case Hints
- `IllegalArgumentException` is an **unchecked** (`RuntimeException`) exception used across the JDK whenever a caller passes an invalid argument.

---

## Problem 3: Custom Checked Exception — `OutOfStockException` (Hard)
### Description
Create a custom checked exception `class OutOfStockException extends Exception` that calls `super(message);`.
In `WarehouseInventory`, implement `public void reserveItems(String itemName, int requested) throws OutOfStockException`:
- If `requested > availableStock`, `throw new OutOfStockException("Cannot reserve " + requested + " of " + itemName + " (Only " + availableStock + " in stock)");`.
- Otherwise deduct `requested` from `availableStock` and print confirmation.

### Expected Output
```
Reserved 3 units of RTX-4090 (Remaining stock: 2)
Order Failed -> OutOfStockException: Cannot reserve 5 of RTX-4090 (Only 2 in stock)
```
### Edge-Case Hints
- Because `OutOfStockException extends Exception` (checked), `reserveItems` **must** declare `throws OutOfStockException` in its method header!
