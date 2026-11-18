# Practice Sheet: Lesson 02 — How to Install Java

Complete the exercises in [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/02_How_To_Install_Java/Exercise.java) to master diagnosing JDK configurations and CLI commands.

---

## Problem 1: CLI Command Builder (Easy)
### Description
Given a source file named `App.java` inside package `com.company.app`, print the exact two terminal commands needed to:
1. Compile `com/company/app/App.java` into an output directory named `bin`.
2. Run the compiled `com.company.app.App` class using `bin` as the classpath (`-cp`).

### Expected Output
```
Compile Command : javac -d bin com/company/app/App.java
Execute Command : java -cp bin com.company.app.App
```
### Edge-Case Hints
- Remember: `javac` takes a file path with slashes (`/`) and `.java`, whereas `java` takes a package-qualified class name with dots (`.`) and **no** `.class` extension.

---

## Problem 2: `JAVA_HOME` Validator (Medium)
### Description
Write logic that inspects a candidate `JAVA_HOME` path string:
`String candidatePath = "C:\\Program Files\\Java\\jdk-17.0.1\\bin";`
Check whether `candidatePath.endsWith("bin")`. If it does, strip the trailing `"\\bin"` (using `candidatePath.substring(0, candidatePath.length() - 4)`) and print both the invalid path and the corrected `JAVA_HOME` path.

### Expected Output
```
Original JAVA_HOME  : C:\Program Files\Java\jdk-17.0.1\bin
Corrected JAVA_HOME : C:\Program Files\Java\jdk-17.0.1
```
### Edge-Case Hints
- In Java string literals, a single backslash `\` must be escaped as `\\`.

---

## Problem 3: Class File Version Calculator (Hard)
### Description
Every Java major release increments the `.class` bytecode major version by `1`, adhering to the formula:
$$\text{Class File Major Version} = \text{Java Major Version} + 44$$
(For example, Java 8 = `8 + 44 = 52`, Java 17 = `17 + 44 = 61`, Java 21 = `21 + 44 = 65`).
Compute and print the `.class` bytecode version for **Java 8**, **Java 11**, **Java 17**, and **Java 21**.

### Expected Output
```
Java 8  -> Bytecode Class Version: 52.0
Java 11 -> Bytecode Class Version: 55.0
Java 17 -> Bytecode Class Version: 61.0
Java 21 -> Bytecode Class Version: 65.0
```
### Edge-Case Hints
- Append `".0"` when printing to match the standard `"java.class.version"` format.
