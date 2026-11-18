# Practice Sheet: Lesson 08 — Arithmetic Operators (Part 2)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/08_Arithmetic_Operators_Part_2/Exercise.java) to master `++`/`--`, compound assignments, and operator precedence.

---

## Problem 1: Pre- vs. Post-Increment Trace (Easy)
### Description
Start with `int x = 5;` and `int y = 5;`:
1. Compute `int a = ++x * 2;` (Pre-increment `x` first, then multiply by `2`).
2. Compute `int b = y++ * 2;` (Multiply `y`'s old value by `2` first, then post-increment `y`).
3. Print `a`, `x`, `b`, and `y`.

### Expected Output
```
Pre-increment  -> a: 12, x: 6
Post-increment -> b: 10, y: 6
```
### Edge-Case Hints
- Notice that both `x` and `y` end up at `6`, but `a` is `12` (`6 * 2`) while `b` is `10` (`5 * 2`).

---

## Problem 2: Wallet Balance Tracker with Compound Assignments (Medium)
### Description
Start with `int balance = 200;` and apply the following five transactions in sequence using **only compound assignment operators** (`+=`, `-=`, `*=`, `/=`, `%=`):
1. Deposit `75` (`+=`)
2. Spend `35` (`-=`)
3. Double the balance via a promotional match (`*=`)
4. Split the balance equally among `3` accounts (`/=`)
5. Keep only the remainder after buying `$50` gift cards (`%=`)
Print the balance after each step.

### Expected Output
```
After += 75 : 275
After -= 35 : 240
After *= 2  : 480
After /= 3  : 160
After %= 50 : 10
```
### Edge-Case Hints
- Modify the existing `balance` variable at each step rather than creating new variables.

---

## Problem 3: Fixing Precedence Bugs with Parentheses (Hard)
### Description
A physics formula calculates the average of three velocities (`v1 = 12.0`, `v2 = 18.0`, `v3 = 30.0`) divided by the sum of two time intervals (`t1 = 2.0`, `t2 = 3.0`):
$$\text{Result} = \frac{(v_1 + v_2 + v_3) / 3.0}{t_1 + t_2}$$
A student wrote `double buggy = v1 + v2 + v3 / 3.0 / t1 + t2;` without parentheses.
1. Print `buggy` to see what happens without parentheses (`12.0 + 18.0 + ((30.0 / 3.0) / 2.0) + 3.0 = 38.0`).
2. Write the properly parenthesized expression `double correct = ((v1 + v2 + v3) / 3.0) / (t1 + t2);` and print `correct` (`20.0 / 5.0 = 4.0`).

### Expected Output
```
Without Parentheses (Buggy)  : 38.0
With Parentheses (Correct)   : 4.0
```
### Edge-Case Hints
- Both the numerator average `(v1 + v2 + v3) / 3.0` and the denominator `(t1 + t2)` need parentheses so `/` doesn't bind only to `v3` and `t1`.
