# Practice Sheet: Lesson 11 — `switch` Statement (Part 1)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/11_Switch_Statement_Part_1/Exercise.java) to master traditional `switch`, `case`, `break`, and `default`.

---

## Problem 1: Day of the Week Mapper (Easy)
### Description
Implement `solveProblem1(int dayNumber)` using a traditional `switch` statement that prints the name of the day (`1` = `"Monday"`, `2` = `"Tuesday"`, ..., `7` = `"Sunday"`), and `"Invalid day number"` in the `default` branch.

### Expected Output
```
Day 1 : Monday
Day 5 : Friday
Day 7 : Sunday
Day 9 : Invalid day number
```
### Edge-Case Hints
- Don't forget `break;` at the end of every `case`!

---

## Problem 2: Four-Function Calculator with `switch (operator)` (Medium)
### Description
Implement `solveProblem2(double num1, char operator, double num2)` using a `switch (operator)` statement on `'+'`, `'-'`, `'*'`, and `'/'`:
- For `'+'`, `'-'`, `'*'`: compute and print the result formatted as `"%.1f %c %.1f = %.2f%n"`.
- For `'/'`: check if `num2 == 0` first! If `num2 == 0`, print `"Error: Cannot divide by zero!"`, otherwise print the division result.
- For `default`: print `"Error: Unknown operator '" + operator + "'"`.

### Expected Output
```
12.0 + 8.0 = 20.00
12.0 * 8.0 = 96.00
15.0 / 4.0 = 3.75
15.0 / 0.0 -> Error: Cannot divide by zero!
12.0 ^ 2.0 -> Error: Unknown operator '^'
```
### Edge-Case Hints
- Notice you can place an `if-else` statement *inside* `case '/':` to guard against division by zero!

---

## Problem 3: Fixing a Broken ATM Dispenser `switch` (Hard)
### Description
In `solveProblem3(int menuChoice)`, the starter code has a `switch` statement where the previous programmer forgot every single `break;` statement, causing option `1` to execute all four menu actions! Add the missing `break;` statements so each option (`1`, `2`, `3`, and `default`) only executes its own message.

### Expected Output
```
Choice 1 -> [ATM] Displaying Current Account Balance...
Choice 2 -> [ATM] Opening Cash Deposit Slot...
Choice 9 -> [ATM] Invalid Menu Selection.
```
### Edge-Case Hints
- Verify that running `solveProblem3(1)` prints only 1 line, not 4!
