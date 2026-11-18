# Lesson 15: `for` Loop Statement (`for` Loop Structure, Nested `for` Loops & Pattern Printing)

## 1. Why Use a `for` Loop?
In Lesson 13, we saw that every counter-controlled loop requires **three parts**: **Initialization**, **Condition**, and **Update**. In a `while` loop, those three parts are spread across different lines (making it easy to accidentally forget `count++`).

The **`for` loop** places all three parts together in a single, compact header at the top of the loop:

```java
for (1_Initialization; 2_Condition; 4_Update) {
    // 3_Loop_Body
}
```

### Exact Execution Order of a `for` Loop
```
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```
1. **Initialization (`int i = 1`)**: Runs **once** when the loop first starts.
2. **Condition (`i <= 5`)**: Evaluated **before** every iteration. If `false`, the loop terminates immediately.
3. **Loop Body (`System.out.println(i)`)**: Executes if the condition was `true`.
4. **Update (`i++`)**: Executes **at the very end of each iteration** (after the body), right before jumping back to Step 2!

---

## 2. Nested `for` Loops (2D Grids & Pattern Printing)
A **nested loop** is a loop placed inside the body of another loop:
- **Outer Loop (`row`)**: Controls which **row** (horizontal line) is currently being printed.
- **Inner Loop (`col`)**: Runs **completely from start to finish** on **every single pass** of the outer loop, controlling the columns within that row.

If the outer loop runs $R$ times and the inner loop runs $C$ times, the inner body executes $R \times C$ times in total!

```java
for (int row = 1; row <= 4; row++) {         // Outer loop: 4 rows
    for (int col = 1; col <= row; col++) {   // Inner loop: prints `row` stars
        System.out.print("* ");
    }
    System.out.println();                    // Moves to the next line after finishing a row
}
```

---

## 3. Common Pitfalls
1. **Re-Using the Same Loop Counter Name in Nested Loops**:
   - Using `i` for both the outer loop and inner loop causes a compile error (`variable i is already defined`). Use descriptive names like `row` and `col` (or `i` and `j`).
2. **Scope of the Loop Counter Variable**:
   - When `i` is declared inside the header (`for (int i = 0; ...)`), `i` exists **only inside that `for` loop**.
3. **Accidental Semicolon After `for (...);`**:
   - Writing `for (int i = 1; i <= 5; i++);` spins an empty loop 5 times and then executes the `{ ... }` block once!

---

## 4. Real-World Use Cases
- **2D Image & Pixel Processing**: Iterating over `height` rows and `width` columns of an image.
- **Generating Multiplication Tables, ASCII Charts, and Calendar Grids**.
