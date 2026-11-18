# Practice Sheet: Lesson 24 — Two-Dimensional Arrays

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/24_Two_Dimensional_Arrays/Exercise.java) to master 2D array traversal, matrix diagonals, and jagged arrays.

---

## Problem 1: Sum & Maximum of All Elements in a 2D Matrix (Easy)
### Description
Given `int[][] salesGrid = {{120, 150, 90}, {200, 180, 240}};` in `solveProblem1()`, use nested loops (either index-based or enhanced `for (int[] row : salesGrid)` / `for (int cell : row)`) to find and print:
- The `totalSales` sum of all 6 elements.
- The `highestCell` value across the entire 2D grid.

### Expected Output
```
Total Matrix Sales : $980 | Highest Single Cell : $240
```
### Edge-Case Hints
- Initialize `int highestCell = salesGrid[0][0];` before starting your nested loops.

---

## Problem 2: Square Matrix Main Diagonal & Anti-Diagonal Sum (Medium)
### Description
Given a $3 \times 3$ square matrix `int[][] square = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};` of size `int n = square.length;`:
- **Main Diagonal** elements are where `row == col` (`square[i][i]`: `1, 5, 9` $\rightarrow$ sum `15`).
- **Anti-Diagonal (Secondary Diagonal)** elements are at `square[i][n - 1 - i]` (`3, 5, 7` $\rightarrow$ sum `15`).
Compute and print both sums using a single `for (int i = 0; i < n; i++)` loop!

### Expected Output
```
Main Diagonal Sum : 15 | Anti-Diagonal Sum : 15
```
### Edge-Case Hints
- Notice you don't even need a nested loop to sum the diagonals of an $N \times N$ matrix: a single loop `i = 0..n-1` indexes `square[i][i]` and `square[i][n - 1 - i]` in $O(N)$ time!

---

## Problem 3: Matrix Transpose ($R \times C \rightarrow C \times R$) (Hard)
### Description
The **transpose** of an $R \times C$ matrix flips its rows and columns into a new $C \times R$ matrix where:
$$\text{transposed}[c][r] = \text{original}[r][c]$$
Given a $2 \times 3$ matrix `int[][] original = {{10, 20, 30}, {40, 50, 60}};` in `solveProblem3()`:
1. Allocate `int[][] transposed = new int[original[0].length][original.length];` (a $3 \times 2$ matrix).
2. Use nested loops to copy `transposed[c][r] = original[r][c];`.
3. Print both `Arrays.deepToString(original)` and `Arrays.deepToString(transposed)`.

### Expected Output
```
Original (2x3)   : [[10, 20, 30], [40, 50, 60]]
Transposed (3x2) : [[10, 40], [20, 50], [30, 60]]
```
### Edge-Case Hints
- Pay close attention to the dimensions of `transposed`: its row count is `original[0].length` (`3`), and its column count is `original.length` (`2`)!
