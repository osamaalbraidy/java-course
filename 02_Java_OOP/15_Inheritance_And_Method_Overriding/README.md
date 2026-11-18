# Lesson 15: Inheritance and Method Overriding (`@Override` Annotation, Overriding vs. Overloading Rules)

## 1. What Is Method Overriding?
**Method Overriding** occurs when a **subclass** provides its own specific implementation for a method that is **already defined in its superclass** with the **exact same signature**!

```java
class ShippingService {
    public double calculateFee(double weightKg) {
        return weightKg * 2.50;
    }
}

class ExpressAirShipping extends ShippingService {
    @Override
    public double calculateFee(double weightKg) {
        // Calls parent calculation via `super.` and adds a $25 priority air surcharge!
        return super.calculateFee(weightKg) + 25.00;
    }
}
```

---

## 2. Why Always Use the `@Override` Annotation?
Placing **`@Override`** above an overriding method tells the Java compiler (`javac`): *"Verify that this method actually overrides a method in a parent class or interface!"*
- Suppose the parent method is `calculateFee(double weightKg)`, and you make a typo in the child class: `calculatFee(double weightKg)` (missing `'e'`).
- **Without `@Override`**: `javac` thinks you just invented a brand-new method! At runtime, polymorphism silently runs the old parent method—a nightmare bug to track down!
- **With `@Override`**: `javac` immediately catches the typo at compile time: `error: method does not override or implement a method from a supertype`!

---

## 3. Method Overriding vs. Method Overloading (Interview Classic!)

| Feature | Method Overloading (Lesson 21) | Method Overriding (Lesson 15) |
| :--- | :--- | :--- |
| **Where It Happens** | Inside the **same class** (or across subclass) | Strictly between **Superclass and Subclass** |
| **Method Name** | Must be **identical** | Must be **identical** |
| **Parameter List** | **MUST be different!** | **MUST be identical!** |
| **Return Type** | Can be anything | Must be identical (or a **covariant subtype**) |
| **Access Modifier** | Can be anything | **Cannot be more restrictive** than parent (`public` cannot become `protected` or `private`!) |
| **Resolved When?** | **Compile-Time** (Static Binding) | **Runtime** (Dynamic Dispatch on Heap object) |

---

## 4. What CANNOT Be Overridden?
1. **`private` methods**: Not visible to subclasses at all.
2. **`static` methods**: Belong to the class, not instances (defining a `static` method with the same signature in a child class is called **Method Hiding**, not overriding!).
3. **`final` methods**: Explicitly locked by the parent class (covered in Lesson 16).

---

## 5. Real-World Use Cases
- **Extending Parent Behavior with `super.method()`**: Overriding `renderComponent()` or `calculateSalary()` to run the parent's base logic first (`super.calculateSalary()`) and then add child-specific bonuses or taxes.
