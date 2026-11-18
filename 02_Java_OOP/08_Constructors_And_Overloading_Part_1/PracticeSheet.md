# Practice Sheet: Lesson 08 — Constructors and Overloading (Part 1)

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/08_Constructors_And_Overloading_Part_1/Exercise.java) to practice writing no-arg and parameterized constructors.

---

## Problem 1: Fixing the "Method Disguised as a Constructor" Bug (Easy)
### Description
In `Exercise.java`, the `PodcastEpisode` class has a broken constructor because a developer accidentally wrote `public void PodcastEpisode(String title, int durationMinutes)` (including a `void` return type!).
Because of that `void` keyword, Java treated `PodcastEpisode(...)` as a normal method and synthesized an empty default constructor instead, leaving `title` as `null` and `durationMinutes` as `0`!
Fix `PodcastEpisode` by removing `void` from its constructor signature so `new PodcastEpisode("Java Deep Dive", 45)` compiles and initializes the fields properly.

### Expected Output
```
Podcast: "Java Deep Dive" (45 mins)
```
### Edge-Case Hints
- Constructors **never** have a return type (not even `void`).

---

## Problem 2: Restoring the Missing No-Arg Constructor in `ServerInstance` (Medium)
### Description
In `ServerInstance`, a parameterized constructor `public ServerInstance(String region, int vCpuCount)` was added. Now `solveProblem2()` wants to create both:
1. A default server using `new ServerInstance()` (which should set `region = "us-east-1"` and `vCpuCount = 2`).
2. A custom server using `new ServerInstance("eu-west-1", 16)`.
Add the explicit no-arg constructor `public ServerInstance()` to `ServerInstance` and instantiate both objects in `solveProblem2()`.

### Expected Output
```
Server [Region: us-east-1 | vCPUs: 2]
Server [Region: eu-west-1 | vCPUs: 16]
```
### Edge-Case Hints
- Remember: once you define any parameterized constructor, `javac` no longer generates the default no-arg constructor for you!

---

## Problem 3: Parameterized Constructor with Validation Guards (`BankVaultAccount`) (Hard)
### Description
Complete the `BankVaultAccount` class in `Exercise.java` by writing a parameterized constructor `public BankVaultAccount(String ownerName, double initialDeposit)`:
- If `ownerName == null || ownerName.trim().isEmpty()`, default `this.ownerName = "Unknown Owner"`; else `this.ownerName = ownerName.trim()`.
- If `initialDeposit < 50.0` (minimum opening deposit is `$50.00`), print `"Warning: Minimum opening deposit is $50.00. Setting initial balance to $50.00."` and set `this.balance = 50.00`; else set `this.balance = initialDeposit`.
Test it in `solveProblem3()` with `("  Clara Oswald  ", 500.00)` and `("", 10.00)`.

### Expected Output
```
Account [Owner: Clara Oswald | Balance: $500.00]
Warning: Minimum opening deposit is $50.00. Setting initial balance to $50.00.
Account [Owner: Unknown Owner | Balance: $50.00]
```
### Edge-Case Hints
- Validating inside the constructor guarantees that no `BankVaultAccount` object can ever exist in memory with a balance below `$50.00`!
