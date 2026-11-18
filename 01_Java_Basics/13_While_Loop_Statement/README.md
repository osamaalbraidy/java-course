# Lesson 13: `while` Loop Statement (Counter-Controlled Loops, Loop Anatomy & Avoiding Infinite Loops)

## 1. Why Do We Need Loops?
Imagine needing to print `"Processing record..."` 10,000 times or summing every transaction in a database table. Copy-pasting code 10,000 times is impossible to maintain. **Loops (Iteration Statements)** allow a program to repeat a block of code automatically as long as a `boolean` continuation condition remains `true`.

---

## 2. Anatomy of a Counter-Controlled `while` Loop
A `while` loop is a **pre-test loop**: it evaluates its condition **before** every iteration (including the very first one). If the condition is initially `false`, the loop body executes **zero times**.

Every counter-controlled `while` loop requires **three essential parts**:

```java
// 1. INITIALIZATION: Set the starting value of the loop control variable (LCV)
int count = 1;

// 2. CONDITION (Test): Evaluated BEFORE each iteration
while (count <= 5) {
    System.out.println("Iteration: " + count);

    // 3. UPDATE (Step): Modify the LCV toward terminating the condition!
    count++;
}
```

```
       [ 1. Initialize Counter ]
                   |
                   v
       /--> < 2. Condition? > ----(false)----> [ Exit Loop ]
       |           |
       |        (true)
       |           v
       |    [ Execute Body ]
       |           |
       |           v
       \--- [ 3. Update Counter ]
```

---

## 3. Common Patterns with `while` Loops
1. **Counting Up**: `int i = 1; while (i <= n) { ... i++; }`
2. **Counting Down (Rocket Countdown)**: `int t = 10; while (t >= 1) { ... t--; }`
3. **Stepping by Multiples**: `int even = 2; while (even <= 20) { ... even += 2; }`
4. **Accumulator Pattern (Summing / Multiplying)**:
   - Initialize `int sum = 0;` **outside (before)** the loop.
   - Add to `sum += current;` **inside** the loop.

---

## 4. Common Pitfalls
1. **The Infinite Loop (Forgetting the Update Step)**:
   - If you forget `count++;` (or move the counter in the wrong direction, like `count--;` when testing `count <= 5`), `count <= 5` stays `true` forever, freezing the program at 100% CPU usage!
2. **Off-by-One Errors (`<` vs. `<=`)**:
   - Starting at `1` and looping `while (i < 5)` executes **4 times** (`1, 2, 3, 4`).
   - Starting at `1` and looping `while (i <= 5)` executes **5 times** (`1, 2, 3, 4, 5`).
3. **Declaring the Accumulator Inside the Loop**:
   - Writing `int sum = 0;` *inside* the `while` body resets `sum` back to `0` on every single iteration!

---

## 5. Real-World Use Cases
- **Batch Pagination**: Fetching pages `1..N` from a REST API while `currentPage <= totalPages`.
- **Compound Interest Projections**: Simulating year-by-year investment growth over a fixed number of years or until a savings goal is reached.
