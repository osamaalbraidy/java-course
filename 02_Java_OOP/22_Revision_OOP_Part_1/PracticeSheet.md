# Practice Sheet: Lesson 22 — Revision OOP (Part 1: Classes, Encapsulation & Constructors)

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/22_Revision_OOP_Part_1/Exercise.java).

---

## Problem 1: Encapsulated `LibraryBook` with Chained Constructors & `static` Counter (Easy)
### Description
Design `LibraryBook` with:
- Static counter `private static int totalBooksCataloged = 0;`.
- Overloaded constructors: `LibraryBook(String title)` chains to `LibraryBook(title, "Unknown Author", 200)`.
- Guard `pageCount` so values `< 1` default to `100`.

### Expected Output
```
Book [Title: Clean Architecture   | Author: Robert Martin   | Pages: 432]
Book [Title: Mystery Manuscript   | Author: Unknown Author  | Pages: 200]
Total Books Cataloged: 2
```
### Edge-Case Hints
- Increment `totalBooksCataloged++` only inside the 3-arg master constructor so chained calls don't double-count!

---

## Problem 2: Fluent `WorkoutSession` Builder with Validation (Medium)
### Description
Create a `WorkoutSession` class (`activityName`, `durationMinutes`, `caloriesBurnedPerMin`) where `withDuration(int mins)` and `withCaloriesPerMin(double cal)` validate positive inputs and `return this;` for fluent chaining.
Include `public double getTotalCaloriesBurned()`.

### Expected Output
```
Workout [HIIT Cardio | 45 mins | 11.5 cal/min | Total Burned: 517.5 cal]
```
### Edge-Case Hints
- Returning `this` allows `new WorkoutSession("HIIT Cardio").withDuration(45).withCaloriesPerMin(11.5)`.

---

## Problem 3: Deep Copy & Equality in `LabExperiment` (Hard)
### Description
Create a `LabExperiment` class containing `experimentCode` and a mutable `double[] measurements` array.
Implement a **Deep Copy Constructor** (`Arrays.copyOf`) and override `equals()` using `Arrays.equals(this.measurements, other.measurements)`.

### Expected Output
```
Original == Clone (Same Address?)    : false
Original.equals(Clone) Before Edit   : true
Original.equals(Clone) After Edit    : false
Original Measurements (Protected!)   : [1.5, 2.5, 3.5]
```
### Edge-Case Hints
- For array fields inside `equals()`, always use `Arrays.equals(arr1, arr2)` rather than `Objects.equals(arr1, arr2)`!
