# Practice Sheet: Lesson 22 — One-Dimensional Arrays

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/22_Arrays/Exercise.java) to master 1D array creation, `for` vs. `for-each` loops, and array algorithms.

---

## Problem 1: Count Above-Average Scores (`for-each`) (Easy)
### Description
Given `int[] examScores = {72, 88, 95, 64, 81, 90, 70};` in `solveProblem1()`:
1. Use a `for-each` loop to compute the `sum` and `double average = (double) sum / examScores.length;`.
2. Use a second `for-each` loop to count how many scores are strictly greater than `average` (`score > average`).
3. Print the average (to 2 decimal places) and the count of above-average scores.

### Expected Output
```
Class Average : 80.00 | Scores Above Average : 4
```
### Edge-Case Hints
- Remember to cast `(double) sum` before dividing by `examScores.length`!

---

## Problem 2: Reverse Traversal & Even-Index Doubling (Medium)
### Description
Given `int[] values = {10, 20, 30, 40, 50, 60};` in `solveProblem2()`:
1. First, use an index-based `for` loop starting at `i = values.length - 1` down to `0` (`i >= 0; i--`) to print the elements in reverse order on one line.
2. Next, use an index-based `for` loop (`0` to `values.length - 1`) to double every element at an **even index** (`if (i % 2 == 0) values[i] *= 2;`).
3. Print the updated array using `Arrays.toString(values)`.

### Expected Output
```
Reverse Order     : 60 50 40 30 20 10 
Doubled Even Idx  : [20, 20, 60, 40, 100, 60]
```
### Edge-Case Hints
- Notice why you **cannot** use a `for-each` loop for step 2: modifying the loop variable `for (int v : values) { v *= 2; }` only changes a local copy, not the array slot `values[i]`!

---

## Problem 3: Finding the Second Largest Element in One Pass (Hard)
### Description
Given `int[] prices = {45, 120, 89, 195, 150, 99};` in `solveProblem3()`, find both the `largest` and `secondLargest` values in a single loop:
1. Initialize `int largest = Integer.MIN_VALUE;` and `int secondLargest = Integer.MIN_VALUE;`.
2. For each `p` in `prices`:
   - If `p > largest`: update `secondLargest = largest;` first, then `largest = p;`.
   - Else if `p > secondLargest && p != largest`: update `secondLargest = p;`.
3. Print both `largest` and `secondLargest`.

### Expected Output
```
Largest Price : $195 | Second Largest Price : $150
```
### Edge-Case Hints
- When a new `largest` is found (`195`), the old `largest` (`120`) must be demoted into `secondLargest` before overwriting `largest`!
