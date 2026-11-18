# Practice Sheet: Lesson 16 — `break` and `continue` Statements

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/16_Break_And_Continue_Statements/Exercise.java) to master `break`, `continue`, and labeled nested loops.

---

## Problem 1: Skip Multiples of 3 (`continue`) (Easy)
### Description
Implement `solveProblem1()` using a `for` loop from `1` to `10` (`for (int i = 1; i <= 10; i++)`):
- If `i % 3 == 0`, use `continue;` to skip printing that number.
- Otherwise, print `i + " "` on the same line (and print a newline after the loop finishes).

### Expected Output
```
1 2 4 5 7 8 10 
```
### Edge-Case Hints
- Notice that `3`, `6`, and `9` are skipped cleanly by `continue;`.

---

## Problem 2: Stop When Sum Exceeds Limit (`break`) (Medium)
### Description
Implement `solveProblem2(int threshold)` using a `for` loop (`for (int i = 1; i <= 100; i++)`):
- Add `i` to `int sum = 0;`.
- If `sum > threshold`, print `"Threshold " + threshold + " exceeded at i = " + i + " (Sum = " + sum + ")"` and immediately `break;` out of the loop!

### Expected Output
```
Threshold 50 exceeded at i = 10 (Sum = 55)
Threshold 100 exceeded at i = 14 (Sum = 105)
```
### Edge-Case Hints
- Update `sum += i;` **before** checking `if (sum > threshold)`.

---

## Problem 3: Labeled `break` in a 2D Seating Chart Search (Hard)
### Description
In `solveProblem3()`, a 2D array `int[][] seats = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};` represents occupied (`0`) and available (`1`) theater seats.
Attach a label `seatSearch:` to the outer `for` loop (`row`) and search across columns (`col`) for the **very first available seat (`1`)**:
- When `seats[row][col] == 1`, print `"First available seat booked at Row " + row + ", Seat " + col` and execute `break seatSearch;` so no further seats are booked!

### Expected Output
```
First available seat booked at Row 1, Seat 1
```
### Edge-Case Hints
- If you use an unlabeled `break;`, the outer loop will continue to Row 2 and book a second seat at Row 2, Seat 0!
