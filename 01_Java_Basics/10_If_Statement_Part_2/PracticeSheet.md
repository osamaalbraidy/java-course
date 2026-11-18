# Practice Sheet: Lesson 10 — `if` Statement (Part 2)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/10_If_Statement_Part_2/Exercise.java) to practice `else if` ladders, logical operators (`&&`, `||`, `!`), and nested conditionals.

---

## Problem 1: Movie Ticket Pricing Tier (`else if` Ladder) (Easy)
### Description
Implement `solveProblem1(int age)` to print the ticket price based on `age`:
- If `age < 0` or `age > 120`: print `"Age " + age + " -> Invalid age"`
- Else if `age <= 12`: print `"Age " + age + " -> Child Ticket: $8.00"`
- Else if `age <= 64`: print `"Age " + age + " -> Adult Ticket: $14.00"`
- Else (`65+`): print `"Age " + age + " -> Senior Ticket: $10.00"`

### Expected Output
```
Age 8 -> Child Ticket: $8.00
Age 34 -> Adult Ticket: $14.00
Age 70 -> Senior Ticket: $10.00
Age -5 -> Invalid age
```
### Edge-Case Hints
- Check for invalid ages (`age < 0 || age > 120`) **first** in your `if` ladder so `-5` doesn't match `age <= 12`!

---

## Problem 2: Gregorian Leap Year Validator (`&&` and `||`) (Medium)
### Description
A year in the Gregorian calendar is a **Leap Year** if:
- It is divisible by `4` (`year % 4 == 0`) **AND** not divisible by `100` (`year % 100 != 0`), **OR**
- It is divisible by `400` (`year % 400 == 0`).

Implement `solveProblem2(int year)` to evaluate this boolean rule and print whether `year` is a `LEAP YEAR` or `COMMON YEAR`.

### Expected Output
```
Year 2024 : LEAP YEAR
Year 1900 : COMMON YEAR
Year 2000 : LEAP YEAR
Year 2026 : COMMON YEAR
```
### Edge-Case Hints
- Notice why `1900` is a common year (divisible by `100` but not `400`) while `2000` is a leap year (divisible by `400`).
- Use parentheses for clarity: `(year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)`.

---

## Problem 3: Progressive Income Tax Bracket Calculator (Hard)
### Description
Implement `solveProblem3(double income, boolean isMarried)` to determine the tax rate percentage:
- First check if `income < 0`: print `"Invalid income"`.
- Otherwise, use nested `if` (or compound `&&`/`||` conditions):
  - If `income > 100000`:
    - Married: `22%` tax rate
    - Single (`!isMarried`): `28%` tax rate
  - Else if `income >= 40000`:
    - Married: `12%` tax rate
    - Single (`!isMarried`): `18%` tax rate
  - Else (`income < 40000`):
    - Both Married and Single: `10%` tax rate
Calculate `double taxAmount = income * (rate / 100.0);` and print:
`printf("Income: $%,9.2f | Married: %-5b | Rate: %d%% | Tax: $%,8.2f%n", income, isMarried, rate, taxAmount)`

### Expected Output
```
Income: $120,000.00 | Married: true  | Rate: 22% | Tax: $26,400.00
Income: $120,000.00 | Married: false | Rate: 28% | Tax: $33,600.00
Income: $ 60,000.00 | Married: false | Rate: 18% | Tax: $10,800.00
Income: $ 25,000.00 | Married: true  | Rate: 10% | Tax: $ 2,500.00
```
### Edge-Case Hints
- Dividing an `int rate` by `100.0` (a `double`) ensures floating-point division rather than integer division!
