# Practice Sheet: Lesson 16 — `final` Methods and `protected` Members

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/16_Final_Methods_And_Protected_Members/Exercise.java).

---

## Problem 1: The 3 Uses of `final` Summary (Easy)
### Description
In `solveProblem1()`, print the exact meaning of `final` when applied to a **Variable**, a **Method**, and a **Class**.

### Expected Output
```
1. final Variable : Value cannot be reassigned after initialization (Constant)
2. final Method   : Method cannot be overridden (@Override) by any subclass
3. final Class    : Class cannot be extended (subclassed) by any other class
```
### Edge-Case Hints
- Remember that `java.lang.String` and `java.lang.Math` are famous examples of `final` classes in the JDK!

---

## Problem 2: Accessing `protected` Parent Members in `GameEntity` -> `BossMonster` (Medium)
### Description
Create a parent class `GameEntity` with `protected String entityName;` and `protected int healthPoints;`, plus a `protected void heal(int amount)` helper method.
Create a subclass `BossMonster extends GameEntity` with `public void triggerEnragePhase()` that directly reads `this.entityName`, calls the inherited `heal(250)`, and prints the boss's enraged health!

### Expected Output
```
Boss [Shadow Dragon] triggered Enrage Phase! Healed +250 HP -> Current HP: 750
```
### Edge-Case Hints
- Because `entityName`, `healthPoints`, and `heal()` are `protected` (rather than `private`), `BossMonster` can access them directly!

---

## Problem 3: Locking a Security Pipeline with a `public final` Method (`Authenticator`) (Hard)
### Description
In `BaseAuthenticator`, define a `public final boolean login(String username, String password)` method that:
1. Prints `"[Security Audit] Login attempt for user: " + username`
2. Calls a `protected boolean verifyCredentials(String username, String password)` method
3. Prints `"[Security Audit] Result: " + (success ? "GRANTED" : "DENIED")` and returns `success`.

Create a subclass `TwoFactorAuthenticator extends BaseAuthenticator` that overrides `protected boolean verifyCredentials(...)` while inheriting the locked `public final boolean login(...)` pipeline!

### Expected Output
```
[Security Audit] Login attempt for user: admin
  -> [2FA Check] Verified password + hardware token for admin
[Security Audit] Result: GRANTED
```
### Edge-Case Hints
- Marking `login(...)` as `final` guarantees that subclasses can customize *how* credentials are verified (`verifyCredentials`), but can **never** disable the mandatory security audit logs!
