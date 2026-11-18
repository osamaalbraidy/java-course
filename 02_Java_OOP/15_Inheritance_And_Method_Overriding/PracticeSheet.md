# Practice Sheet: Lesson 15 — Inheritance and Method Overriding

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/15_Inheritance_And_Method_Overriding/Exercise.java).

---

## Problem 1: Overriding vs. Overloading Comparison Table (Easy)
### Description
In `solveProblem1()`, print the 4 core distinctions between Method Overriding and Method Overloading.

### Expected Output
```
1. Parameters   : Overriding keeps IDENTICAL parameters; Overloading requires DIFFERENT parameters
2. Class Scope  : Overriding requires Superclass/Subclass; Overloading can be in the SAME class
3. Binding Time : Overriding uses Runtime Dynamic Dispatch; Overloading uses Compile-Time Binding
4. Annotation   : Overriding uses @Override; Overloading does NOT use @Override
```
### Edge-Case Hints
- Always add `@Override` when overriding so the compiler protects you from signature typos!

---

## Problem 2: Overriding with `super.method()` in `CoffeeOrder` & `SpecialtyLatteOrder` (Medium)
### Description
Create a base class `CoffeeOrder` (`size`, `basePrice`, `public double getCost()`, `public String getDescription()`) and a subclass `SpecialtyLatteOrder extends CoffeeOrder` (`syrupFlavor`, `oatMilk`):
- Override `getCost()` in `SpecialtyLatteOrder` to call `super.getCost()` and add `$0.75` for the syrup plus `$1.00` if `oatMilk` is `true`.
- Override `getDescription()` to append `" + " + syrupFlavor + " Syrup"` (and `" + Oat Milk"` if `oatMilk` is `true`) to `super.getDescription()`.

### Expected Output
```
Base Order      : Large Coffee -> $3.50
Specialty Order : Large Coffee + Vanilla Syrup + Oat Milk -> $5.25
```
### Edge-Case Hints
- Calling `super.getCost()` inside `@Override public double getCost()` avoids infinite recursion (calling `this.getCost()` inside `getCost()` would call itself forever!).

---

## Problem 3: Bank Account Withdrawal Fee Override (`CheckingAccount` -> `FeeCheckingAccount`) (Hard)
### Description
In `CheckingAccount`, `public boolean withdraw(double amount)` deducts `amount` from `balance` if `amount <= balance`.
In `FeeCheckingAccount extends CheckingAccount`, every withdrawal incurs a flat `$2.50` transaction fee!
Override `withdraw(double amount)` in `FeeCheckingAccount` so it delegates `return super.withdraw(amount + 2.50);`!

### Expected Output
```
Standard Checking ($200 - $50)     -> Approved: true  | Remaining: $150.00
Fee Checking      ($200 - $50-$2.5)-> Approved: true  | Remaining: $147.50
Fee Checking Overdraft ($147.50)   -> Approved: false | Remaining: $147.50
```
### Edge-Case Hints
- Notice how `return super.withdraw(amount + 2.50);` reuses all of the parent's balance check and deduction logic in a single line!
