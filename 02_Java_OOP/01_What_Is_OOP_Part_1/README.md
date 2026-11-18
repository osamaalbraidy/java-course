# Lesson 01: What Is OOP? — Part 1 (Classes as Blueprints, Objects as Instances, State & Behavior)

## 1. Classes vs. Objects: The Architectural Analogy
The most fundamental distinction in Object-Oriented Programming is the difference between a **Class** and an **Object**:

- **A Class Is a Blueprint (Template)**:
  - Think of an architect's blueprint for a house or a factory mold for a car.
  - A blueprint defines **what attributes (fields)** every house will have (`address`, `squareFeet`, `isAlarmArmed`) and **what actions (methods)** it can perform (`armSecuritySystem()`).
  - You cannot live inside a paper blueprint! A class itself consumes no instance memory on the Heap until you build objects from it.
- **An Object Is a Concrete Instance**:
  - Created at runtime using the `new` keyword (`House myHouse = new House();`).
  - You can stamp out **1,000 independent House objects** from **1 House class blueprint**. Each object gets its own dedicated memory on the **Heap** and holds its own independent field values!

---

## 2. The Three Characteristics of Every Object
1. **State (Attributes / Fields / Instance Variables)**:
   - *What the object knows / has.* Represented by nouns (`brand`, `batteryPercent`, `currentSpeedKmH`).
2. **Behavior (Methods)**:
   - *What the object does.* Represented by verbs (`accelerate()`, `brake()`, `recharge()`).
3. **Identity (Memory Reference)**:
   - Every `new` object has a unique identity on the JVM Heap so two cars with identical state (`"Tesla"`, `"Red"`, `0 km/h`) are still two distinct physical cars!

---

## 3. Stack References vs. Heap Objects
```
STACK (Variables in main)               HEAP (Actual Object Instances)
+-----------------------+               +-----------------------------------+
| car1 [Ref: 0x10A0] ---|-------------->| ElectricCar Instance #1           |
+-----------------------+               | brand = "Rivian", battery = 85%   |
                                        +-----------------------------------+
+-----------------------+               +-----------------------------------+
| car2 [Ref: 0x20B8] ---|-------------->| ElectricCar Instance #2           |
+-----------------------+               | brand = "Lucid",  battery = 40%   |
                                        +-----------------------------------+
```

---

## 4. Common Pitfalls
1. **Confusing Class Names (`PascalCase`) with Object Variable Names (`lowerCamelCase`)**:
   - **Classes** always start with an **Uppercase** letter (`SmartWatch`).
   - **Object reference variables** always start with a **lowercase** letter (`SmartWatch myWatch = new SmartWatch();`).
2. **Assuming Changing `obj1.field` Changes `obj2.field`**:
   - Instance fields (non-`static`) belong to each individual object. Draining the battery on `car1` has zero effect on `car2`'s battery!

---

## 5. Real-World Use Cases
- **Video Games & Simulations**: One `EnemyShip` class blueprint instantiates 50 independent ships on screen, each tracking its own `(x, y)` coordinates and `healthPoints`.
