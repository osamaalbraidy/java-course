# Lesson 20: Exception Handling (`try-catch-finally`, Checked vs. Unchecked Exceptions, `throw`, `throws` & Custom Exceptions)

## 1. What Is an Exception?
An **exception** is an abnormal event that occurs during runtime (such as dividing by zero, accessing an out-of-bounds array index, or failing to open a missing file) that disrupts the normal sequential flow of instructions.

Without exception handling, any uncaught exception immediately **crashes the thread/program** and prints a stack trace. **Exception Handling** allows your program to intercept errors gracefully, recover, and keep running!

---

## 2. The Java `Throwable` Hierarchy: Checked vs. Unchecked Exceptions

```
                      [ java.lang.Throwable ]
                         /               \
                        v                 v
            [ java.lang.Error ]     [ java.lang.Exception ]
            (JVM Hardware/Memory:     /                 \
             OutOfMemoryError,       v                   v
             StackOverflowError)  [ Checked Exceptions ] [ RuntimeException ]
                                  (IOException,          (Unchecked:
                                   SQLException)          NullPointerException,
                                                          ArithmeticException,
                                                          IllegalArgumentException)
```

| Category | Examples | Compiler Enforcement |
| :--- | :--- | :--- |
| **1. Unchecked (`RuntimeException` subclasses)** | `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException`, `NumberFormatException` | Represent programming/logic bugs; compiler does **not** force `try-catch` or `throws`. |
| **2. Checked (`Exception` subclasses outside `RuntimeException`)** | `IOException`, `FileNotFoundException`, `SQLException` | Represent external environmental failures; **compiler FORCES you** to either catch (`try-catch`) or declare (`throws`) them! |

---

## 3. Anatomy of `try - catch - finally`, `throw`, and `throws`
1. **`try { ... }`**: Wraps the risky code that might throw an exception.
2. **`catch (ExceptionType ex) { ... }`**: Executes **only if** an exception of `ExceptionType` is thrown inside `try`.
   - **Rule:** When chaining multiple `catch` blocks, always place **more specific child exceptions BEFORE broader parent exceptions** (`catch (ArithmeticException)` before `catch (Exception)`).
3. **`finally { ... }`**: **ALWAYS executes** whether an exception occurred or not! Used to close resources/connections.
4. **`throw new SomeException("message");`**: Used **inside a method body** to manually trigger an exception.
5. **`throws SomeException`**: Placed **in a method signature** (`public void loadData() throws IOException`) to warn callers that this method might throw a checked exception.

---

## 4. Creating Custom Domain Exceptions
Create your own meaningful business exception by extending `Exception` (for a checked exception) or `RuntimeException` (for an unchecked exception) and passing the error message to `super(message);`:
```java
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
```

---

## 5. Real-World Use Cases
- **Financial & API Error Recovery**: Throwing a custom `InsufficientFundsException` or `RateLimitExceededException` and catching it in the controller layer to return a clean error message instead of crashing the server.
