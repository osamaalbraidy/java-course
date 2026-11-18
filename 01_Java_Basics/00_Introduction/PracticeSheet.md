# Practice Sheet: Lesson 00 — Introduction to Java Architecture

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/00_Introduction/Exercise.java). Each problem builds your familiarity with the JVM environment, compilation pipeline, and runtime introspection.

---

## Problem 1: JDK, JRE, and JVM Component Classifier (Easy)
### Description
Print a structured summary table to the console that classifies which layer (`JVM`, `JRE`, or `JDK`) is responsible for each of the following tools/components:
1. `javac` (Java Compiler)
2. `Standard Class Libraries (java.lang, java.util)`
3. `Garbage Collector (GC) & JIT Compiler`

### Expected Output Format
```
Component                                     | Layer
----------------------------------------------+------
javac (Java Compiler)                         | JDK
Standard Class Libraries (java.lang, util)    | JRE
Garbage Collector (GC) & JIT Compiler         | JVM
```
### Edge-Case Hints
- Ensure your column alignment is clean and easy to read.

---

## Problem 2: WORA Platform Inspector (Medium)
### Description
Using `System.getProperty(...)`, fetch and display the current user's working directory (`"user.dir"`), the Java Class Version (`"java.class.version"`), and the file separator character (`"file.separator"`) used by the host OS.

### Sample Output (Windows with Java 17)
```
Working Directory : d:\Dev\09-Courses\Java
Class Format Ver  : 61.0
OS File Separator : \
```
### Edge-Case Hints
- Java 17 uses class file version `61.0` (Java 8 uses `52.0`, Java 11 uses `55.0`, Java 21 uses `65.0`).
- Property keys are case-sensitive (`"user.dir"`, not `"User.Dir"`).

---

## Problem 3: JVM Heap Used-Memory Calculator (Hard)
### Description
Query `Runtime.getRuntime()` to calculate how many **Kilobytes (KB)** of heap memory are currently **in use** by your Java program.
$$\text{Used Memory (bytes)} = \text{Total Allocated Memory} - \text{Free Memory}$$
Convert the result from bytes to Kilobytes by dividing by `1024`, and print total, free, and used memory in KB.

### Sample Output
```
Total Heap (KB) : 260096
Free Heap (KB)  : 254112
Used Heap (KB)  : 5984
```
### Edge-Case Hints
- `Runtime.getRuntime().totalMemory()` and `freeMemory()` return `long` values in **bytes**. Always store memory measurements in `long` variables rather than `int` to avoid integer overflow on machines with >2 GB of RAM.
