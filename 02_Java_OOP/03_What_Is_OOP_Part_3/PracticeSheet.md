# Practice Sheet: Lesson 03 — What Is OOP? (Part 3: Abstraction, Cohesion & Coupling)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/03_What_Is_OOP_Part_3/Exercise.java) to practice designing clean abstractions and high-cohesion domain classes.

---

## Problem 1: Encapsulation vs. Abstraction vs. Cohesion vs. Coupling (Easy)
### Description
In `solveProblem1()`, print the architectural summary matching each OOP design principle to its definition:

### Expected Output
```
Encapsulation  : Hides internal state using private fields and controlled public methods
Abstraction    : Hides complex multi-step implementation details behind a simple API
High Cohesion  : Ensures each class has a single, well-focused responsibility
Loose Coupling : Minimizes how much one class depends on the internal details of another
```
### Edge-Case Hints
- Remember our architectural goal: **High Cohesion** and **Loose Coupling**!

---

## Problem 2: Hiding Complex Steps Behind an Abstraction (`CloudBackupService`) (Medium)
### Description
In `Exercise.java`, complete the `CloudBackupService` class so that callers only need to call **one `public` method**:
`public void backupDirectory(String folderPath)`
Inside `backupDirectory(String folderPath)`, invoke three **`private` helper methods** in exact order:
1. `compressFiles(folderPath)` $\rightarrow$ prints `"  1. Compressing " + folderPath + " into archive.zip..."`
2. `encryptArchive()` $\rightarrow$ prints `"  2. Encrypting archive with AES-256..."`
3. `uploadToCloud()` $\rightarrow$ prints `"  3. Uploading encrypted archive to cloud bucket -> DONE!"`

### Expected Output
```
Starting Backup for /var/www/app:
  1. Compressing /var/www/app into archive.zip...
  2. Encrypting archive with AES-256...
  3. Uploading encrypted archive to cloud bucket -> DONE!
```
### Edge-Case Hints
- Mark `compressFiles`, `encryptArchive`, and `uploadToCloud` as `private` so external code cannot call them out of order!

---

## Problem 3: High-Cohesion Refactoring (`ShippingBox` and `PostageCalculator`) (Hard)
### Description
Instead of mixing physical 3D box geometry with postal rate math in one class, complete the two focused classes in `Exercise.java`:
1. `ShippingBox`:
   - Private fields: `double length`, `double width`, `double height`, `double weightKg`.
   - Public method `public double calculateVolume()`: returns `length * width * height`.
   - Public method `public double getWeightKg()`: returns `weightKg`.
2. `PostageCalculator`:
   - Public method `public double calculateShippingCost(ShippingBox box)`:
     Computes base cost `$5.00 + (box.getWeightKg() * 2.50)`. If `box.calculateVolume() > 1000.0`, adds an oversize surcharge of `$10.00`. Returns the total cost.
Test both classes in `solveProblem3()` on a box of dimensions `20.0 x 10.0 x 8.0` (volume `1600.0`) and weight `4.0 kg`.

### Expected Output
```
Box Volume: 1600.0 cm3 | Weight: 4.0 kg | Shipping Cost: $25.00
```
### Edge-Case Hints
- Base cost = `5.00 + (4.0 * 2.50) = 15.00`, plus `$10.00` oversize surcharge (since `1600.0 > 1000.0`) = `$25.00`.
