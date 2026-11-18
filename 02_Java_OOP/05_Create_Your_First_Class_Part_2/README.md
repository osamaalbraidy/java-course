# Lesson 05: Create Your First Class — Part 2 (Getters, Setters & Validation Inside Setters)

## 1. What Are Getters (Accessors) and Setters (Mutators)?
When we encapsulate a class by marking all its fields `private`, external classes can no longer read or modify those fields directly (`product.price = 19.99;` will not compile).

To provide controlled read/write access, Java follows the **JavaBeans Naming Convention**:
1. **Getter (Accessor Method)**: Reads and returns the value of a `private` field.
   - Naming rule: **`getFieldName()`** (or **`isFieldName()`** for `boolean` fields!).
   - Takes **0 parameters** and returns the field's data type.
2. **Setter (Mutator Method)**: Validates a new value and updates the `private` field.
   - Naming rule: **`setFieldName(Type newValue)`**.
   - Takes **1 parameter** of the field's type and typically returns `void`.

---

## 2. Why Use Getters and Setters Instead of `public` Fields?
Beginners often ask: *"If I just add a getter and setter for every `private` field, isn't that the same as making the field `public`?"*
**No! Here are 4 powerful advantages:**
1. **Input Validation (Guard Clauses)**: A setter can reject negative prices, empty strings, or out-of-range percentages before they ever touch the `private` field!
2. **Read-Only or Write-Only Fields**:
   - Provide a **Getter with NO Setter** (`getAccountId()`) so external code can read the ID, but can never overwrite it!
3. **Computed / Derived Properties**:
   - `getDiscountedPrice()` can compute a value on the fly without needing an extra field stored in RAM.
4. **Future-Proof Internal Refactoring**:
   - You can change how a field is stored internally (e.g., storing cents as `long` instead of `double`) without breaking a single caller that uses `getPrice()`!

---

## 3. Common Pitfalls
1. **Unconditional "Blind" Setters (`this.age = age;`)**:
   - Writing a setter that accepts `-50` for `age` or `""` for `name` defeats half the purpose of encapsulation. Always validate domain rules inside setters!
2. **Wrong Boolean Getter Prefix**:
   - For `private boolean active;`, the standard Java convention is `public boolean isActive()`, whereas for `String name`, it is `public String getName()`.

---

## 4. Real-World Use Cases
- **Enterprise Frameworks (Spring, Jackson JSON, Hibernate JPA)**: Automatically inspect `getXxx()`, `isXxx()`, and `setXxx()` methods to serialize Java objects to JSON and map database rows to entities.
