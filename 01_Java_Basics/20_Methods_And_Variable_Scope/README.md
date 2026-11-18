# Lesson 20: Methods and Variable Scope (Local Scope, Block Scope, Shadowing & Lifetime)

## 1. What Is Variable Scope and Lifetime?
- **Scope**: The region of a program's source code where a variable can be referenced by its name.
- **Lifetime**: The duration during runtime that a variable's memory slot exists before being destroyed.

In Java, scope is strictly determined by **curly braces `{ }`**: a variable is visible from the line where it is declared down to the **closing curly brace `}` of the block in which it was declared**.

---

## 2. Three Levels of Variable Scope in Java

| Scope Level | Where Declared | Visibility | Lifetime |
| :--- | :--- | :--- | :--- |
| **1. Class / Static Scope** | Inside `class`, outside all methods (`static int maxUsers = 100;`) | Visible to **all methods** in the class. | Lives for the entire duration of the program. |
| **2. Method Local Scope** | Parameters or variables declared inside a method (`void foo(int p) { int x = 1; }`) | Visible **only inside that method** (from declaration to `}`). | Created when method is called; **destroyed when method returns**. |
| **3. Block / Loop Scope** | Inside an `if { }`, `for (...) { }`, or `{ }` block | Visible **only inside that inner `{ }` block**. | Created on entering block; destroyed at block's closing `}`. |

---

## 3. Variable Shadowing
**Variable shadowing** occurs when a local variable (or parameter) inside a method declares the **exact same name** as a class-level field:

```java
public class Example {
    static String environment = "PRODUCTION"; // Class-level field

    public static void main(String[] args) {
        String environment = "LOCAL_DEV"; // Shadows the class-level field!
        System.out.println(environment);          // Prints "LOCAL_DEV" (nearest scope wins)
        System.out.println(Example.environment);  // Prints "PRODUCTION" (explicit class qualifier)
    }
}
```
> **Note:** While a local variable **can** shadow a class-level field, Java **forbids** declaring a variable in a nested block (`if`, `for`) with the same name as a local variable already in the enclosing method!

---

## 4. Common Pitfalls
1. **Trying to Access a Loop or `if`-Block Variable Outside Its Braces**:
   ```java
   if (score > 50) {
       String message = "Passed!";
   }
   // System.out.println(message); // COMPILE ERROR: cannot find symbol `message`!
   ```
2. **Duplicate Local Variable in Nested Block**:
   ```java
   int i = 10;
   for (int i = 0; i < 5; i++) { } // COMPILE ERROR: variable `i` is already defined in method!
   ```
3. **Accidentally Shadowing a Class Field**:
   - Writing `int totalCount = 50;` inside a method when you meant to update the class field `totalCount = 50;` creates a brand-new local variable and leaves the class field untouched!

---

## 5. Real-World Use Cases
- **Principle of Least Privilege (Minimize Scope)**: Declaring variables in the narrowest possible block (e.g., declaring `int i` inside `for (int i = 0; ...)` rather than at the top of a 100-line method) prevents accidental reuse or state corruption.
