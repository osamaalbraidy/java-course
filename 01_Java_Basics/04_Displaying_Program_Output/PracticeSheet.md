# Practice Sheet: Lesson 04 — Displaying Program Output

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/04_Displaying_Program_Output/Exercise.java) to master `print`, `println`, `printf`, and escape sequences.

---

## Problem 1: Escape Sequence Directory Card (Easy)
### Description
Using a **single** `System.out.println(...)` statement containing `\n`, `\t`, `\"`, and `\\`, display the following developer profile card:

### Expected Output
```
Developer : "Ada Lovelace"
Workspace : C:\Dev\Java\Projects
Skills    : Java	SQL	Git
```
### Edge-Case Hints
- Notice that `Java`, `SQL`, and `Git` are separated by `\t` (tab), the name has escaped quotes `\"`, and the Windows path uses escaped backslashes `\\`.

---

## Problem 2: Progress Bar with `print` and `println` (Medium)
### Description
Use multiple `System.out.print(...)` statements (and a final `println`) to assemble the following single-line status output step by step:
1. Print `"Downloading SDK: ["`
2. Print `"####"`
3. Print `"####"`
4. Print `"..] "`
5. Print `80` followed by `"% Complete"` and end the line.

### Expected Output
```
Downloading SDK: [########..] 80% Complete
```
### Edge-Case Hints
- Only the very last statement should be `println` so everything stays on one line!

---

## Problem 3: Formatted Café Receipt with `printf` (Hard)
### Description
Given three items:
- `"Espresso"` (Qty: `2`, Price: `3.50`)
- `"Croissant"` (Qty: `1`, Price: `4.25`)
- `"Matcha Latte"` (Qty: `3`, Price: `5.75`)

Use `System.out.printf` to print a receipt table where:
- Column 1 (`Item`) is left-aligned, 15 characters wide (`%-15s`)
- Column 2 (`Qty`) is right-aligned, 3 characters wide (`%3d`)
- Column 3 (`Price`) is prefixed with `$` and formatted to 2 decimal places (`$%6.2f`)

### Expected Output
```
ITEM            | QTY |   PRICE
----------------+-----+--------
Espresso        |   2 | $  3.50
Croissant       |   1 | $  4.25
Matcha Latte    |   3 | $  5.75
```
### Edge-Case Hints
- Always end your `printf` format string with `%n` so each row starts on a new line.
