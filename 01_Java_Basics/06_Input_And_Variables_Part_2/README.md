# Lesson 06: Input and Variables — Part 2 (Type Casting, `final` Constants & `Scanner` Buffer Quirks)

## 1. Type Casting in Java (Widening vs. Narrowing)
**Type casting** converts a value from one primitive data type to another.

```
WIDENING (Implicit / Automatic — Safe, No Data Footprint Loss):
byte (1B) -> short (2B) -> int (4B) -> long (8B) -> float (4B) -> double (8B)
                  char (2B) ------^

NARROWING (Explicit Cast Required — Risk of Truncation or Overflow):
double -> float -> long -> int -> short -> byte
```

### A. Implicit Widening Conversion
When assigning a smaller type to a larger type, Java converts it automatically:
```java
int items = 42;
double preciseItems = items; // Automatically becomes 42.0
```

### B. Explicit Narrowing Conversion
When assigning a larger type to a smaller type, you **must** write an explicit cast `(TargetType)` to acknowledge potential loss of fractional digits or range overflow:
```java
double price = 19.99;
int wholeDollars = (int) price; // Truncates decimal part -> 19 (Does NOT round to 20!)
```

---

## 2. Constants with the `final` Keyword
If a variable's value should **never change** after initialization, declare it with the `final` keyword.
- **Naming Convention**: Use `UPPER_SNAKE_CASE` for constants.
- **Compiler Enforcement**: Any attempt to reassign a `final` variable triggers a compilation error: `cannot assign a value to final variable`.

```java
final double EARTH_GRAVITY_M_S2 = 9.80665;
final int MAX_LOGIN_ATTEMPTS = 3;
```

---

## 3. The Classic `Scanner` Buffer Quirk (`nextInt()` followed by `nextLine()`)
One of the most famous beginner bugs in Java happens when you call `scanner.nextLine()` immediately after `scanner.nextInt()` (or `nextDouble()` / `next()`):

### Why It Happens
Suppose the user types `25` and presses **Enter**. The input buffer actually contains:
`"25\n"`
1. `int age = scanner.nextInt();` reads the digits `25`, **but leaves the trailing newline `\n` sitting in the buffer!**
2. `String fullName = scanner.nextLine();` reads everything up to the next `\n`. Because `\n` is sitting right at the front of the buffer, `nextLine()` immediately consumes that leftover `\n` and returns an **empty string `""`** without waiting for the user!

### Two Ways to Fix It
1. **Consume the leftover newline**: Call an extra `scanner.nextLine();` right after `nextInt()` to flush the line break before reading the real `nextLine()`.
2. **Parse whole lines**: Read every line with `scanner.nextLine()` and convert numbers using `Integer.parseInt(scanner.nextLine())`.

---

## 4. Common Pitfalls
- **Assuming `(int) 9.99` Rounds to `10`**: Casting `double` to `int` **truncates** (chops off) the decimal portion toward zero, yielding `9`. Use `Math.round(9.99)` if you want mathematical rounding.
- **Narrowing Overflow (`(byte) 130`)**: Since `byte` only holds `-128` to `127`, casting `130` to `(byte)` wraps around the 8-bit binary representation to `-126`!
- **Casting `String` to `int` with `(int) "123"`**: Primitive casting `(int)` only works between numeric/char primitives. To convert a `String` to an `int`, use `Integer.parseInt("123")`.

---

## 5. Real-World Use Cases
- **Configuration Constants (`final`)**: Defining tax rates, mathematical constants, maximum retry thresholds, and timeout limits so magic numbers aren't scattered across code.
- **Interactive CLI Forms**: Properly flushing the `Scanner` buffer when collecting mixed numeric IDs and multi-word addresses/names from a user.
