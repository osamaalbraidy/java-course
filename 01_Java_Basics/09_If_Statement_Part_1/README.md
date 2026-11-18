# Lesson 09: `if` Statement — Part 1 (`if`, `else`, Relational Operators `==`, `!=`, `<`, `>`)

## 1. Decision-Making with `if` and `else`
Until now, our programs have executed every line sequentially from top to bottom. **Conditional statements** (`if` and `else`) allow a program to branch and execute code blocks selectively based on a **`boolean` condition** (`true` or `false`):

```java
if (condition) {
    // Executes ONLY when condition evaluates to true
} else {
    // Executes ONLY when condition evaluates to false
}
```

> **Important Rule:** Unlike C or C++, Java's `if (condition)` **strictly requires a `boolean` expression**. Writing `if (1)` or `if (count)` is a compile-time error in Java: `incompatible types: int cannot be converted to boolean`.

---

## 2. Java's 6 Relational (Comparison) Operators
Relational operators compare two primitive values and always produce a `boolean` result (`true` or `false`):

| Operator | Meaning | Example (`a = 10, b = 20`) | Evaluates To |
| :---: | :--- | :--- | :---: |
| `==` | Equal to | `a == b` | `false` |
| `!=` | Not equal to | `a != b` | `true` |
| `<` | Less than | `a < b` | `true` |
| `<=` | Less than or equal to | `a <= 10` | `true` |
| `>` | Greater than | `a > b` | `false` |
| `>=` | Greater than or equal to | `b >= 20` | `true` |

---

## 3. Comparing `String` Objects: `.equals()` vs. `==`
- For **primitives** (`int`, `double`, `char`, `boolean`), always use `==` to test equality.
- For **`String` (and objects)**, `==` checks whether two variables point to the **exact same memory address**, NOT whether they contain the same characters!
- **Always use `str1.equals(str2)`** (or `str1.equalsIgnoreCase(str2)`) to compare text content!

---

## 4. Common Pitfalls
1. **Confusing Assignment (`=`) with Equality (`==`)**:
   - `x = 5` assigns `5` to `x`.
   - `x == 5` compares `x` with `5`.
   - Watch out for `boolean` variables: writing `if (isAdmin = true)` accidentally **assigns** `true` to `isAdmin` and always enters the `if` block! Better yet, just write `if (isAdmin)`.
2. **Accidental Semicolon After `if (condition);`**:
   ```java
   if (score < 50); { // <-- BUG! The ';' terminates the if statement with an empty body!
       System.out.println("Failed!"); // This block now runs UNCONDITIONALLY!
   }
   ```
3. **Omitting Curly Braces `{ }` on Multi-Line Blocks**:
   - Without `{ }`, only the **first statement** after `if` or `else` belongs to the branch. Always use `{ }` even for single-line `if` blocks to prevent bugs!

---

## 5. Real-World Use Cases
- **Authentication & Access Control**: Checking `if (enteredPin == storedPin)` or `if (userAge >= 18)`.
- **Banking Overdraft Protection**: Checking `if (withdrawalAmount <= currentBalance)` before deducting funds.
