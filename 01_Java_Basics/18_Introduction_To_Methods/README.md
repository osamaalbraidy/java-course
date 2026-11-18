# Lesson 18: Introduction to Methods (Method Declaration, Calling `void` Methods & Call Stack Flow)

## 1. What Is a Method and Why Do We Use Them?
A **method** is a named, reusable block of code inside a class that performs a specific task.
Until now, we placed almost all our code inside `main()`. As applications grow, putting thousands of lines inside `main()` creates unmaintainable code.

Methods provide three major benefits:
1. **DRY Principle (Don't Repeat Yourself)**: Write logic once, call it from anywhere.
2. **Modularity & Readability**: Break complex workflows into small, self-descriptive steps (`validateOrder()`, `chargeCard()`, `sendReceiptEmail()`).
3. **Easier Debugging & Testing**: Test each method in isolation.

---

## 2. Anatomy of a Method Declaration

```java
public static void printBanner() {
    System.out.println("========================");
}
```
- **`public`**: Access modifier (visible outside the class).
- **`static`**: Allows the method to be called directly from `public static void main` without creating an object instance.
- **`void`**: Return type indicating the method performs an action and returns **no value**.
- **`printBanner`**: Method name (always uses **lowerCamelCase** and starts with a verb).
- **`()`**: Parameter list (empty here because it requires no inputs).

---

## 3. How the JVM Call Stack Executes Methods (LIFO: Last-In, First-Out)
When Method A calls Method B, and Method B calls Method C, the JVM tracks execution using the **Call Stack**:
1. `main()` is pushed onto the bottom of the Call Stack.
2. When `main()` calls `stepOne()`, a new **stack frame** for `stepOne()` is pushed on top of `main()`, and `main()` pauses.
3. When `stepOne()` finishes (hits its closing `}` or `return;`), its stack frame is **popped** off the stack, and execution resumes in `main()` on the exact line after the call!

```
  [ Top of Stack ]
  +--------------------+
  | verifyDatabase()   |  <-- Currently executing (Pops 1st)
  +--------------------+
  | initializeServer() |  <-- Paused at line calling verifyDatabase() (Pops 2nd)
  +--------------------+
  | main(String[] args)|  <-- Paused at line calling initializeServer() (Pops Last)
  +--------------------+
```

---

## 4. Common Pitfalls
1. **Declaring a Method *Inside* Another Method**:
   - In Java, you **cannot** nest a method declaration inside `main()`! All methods must be declared directly inside the `class { ... }` body, as siblings of `main()`.
2. **Calling a Non-Static Method from `static main()`**:
   - Forgetting `static` on a helper method causes: `non-static method myHelper() cannot be referenced from a static context`.
3. **Forgetting Parentheses `()` When Calling a Method**:
   - Writing `printBanner;` instead of `printBanner();` is a syntax error.

---

## 5. Real-World Use Cases
- **Application Bootstrap Pipelines**: Decomposing startup into `loadConfig()`, `connectDatabase()`, `startHttpServer()`, and `printStartupSummary()`.
