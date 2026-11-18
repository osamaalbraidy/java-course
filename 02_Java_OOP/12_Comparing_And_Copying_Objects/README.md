# Lesson 12: Comparing and Copying Objects (`==` vs. `.equals()`, Reference Alias, Shallow vs. Deep Copy & Copy Constructors)

## 1. Comparing Objects: `==` (Reference Identity) vs. `.equals()` (Logical Value Equality)
Suppose we create two `Passport` objects with the exact same passport number and holder name:
```java
Passport p1 = new Passport("US-99481", "Alice");
Passport p2 = new Passport("US-99481", "Alice");
```
- **`p1 == p2` evaluates to `false`!** Why? Because each `new` keyword allocates a **separate object at a different memory address** on the Heap, and `==` compares memory addresses!
- **`p1.equals(p2)`**: By default, `Object.equals()` also uses `==` unless your class **overrides `equals(Object obj)`** (and `hashCode()`) to compare the internal field values!

---

## 2. Copying Objects: Reference Aliasing vs. Copy Constructor
What happens if you try to "copy" an object using the assignment operator `=`?
```java
Passport alias = p1; // DOES NOT COPY THE OBJECT!
```
This is called **Reference Aliasing**: `alias` and `p1` now point to the **exact same Heap object**. Changing `alias.setHolder("Bob")` also changes `p1`!

### How to Truly Copy an Object: The Copy Constructor
A **Copy Constructor** is a constructor that takes an existing object of the **same class** as its parameter (`public Passport(Passport other)`) and copies its fields into a brand-new Heap instance:
```java
public Passport(Passport source) {
    this.passportNumber = source.passportNumber;
    this.holderName = source.holderName;
}
```

---

## 3. Shallow Copy vs. Deep Copy
What if a class contains a **mutable reference field** (such as an `int[] scores` array or another mutable object)?
1. **Shallow Copy**: Copies the reference address of the inner array (`this.scores = source.scores;`). Now both objects share the **same inner array** on the Heap!
2. **Deep Copy**: Allocates a **brand-new copy** of every mutable inner array or object (`this.scores = Arrays.copyOf(source.scores, source.scores.length);`) so the two objects are 100% independent!

---

## 4. Common Pitfalls
1. **Using `=` Thinking It Clones an Object**:
   - `Car c2 = c1;` only copies the 64-bit memory pointer on the Stack, not the `Car` on the Heap.
2. **Forgetting to Override `equals()` Before Calling `obj1.equals(obj2)`**:
   - If you don't override `equals()` in your custom class, `obj1.equals(obj2)` falls back to `Object.equals()`, which just executes `obj1 == obj2`!

---

## 5. Real-World Use Cases
- **Undo / Redo History & Snapshot Backups**: Creating a **deep copy** of a document or game state before applying destructive edits so the user can roll back cleanly.
