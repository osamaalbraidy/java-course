# Practice Sheet: Lesson 01 — What Is OOP? (Part 1)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/01_What_Is_OOP_Part_1/Exercise.java) to practice distinguishing classes vs. objects and working with object state and behavior.

---

## Problem 1: Class vs. Object Concept Classifier (Easy)
### Description
In `solveProblem1()`, print whether each of the following 4 items is a `CLASS (Blueprint)` or an `OBJECT (Instance)`:
1. `Car` (The general specification for all cars)
2. `A red 2026 Porsche 911 with VIN #WP0AB2`
3. `String` (The `java.lang.String` type definition)
4. `"Hello World"` (A specific text string in memory)

### Expected Output
```
1. Car                                     -> CLASS (Blueprint)
2. Red 2026 Porsche 911 (VIN #WP0AB2)      -> OBJECT (Instance)
3. java.lang.String                        -> CLASS (Blueprint)
4. "Hello World"                           -> OBJECT (Instance)
```
### Edge-Case Hints
- Remember: a Class is the abstract definition/type; an Object is a concrete instance occupying memory.

---

## Problem 2: Instantiating Two `SmartLightBulb` Objects (Medium)
### Description
Using the `SmartLightBulb` class defined at the bottom of `Exercise.java`:
1. Create two instances in `solveProblem2()`:
   - `livingRoomBulb` with `roomName = "Living Room"`, `brightness = 80`, `isOn = false`
   - `kitchenBulb` with `roomName = "Kitchen"`, `brightness = 100`, `isOn = false`
2. Call `turnOn()` ONLY on `livingRoomBulb`.
3. Call `printStatus()` on both `livingRoomBulb` and `kitchenBulb` to verify that `kitchenBulb` remains `OFF`.

### Expected Output
```
[Living Room] Light is ON  (Brightness: 80%)
[Kitchen]     Light is OFF (Brightness: 100%)
```
### Edge-Case Hints
- Each `new SmartLightBulb()` call allocates an independent object on the Heap.

---

## Problem 3: Designing State & Behavior for `GameCharacter` (Hard)
### Description
Complete the `GameCharacter` class at the bottom of `Exercise.java`:
1. Add three instance fields: `String name;`, `int health;`, and `int mana;`.
2. Implement `void takeDamage(int damage)`: subtracts `damage` from `health` (if `health < 0`, clamp `health = 0`).
3. Implement `void castSpell(String spellName, int manaCost)`: if `mana >= manaCost`, subtract `manaCost` from `mana` and print `name + " casts " + spellName + "! (Mana left: " + mana + ")"`; else print `name + " has insufficient mana for " + spellName + "!"`.
4. In `solveProblem3()`, create a `GameCharacter` named `"Merlin"` with `health = 100`, `mana = 50`. Call `takeDamage(30)`, `castSpell("Fireball", 35)`, and `castSpell("Meteor", 35)`.

### Expected Output
```
Merlin casts Fireball! (Mana left: 15)
Merlin has insufficient mana for Meteor!
Merlin Status -> Health: 70 | Mana: 15
```
### Edge-Case Hints
- Notice how `Merlin` remembers that its `mana` dropped from `50` to `15` after the first spell, causing the second `35`-mana spell to fail!
