# Practice Sheet: Lesson 13.1 — Flag-Controlled `while` Loop (Part 1)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/13_1_Flag_Controlled_While_Loop_Part_1/Exercise.java) to master boolean flags and input validation loops.

---

## Problem 1: Exam Score Validation Loop (Easy)
### Description
In `solveProblem1()`, a `Scanner` provides simulated exam score entries: `"-15 108 150 88 92"`.
Use a boolean flag `boolean isValidScore = false;` and a `while (!isValidScore)` loop to read integers from `scanner.nextInt()`:
- If the score is between `0` and `100` inclusive (`score >= 0 && score <= 100`), flip `isValidScore = true;` and print `"Accepted valid exam score: " + score`.
- Otherwise, print `"Invalid score (" + score + "). Must be 0..100."`.

### Expected Output
```
Invalid score (-15). Must be 0..100.
Invalid score (108). Must be 0..100.
Invalid score (150). Must be 0..100.
Accepted valid exam score: 88
```
### Edge-Case Hints
- Notice that `92` is never read because `88` flips `isValidScore = true;` and stops the loop!

---

## Problem 2: Temperature Thermostat Stabilization Flag (Medium)
### Description
A smart cooling system starts at `int currentTemp = 30;` degrees Celsius and wants to reach `int targetTemp = 22;`.
Use a boolean flag `boolean isStabilized = false;` and loop `while (!isStabilized)`:
- If `currentTemp > targetTemp`, decrease `currentTemp -= 2;` and print `"Cooling... Current Temp: " + currentTemp + "C"`.
- If `currentTemp <= targetTemp`, flip `isStabilized = true;` and print `"Thermostat stabilized at " + currentTemp + "C!"`.

### Expected Output
```
Cooling... Current Temp: 28C
Cooling... Current Temp: 26C
Cooling... Current Temp: 24C
Cooling... Current Temp: 22C
Thermostat stabilized at 22C!
```
### Edge-Case Hints
- You can either check `if (currentTemp <= targetTemp)` right after cooling or on the next pass of the loop; notice the expected output prints `"Thermostat stabilized at 22C!"` once `22C` is reached.

---

## Problem 3: Password Strength Validator Loop (Hard)
### Description
In `solveProblem3()`, a `Scanner` contains candidate passwords separated by spaces:
`"12345" "java" "pass123" "SecurePass2026"`
A valid password must have a length of **at least 10 characters** (`candidate.length() >= 10`).
Use a boolean flag `boolean isStrongPassword = false;` and loop `while (!isStrongPassword && scanner.hasNext())`:
- Read `String candidate = scanner.next();`
- If `candidate.length() >= 10`, flip `isStrongPassword = true;` and print `"Password ACCEPTED: \"" + candidate + "\" (Length: " + candidate.length() + ")"`
- Otherwise, print `"Password REJECTED: \"" + candidate + "\" (Too short: " + candidate.length() + " chars)"`

### Expected Output
```
Password REJECTED: "12345" (Too short: 5 chars)
Password REJECTED: "java" (Too short: 4 chars)
Password REJECTED: "pass123" (Too short: 7 chars)
Password ACCEPTED: "SecurePass2026" (Length: 14)
```
### Edge-Case Hints
- Use `candidate.length()` to check the number of characters in a `String`.
