# Practice Sheet: Lesson 15 — `for` Loop Statement

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/15_For_Loop_Statement/Exercise.java) to master `for` loops, nested loops, and pattern printing.

---

## Problem 1: Sum of Odd Numbers from `1` to `N` (Easy)
### Description
Implement `solveProblem1(int n)` using a `for` loop that steps by `2` (`for (int i = 1; i <= n; i += 2)`) to sum all odd numbers from `1` up to `n`, then print the sum.

### Expected Output
```
Sum of odd numbers up to 10 : 25
Sum of odd numbers up to 19 : 100
```
### Edge-Case Hints
- Notice that stepping by `i += 2` starting at `1` visits `1, 3, 5, 7, 9...` directly without needing an `if` check!

---

## Problem 2: Hollow Square Border Pattern (Medium)
### Description
Implement `solveProblem2(int size)` using nested `for` loops (`row` from `1` to `size`, `col` from `1` to `size`) to print a hollow square of `'#'` characters:
- If `row == 1 || row == size || col == 1 || col == size`, print `"# "`.
- Otherwise, print `"  "` (two spaces).
- Print a newline after each row.

### Expected Output (for `size = 4`)
```
# # # # 
#     # 
#     # 
# # # # 
```
### Edge-Case Hints
- Use `System.out.print` inside the inner loop and `System.out.println()` at the end of the outer loop.

---

## Problem 3: Inverted Number Staircase Pattern (Hard)
### Description
Implement `solveProblem3(int rows)` using nested `for` loops so that row 1 prints `1 2 3 4 5`, row 2 prints `1 2 3 4`, ..., down to `1`:
- Outer loop: `for (int r = rows; r >= 1; r--)`
- Inner loop: `for (int c = 1; c <= r; c++)`, printing `c + " "`

### Expected Output (for `rows = 5`)
```
1 2 3 4 5 
1 2 3 4 
1 2 3 
1 2 
1 
```
### Edge-Case Hints
- Counting the outer loop **down** (`r = rows; r >= 1; r--`) makes the inner loop limit (`c <= r`) shrink automatically on each row!
