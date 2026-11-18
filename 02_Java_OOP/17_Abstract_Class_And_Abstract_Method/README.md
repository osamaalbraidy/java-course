# Lesson 17: `abstract` Class and `abstract` Method (Abstract vs. Concrete Methods & Template Design)

## 1. Why Do We Need `abstract` Classes?
In Lesson 14, we created a base class `Shape2D` with a dummy method `public double calculateArea() { return 0.0; }`.
Think about that:
1. Does a generic, formless `"Shape2D"` exist in the real world? **No!** Only concrete shapes like `Circle`, `Rectangle`, and `Triangle` exist! Allowing someone to write `new Shape2D()` makes no sense.
2. What is the area formula for an unknown `Shape2D`? **There isn't one!** Returning `0.0` is a fake placeholder, and if a developer creates `class Hexagon extends Shape2D` and forgets to override `calculateArea()`, the compiler won't warn them!

Java solves both problems with the **`abstract`** keyword:

```java
public abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    // ABSTRACT METHOD: Has NO body `{ }` — ends with a semicolon `;`!
    // Forces every concrete subclass to @Override and implement it!
    public abstract double calculateArea();
}
```

---

## 2. The 5 Compiler Rules of `abstract` Classes and Methods
1. **Cannot Be Instantiated Directly**: Writing `new Shape("Red")` is a **compile-time error** (`Shape is abstract; cannot be instantiated`). You can still declare `Shape` **reference variables** (`Shape s = new Circle("Red", 5.0);`) for polymorphism!
2. **An `abstract` Method Has No Body**: Declared with `abstract` and ends with a semicolon: `public abstract double calculateArea();`.
3. **Any Class Containing an `abstract` Method MUST Be Declared `abstract class`**.
4. **An `abstract` Class CAN Have Concrete Members Too**: It can have instance fields, **constructors** (called by subclasses via `super(...)`), and normal concrete methods with `{ ... }` bodies!
5. **Subclass Contract**: Any non-abstract subclass that `extends` an `abstract` class **MUST `@Override` and implement ALL inherited `abstract` methods**!

---

## 3. Common Pitfalls
1. **Combining `abstract` with `private`, `static`, or `final`**:
   - An `abstract` method *must* be overridden by a subclass, whereas `private`, `static`, and `final` methods *cannot* be overridden! Therefore, `private abstract`, `static abstract`, and `final abstract` are illegal in Java.
2. **Thinking `abstract` Classes Cannot Have Constructors**:
   - Even though you cannot call `new AbstractClass()` directly, an `abstract` class **always has a constructor** so its subclasses can initialize the parent's fields via `super(...)`!

---

## 4. Real-World Use Cases
- **Template Method Design Pattern (`DataExporter`, `ReportGenerator`)**: An `abstract` base class implements the shared steps (`openFile()`, `closeFile()`) in concrete methods and declares the format-specific step (`protected abstract String formatRow(String data);`) as `abstract` for `CsvExporter` and `JsonExporter` to implement.
