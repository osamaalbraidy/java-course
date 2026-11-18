# Practice Sheet: Lesson 06 — Create Your First Class (Part 3: The `this` Keyword)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/06_Create_Your_First_Class_Part_3/Exercise.java) to master resolving field shadowing with `this` and building fluent method chains.

---

## Problem 1: Fixing Shadowed Setters in `EmployeeBadge` (Easy)
### Description
In `Exercise.java`, the `EmployeeBadge` class has two broken setters where the developer wrote `fullName = fullName;` and `department = department;` without `this.`.
Fix both setters using `this.fullName = fullName;` and `this.department = department;` so `solveProblem1()` prints the employee's actual name and department instead of `null | null`.

### Expected Output
```
Badge -> Name: Dr. Alan Grant | Department: Paleontology
```
### Edge-Case Hints
- Whenever a parameter has the exact same identifier as an instance field, `this.fieldName` is mandatory to target the instance field!

---

## Problem 2: Comparing Two Instances Using `this` (`isMoreExpensiveThan`) (Medium)
### Description
Inside the `Watch` class in `Exercise.java`, implement:
`public boolean isMoreExpensiveThan(Watch otherWatch)`
which compares `this.price > otherWatch.price` and returns `true` or `false`.
Test it in `solveProblem2()` with `watchA` (`"Omega"`, `$6500.00`) and `watchB` (`"Seiko"`, `$450.00`).

### Expected Output
```
Is Omega ($6500.0) more expensive than Seiko ($450.0)? true
Is Seiko ($450.0) more expensive than Omega ($6500.0)? false
```
### Edge-Case Hints
- Notice that inside `Watch`, a method can access `otherWatch.price` directly because `private` is **class-level** in Java (any `Watch` method can access `private` fields of any `Watch` reference!).

---

## Problem 3: Fluent `PizzaOrder` Builder (`return this;`) (Hard)
### Description
Complete the `PizzaOrder` class in `Exercise.java` so that all three configuration methods return `PizzaOrder` (`return this;`), allowing fluent method chaining:
1. `public PizzaOrder setSize(String size)`: sets `this.size = size;` and returns `this`.
2. `public PizzaOrder setCrust(String crust)`: sets `this.crust = crust;` and returns `this`.
3. `public PizzaOrder addTopping(double toppingPrice)`: increments `this.toppingCount++`, adds `toppingPrice` to `this.basePrice`, and returns `this`.
In `solveProblem3()`, chain `.setSize("Large").setCrust("Thin").addTopping(2.50).addTopping(3.00)` on a new `PizzaOrder` (initial `basePrice = 12.00`) and call `printSummary()`.

### Expected Output
```
Pizza [Size: Large | Crust: Thin | Toppings: 2 | Total: $17.50]
```
### Edge-Case Hints
- Change the return type of the mutator methods from `void` to `PizzaOrder` and end each method with `return this;`.
