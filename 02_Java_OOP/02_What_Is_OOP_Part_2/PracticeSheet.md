# Practice Sheet: Lesson 02 — What Is OOP? (Part 2: Encapsulation)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/02_What_Is_OOP_Part_2/Exercise.java) to master `private` vs. `public` access modifiers and data hiding.

---

## Problem 1: Access Modifier Visibility Table (Easy)
### Description
In `solveProblem1()`, print the 4 Java access modifiers ordered from **most restrictive** to **least restrictive**:
1. `private`
2. `default (package-private)`
3. `protected`
4. `public`

### Expected Output
```
1. private                   : Visible ONLY within the declaring class
2. default (package-private) : Visible within the same package folder
3. protected                 : Visible within the same package + subclasses anywhere
4. public                    : Visible everywhere across all packages
```
### Edge-Case Hints
- Remember that "default" access is what you get when you omit an access modifier keyword (`int x;` instead of `private int x;`).

---

## Problem 2: Encapsulating `UserCredentials` with a `private` Helper (Medium)
### Description
Complete the `UserCredentials` class in `Exercise.java`:
1. Make both `username` and `password` fields `private`.
2. Implement `public boolean authenticate(String attempt)`: returns `true` if `password.equals(attempt)`, `false` otherwise.
3. Implement `public void updatePassword(String currentPass, String newPass)`:
   - First check `if (!authenticate(currentPass))`: print `"Password update failed: Incorrect current password!"`.
   - Else check `if (!isStrongEnough(newPass))`: print `"Password update failed: New password must be >= 8 chars!"`.
   - Else update `password = newPass;` and print `"Password updated successfully for " + username`.
4. Implement the **private helper method** `private boolean isStrongEnough(String candidate)` that returns `candidate != null && candidate.length() >= 8`.

### Expected Output
```
Update with wrong old pass : Password update failed: Incorrect current password!
Update with short new pass : Password update failed: New password must be >= 8 chars!
Update with valid new pass : Password updated successfully for admin_user
Login with new password    : true
```
### Edge-Case Hints
- Making `isStrongEnough` `private` hides the internal validation rule implementation from outside callers.

---

## Problem 3: Encapsulated `InventoryItem` Stock Guard (Hard)
### Description
Complete the `InventoryItem` class in `Exercise.java`:
- Private fields: `private String sku;` and `private int quantityInStock;`.
- Public methods:
  - `public void restock(int units)`: if `units > 0`, add to `quantityInStock` and print `"Restocked +" + units + " units of " + sku + " (Stock: " + quantityInStock + ")"`.
  - `public boolean fulfillOrder(int requestedUnits)`: if `requestedUnits > 0 && requestedUnits <= quantityInStock`, subtract `requestedUnits` from `quantityInStock`, print `"Fulfilled " + requestedUnits + " units of " + sku + " (Remaining: " + quantityInStock + ")"`, and return `true`; otherwise print `"Order rejected for " + requestedUnits + " units of " + sku + " (Only " + quantityInStock + " in stock)"` and return `false`.

### Expected Output
```
Restocked +50 units of SKU-900 (Stock: 50)
Fulfilled 35 units of SKU-900 (Remaining: 15)
Order rejected for 20 units of SKU-900 (Only 15 in stock)
```
### Edge-Case Hints
- Notice that `quantityInStock` can never drop below `0` because all modifications must pass through `restock` and `fulfillOrder`!
