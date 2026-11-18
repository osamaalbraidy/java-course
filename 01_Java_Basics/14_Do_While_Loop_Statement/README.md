# Lesson 14: `do-while` Loop Statement (Post-Test Loops & Menu-Driven CLI Programs)

## 1. What Is a `do-while` Loop?
Unlike a `while` loop (which is a **pre-test loop** that checks its condition *before* entering the loop body), a **`do-while` loop** is a **post-test loop**: it executes the loop body **first**, and evaluates the continuation condition **at the bottom** of each iteration.

> **Key Guarantee:** A `do-while` loop **always executes its body at least once**, even if the condition is `false` on the very first check!

```java
do {
    // 1. Executes AT LEAST ONCE before condition is ever tested
    System.out.println("Displaying menu...");
} while (condition); // 2. Note the MANDATORY semicolon ';' at the end!
```

---

## 2. `while` vs. `do-while` Comparison

| Feature | `while (condition) { ... }` | `do { ... } while (condition);` |
| :--- | :--- | :--- |
| **Evaluation Timing** | **Pre-test** (Top of loop) | **Post-test** (Bottom of loop) |
| **Minimum Executions** | **0 times** (if initially `false`) | **1 time** (guaranteed first pass) |
| **Trailing Semicolon** | No semicolon after `{ ... }` | **Mandatory `;` after `while (condition);`** |
| **Ideal Use Case** | Reading streams/arrays that might be empty | Interactive CLI Menus, "Play Again? (y/n)" prompts |

---

## 3. Common Pitfalls
1. **Forgetting the Trailing Semicolon `;` After `while (condition);`**:
   - Unlike `while (...) { }`, a `do-while` statement **must** end with `;`. Omitting it causes `error: ';' expected`.
2. **Variable Scope Inside `do { ... }`**:
   - Any variable declared *inside* the `do { int choice = ...; }` block is destroyed at the closing brace `}` and **cannot be seen inside `while (choice != 0);`**!
   - **Rule:** Always declare the variable tested in `while (...)` **before** the `do` keyword.

---

## 4. Real-World Use Cases
- **Interactive CLI Menus (ATM, Banking, Inventory Apps)**: You must show the menu and read the user's choice at least once before checking `while (choice != EXIT_OPTION);`.
- **Retry-With-Backoff Network Calls**: Attempting an HTTP request at least once and repeating `while (statusCode != 200 && retries < 3);`.
