# Practice Sheet: Lesson 13 — `while` Loop Statement

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/13_While_Loop_Statement/Exercise.java) to practice counter-controlled `while` loops and accumulators.

---

## Problem 1: Multiplication Table Generator (Easy)
### Description
Implement `solveProblem1(int number)` using a `while` loop with a counter `int i = 1;` up to `5` (`i <= 5`) that prints the first 5 multiples of `number`.

### Expected Output (for `number = 7`)
```
7 x 1 = 7
7 x 2 = 14
7 x 3 = 21
7 x 4 = 28
7 x 5 = 35
```
### Edge-Case Hints
- Don't forget `i++;` at the bottom of your `while` loop body!

---

## Problem 2: Factorial Accumulator ($n!$) (Medium)
### Description
The factorial of a positive integer $n$ (written $n!$) is the product of all integers from $1$ to $n$:
$$6! = 1 \times 2 \times 3 \times 4 \times 5 \times 6 = 720$$
Implement `solveProblem2(int n)` using a `long factorial = 1L;` accumulator and a `while` loop to compute and print $n!$.

### Expected Output
```
6! = 720
10! = 3628800
```
### Edge-Case Hints
- A multiplicative accumulator must be initialized to `1L` (not `0L`, or multiplying by `0` will keep the result at `0` forever!).

---

## Problem 3: Digit Reverser Algorithm with `while` (Hard)
### Description
Implement `solveProblem3(int number)` to reverse the digits of a positive integer (e.g., `12345` $\rightarrow$ `54321`) using a `while (workingNum > 0)` loop and integer math (`% 10` and `/ 10`):
1. Initialize `int reversed = 0;` and `int workingNum = number;`.
2. While `workingNum > 0`:
   - Extract the last digit: `int lastDigit = workingNum % 10;`
   - Shift `reversed` left by one decimal place and append `lastDigit`: `reversed = (reversed * 10) + lastDigit;`
   - Remove the last digit from `workingNum`: `workingNum /= 10;`
3. Print both the original `number` and `reversed`.

### Expected Output
```
Original: 12345 -> Reversed: 54321
Original: 90807 -> Reversed: 70809
```
### Edge-Case Hints
- Notice how `workingNum /= 10;` shrinks `workingNum` on each iteration until `workingNum` reaches `0`, guaranteeing termination!
