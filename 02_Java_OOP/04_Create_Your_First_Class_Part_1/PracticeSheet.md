# Practice Sheet: Lesson 04 — Create Your First Class (Part 1)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/04_Create_Your_First_Class_Part_1/Exercise.java) to practice defining classes, inspecting default field values, and invoking instance methods.

---

## Problem 1: Default Instance Field Inspector (Easy)
### Description
In `solveProblem1()`, instantiate a `new LaptopAsset()` without setting any of its fields (`modelName`, `ramGb`, `purchasePrice`, `isAssigned`), and print its 4 default field values.

### Expected Output
```
Default modelName     : null
Default ramGb         : 0
Default purchasePrice : 0.0
Default isAssigned    : false
```
### Edge-Case Hints
- Notice that `String` defaults to `null`, `int` to `0`, `double` to `0.0`, and `boolean` to `false`.

---

## Problem 2: Configuring `LaptopAsset` & Calling Upgrade Methods (Medium)
### Description
Inside `LaptopAsset` at the bottom of `Exercise.java`, implement two methods:
1. `void doubleRam()`: doubles `ramGb` (`ramGb *= 2;`).
2. `void printSpecs()`: prints `printf("Laptop: %s | RAM: %dGB | Price: $%.2f | Assigned: %b%n", modelName, ramGb, purchasePrice, isAssigned)`.

In `solveProblem2()`:
1. Create a `new LaptopAsset()`, set `modelName = "ThinkPad X1"`, `ramGb = 16`, `purchasePrice = 1499.99`, `isAssigned = true`.
2. Call `printSpecs()`, then call `doubleRam()`, then call `printSpecs()` again.

### Expected Output
```
Laptop: ThinkPad X1 | RAM: 16GB | Price: $1499.99 | Assigned: true
Laptop: ThinkPad X1 | RAM: 32GB | Price: $1499.99 | Assigned: true
```
### Edge-Case Hints
- Inside `doubleRam()`, you can directly modify `ramGb *= 2;` because `ramGb` is an instance field of the same class.

---

## Problem 3: Building the `CircleBlueprint` Class from Scratch (Hard)
### Description
Complete the `CircleBlueprint` class at the bottom of `Exercise.java`:
1. Add two fields: `double radius;` and `String color;`.
2. Implement `double getArea()` $\rightarrow$ returns `3.14159 * radius * radius`.
3. Implement `double getCircumference()` $\rightarrow$ returns `2 * 3.14159 * radius`.
4. Implement `void scale(double factor)` $\rightarrow$ multiplies `radius *= factor;`.
In `solveProblem3()`, create a `CircleBlueprint` with `radius = 5.0` and `color = "Crimson"`, print its area, call `scale(2.0)`, and print its new area and circumference (formatted to 2 decimal places).

### Expected Output
```
Crimson Circle (r=5.0)  -> Area: 78.54
Crimson Circle (r=10.0) -> Area: 314.16 | Circumference: 62.83
```
### Edge-Case Hints
- Scaling the radius by `2.0` quadruples (`4x`) the circle's area!
