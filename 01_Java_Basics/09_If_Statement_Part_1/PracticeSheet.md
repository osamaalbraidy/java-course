# Practice Sheet: Lesson 09 — `if` Statement (Part 1)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/09_If_Statement_Part_1/Exercise.java) to practice relational operators and `if-else` branching.

---

## Problem 1: Even or Odd Number Classifier (Easy)
### Description
Write logic inside `solveProblem1(int number)` that uses the modulo operator (`%`) and an `if-else` statement to check whether `number` is even (`number % 2 == 0`) or odd, and prints the result.
In `main()`, it is tested with `42` and `77`.

### Expected Output
```
Number 42 is EVEN.
Number 77 is ODD.
```
### Edge-Case Hints
- Remember to use `==` (comparison), not `=` (assignment), inside `if (number % 2 == 0)`.

---

## Problem 2: E-Commerce Free Shipping Threshold (Medium)
### Description
An online store charges `$9.99` for shipping unless the customer's `cartSubtotal` is **at least `$50.00`** (`cartSubtotal >= 50.00`), in which case shipping is `$0.00`.
Inside `solveProblem2(double cartSubtotal)`:
1. Determine `double shippingFee` using an `if-else` statement (`0.00` if `cartSubtotal >= 50.00`, otherwise `9.99`).
2. Calculate `double finalTotal = cartSubtotal + shippingFee;`.
3. Print the summary using `printf`: `"Subtotal: $%.2f | Shipping: $%.2f | Total: $%.2f%n"`.

### Expected Output
```
Subtotal: $35.00 | Shipping: $9.99 | Total: $44.99
Subtotal: $50.00 | Shipping: $0.00 | Total: $50.00
```
### Edge-Case Hints
- "At least `$50.00`" means `>= 50.00` (inclusive of `50.00`!). If you use `> 50.00`, an order of exactly `$50.00` will wrongly be charged shipping.

---

## Problem 3: Case-Insensitive Coupon Code Validator (Hard)
### Description
Write logic inside `solveProblem3(String enteredCoupon, double orderAmount)` that checks whether `enteredCoupon` matches `"SAVE20"` **ignoring case** (using `enteredCoupon.equalsIgnoreCase("SAVE20")`):
- If it matches, apply a 20% discount (`orderAmount * 0.80`) and print:
  `"Coupon '" + enteredCoupon + "' VALID -> Final Price: $" + discountedPrice`
- Otherwise, keep the original price and print:
  `"Coupon '" + enteredCoupon + "' INVALID -> Final Price: $" + orderAmount`

### Expected Output
```
Coupon 'save20' VALID -> Final Price: $80.0
Coupon 'WELCOME10' INVALID -> Final Price: $100.0
```
### Edge-Case Hints
- Never compare Strings with `==`. Use `.equalsIgnoreCase("SAVE20")` so `"save20"`, `"Save20"`, and `"SAVE20"` are all accepted!
