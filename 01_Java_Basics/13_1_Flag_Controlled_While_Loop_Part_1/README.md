# Lesson 13.1: Flag-Controlled `while` Loop — Part 1 (Boolean Flags & Input Validation Loops)

## 1. What Is a Flag-Controlled `while` Loop?
In Lesson 13, we used **counter-controlled** `while` loops where we knew in advance how many iterations were needed (`1` to `10`).

However, in many real-world scenarios—such as waiting for a user to enter a valid age, guessing a secret number, or polling a server until it comes online—**we do not know in advance how many iterations it will take**.

A **flag-controlled `while` loop** uses a `boolean` variable (called a **flag**) to control when the loop terminates:

```java
boolean isValidInput = false; // 1. Initialize boolean flag

while (!isValidInput) {       // 2. Continue looping while flag is false
    int age = scanner.nextInt();
    if (age >= 1 && age <= 120) {
        isValidInput = true;  // 3. Flip the flag to true to exit the loop!
    } else {
        System.out.println("Invalid age! Please try again.");
    }
}
```

---

## 2. Naming Boolean Flags Clearly
Good boolean flag names read like natural English assertions after `while`:
- **Positive State Flags** (loop while `!flag`):
  - `boolean isAuthenticated = false;` $\rightarrow$ `while (!isAuthenticated)`
  - `boolean isTargetFound = false;` $\rightarrow$ `while (!isTargetFound)`
  - `boolean isValid = false;` $\rightarrow$ `while (!isValid)`
- **Continuation Flags** (loop while `flag`):
  - `boolean isRunning = true;` $\rightarrow$ `while (isRunning)`
  - `boolean keepSearching = true;` $\rightarrow$ `while (keepSearching)`

---

## 3. Input Validation Loop Pattern
Whenever your program accepts untrusted input from a user, wrap the input prompt in a flag-controlled validation loop so bad data never corrupts downstream logic:
1. Check `scanner.hasNextInt()` first if non-numeric text is possible (and discard bad tokens with `scanner.next()`).
2. Check domain boundaries (e.g., `score >= 0 && score <= 100`).
3. Flip `isValid = true;` only when all checks pass.

---

## 4. Common Pitfalls
1. **Using `=` Instead of `==` Inside `while (flag == false)`**:
   - Writing `while (isFound = false)` **assigns** `false` to `isFound` and never enters the loop!
   - Writing `while (isRunning = true)` **assigns** `true` to `isRunning` and creates an **infinite loop**!
   - **Best Practice**: Never compare a `boolean` to `true` or `false` with `==`. Write `while (isRunning)` or `while (!isFound)`.
2. **Expecting the Loop to Exit Instantly When the Flag Flips**:
   - Setting `isFound = true;` in the middle of the loop body does **not** jump out immediately (`break` does that); the remaining lines in the current iteration still finish before the `while (!isFound)` condition is re-checked at the top of the next iteration!

---

## 5. Real-World Use Cases
- **CLI & Web Form Validation**: Prompting for a valid port number (`1024..65535`) or positive deposit amount until valid input is supplied.
- **Service Health Polling**: Polling a database container every second until `isDatabaseReady` flips to `true`.
