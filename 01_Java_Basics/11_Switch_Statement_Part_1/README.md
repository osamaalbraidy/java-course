# Lesson 11: `switch` Statement — Part 1 (Traditional `switch`, `case`, `break`, `default`)

## 1. When to Use `switch` Instead of `if-else`
When you are comparing a **single variable or expression** against several **discrete constant values** (such as menu choices `1, 2, 3, 4` or status codes `200, 404, 500`), a `switch` statement is cleaner, easier to read, and often compiled by the JVM into a fast jump table (`tableswitch` or `lookupswitch` bytecode).

```java
switch (expression) {
    case CONSTANT_1:
        // Statements for CONSTANT_1
        break;
    case CONSTANT_2:
        // Statements for CONSTANT_2
        break;
    default:
        // Executes if NO case matches (optional, like the final `else`)
        break;
}
```

---

## 2. Anatomy of a Traditional `switch` Statement
1. **`switch (expression)`**: Evaluates once and jumps directly to the matching `case` label.
   - **Allowed Data Types in Java**:
     - Primitives: `byte`, `short`, `char`, `int`
     - Wrapper classes: `Byte`, `Short`, `Character`, `Integer`
     - Reference types: `String` (Java 7+) and `enum` types (Java 5+)
   - **Disallowed Types**: `long`, `float`, `double`, and `boolean` **cannot** be used in a traditional `switch`!
2. **`case value:`**: Must be a **compile-time constant** literal or `final` constant variable (cannot be a dynamic runtime variable or relational expression like `case > 5:`).
3. **`break;`**: Immediately exits the `switch` block. **Without `break;`, execution "falls through" into the next `case` block below it!**
4. **`default:`**: Catch-all branch executed when none of the `case` labels match.

---

## 3. Common Pitfalls
1. **Forgetting `break;` (Accidental Fall-Through)**:
   - If `case 1:` does not end with `break;`, Java executes `case 1:` and then immediately executes `case 2:` (and every case below it until it hits a `break;` or the closing `}` of the `switch`).
2. **Trying to `switch` on a `double` or `long`**:
   - `switch (price)` where `price` is a `double` causes a compile-time error: `selector type double is not allowed`.
3. **Duplicate `case` Labels**:
   - Having two `case 1:` labels in the same `switch` fails to compile (`duplicate case label`).

---

## 5. Real-World Use Cases
- **HTTP Status Code Routers**: Handling `200 (OK)`, `400 (Bad Request)`, `401 (Unauthorized)`, `404 (Not Found)`, and `500 (Internal Server Error)`.
- **ATM / CLI Menu Dispatchers**: Routing user option `1` (Check Balance), `2` (Deposit), `3` (Withdraw), `4` (Exit).
