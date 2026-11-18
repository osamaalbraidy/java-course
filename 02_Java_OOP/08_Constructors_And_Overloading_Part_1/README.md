# Lesson 08: Constructors and Overloading — Part 1 (Default vs. Parameterized Constructors & Object Initialization)

## 1. What Is a Constructor?
A **constructor** is a special block of code that is **automatically invoked when an object is created with the `new` keyword** (`new ServerNode("db-primary", 5432)`).
Its primary job is to **guarantee that a brand-new object starts its life in a valid, fully initialized state** (so callers can never forget to call `setHost()` or `setPort()` after `new`!).

### 3 Strict Syntax Rules for Constructors
1. **Exact Same Name as the Class**: A constructor inside `class ServerNode` **must** be named `ServerNode` (case-sensitive).
2. **NO Return Type (Not Even `void`!)**:
   - Writing `public void ServerNode()` turns it into an **ordinary method** that happens to share the class name—it will **not** run when `new ServerNode()` is called!
3. **Cannot Be `static`, `final`, or `abstract`**.

---

## 2. The 3 Types of Constructors

| Constructor Type | How It Looks | When It Exists |
| :--- | :--- | :--- |
| **1. Compiler-Provided Default Constructor** | `public ClassName() { }` *(Synthesized silently by `javac`)* | **ONLY** when you write **zero constructors** in the class! |
| **2. Explicit No-Arg Constructor** | `public ClassName() { this.status = "READY"; }` | Written explicitly by you to set sensible default field values. |
| **3. Parameterized Constructor** | `public ClassName(String name, int port) { ... }` | Written by you to require mandatory fields at creation time. |

---

## 3. Crucial Compiler Rule: When the Default Constructor Disappears!
- If you write **no constructors** in `class Car`, the Java compiler (`javac`) automatically inserts a hidden `public Car() {}` no-arg constructor so `new Car()` compiles.
- **THE MOMENT you write ANY parameterized constructor** (e.g., `public Car(String model)`), **`javac` stops generating the default no-arg constructor**!
- Calling `new Car()` with no arguments will now fail with a compile-time error (`constructor Car in class Car cannot be applied to given types`) unless you **also** explicitly write `public Car() { ... }`!

---

## 4. Common Pitfalls
1. **Accidentally Adding `void` to a Constructor**:
   - `public void BankAccount(String owner)` is a regular method, NOT a constructor!
2. **Bypassing Validation in Constructors**:
   - If your setter `setPrice(double price)` validates that `price > 0`, don't let your constructor blindly assign `this.price = price;` with `-500.0`! Either validate inside the constructor or call the setter.

---

## 5. Real-World Use Cases
- **Enforcing Mandatory Dependencies**: Requiring an `accountNumber` and `initialDeposit` inside `new BankAccount(accNum, deposit)` so an account without an ID can never exist in memory.
