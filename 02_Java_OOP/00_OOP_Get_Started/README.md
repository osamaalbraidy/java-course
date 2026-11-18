# Lesson 00: OOP — Get Started (Procedural vs. Object-Oriented Programming & The 4 Pillars)

## 1. Procedural Programming vs. Object-Oriented Programming (OOP)
In Module 1 (`01_Java_Basics`), we wrote **procedural code**: data lived in separate primitive variables or arrays (`String[] names`, `double[] balances`), and `static` helper methods operated on those loose variables passed as arguments.

As software systems scale to hundreds of thousands of lines, procedural code suffers from a major flaw: **data and the functions that manipulate that data are disconnected**. Adding a new field requires updating dozens of method parameter lists across the codebase.

**Object-Oriented Programming (OOP)** solves this by bundling **State (Data/Fields)** and **Behavior (Methods)** together into self-contained units called **Objects**:

| Dimension | Procedural Programming | Object-Oriented Programming (OOP) |
| :--- | :--- | :--- |
| **Core Unit** | Functions / Procedures (`static` methods) | **Objects** (Instances of **Classes**) |
| **Data & Behavior** | Kept separate (loose arrays/variables passed into functions) | **Bundled together** inside the same Object |
| **Data Security** | Global or passed around openly; any function can corrupt it | Protected via **Encapsulation** (`private` fields) |
| **Extensibility** | Modifying existing `if-else` / `switch` blocks everywhere | Adding new subclasses/implementations via **Polymorphism** |

---

## 2. Overview of the 4 Pillars of OOP

```
           +---------------------------------------------+
           |       OBJECT-ORIENTED PROGRAMMING (OOP)     |
           +---------------------------------------------+
             /              |              |             \
            v               v              v              v
   [1. Encapsulation] [2. Abstraction] [3. Inheritance] [4. Polymorphism]
    Data hiding via    Hiding complex   Reusing code     One interface,
    private fields &   internals behind via IS-A class   many runtime
    public methods     simple contracts hierarchies      behaviors
```

1. **Encapsulation (Data Protection)**: Wrapping fields (`private`) and methods (`public`) inside a class so outside code cannot put an object into an invalid state (e.g., setting a bank balance to `-$999,999`).
2. **Abstraction (Simplicity)**: Exposing **what** an object does (`car.brake()`) while hiding **how** the complex hydraulic/electronic internals work under the hood.
3. **Inheritance (Code Reuse)**: Allowing a child class (`SavingsAccount`) to inherit fields and methods from a parent class (`BankAccount`) via the `extends` keyword.
4. **Polymorphism (Flexibility)**: Treating different subclass objects (`CreditCard`, `PayPal`, `CryptoWallet`) uniformly through a shared parent type (`PaymentMethod`).

---

## 3. Common Pitfalls
1. **"Anemic" Procedural Code Disguised as OOP**:
   - Putting `static` on every field and method inside a class is still procedural programming! True OOP creates **object instances** (`new BankAccount(...)`) where each object manages its own state.
2. **Public Mutable Fields**:
   - Declaring fields `public double balance;` allows any class in the project to overwrite `account.balance = -5000;` without validation.

---

## 4. Real-World Use Cases
- **Enterprise Domain Modeling (Banking, E-Commerce, Healthcare)**: Modeling real-world entities (`Customer`, `Order`, `Invoice`, `MedicalRecord`) where business rules live directly inside the domain object.
