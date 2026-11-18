# Lesson 13: Inheritance and Polymorphism — Part 1 (`extends` Keyword, `super` Keyword & IS-A Relationship)

## 1. What Is Inheritance?
**Inheritance** is one of the 4 Pillars of OOP. It allows a new class (called the **Subclass / Child Class / Derived Class**) to acquire all the non-private fields and methods of an existing class (called the **Superclass / Parent Class / Base Class**) using the **`extends`** keyword:

```java
class Vehicle { ... }                      // Superclass (Parent)
class ElectricTruck extends Vehicle { ... } // Subclass (Child)
```

### The "IS-A" Relationship Test
Before using `extends`, always verify the **IS-A rule**:
- A `SavingsAccount` **IS-A** `BankAccount` ($\checkmark$ Valid Inheritance).
- A `Manager` **IS-A** `Employee` ($\checkmark$ Valid Inheritance).
- A `Car` **IS-A** `Engine` ($\times$ False! A `Car` **HAS-A** `Engine`—use a field/composition instead of `extends`!).

---

## 2. How the `super` Keyword Works
Inside a subclass (`Child`), **`super`** refers to the immediate parent class (`Parent`):

1. **Calling the Parent Constructor (`super(arg1, arg2)`)**:
   - Constructors are **not** inherited, so the child's constructor must invoke the parent's constructor first to initialize the parent's fields!
   - **Rule:** Just like `this(...)`, **`super(...)` MUST be the very first statement** inside the child's constructor!
   - If you don't write `super(...)`, `javac` automatically inserts a hidden `super();` (0-arg call) on line 1 of the child constructor.
2. **Calling a Parent Method (`super.methodName()`)**:
   - Used when a subclass wants to extend or reuse a method defined in the parent class.

---

## 3. Single Inheritance Rule in Java
- A Java class can directly extend **only ONE superclass** (`class A extends B, C` is illegal in Java to avoid the "Diamond Problem").
- However, inheritance can form **multi-level hierarchies** (`Object -> Vehicle -> Car -> ElectricCar`).
- **Every class in Java implicitly extends `java.lang.Object`** if no `extends` clause is written!

---

## 4. Common Pitfalls
1. **Parent Class Missing a No-Arg Constructor**:
   - If `Parent` only defines `public Parent(String name)` (no 0-arg constructor), and `Child` doesn't explicitly call `super("...")` on line 1 of its constructor, `javac` tries to insert `super();` and fails with a compile error!
2. **Trying to Access `private` Parent Fields Directly in the Child**:
   - Even in a subclass, a `private` field in `Parent` cannot be accessed directly (`this.privateParentField` fails). Initialize it via `super(...)` and read/write it via `public` or `protected` getters/setters!

---

## 5. Real-World Use Cases
- **HR & Payroll Hierarchies**: `Employee` base class holds shared `id`, `name`, and `baseSalary`, while `SoftwareEngineer`, `SalesRepresentative`, and `Executive` subclasses add role-specific fields (`stockOptions`, `commissionRate`).
