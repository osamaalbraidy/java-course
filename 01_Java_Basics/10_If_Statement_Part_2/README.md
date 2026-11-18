# Lesson 10: `if` Statement — Part 2 (`else if` Ladders, Nested `if`, Logical Operators `&&`, `||`, `!`)

## 1. Multi-Way Branching with `else if` Ladders
When a decision has more than two mutually exclusive outcomes (e.g., assigning letter grades `A`, `B`, `C`, `D`, `F`), chain conditions using an **`else if` ladder**:

```java
if (score >= 90) {
    grade = 'A';
} else if (score >= 80) {
    grade = 'B';
} else if (score >= 70) {
    grade = 'C';
} else {
    grade = 'F';
}
```
> **Execution Rule:** Java evaluates conditions from top to bottom. As soon as the **first `true` condition** is found, its block executes and the **entire rest of the ladder is skipped**!

---

## 2. Logical Operators (`&&`, `||`, `!`)
Logical operators combine or invert `boolean` expressions:

| Operator | Name | Behavior | Example |
| :---: | :--- | :--- | :--- |
| `&&` | **Short-Circuit AND** | `true` **only if BOTH** left and right are `true` | `age >= 18 && hasLicense` |
| `\|\|` | **Short-Circuit OR** | `true` **if AT LEAST ONE** side is `true` | `isWeekend \|\| isHoliday` |
| `!` | **Logical NOT** | Inverts `true` $\leftrightarrow$ `false` | `!isLocked` |

### Why "Short-Circuit" Evaluation Matters
- In `A && B`: If `A` is `false`, the whole expression **must** be `false`, so Java **does not even evaluate `B`**.
- In `A || B`: If `A` is `true`, the whole expression **must** be `true`, so Java **does not even evaluate `B`**.
- **Defensive Guard Pattern**: `if (text != null && text.length() > 0)` safely prevents a `NullPointerException` because `text.length()` is skipped when `text != null` is `false`!

---

## 3. Nested `if` Statements & The Ternary Operator (`? :`)
- **Nested `if`**: Placing an `if-else` statement *inside* another `if` block allows hierarchical error messages (e.g., first check if an account exists; inside that, check if the password matches; inside that, check 2FA).
- **Ternary Conditional Operator (`condition ? valueIfTrue : valueIfFalse`)**:
  A concise inline shorthand for assigning a value based on a condition:
  ```java
  String status = (score >= 60) ? "PASS" : "FAIL";
  ```

---

## 4. Common Pitfalls
1. **Wrong Order in an `else if` Ladder**:
   - If you test `if (score >= 60)` *before* `else if (score >= 90)`, a student with `95` will match `>= 60` first and receive a `'D'`! Always order numeric ranges from **most restrictive to least restrictive** (descending or ascending).
2. **Writing Mathematical Range Syntax `if (18 <= age <= 65)`**:
   - Java does **not** allow chained relational operators like `18 <= age <= 65` (`18 <= age` produces a `boolean`, and `boolean <= 65` fails to compile). Always write: `if (age >= 18 && age <= 65)`.
3. **Precedence Between `&&` and `||`**:
   - `&&` has **higher precedence** than `||` (just like `*` has higher precedence than `+`). Use parentheses `(A || B) && C` to make intent 100% explicit.

---

## 5. Real-World Use Cases
- **Loan & Insurance Underwriting Engines**: Combining credit score ranges, debt-to-income ratios, and employment status via `&&`, `||`, and `else if` tiers.
