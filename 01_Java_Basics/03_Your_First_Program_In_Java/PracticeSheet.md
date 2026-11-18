# Practice Sheet: Lesson 03 — Your First Program in Java

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/03_Your_First_Program_In_Java/Exercise.java) to solidify your understanding of Java class structure, comments, and `public static void main(String[] args)`.

---

## Problem 1: Signature Anatomy Explainer (Easy)
### Description
Print five lines explaining each keyword in `public static void main(String[] args)` in your own words (following the exact prefix format below).

### Expected Output
```
public     : Visible to the JVM from anywhere
static     : Belongs to the class itself; no object needed
void       : Returns nothing when execution finishes
main       : Entry-point method name searched by the JVM
String[]   : Array of command-line text arguments
```
### Edge-Case Hints
- Remember that every `System.out.println(...)` statement must end with a semicolon `;`.

---

## Problem 2: Fixing Broken Syntax (Medium)
### Description
Inside `solveProblem2()` of `Exercise.java`, you will find three commented-out lines of broken Java code:
```java
// system.out.println("Line 1: Case sensitivity matters!")
// System.out.println(Line 2: Quotes matter!);
// System.Out.Println("Line 3: Method casing matters!");
```
Uncomment and fix all three lines so they compile and print cleanly.

### Expected Output
```
Line 1: Case sensitivity matters!
Line 2: Quotes matter!
Line 3: Method casing matters!
```
### Edge-Case Hints
- Check capitalization of `System`, `out`, and `println`, string double quotes `"..."`, and trailing semicolons `;`.

---

## Problem 3: Command-Line Argument Echo Simulator (Hard)
### Description
Write code in `solveProblem3(String[] args)` that checks how many command-line arguments were passed into `args`:
- If `args.length == 0`, print: `"Arguments count: 0 (Default Mode)"`
- Otherwise, print `"Arguments count: " + args.length + " | First arg: " + args[0]`
In `main()`, call `solveProblem3(args)` first, and then test it a second time by passing a simulated array: `solveProblem3(new String[]{"--env=prod", "--port=9090"})`.

### Expected Output (when run with no CLI args)
```
Arguments count: 0 (Default Mode)
Arguments count: 2 | First arg: --env=prod
```
### Edge-Case Hints
- Never access `args[0]` without first checking `args.length > 0`, or Java will throw an `ArrayIndexOutOfBoundsException`!
