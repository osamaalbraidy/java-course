# Lesson 04: Displaying Program Output (`print`, `println`, `printf` & Escape Sequences)

## 1. Standard Output Stream (`System.out`)
In Java, `System` is a built-in final class inside the `java.lang` package, and `out` is a static `PrintStream` object connected to the standard console output (your terminal screen).

Java provides three primary methods on `System.out` for displaying text:

### A. `System.out.println(...)` (Print Line)
Prints the argument to the console and **moves the cursor to the beginning of the next line** (appends a newline). Calling `System.out.println()` with no arguments simply prints a blank line.

### B. `System.out.print(...)` (Print Inline)
Prints the argument to the console and **keeps the cursor on the exact same line**. Subsequent output appears immediately next to it.

### C. `System.out.printf(String format, Object... args)` (Print Formatted)
Prints text using **format specifiers** (placeholders starting with `%`) and **does NOT automatically append a newline** (use `%n` for a platform-independent newline).

---

## 2. Mastering `printf` Format Specifiers

| Specifier | Data Type | Example Code | Output |
| :--- | :--- | :--- | :--- |
| `%d` | Integer (`int`, `long`) | `System.out.printf("Age: %d%n", 25);` | `Age: 25` |
| `%,d` | Integer with comma separators | `System.out.printf("Pop: %,d%n", 1500000);` | `Pop: 1,500,000` |
| `%f` | Floating-point (`double`, `float`) | `System.out.printf("Price: %.2f%n", 19.5);` | `Price: 19.50` |
| `%s` | String | `System.out.printf("Hello %s!%n", "Alice");` | `Hello Alice!` |
| `%-12s` | Left-aligned String (width 12) | `System.out.printf("|%-10s|%n", "Java");` | `|Java      |` |
| `%12s` | Right-aligned String (width 12) | `System.out.printf("|%10s|%n", "Java");` | `|      Java|` |
| `%b` | Boolean | `System.out.printf("Active: %b%n", true);` | `Active: true` |
| `%c` | Character | `System.out.printf("Grade: %c%n", 'A');` | `Grade: A` |
| `%%` | Literal percent sign `%` | `System.out.printf("Tax: 15%%%n");` | `Tax: 15%` |
| `%n` | Platform-native newline | `System.out.printf("Line 1%nLine 2%n");` | Newline (`\r\n` on Windows, `\n` on Unix) |

---

## 3. Escape Sequences
An **escape sequence** starts with a backslash `\` and tells the Java compiler to treat the following character specially:

| Escape Sequence | Meaning | Example |
| :--- | :--- | :--- |
| `\n` | Line feed (Newline) | `"First Line\nSecond Line"` |
| `\t` | Horizontal Tab | `"Column1\tColumn2"` |
| `\"` | Double Quote inside a String | `"She said, \"Hello!\""` |
| `\\` | Literal Backslash (Windows file paths) | `"C:\\Users\\Admin\\file.txt"` |
| `\r` | Carriage Return | Moves cursor to start of current line |

---

## 4. Common Pitfalls
1. **String Concatenation vs. Addition (`+` Operator)**:
   - Java evaluates `+` from left to right.
   - `"Result: " + 5 + 3` evaluates to `"Result: 53"` (concatenation!).
   - `"Result: " + (5 + 3)` evaluates to `"Result: 8"` (parentheses force addition first!).
2. **`MissingFormatArgumentException` or `IllegalFormatConversionException` in `printf`**:
   - Passing a `String` into `%d` or providing fewer arguments than `%` specifiers crashes at runtime.
3. **Forgetting `%n` in `printf`**:
   - Unlike `println`, `printf` stays on the same line unless you end the format string with `%n` or `\n`.

---

## 5. Real-World Use Cases
- **CLI Tables, Invoices & Financial Reports**: Aligning columns with `%-20s` and rounding currency values to 2 decimal places with `$%,.2f`.
- **Structured Log Messages**: Formatting timestamps, severity levels, and execution metrics.
