# Practice Sheet: Lesson 17 — Revision: Loops and Conditionals

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/17_Revision_Loops_And_Conditionals/Exercise.java) to review combining conditionals and loops.

---

## Problem 1: Classic FizzBuzz Interview Challenge (`for` + `if-else if`) (Easy)
### Description
Implement `solveProblem1(int n)` to loop from `1` to `n` (`for (int i = 1; i <= n; i++)`) and print each output separated by a space:
- If `i` is divisible by **both 3 and 5** (`i % 15 == 0`): print `"FizzBuzz "`
- Else if `i` is divisible by **3** (`i % 3 == 0`): print `"Fizz "`
- Else if `i` is divisible by **5** (`i % 5 == 0`): print `"Buzz "`
- Else: print `i + " "`
Print a newline at the end.

### Expected Output (for `n = 15`)
```
1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 
```
### Edge-Case Hints
- Always test `i % 3 == 0 && i % 5 == 0` **first**! If you test `i % 3 == 0` first, `15` will print `"Fizz"` and skip the `"FizzBuzz"` branch.

---

## Problem 2: Prime Number Finder in Range (`for` + Nested `for` + `break`) (Medium)
### Description
Implement `solveProblem2(int start, int end)` to find and print all **prime numbers** between `start` and `end` (inclusive).
- For each candidate `num` from `start` to `end` (where `num >= 2`):
  - Assume `boolean isPrime = true;`.
  - Loop divisor `d` from `2` while `d * d <= num`.
  - If `num % d == 0`, set `isPrime = false;` and `break;` out of the inner loop.
  - After the inner loop, if `isPrime` is still `true`, print `num + " "`.

### Expected Output (for `start = 10, end = 30`)
```
Primes [10..30]: 11 13 17 19 23 29 
```
### Edge-Case Hints
- Declare `boolean isPrime = true;` *inside* the outer loop so it resets to `true` for each new candidate number!

---

## Problem 3: Mini-ATM Transaction Log Analyzer (Hard)
### Description
In `solveProblem3()`, a `Scanner` contains transaction codes and amounts ending with `"END"`:
`"DEP 500.0 WITH 200.0 WITH 900.0 DEP -50.0 DEP 150.0 END"`
Start with `double balance = 300.0;`, `int approvedCount = 0;`, and `int declinedCount = 0;`.
Loop while `scanner.hasNext()`:
1. Read `String type = scanner.next();`. If `type.equals("END")`, `break;`.
2. Read `double amount = scanner.nextDouble();`.
3. If `amount <= 0`, increment `declinedCount` and `continue;`.
4. Switch on `type`:
   - `"DEP"`: add `amount` to `balance` and increment `approvedCount`.
   - `"WITH"`: if `amount <= balance`, subtract `amount` from `balance` and increment `approvedCount`; otherwise increment `declinedCount`.
Print the final summary: `printf("Final Balance: $%.2f | Approved: %d | Declined: %d%n", balance, approvedCount, declinedCount)`.

### Expected Output
```
Final Balance: $750.00 | Approved: 3 | Declined: 2
```
### Edge-Case Hints
- Notice `WITH 900.0` (exceeds `$600` balance at that moment) and `DEP -50.0` (negative amount) are the 2 declined transactions!
