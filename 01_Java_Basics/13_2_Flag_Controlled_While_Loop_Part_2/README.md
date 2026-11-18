# Lesson 13.2: Flag-Controlled `while` Loop — Part 2 (Sentinel Values & Multi-Condition Loop Control)

## 1. What Is a Sentinel Value?
When processing a list of inputs of unknown length (for example, scanning grocery item prices at a register or entering student grades), how does the user signal that there are **no more items**?

A **sentinel value** (also called a "dummy value" or "signal value") is a special predefined input value outside the valid data range that signals **"End of Input"**:
- **`-1`** when entering non-negative exam scores (`0..100`).
- **`0.0`** when scanning positive item prices.
- **`"QUIT"` or `"EXIT"`** when entering text commands or names.

> **Golden Rule of Sentinels:** The sentinel value **must only trigger loop termination**—it must **NEVER** be added to your running sum, count, or average!

---

## 2. Combining Flags, Sentinels, and Safety Caps (Multi-Condition Loops)
In production systems, loops rarely rely on a single condition. For example, an ATM PIN prompt or a shopping cart checkout might stop when **any** of several events occur:
1. The user enters the **sentinel value** (e.g., `-1` to cancel).
2. A **boolean flag** flips (e.g., `isAuthenticated = true` or `budgetExceeded = true`).
3. A **maximum retry counter** is reached (e.g., `attempts < MAX_ATTEMPTS`).

```java
boolean isAuthenticated = false;
boolean isCancelled = false;
int attempts = 0;
final int MAX_ATTEMPTS = 3;

while (!isAuthenticated && !isCancelled && attempts < MAX_ATTEMPTS) {
    // Read input, check sentinel (-1), or check credentials...
    attempts++;
}
```

---

## 3. De Morgan's Law in Multi-Condition `while` Headers
Suppose you want a loop to **stop** when `isDone` becomes `true` **OR** `hasError` becomes `true`.
When writing the **continuation condition** (`while (...)`), you want to continue while **neither** has happened:
$$\neg(\text{isDone} \lor \text{hasError}) \iff \neg\text{isDone} \land \neg\text{hasError}$$
In Java:
```java
while (!isDone && !hasError) { ... }
```
*(A common bug is writing `while (!isDone || !hasError)`—which keeps running until **both** `isDone` AND `hasError` are true!)*

---

## 4. Common Pitfalls
1. **Adding the Sentinel Value (`-1`) into the Sum/Count**:
   - If a student enters grades `90, 80, -1` and you add `-1` before checking for the sentinel, your sum becomes `169` across `3` items instead of `170` across `2` items! Always test `if (input == SENTINEL)` **before** updating accumulators.
2. **Division by Zero When the First Input Is the Sentinel**:
   - If the very first number typed by the user is `-1`, `count` is `0`. Computing `sum / count` will divide by zero unless you guard with `if (count > 0)`.

---

## 5. Real-World Use Cases
- **Point-of-Sale (POS) Checkout Registers**: Scanning item barcodes until the cashier scans the `"END_TRANSACTION"` sentinel or the customer's gift card limit is reached.
- **Brute-Force Lockout Systems**: Allowing a user to enter a PIN until `isUnlocked` is `true`, the user presses `"CANCEL"` (sentinel), or `attempts == 3` locks the account.
