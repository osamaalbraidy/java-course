# Practice Sheet: Lesson 05 — Create Your First Class (Part 2: Getters & Setters)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/05_Create_Your_First_Class_Part_2/Exercise.java) to practice writing getters, setters, and validation guards.

---

## Problem 1: Student Profile Getters & GPA Validation Setter (Easy)
### Description
Complete the `StudentProfile` class in `Exercise.java`:
- Private fields: `private String name;` and `private double gpa;`.
- Implement `getName()`, `setName(String newName)`, and `getGpa()`.
- Implement `setGpa(double newGpa)`:
  - If `newGpa >= 0.0 && newGpa <= 4.0`, update `gpa = newGpa;`.
  - Otherwise, print `"Invalid GPA (" + newGpa + ")! Must be between 0.0 and 4.0."` and leave `gpa` unchanged.

### Expected Output
```
Invalid GPA (4.8)! Must be between 0.0 and 4.0.
Invalid GPA (-1.2)! Must be between 0.0 and 4.0.
Student: Elena | Validated GPA: 3.85
```
### Edge-Case Hints
- When `setGpa(4.8)` and `setGpa(-1.2)` are called after `setGpa(3.85)`, `gpa` remains `3.85`!

---

## Problem 2: Boolean `isXxx()` Getter & Read-Only Field in `SmartLock` (Medium)
### Description
Complete the `SmartLock` class in `Exercise.java`:
- Private fields: `private final String serialNumber;` (read-only!), `private boolean locked;`, and `private int batteryLevel;`.
- Implement:
  - `public String getSerialNumber()` (Read-only: no setter!)
  - `public boolean isLocked()` and `public void setLocked(boolean locked)`
  - `public int getBatteryLevel()` and `public void setBatteryLevel(int level)`: clamp `level` so that values `< 0` become `0` and values `> 100` become `100`.

### Expected Output
```
Serial: LOCK-990 | Locked: true | Battery: 100%
Serial: LOCK-990 | Locked: false | Battery: 0%
```
### Edge-Case Hints
- Passing `150` to `setBatteryLevel(150)` clamps it to `100`; passing `-20` clamps it to `0`.

---

## Problem 3: Computed Getters in `HotelReservation` (Hard)
### Description
Complete the `HotelReservation` class in `Exercise.java`:
- Private fields: `private String guestName;`, `private int nights;` (default `1`), `private double nightlyRate;` (default `100.0`).
- Setters:
  - `setGuestName(String name)`: only updates if `name != null && !name.trim().isEmpty()`.
  - `setNights(int nights)`: only updates if `nights >= 1 && nights <= 30`.
  - `setNightlyRate(double rate)`: only updates if `rate >= 50.0`.
- Computed Getters:
  - `public double getSubtotal()`: returns `nights * nightlyRate`.
  - `public double getTotalWithTax()`: returns `getSubtotal() * 1.12` (adds 12% occupancy tax).

### Expected Output
```
Guest: Marcus Vance | Nights: 4 | Subtotal: $800.00 | Total (w/ 12% Tax): $896.00
```
### Edge-Case Hints
- Notice that `subtotal` and `totalWithTax` do not need to be stored as fields; computing them inside `getSubtotal()` and `getTotalWithTax()` guarantees they are never out of sync when `nights` or `nightlyRate` changes!
