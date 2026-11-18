# Lesson 04: Create Your First Class — Part 1 (Defining Fields, Methods & Instantiating with `new`)

## 1. Anatomy of a Custom Java Class
When designing a class from scratch, structure its members in a clean, standard order:

```java
class Book {
    // 1. INSTANCE FIELDS (State / Attributes)
    String title;
    String author;
    int pageCount;
    boolean isCheckedOut;

    // 2. INSTANCE METHODS (Behavior / Actions)
    void checkOut() {
        isCheckedOut = true;
    }

    void returnBook() {
        isCheckedOut = false;
    }
}
```

---

## 2. Default Values of Instance Fields vs. Local Variables
In Module 1, we saw that **local variables** inside a method do **not** get default values (using an uninitialized local variable fails to compile).

**Instance fields** inside a class are different! When you allocate an object on the Heap with `new Book()`, the JVM automatically zeroes out the object's memory block, giving every instance field a **guaranteed default value**:

| Field Data Type | Default Value on the Heap |
| :--- | :--- |
| `byte`, `short`, `int`, `long` | `0` (`0L`) |
| `float`, `double` | `0.0f`, `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` (null character) |
| **Any Reference Type (`String`, Arrays, Objects)** | **`null`** |

---

## 3. What the `new` Keyword Actually Does at Runtime
When Java executes `Book myBook = new Book();`:
1. **`new`**: Allocates a fresh block of memory on the **JVM Heap** large enough to hold all instance fields of `Book` and initializes them to their default values.
2. **`Book()`**: Invokes the class constructor to perform any setup.
3. **`Book myBook = ...`**: Stores the **Heap memory reference address** into the `myBook` reference variable on the **Stack**.
4. **The Dot Operator (`.`)**: Used to access the object's fields and methods (`myBook.title = "Effective Java";`, `myBook.checkOut();`).

---

## 4. Common Pitfalls
1. **`NullPointerException` (`NPE`) on Uninitialized Reference Variables**:
   - Declaring `Book b = null;` and calling `b.checkOut();` crashes at runtime with `java.lang.NullPointerException` because `b` does not point to any object on the Heap!
   - Similarly, calling `myBook.title.toUpperCase()` when `myBook.title` is still its default value (`null`) throws a `NullPointerException`.

---

## 5. Real-World Use Cases
- **Library & Asset Management Systems**: Modeling physical or digital items (`Book`, `LaptopAsset`, `Subscription`) with state transitions (`checkOut()`, `returnItem()`).
