# Practice Sheet: Lesson 13.2 — Flag-Controlled `while` Loop (Part 2)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/13_2_Flag_Controlled_While_Loop_Part_2/Exercise.java) to master sentinel values and multi-condition `while` loops.

---

## Problem 1: Charity Donation Tracker with Sentinel `0` (Easy)
### Description
In `solveProblem1()`, a `Scanner` contains donation amounts ending with the sentinel `0`:
`"50 120 30 200 0 500"`
Use a boolean flag `boolean isFinished = false;` and loop `while (!isFinished && scanner.hasNextInt())`:
- Read `int amount = scanner.nextInt();`
- If `amount == 0` (the sentinel), set `isFinished = true;`.
- Otherwise, add `amount` to `totalDonations` and increment `donorCount`.
- Print `"Donors: " + donorCount + " | Total Raised: $" + totalDonations`.

### Expected Output
```
Donors: 4 | Total Raised: $400
```
### Edge-Case Hints
- Make sure `0` is not counted as a 5th donor, and `500` (which appears after `0`) is never read!

---

## Problem 2: Server Log Error Monitor (Sentinel `"EOF"` or Threshold Flag) (Medium)
### Description
A log analyzer reads severity tags (`"INFO"`, `"WARN"`, `"ERROR"`) from a `Scanner` until **either**:
1. It encounters the sentinel word `"EOF"`, **OR**
2. The count of `"ERROR"` tags reaches `3` (`criticalThresholdReached = true`).

Given the simulated stream `"INFO ERROR WARN ERROR INFO ERROR INFO EOF"` in `solveProblem2()`:
- Track `int totalLogsRead = 0;` and `int errorCount = 0;`.
- When `"EOF"` is read, flip `endOfStream = true;` (do not count `"EOF"` in `totalLogsRead`).
- Otherwise increment `totalLogsRead`. If the tag equals `"ERROR"`, increment `errorCount`; if `errorCount == 3`, flip `criticalThresholdReached = true;` and print `"ALERT: 3 errors detected! Halting log scan."`.
- After the loop, print `"Logs Processed: " + totalLogsRead + " | Errors Found: " + errorCount`.

### Expected Output
```
ALERT: 3 errors detected! Halting log scan.
Logs Processed: 6 | Errors Found: 3
```
### Edge-Case Hints
- Use `while (!endOfStream && !criticalThresholdReached && scanner.hasNext())`.

---

## Problem 3: Multi-Condition ATM PIN Lockout System (Hard)
### Description
Implement `solveProblem3(String inputStream)` where `final int SECRET_PIN = 4321;`, `final int CANCEL_SENTINEL = -1;`, and `final int MAX_ATTEMPTS = 3;`.
The loop should continue while `!isUnlocked && !isCancelled && attempts < MAX_ATTEMPTS && scanner.hasNextInt()`:
- Read `int enteredPin = scanner.nextInt();`
- If `enteredPin == CANCEL_SENTINEL`, flip `isCancelled = true;` and print `"[Cancelled] User pressed Cancel (-1)."`
- Else:
  - Increment `attempts++`.
  - If `enteredPin == SECRET_PIN`, flip `isUnlocked = true;` and print `"[Unlocked] PIN accepted on attempt #" + attempts + "!"`
  - Else print `"[Failed] Wrong PIN (" + enteredPin + ") - Attempt " + attempts + "/" + MAX_ATTEMPTS`
- After the loop, if `!isUnlocked && !isCancelled && attempts == MAX_ATTEMPTS`, print `"[LOCKED] Account locked after 3 failed attempts!"`.

### Expected Output
```
--- Test A: Wrong twice, then correct ---
[Failed] Wrong PIN (1111) - Attempt 1/3
[Failed] Wrong PIN (2222) - Attempt 2/3
[Unlocked] PIN accepted on attempt #3!
--- Test B: 3 wrong attempts (Lockout) ---
[Failed] Wrong PIN (1111) - Attempt 1/3
[Failed] Wrong PIN (2222) - Attempt 2/3
[Failed] Wrong PIN (3333) - Attempt 3/3
[LOCKED] Account locked after 3 failed attempts!
--- Test C: User cancels with -1 ---
[Failed] Wrong PIN (9999) - Attempt 1/3
[Cancelled] User pressed Cancel (-1).
```
### Edge-Case Hints
- Check `if (enteredPin == CANCEL_SENTINEL)` **before** incrementing `attempts++` so cancelling doesn't count as a failed PIN attempt!
