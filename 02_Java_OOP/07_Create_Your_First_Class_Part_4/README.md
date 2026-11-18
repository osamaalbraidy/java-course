# Lesson 07: Create Your First Class — Part 4 (UML Class Diagrams to Java Code Translation & Full Class Design)

## 1. What Is a UML Class Diagram?
**UML (Unified Modeling Language)** is the universal visual standard used by software engineers and architects to blueprint classes before writing code.

A **UML Class Box** is divided into **three horizontal compartments**:

```
+-------------------------------------------------------+
|                    BankAccount                        |  <-- 1. Class Name
+-------------------------------------------------------+
| - accountNumber : String                              |  <-- 2. Fields (Attributes)
| - accountHolder : String                              |      Syntax: visibility name : Type
| - balance       : double                              |
+-------------------------------------------------------+
| + BankAccount(accNum: String, holder: String)         |  <-- 3. Constructors & Methods
| + deposit(amount: double) : boolean                   |      Syntax: visibility name(params) : ReturnType
| + withdraw(amount: double) : boolean                  |
| + getBalance() : double                               |
| - isValidAmount(amount: double) : boolean             |
+-------------------------------------------------------+
```

---

## 2. UML Visibility Symbols Cheat Sheet
When translating a UML diagram into Java code, the leading symbol on each field or method maps directly to a Java access modifier:

| UML Symbol | Java Access Modifier | Typical Usage |
| :---: | :--- | :--- |
| **`-`** (Minus) | **`private`** | Instance fields & internal helper methods |
| **`+`** (Plus) | **`public`** | Constructors, getters, setters & public API methods |
| **`#`** (Hash) | **`protected`** | Fields/methods shared with subclasses |
| **`~`** (Tilde) | *(package-private / default)* | Internal package-level utilities |
| *Underlined* | **`static`** | Class-level constants and static methods |

---

## 3. Translating `toString()` for Clean Object Representation
Every Java class implicitly inherits a `public String toString()` method from `java.lang.Object`.
- By default, `System.out.println(myAccount)` calls `Object.toString()`, which prints an unhelpful memory hash like `BankAccount@6d06d69c`.
- **Best Practice**: Override `public String toString()` in your domain classes to return a human-readable summary of the object's state!

---

## 4. Common Pitfalls
1. **Reversing UML Type Order (`name : Type` vs. `Type name`)**:
   - In UML, the type comes **after** the colon (`- balance : double`).
   - In Java, the type comes **before** the identifier (`private double balance;`).
2. **Omitting Return Types on Non-Constructor Methods**:
   - In UML, constructors have **no return type**, whereas methods returning nothing specify `: void`.

---

## 5. Real-World Use Cases
- **Technical Design Documents (TDDs) & System Architecture Reviews**: Engineering teams agree on UML class diagrams before splitting implementation tasks across developers.
