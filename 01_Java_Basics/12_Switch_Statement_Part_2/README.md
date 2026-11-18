# Lesson 12: `switch` Statement — Part 2 (Fall-Through Grouping, `String` `switch` & Modern `switch` Expressions)

## 1. Intentional Fall-Through (Grouping Multiple Cases)
While **accidental** fall-through is a bug, **intentional** fall-through allows multiple `case` labels to share a single block of code cleanly:

```java
switch (month) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
        days = 31;
        break;
    case 4:
    case 6:
    case 9:
    case 11:
        days = 30;
        break;
    case 2:
        days = 28;
        break;
}
```

---

## 2. Switching on `String` (Java 7+)
Since Java 7, `switch` supports `String` expressions. Under the hood, the compiler uses `String.hashCode()` followed by `.equals()` for safety.
- **Case Sensitivity**: `switch (command)` is **case-sensitive** (`"START"` != `"start"`).
- **Idiom for Case-Insensitive `switch`**: Convert the input first: `switch (command.toUpperCase())` or `switch (command.toLowerCase())`.
- **Null Warning**: If the `String` passed to `switch (str)` is `null`, Java immediately throws a `NullPointerException`!

---

## 3. Modern Java 14+ / 17 LTS `switch` Expressions (`->` and `yield`)
Java 14 standardized **Switch Expressions** (a major Java 17 LTS feature), fixing all the headaches of traditional `switch`:
1. **Arrow Syntax (`case X ->`)**: Executes **only** the code to the right of `->`—**no `break` needed, and zero risk of accidental fall-through!**
2. **Comma-Separated Case Lists**: Write `case 1, 3, 5, 7, 8, 10, 12 -> 31;` on a single line!
3. **Returns a Value Directly**: A `switch` expression can be assigned directly to a variable (`int days = switch (month) { ... };`).
4. **Multi-Line Blocks with `yield`**: If an arrow branch needs multiple lines of logic, wrap them in `{ ... }` and use `yield value;` to return the result from that branch.

```java
String dayType = switch (dayOfWeek) {
    case 1, 2, 3, 4, 5 -> "Weekday (Work)";
    case 6, 7          -> "Weekend (Rest)";
    default            -> {
        System.out.println("Warning: Out-of-range day: " + dayOfWeek);
        yield "Invalid Day";
    }
};
```

---

## 4. Common Pitfalls
1. **Mixing `:` and `->` in the Same `switch`**:
   - You cannot mix traditional `case 1:` colons and modern `case 2 ->` arrows in the same `switch` block.
2. **Non-Exhaustive `switch` Expressions**:
   - When a `switch` expression returns a value (`String s = switch (x) { ... };`), it **must be exhaustive** (cover all possible input values, which almost always requires a `default ->` branch).
3. **Passing `null` into `switch (str)`**:
   - Always check `if (str == null)` before switching on a `String`.

---

## 5. Real-World Use Cases
- **Command & Event Routers**: Mapping CLI commands (`"deploy"`, `"rollback"`, `"status"`) or currency codes (`"USD"`, `"EUR"`, `"GBP"`, `"JPY"`) cleanly using Java 17 `switch` expressions.
