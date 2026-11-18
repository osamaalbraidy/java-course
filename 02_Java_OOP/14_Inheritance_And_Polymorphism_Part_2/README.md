# Lesson 14: Inheritance and Polymorphism — Part 2 (Upcasting, Dynamic Method Dispatch & Runtime Polymorphism)

## 1. What Is Runtime Polymorphism?
The word **Polymorphism** comes from Greek (*poly* = many, *morph* = forms).
In OOP, **Runtime Polymorphism** allows a **single parent reference variable** (or array of parent references) to point to objects of **any subclass**, and automatically invoke the **subclass's specific version** of a method at runtime!

```java
// UPCASTING: Storing Child objects inside Parent reference variables!
PaymentProcessor p1 = new CreditCardProcessor();
PaymentProcessor p2 = new PayPalProcessor();
PaymentProcessor p3 = new CryptoProcessor();
```

---

## 2. Compile-Time Reference Type vs. Runtime Object Type
Look closely at the two sides of `PaymentProcessor p1 = new CreditCardProcessor();`:
$$\underbrace{\text{PaymentProcessor p1}}_{\text{Compile-Time Reference Type}} = \underbrace{\text{new CreditCardProcessor()}}_{\text{Runtime Object Type on the Heap}};$$

1. **The Left Side (Reference Type)** determines **WHAT methods you are allowed to call** at compile time (`javac` checks if `processPayment()` exists in `PaymentProcessor`).
2. **The Right Side (Actual Heap Object Type)** determines **WHICH implementation actually executes at runtime**! This is called **Dynamic Method Dispatch (Late Binding)**.

---

## 3. Upcasting vs. Downcasting and `instanceof`
1. **Upcasting (Child $\rightarrow$ Parent)**:
   - Automatic and 100% safe (`Animal a = new Dog();`), because every `Dog` **IS-A** `Animal`.
2. **Downcasting (Parent $\rightarrow$ Child)**:
   - Requires an explicit cast (`Dog d = (Dog) a;`) to call child-only methods (like `d.fetchBall()`).
   - **Danger (`ClassCastException`)**: If `a` actually points to a `Cat` at runtime, `(Dog) a` crashes with `java.lang.ClassCastException`!
   - **Safe Pattern Matching for `instanceof` (Java 16+ / 17 LTS)**:
     ```java
     if (a instanceof Dog myDog) { // Checks type AND casts to `myDog` in one step!
         myDog.fetchBall();
     }
     ```

---

## 4. Common Pitfalls
1. **Calling a Child-Only Method on a Parent Reference Without Downcasting**:
   - If `Animal` only declares `makeSound()`, and `Dog` adds `fetch()`, writing `Animal a = new Dog(); a.fetch();` fails at compile time because `Animal` does not have a `fetch()` method!
2. **Unsafe Downcasting Without `instanceof`**:
   - Never write `(SubClass) parentRef` without checking `if (parentRef instanceof SubClass)` first.

---

## 5. Real-World Use Cases
- **Extensible Plugin & Notification Engines**: Looping over a single `NotificationSender[]` array containing `EmailSender`, `SmsSender`, and `PushNotificationSender` objects and calling `sender.send(alert)` without a single `if-else` statement!
