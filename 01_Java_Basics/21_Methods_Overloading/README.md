# Lesson 21: Method Overloading (Compile-Time Polymorphism, Signature Rules & Type Promotion)

## 1. What Is Method Overloading?
**Method Overloading** (also called **Compile-Time Polymorphism** or **Static Binding**) allows multiple methods in the **same class** to share the **exact same name**, provided their **parameter lists** are different.

For example, `System.out.println(...)` and `Math.max(...)` are heavily overloaded in the Java standard library:
- `Math.max(int a, int b)`
- `Math.max(long a, long b)`
- `Math.max(double a, double b)`

Instead of forcing developers to memorize `maxInt`, `maxLong`, and `maxDouble`, Java lets you call `Math.max(...)` and automatically resolves the matching version at **compile time**!

---

## 2. The Golden Rule of Method Signatures
In Java, a **Method Signature** consists of **ONLY two things**:
$$\text{Method Signature} = \text{Method Name} + \text{Ordered Parameter Types}$$

To overload a method validly, you must change **at least one** of the following in the parameter list:
1. **The Number (Arity) of Parameters**: `add(int a, int b)` vs. `add(int a, int b, int c)`
2. **The Data Types of Parameters**: `add(int a, int b)` vs. `add(double a, double b)`
3. **The Order of Mixed Parameter Types**: `log(String msg, int code)` vs. `log(int code, String msg)`

> **CRITICAL RULE:** **Return type and parameter variable names are NOT part of the method signature!**
> Declaring `int compute(int x)` and `double compute(int y)` in the same class is a **compile-time error** (`method compute(int) is already defined`).

---

## 3. Automatic Type Promotion in Overloaded Calls
What happens if you call `process(5)` (passing an `int`), and there is **no** `process(int)` method, but there **is** a `process(double)` method?
Java's compiler automatically **widens (promotes)** the argument along the widening chain:
`byte -> short -> int -> long -> float -> double` (and `char -> int`).

---

## 4. Common Pitfalls
1. **Trying to Overload by Changing Only the Return Type**:
   - If you call `compute(10);`, the compiler cannot tell whether you wanted the `int` version or the `double` version!
2. **Ambiguous Method Call Error (`reference to ... is ambiguous`)**:
   - Suppose you define `test(int a, double b)` and `test(double a, int b)`.
   - Calling `test(10, 20)` (two `int` arguments) fails to compile because **both** methods require one `int -> double` promotion, so neither is more specific!

---

## 5. Real-World Use Cases
- **Default Argument Emulation**: Since Java does not have Python/C++ default parameter syntax (`void connect(String host, int port = 8080)`), Java developers overload `connect(String host)` to delegate to `connect(host, 8080)`!
- **Flexible Logging & Formatting APIs**: `log(String message)`, `log(String message, int errorCode)`, `log(String category, String message, double durationMs)`.
