# Lesson 19: Enumerated Types — `enum` (`enum` Declarations, `switch` with Enums, Fields & Constructors)

## 1. What Is an `enum` and Why Use It?
Before Java 5, developers represented fixed sets of constants (like days of the week, order statuses, or user roles) using raw `int` numbers (`0 = PENDING, 1 = SHIPPED`) or raw `String` literals (`"PENDING"`).
Raw `int`s and `String`s are dangerous:
- Nothing stops someone from passing `status = 999` or `"PENIDNG"` (a typo!) into a method!

An **Enumerated Type (`enum`)** is a special **type-safe class** whose instances are strictly restricted to a predefined list of named constants:

```java
public enum OrderStatus {
    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
```
If a method expects `OrderStatus status`, the compiler **only allows those 5 exact values**!

---

## 2. Built-In `enum` Methods (Inherited from `java.lang.Enum`)
Every `enum` in Java implicitly extends `java.lang.Enum` and comes with helpful methods out of the box:
1. **`OrderStatus.values()`**: Returns an array (`OrderStatus[]`) of all enum constants in declaration order.
2. **`status.name()`**: Returns the exact `String` name of the constant (`"SHIPPED"`).
3. **`status.ordinal()`**: Returns its 0-based position index (`0` for `PENDING`, `1` for `PROCESSING`, etc.).
4. **`OrderStatus.valueOf("SHIPPED")`**: Parses a case-sensitive `String` into the matching `enum` constant (or throws `IllegalArgumentException` if not found).
5. **Safe `==` Comparison**: Because there is only **one singleton instance** of each enum constant in the JVM, you can safely compare enums with **`==`** (`if (status == OrderStatus.SHIPPED)`)!

---

## 3. Rich Enums with Fields, Constructors, and Methods
In Java, an `enum` is a full-fledged class! Each constant can hold its own **fields**, initialized through a **`private` constructor**, and expose **methods**:

```java
enum Planet {
    EARTH(5.97e24, 6371.0),
    MARS(6.42e23, 3389.5); // <-- Semicolon required when fields/methods follow!

    private final double massKg;
    private final double radiusKm;

    // Enum constructors are ALWAYS implicitly `private`!
    Planet(double massKg, double radiusKm) {
        this.massKg = massKg;
        this.radiusKm = radiusKm;
    }

    public double getRadiusKm() { return this.radiusKm; }
}
```

---

## 4. Common Pitfalls
1. **Trying to Call `new MyEnum()` or Declare a `public` Enum Constructor**:
   - Enum constructors are strictly **`private`** because the fixed set of constants is created once when the enum class loads.
2. **Relying on `.ordinal()` for Database IDs**:
   - If someone inserts a new enum constant at the top of the list later, all `.ordinal()` numbers shift by `+1`! Store an explicit `private final int code;` field inside the enum instead.

---

## 5. Real-World Use Cases
- **State Machines & Order Lifecycles**: `OrderStatus` (`PENDING -> PAID -> SHIPPED -> DELIVERED`), `HttpStatus` (`OK(200)`, `NOT_FOUND(404)`), and `Role` (`GUEST`, `USER`, `ADMIN`).
