# Lesson 02: What Is OOP? — Part 2 (Encapsulation, Data Hiding & Access Modifiers `private` vs. `public`)

## 1. What Is Encapsulation?
**Encapsulation** is the practice of bundling an object's **data (fields)** and **methods** together within a class while **restricting direct external access** to the object's internal state (**Data Hiding**).

In Lesson 01, our `DeliveryDrone` fields had no access modifier, allowing external code in `main()` to write `drone.batteryPercent = -500;`! In production software, allowing external classes to mutate fields directly makes it impossible to enforce business rules (invariants).

---

## 2. Java's 4 Access Modifiers
Java provides four access levels to control where a class, field, constructor, or method can be accessed:

| Modifier | Same Class | Same Package | Subclass (Other Pkg) | Everywhere (World) |
| :--- | :---: | :---: | :---: | :---: |
| **`private`** | **YES** | No | No | No |
| *(default / package-private)* | **YES** | **YES** | No | No |
| **`protected`** | **YES** | **YES** | **YES** | No |
| **`public`** | **YES** | **YES** | **YES** | **YES** |

---

## 3. The Golden Rule of Encapsulation in Java
1. **Make Instance Fields `private`**:
   - No code outside the class can read or overwrite a `private` field directly (`obj.secretField` causes a compile-time error: `secretField has private access`).
2. **Provide `public` Methods as Controlled Gateways**:
   - External callers interact with the object exclusively through `public` methods, which validate inputs before mutating `private` fields.
3. **Make Internal Helper Methods `private`**:
   - If a class has a helper method (like `calculateInternalChecksum()` or `maskCardNumber()`) that only its own methods need, mark that method `private` so external callers aren't coupled to it!

---

## 4. Common Pitfalls
1. **Thinking `private` Means "Encrypted in RAM"**:
   - `private` is a **compile-time architectural boundary** that prevents accidental misuse and enforces clean modular design; it is not cryptographic encryption.
2. **Forgetting Access Modifiers (Defaulting to Package-Private)**:
   - Omitting `private` leaves fields accessible to every other class in the same package folder. Always write `private` explicitly on fields.

---

## 5. Real-World Use Cases
- **Payment Processing (`CreditCardVault`)**: Keeping the raw 16-digit card number and CVV `private`, and only exposing a `public String getMaskedCardNumber()` method that returns `"****-****-****-4242"`.
