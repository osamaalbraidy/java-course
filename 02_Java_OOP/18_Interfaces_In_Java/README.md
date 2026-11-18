# Lesson 18: Interfaces in Java (`implements`, Multiple Interface Inheritance, `default` & `static` Interface Methods)

## 1. What Is an Interface?
An **Interface** (`public interface Payable`) is a 100% pure **capability contract** ("CAN-DO" relationship) that specifies **what methods a class must support**, without dictating **how** the class is structured internally or what class hierarchy it belongs to!

- Whereas `extends` models an **IS-A** identity (`Dog extends Animal`) and is limited to **1 parent class**,
- **`implements`** models **CAN-DO capabilities** (`SmartPhone extends ElectronicDevice implements Rechargeable, Connectable, Photographable`), and **a single Java class can implement ANY NUMBER of interfaces!**

```java
public interfaceEncryptable {
    // 1. Constants: Implicitly `public static final`
    String ALGORITHM = "AES-256-GCM";

    // 2. Abstract Contract Methods: Implicitly `public abstract`
    String encrypt(String plainText);

    // 3. Default Method (Java 8+): Provides a default body `{ ... }` that classes inherit!
    default void printSecurityBadge() {
        System.out.println("Secured with " + ALGORITHM);
    }

    // 4. Static Method (Java 8+): Called via `Encryptable.isValidKey(key)`
    static boolean isValidKey(String key) {
        return key != null && key.length() >= 16;
    }
}
```

---

## 2. `abstract class` vs. `interface` Comparison (Top Interview Question!)

| Feature | `abstract class` (`extends`) | `interface` (`implements`) |
| :--- | :--- | :--- |
| **Multiple Inheritance** | A class can extend **ONLY ONE** class | A class can implement **MANY** interfaces (`implements A, B, C`) |
| **Instance Fields** | **YES** (Can have `private`, `protected` mutable state) | **NO!** (All fields are implicitly `public static final` constants!) |
| **Constructors** | **YES** (Called via `super(...)` by subclasses) | **NO!** (Interfaces have no state to construct) |
| **Methods** | `abstract` + concrete (`public`, `protected`, `private`) | `abstract` (default), `default`, `static`, and `private` helpers (Java 9+) |
| **Relationship Type** | **IS-A** (Shared identity & base state) | **CAN-DO** (Shared capability across unrelated classes) |

---

## 3. Why Java 8+ Added `default` and `static` Methods to Interfaces
Before Java 8, adding a new method to an existing interface (like `java.util.List`) would break every existing class in the world that implemented `List`!
- **`default` methods (`default void sort(...) { ... }`)** let interface authors add new methods with a built-in fallback implementation so existing implementing classes continue compiling without changes!

---

## 4. Common Pitfalls
1. **Accidentally Reducing Visibility When Implementing an Interface Method**:
   - Every method in an interface is implicitly **`public`**. When implementing it in your class, you **must** write **`public`** (`void pay()` without `public` fails to compile: `attempting to assign weaker access privileges; was public`)!
2. **Trying to Put Mutable Instance Fields in an Interface**:
   - Any variable declared in an interface is automatically a `public static final` constant.

---

## 5. Real-World Use Cases
- **Dependency Injection & Loose Coupling (Spring Boot / Clean Architecture)**: Controllers depend on `PaymentGateway` or `UserRepository` **interfaces** so you can swap `StripePaymentGateway` in production with `MockPaymentGateway` in unit tests!
