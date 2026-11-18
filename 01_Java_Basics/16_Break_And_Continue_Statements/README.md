# Lesson 16: `break` and `continue` Statements (Loop Flow Control & Labeled Loops)

## 1. Controlling Loop Execution: `break` vs. `continue`
Sometimes you need to alter the normal iteration flow inside a loop (`for`, `while`, or `do-while`):

| Statement | Action | Effect on Loop |
| :---: | :--- | :--- |
| **`break;`** | **Terminates** the innermost enclosing loop immediately | Jumps straight to the first statement **after** the loop's closing `}`. |
| **`continue;`** | **Skips** the remaining statements in the **current iteration** | Jumps directly to the **update step** (`for`) or **condition check** (`while`/`do-while`) for the next iteration. |

```
for (int i = 1; i <= 5; i++) {
    if (i == 2) continue; // Skips printing 2, jumps to i++ (next is 3)
    if (i == 4) break;    // Exits the loop completely when i is 4
    System.out.println(i);
}
// Output: 1, 3
```

---

## 2. Labeled `break` and `continue` (For Nested Loops)
By default, an unlabeled `break;` or `continue;` only affects the **innermost loop** in which it appears.
If you are inside a nested loop (e.g., searching a 2D grid of rows and columns) and want to break out of **both** the inner loop and the outer loop at the same time, attach a **label** (`labelName:`) to the outer loop:

```java
searchGrid: // <-- Loop Label
for (int row = 0; row < 3; row++) {
    for (int col = 0; col < 3; col++) {
        if (grid[row][col] == target) {
            System.out.println("Found at (" + row + ", " + col + ")");
            break searchGrid; // Exits BOTH inner and outer loops immediately!
        }
    }
}
```

---

## 3. Common Pitfalls
1. **`continue;` Inside a `while` Loop Skipping the Counter Update**:
   - In a `for (int i = 0; i < 10; i++)` loop, `continue;` still executes `i++` automatically.
   - However, in a `while` loop, if `i++` is at the bottom of the loop body and you call `continue;` *above* `i++`, `i` never increments—creating an **infinite loop**!
2. **Unreachable Code After `break;` or `continue;`**:
   - Writing statements immediately after an unconditional `break;` or `continue;` in the same block causes a compile-time error: `unreachable statement`.

---

## 4. Real-World Use Cases
- **Early Search Termination (`break`)**: Stopping a database/file scan the moment a matching record ID is found instead of wasting CPU cycles checking the remaining 999,999 rows.
- **Data Sanitization / Filtering (`continue`)**: Skipping blank lines, comment lines (`#`), or corrupted negative readings while batch-processing a CSV file.
