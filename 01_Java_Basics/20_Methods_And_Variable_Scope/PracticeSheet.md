# Practice Sheet: Lesson 20 — Methods and Variable Scope

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/20_Methods_And_Variable_Scope/Exercise.java) to master block scope, method scope, and variable shadowing.

---

## Problem 1: Fixing an Out-of-Scope `if`-Block Variable (Easy)
### Description
In `solveProblem1(int orderTotal)`, a junior developer declared `String discountLabel` *inside* the `if` block and `else` block, causing a compile error when trying to print `discountLabel` after the `if-else` statement:
```java
// if (orderTotal >= 100) {
//     String discountLabel = "VIP_20_PERCENT";
// } else {
//     String discountLabel = "STANDARD_5_PERCENT";
// }
// System.out.println("Order $" + orderTotal + " -> " + discountLabel);
```
Fix the scope issue by declaring `String discountLabel;` **before** the `if-else` block, assigning it inside each branch, and printing the result.

### Expected Output
```
Order $150 -> VIP_20_PERCENT
Order $45 -> STANDARD_5_PERCENT
```
### Edge-Case Hints
- Make sure you remove the duplicate `String` type keyword inside the `if` and `else` blocks once `String discountLabel;` is declared above them!

---

## Problem 2: Resolving Variable Shadowing (Medium)
### Description
`Exercise` has a class-level static variable `static int taxRatePercent = 8;`.
Inside `solveProblem2()`:
1. Declare a local variable `int taxRatePercent = 15;` (which shadows the class-level variable).
2. Print the local variable (`15%`) and the shadowed class-level variable (`8%` via `Exercise.taxRatePercent`).

### Expected Output
```
Local Special Tax Rate  : 15%
Global Default Tax Rate : 8%
```
### Edge-Case Hints
- Prefixing with the class name (`Exercise.taxRatePercent`) bypasses the local variable and accesses the `static` class variable directly.

---

## Problem 3: Shared Static Counter vs. Local Call Counter (Hard)
### Description
`Exercise` declares `static int totalApiCalls = 0;`.
Implement `public static void simulateEndpointHit(String endpointName)` so that:
1. It increments the class-level `totalApiCalls++`.
2. It declares a method-local variable `int localPayloadBytes = 256;` and adds `128` to it (`localPayloadBytes += 128;`).
3. It prints: `"Hit " + endpointName + " | Call #" + totalApiCalls + " | Local Payload: " + localPayloadBytes + "B"`.
Call `simulateEndpointHit` three times in `solveProblem3()` to see how `totalApiCalls` persists (`1, 2, 3`) while `localPayloadBytes` is recreated fresh (`384B`) on every call!

### Expected Output
```
Hit /login | Call #1 | Local Payload: 384B
Hit /orders | Call #2 | Local Payload: 384B
Hit /logout | Call #3 | Local Payload: 384B
```
### Edge-Case Hints
- Notice why `localPayloadBytes` is always `384B`: its stack memory is destroyed each time `simulateEndpointHit` returns!
