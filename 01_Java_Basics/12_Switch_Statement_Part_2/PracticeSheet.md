# Practice Sheet: Lesson 12 — `switch` Statement (Part 2)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/12_Switch_Statement_Part_2/Exercise.java) to practice case grouping, `String` switches, and modern Java 17 `switch` expressions.

---

## Problem 1: Quarter of the Year Classifier (Case Grouping) (Easy)
### Description
Implement `solveProblem1(int month)` to map a month number (`1` to `12`) to its fiscal quarter:
- Months `1, 2, 3` $\rightarrow$ `"Q1 (First Quarter)"`
- Months `4, 5, 6` $\rightarrow$ `"Q2 (Second Quarter)"`
- Months `7, 8, 9` $\rightarrow$ `"Q3 (Third Quarter)"`
- Months `10, 11, 12` $\rightarrow$ `"Q4 (Fourth Quarter)"`
- Any other number $\rightarrow$ `"Invalid Month"`

### Expected Output
```
Month 2  -> Q1 (First Quarter)
Month 6  -> Q2 (Second Quarter)
Month 11 -> Q4 (Fourth Quarter)
Month 15 -> Invalid Month
```
### Edge-Case Hints
- You can use either stacked `case 1: case 2: case 3:` labels or Java 17 `case 1, 2, 3 ->`.

---

## Problem 2: Cloud Region Latency Lookup (`switch` on `String`) (Medium)
### Description
Implement `solveProblem2(String regionCode)`:
1. Normalize `regionCode` using `regionCode.trim().toLowerCase()`.
2. Switch on the normalized string:
   - `"us-east"` or `"us-west"` $\rightarrow$ `"North America Cluster (25ms)"`
   - `"eu-central"` or `"eu-west"` $\rightarrow$ `"Europe Cluster (40ms)"`
   - `"ap-south"` or `"ap-east"` $\rightarrow$ `"Asia-Pacific Cluster (65ms)"`
   - `default` $\rightarrow$ `"Unknown Region"`

### Expected Output
```
Region 'US-EAST'    -> North America Cluster (25ms)
Region 'eu-central' -> Europe Cluster (40ms)
Region 'ap-east'    -> Asia-Pacific Cluster (65ms)
Region 'sa-east'    -> Unknown Region
```
### Edge-Case Hints
- Normalizing with `.toLowerCase()` means your `case` labels must be all lowercase (`"us-east"`, not `"US-EAST"`).

---

## Problem 3: Modern Java 17 `switch` Expression with `yield` (Hard)
### Description
Implement `solveProblem3(String gradeCode, int extraCreditPoints)` using a **Java 17 `switch` expression** (`int basePoints = switch (gradeCode) { ... };`) that returns GPA base points:
- `"A"` $\rightarrow$ `90`
- `"B"` $\rightarrow$ `80`
- `"C"` $\rightarrow$ `70`
- `"D", "F"` $\rightarrow$ use a `{ ... }` block that adds `extraCreditPoints` to `50` and returns it via `yield 50 + extraCreditPoints;`
- `default` $\rightarrow$ `0`
Print `"Grade " + gradeCode + " (Extra +" + extraCreditPoints + ") -> Total Score: " + basePoints`.

### Expected Output
```
Grade A (Extra +5) -> Total Score: 90
Grade D (Extra +8) -> Total Score: 58
Grade Z (Extra +5) -> Total Score: 0
```
### Edge-Case Hints
- Remember to put a semicolon `;` after the closing brace `};` of a `switch` expression assignment!
