# Practice Sheet: Lesson 14 — `do-while` Loop Statement

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/14_Do_While_Loop_Statement/Exercise.java) to practice post-test loops and menu-driven programs.

---

## Problem 1: Dice Roll Until Six (`do-while`) (Easy)
### Description
In `solveProblem1()`, an array `int[] simulatedRolls = {3, 5, 2, 6, 4};` represents a sequence of 6-sided dice rolls.
Use a `do-while` loop to pull rolls from `simulatedRolls` one by one (`int roll = simulatedRolls[index++];`):
- Print `"Roll #" + index + ": " + roll`
- Continue looping `while (roll != 6);`
- After the loop finishes, print `"Rolled a 6 after " + index + " rolls!"`.

### Expected Output
```
Roll #1: 3
Roll #2: 5
Roll #3: 2
Roll #4: 6
Rolled a 6 after 4 rolls!
```
### Edge-Case Hints
- Declare `int roll;` **before** the `do` block so `while (roll != 6);` can see it!

---

## Problem 2: "Continue Playing? (y/n)" Game Loop (Medium)
### Description
In `solveProblem2()`, a `Scanner` contains user responses `"y Y n"`.
Use a `do-while` loop to track `int roundsPlayed = 0;`:
- Increment `roundsPlayed++`.
- Read `String response = scanner.next();`
- Print `"Completed Game Round #" + roundsPlayed + " | Play again? " + response`
- Continue looping `while (response.equalsIgnoreCase("y"));`
- Print `"Game Over! Total rounds played: " + roundsPlayed`.

### Expected Output
```
Completed Game Round #1 | Play again? y
Completed Game Round #2 | Play again? Y
Completed Game Round #3 | Play again? n
Game Over! Total rounds played: 3
```
### Edge-Case Hints
- Using `.equalsIgnoreCase("y")` handles both lowercase `"y"` and uppercase `"Y"`.

---

## Problem 3: Menu-Driven Unit Converter CLI (Hard)
### Description
In `solveProblem3()`, a `Scanner` provides menu selections and values: `"1 10.0 2 50.0 0"`.
Menu options:
- `1`: Convert Kilometers to Miles ($\text{miles} = \text{km} \times 0.621371$). Read `double km = scanner.nextDouble();` and print `printf("%.1f km = %.2f miles%n", km, miles)`.
- `2`: Convert Kilograms to Pounds ($\text{lbs} = \text{kg} \times 2.20462$). Read `double kg = scanner.nextDouble();` and print `printf("%.1f kg = %.2f lbs%n", kg, lbs)`.
- `0`: Print `"Converter closed."` and exit the `do-while (option != 0);` loop.

### Expected Output
```
10.0 km = 6.21 miles
50.0 kg = 110.23 lbs
Converter closed.
```
### Edge-Case Hints
- Remember the semicolon `;` after `while (option != 0);`.
