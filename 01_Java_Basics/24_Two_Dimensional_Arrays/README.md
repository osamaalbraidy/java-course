# Lesson 24: Two-Dimensional Arrays (2D Matrices, Row/Column Traversal & Jagged Arrays)

## 1. What Is a Two-Dimensional (2D) Array in Java?
A **2D array** (`int[][] matrix`) represents a grid or table of rows and columns (like a spreadsheet, chessboard, or image pixel grid).

Under the hood on the JVM Heap, a 2D array in Java is actually an **"array of arrays"**:
- The outer array (`matrix`) holds references to each **row** array (`matrix[row]`).
- Each row array (`matrix[row]`) holds the actual **column elements** (`matrix[row][col]`).

```
int[][] grid = {
    {10, 20, 30},   // Row 0 -> grid[0][0]=10, grid[0][1]=20, grid[0][2]=30
    {40, 50, 60}    // Row 1 -> grid[1][0]=40, grid[1][1]=50, grid[1][2]=60
};
```
- **Number of Rows**: `grid.length` (here `2`).
- **Number of Columns in Row `r`**: `grid[r].length` (here `3`).

---

## 2. Row-Major vs. Column-Major Traversal

### A. Row-Major Traversal (Row by Row — Standard)
Outer loop iterates over **rows** (`r`), inner loop iterates over **columns** (`c`) inside that row:
```java
for (int r = 0; r < matrix.length; r++) {
    for (int c = 0; c < matrix[r].length; c++) {
        System.out.print(matrix[r][c] + " ");
    }
    System.out.println();
}
```

### B. Column-Major Traversal (Column by Column — For Rectangular Matrices)
Outer loop iterates over **columns** (`c`), inner loop iterates down the **rows** (`r`):
```java
for (int c = 0; c < matrix[0].length; c++) {
    for (int r = 0; r < matrix.length; r++) {
        // Processes all elements in column `c` from top to bottom
    }
}
```

---

## 3. Jagged (Ragged) Arrays
Because a Java 2D array is an array of 1D row arrays, **each row can have a different length**! A 2D array with uneven row lengths is called a **Jagged Array**:

```java
int[][] jagged = new int[3][]; // Allocate 3 row slots first
jagged[0] = new int[]{1, 2};
jagged[1] = new int[]{3, 4, 5, 6};
jagged[2] = new int[]{7};
```
> **Always use `matrix[r].length` (NOT `matrix.length` or `matrix[0].length`) as the upper bound of your inner column loop** so your code works safely on rectangular, square, and jagged arrays alike!

---

## 4. Common Pitfalls
1. **Using `matrix.length` for Both Loops on a Non-Square Matrix**:
   - If `matrix` has `2` rows and `5` columns (`new int[2][5]`), `matrix.length` is `2` and `matrix[r].length` is `5`. Using `matrix.length` for the column loop only visits 2 columns; if `matrix` has `5` rows and `2` columns, it throws `ArrayIndexOutOfBoundsException`!
2. **Printing a 2D Array with `Arrays.toString(matrix)`**:
   - `Arrays.toString(matrix)` only prints the memory addresses of the inner row arrays (`[[I@..., [I@...]`).
   - **Fix**: Use **`Arrays.deepToString(matrix)`** for 2D/multi-dimensional arrays!

---

## 5. Real-World Use Cases
- **Student Gradebooks & Financial Spreadsheets**: Rows represent students/regions; columns represent exams/quarters.
- **Matrix Math & Game Boards**: Chessboards (`char[8][8]`), Tic-Tac-Toe, Sudoku (`int[9][9]`), and 3D graphics transformation matrices.
