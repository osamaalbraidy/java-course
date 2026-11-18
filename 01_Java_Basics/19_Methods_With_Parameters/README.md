# Lesson 19: Methods with Parameters (Parameters vs. Arguments, Return Types & Pass-by-Value)

## 1. Parameters vs. Arguments
To make methods flexible and general-purpose, we pass input values into them and receive computed output values back:

```java
// `price` and `taxRate` are PARAMETERS (variables declared in the method header)
public static double calculateTotal(double price, double taxRate) {
    return price + (price * taxRate);
}

public static void main(String[] args) {
    // `100.0` and `0.08` are ARGUMENTS (actual values passed when calling the method)
    double finalBill = calculateTotal(100.0, 0.08);
}
```
- **Parameter (Formal Parameter)**: The placeholder variable declared inside the method's parentheses `(double price, double taxRate)`.
- **Argument (Actual Parameter)**: The concrete value or expression supplied by the caller `(100.0, 0.08)`.

---

## 2. Value-Returning Methods (`return expression;`)
When a method declares a non-`void` return type (`int`, `double`, `boolean`, `String`, etc.):
1. It **must** execute a `return expression;` statement along **every possible execution path** (`if` and `else`).
2. The type of the returned expression must match (or be implicitly widenable to) the declared return type.
3. The `return` statement **immediately terminates** the method and sends the value back to the caller.

---

## 3. Java Is Strictly Pass-by-Value!
One of the most important interview concepts in Java: **Java always passes arguments by value (it passes a COPY of the variable's value into the parameter)**.
- When you pass a primitive variable `int original = 50;` into `modifyValue(int copy)`, `copy` receives its own independent stack slot initialized to `50`.
- Changing `copy = 999;` inside `modifyValue` **only modifies the local `copy`**—`original` inside `main()` remains `50`!

---

## 4. Common Pitfalls
1. **`missing return statement` Compile Error**:
   - If a method returns `int` and has `if (x > 0) { return 1; }` without an `else` return, the compiler rejects it because Java cannot guarantee what is returned when `x <= 0`.
2. **Calling a Value-Returning Method and Ignoring the Return Value**:
   - Calling `Math.max(10, 20);` without storing or printing the result (`int m = Math.max(10, 20);`) discards the computed answer!
3. **Wrong Argument Order or Type Mismatch**:
   - Passing `(String, int)` to a method expecting `(int, String)` fails at compile time.

---

## 5. Real-World Use Cases
- **Pure Calculation Functions**: Tax calculators, shipping estimators, cryptographic hash generators, and boolean predicate helpers (`isValidEmail(String email)`).
