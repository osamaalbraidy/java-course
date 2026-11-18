# Lesson 16: `final` Methods and `protected` Members (`protected` Access & The 3 Uses of `final`)

## 1. The `protected` Access Modifier in Inheritance
In Lesson 02 and Lesson 13, we saw that **`private`** fields in a superclass are completely invisible to subclasses (`Child` cannot access `this.privateParentField` directly).
What if a superclass **wants** to grant its subclasses direct access to a field or helper method—even when the subclass lives in a **different package**—while still hiding it from unrelated external classes?

That is the exact purpose of **`protected`**:
- **`protected` members are accessible**:
  1. Inside the declaring class itself.
  2. By any class in the **same package**.
  3. **By any Subclass (`extends`), even in a completely different package!**

---

## 2. The 3 Meanings of the `final` Keyword in Java
The keyword **`final`** means *"cannot be changed or extended"*, and applies to three different targets:

| Target of `final` | Syntax Example | Architectural Effect |
| :--- | :--- | :--- |
| **1. `final` Variable / Field** | `final int MAX_USERS = 100;` | **Value cannot be reassigned** after initialization (Constant). |
| **2. `final` Method** | `public final void verifySecurity()` | **Method cannot be overridden (`@Override`)** by any subclass! |
| **3. `final` Class** | `public final class String` | **Class cannot be subclassed (`extends`)** at all! |

---

## 3. Why Mark a Method or Class `final`?
1. **Security & Invariant Protection (`final` Method)**:
   - Suppose `BankTransaction` has a method `public final void executeSecureTransfer()` that logs an audit trail and checks fraud rules before transferring funds. Marking it `final` guarantees that no malicious or buggy subclass can override `executeSecureTransfer()` to skip the fraud check!
2. **Immutability (`final` Class)**:
   - Core Java classes like **`java.lang.String`**, `Integer`, `LocalDate`, and `Math` are declared **`public final class`** so no one can create a mutable subclass of `String`!

---

## 4. Common Pitfalls
1. **Overusing `protected` Fields Instead of `private` Fields + `protected` Getters/Setters**:
   - Exposing a mutable field as `protected double balance;` lets any subclass set `balance = -9999;`. Prefer keeping fields `private` and providing `protected` helper methods!
2. **Confusing `final` Reference Variables with Immutable Objects**:
   - `final BankAccount acc = new BankAccount(100);` prevents you from reassigning `acc = new BankAccount(500);`, **but you can still mutate the object's internal state** (`acc.deposit(50);`)!

---

## 5. Real-World Use Cases
- **Template Method Security Pipelines**: Locking the outer authentication/logging workflow in a `public final void handleRequest()` method while delegating customizable steps to `protected` hook methods.
