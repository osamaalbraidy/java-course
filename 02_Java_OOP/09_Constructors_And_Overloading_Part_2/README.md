# Lesson 09: Constructors and Overloading — Part 2 (Constructor Overloading & Chaining with `this()`)

## 1. What Is Constructor Overloading?
Just like regular methods (Lesson 21), **constructors can be overloaded**! A class can provide multiple constructors with different parameter lists so callers can create objects with varying levels of detail:
- `new SmartWatch()` (0 args: uses default model, color, and strap)
- `new SmartWatch("Ultra 2")` (1 arg: custom model, default color and strap)
- `new SmartWatch("Ultra 2", "Titanium", true)` (3 args: full custom specification)

---

## 2. Constructor Chaining with `this(...)` (Telescoping Constructor Pattern)
If you have 3 overloaded constructors and you copy-paste field assignments and validation logic into all 3 constructors, you violate the **DRY (Don't Repeat Yourself)** principle!

Java solves this with **Constructor Chaining (`this(...)`)**:
- Inside a constructor, calling **`this(arg1, arg2, ...)`** invokes another constructor in the **same class**!
- **Best Practice (Telescoping Pattern)**: Have smaller constructors (`0-arg`, `1-arg`, `2-arg`) delegate upward to ONE **Master (Primary) Constructor** that holds all validation and field assignments:

```java
class SmartWatch {
    private String model;
    private String finish;
    private boolean cellular;

    // 1. 0-Arg Constructor chains to 1-Arg Constructor
    public SmartWatch() {
        this("Series 10");
    }

    // 2. 1-Arg Constructor chains to 3-Arg Master Constructor
    public SmartWatch(String model) {
        this(model, "Midnight Aluminum", false);
    }

    // 3. 3-Arg MASTER CONSTRUCTOR (Single Source of Truth for Initialization & Validation!)
    public SmartWatch(String model, String finish, boolean cellular) {
        this.model = model;
        this.finish = finish;
        this.cellular = cellular;
    }
}
```

---

## 3. Strict Compiler Rules for `this(...)`
1. **Must Be the VERY FIRST Statement in the Constructor**:
   - Writing `System.out.println("Starting...");` *before* `this(...)` fails to compile with: `error: call to this must be first statement in constructor`.
2. **Cannot Call `this(...)` From a Normal Method**:
   - `this(...)` constructor calls are only legal inside constructors.
3. **No Recursive Constructor Cycles**:
   - Constructor A calling Constructor B while Constructor B calls Constructor A fails to compile (`recursive constructor invocation`).

---

## 4. Real-World Use Cases
- **SDK Client & Connection Configurations**: Providing a convenient 1-argument `new HttpClient(baseUrl)` constructor that chains to `this(baseUrl, 5000, 3, true)` with production-ready defaults for timeout, retries, and connection pooling.
