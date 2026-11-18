# Lesson 05: Input and Variables — Part 1 (Primitive Data Types, Variable Declaration & `Scanner` Basics)

## 1. What Is a Variable?
A **variable** is a named memory container on the stack that holds a value of a specific **data type**. Because Java is a **statically typed language**, every variable must be declared with its type before it can be used:

```java
DataType variableName = initialValue;
```
- **Declaration**: `int age;` (Reserves 4 bytes of memory named `age`).
- **Initialization**: `age = 25;` (Stores the first value `25` into `age`).
- **Combined**: `int age = 25;`

---

## 2. Java's 8 Primitive Data Types
Java has exactly **8 primitive types** built into the language keywords (plus reference types like `String`):

| Category | Type | Size | Range / Precision | Example Literal |
| :--- | :--- | :--- | :--- | :--- |
| **Integer** | `byte` | 1 byte (8 bits) | `-128` to `127` | `byte b = 100;` |
| **Integer** | `short` | 2 bytes (16 bits) | `-32,768` to `32,767` | `short s = 30000;` |
| **Integer** | `int` | 4 bytes (32 bits) | `-2,147,483,648` to `2,147,483,647` | `int count = 1_000_000;` |
| **Integer** | `long` | 8 bytes (64 bits) | $\approx \pm 9.22 \times 10^{18}$ | `long worldPop = 8_000_000_000L;` |
| **Floating-Point** | `float` | 4 bytes (32 bits) | ~6–7 decimal digits | `float pi = 3.14f;` |
| **Floating-Point** | `double` | 8 bytes (64 bits) | ~15–16 decimal digits | `double gpa = 3.95;` |
| **Character** | `char` | 2 bytes (16 bits) | Single UTF-16 character (`0` to `65,535`) | `char grade = 'A';` |
| **Boolean** | `boolean` | ~1 byte (JVM-dep) | `true` or `false` | `boolean isPassed = true;` |

> **Note on `String`:** `String` (`String name = "Alice";`) is **not** a primitive type—it is a reference class (`java.lang.String`), though Java gives it special literal syntax with double quotes `"..."`.

---

## 3. Identifier Naming Rules & Conventions
- **Compiler Rules**:
  - Can contain letters, digits (`0-9`), underscores (`_`), or dollar signs (`$`).
  - **Cannot start with a digit** (e.g., `1stPlace` is illegal; `firstPlace` is valid).
  - Cannot be a reserved Java keyword (`int`, `class`, `public`, `boolean`, etc.).
- **Java Style Convention**:
  - Use **lowerCamelCase** for variables and methods (`studentAge`, `totalAccountBalance`).

---

## 4. Reading Console Input with `java.util.Scanner`
To read input typed by the user (or from an input stream), import `java.util.Scanner`:

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
String firstName = scanner.next();       // Reads a single whitespace-delimited word
int age          = scanner.nextInt();    // Reads an int
double salary    = scanner.nextDouble(); // Reads a double
boolean isActive = scanner.nextBoolean();// Reads true or false
```

---

## 5. Common Pitfalls
1. **Forgetting the `L` suffix on `long` literals or `f` suffix on `float` literals**:
   - By default, whole-number literals in Java are `int`, and decimal literals are `double`.
   - `long distance = 5000000000;` fails to compile because `5000000000` exceeds `Integer.MAX_VALUE`. You must write `5000000000L`.
   - `float rate = 4.5;` fails to compile because `4.5` is a `double`. You must write `4.5f`.
2. **Using Uninitialized Local Variables**:
   - Local variables inside methods do **not** get default values. Reading a variable before assigning to it causes a compile-time error: `variable x might not have been initialized`.
3. **`InputMismatchException` in `Scanner`**:
   - If `scanner.nextInt()` is called and the user types `"twenty"`, `Scanner` throws `java.util.InputMismatchException`.

---

## 6. Real-World Use Cases
- **Memory Optimization**: Choosing `byte` or `short` in high-volume binary network buffers or image pixel arrays, and `long` for database primary keys, financial timestamps (epoch milliseconds), and global counters.
