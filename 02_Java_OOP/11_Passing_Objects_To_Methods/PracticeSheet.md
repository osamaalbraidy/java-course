# Practice Sheet: Lesson 11 — Passing Objects to Methods

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/11_Passing_Objects_To_Methods/Exercise.java).

---

## Problem 1: Mutating an Object Inside a Method (`applySaleDiscount`) (Easy)
### Description
Given a `ProductItem` class with `name` and `price`:
- Write a method `public static void applySaleDiscount(ProductItem item, double percentOff)` that reduces `item`'s price in-place by calling `item.setPrice(newPrice)`.
- Test it on a `"Gaming Monitor"` priced at `$400.00` with a `25.0%` discount.

### Expected Output
```
Before Discount : Product [Gaming Monitor | $400.00]
After 25% Off   : Product [Gaming Monitor | $300.00]
```
### Edge-Case Hints
- Because `item` holds a copy of the Heap reference, calling `item.setPrice(...)` inside `applySaleDiscount` mutates the original `ProductItem` object in `main()`!

---

## Problem 2: Object-to-Object Combat Interaction (`hero.attack(monster)`) (Medium)
### Description
Create a `CombatUnit` class with `name`, `health`, and `attackPower`:
- Implement an instance method `public void attack(CombatUnit target)` where `this` unit deals `this.attackPower` damage to `target` by calling `target.takeDamage(this.attackPower)`.
- Test `paladin` (`"Paladin"`, HP `100`, ATK `35`) attacking `dragon` (`"Red Dragon"`, HP `120`, ATK `40`) twice!

### Expected Output
```
Paladin attacks Red Dragon for 35 damage! (Red Dragon HP: 85)
Paladin attacks Red Dragon for 35 damage! (Red Dragon HP: 50)
```
### Edge-Case Hints
- Notice how `paladin.attack(dragon)` uses `this.name` and `this.attackPower` for the attacker (`paladin`) and mutates `target`'s health (`dragon`)!

---

## Problem 3: Returning a New Object (`Vector2D.add(Vector2D other)`) (Hard)
### Description
In physics and game engines, vectors are often **immutable**: adding two vectors `v1` and `v2` returns a **brand-new `Vector2D` object** without modifying `v1` or `v2`!
Implement `public Vector2D add(Vector2D other)` inside `Vector2D` that returns `new Vector2D(this.x + other.x, this.y + other.y)`.

### Expected Output
```
Vector v1           : (3.0, 4.0)
Vector v2           : (7.0, -1.5)
Returned v3 = v1+v2 : (10.0, 2.5)
v1 Unchanged        : (3.0, 4.0)
```
### Edge-Case Hints
- Allocating and returning `new Vector2D(...)` inside `add()` leaves both `v1` and `v2` completely unchanged!
