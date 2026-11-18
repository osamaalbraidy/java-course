# Lesson 07: Arithmetic Operators — Part 1 (`+`, `-`, `*`, `/`, `%`, Integer vs. Floating-Point Division)

## 1. The 5 Basic Binary Arithmetic Operators
Java provides five binary arithmetic operators that work on all numeric primitive types (`byte`, `short`, `int`, `long`, `float`, `double`) as well as `char`:

| Operator | Name | Example (`a = 17, b = 5`) | Result |
| :---: | :--- | :--- | :--- |
| `+` | Addition | `a + b` | `22` |
| `-` | Subtraction | `a - b` | `12` |
| `*` | Multiplication | `a * b` | `85` |
| `/` | Division | `a / b` | `3` *(Integer division truncates `.4`!)* |
| `%` | Modulo (Remainder) | `a % b` | `2` *(Because $17 = 5 \times 3 + 2$)* |

---

## 2. Integer Division vs. Floating-Point Division
One of the most critical rules in Java arithmetic is how the `/` operator behaves depending on the **types of its operands**:

### A. Integer Division (`int / int` produces `int`)
When **both** operands are integers (`byte`, `short`, `int`, `long`), Java performs **integer division** and **discards (truncates) the fractional remainder**:
```java
int result = 7 / 2;         // Evaluates to 3 (NOT 3.5!)
double trap = 7 / 2;        // Still evaluates 7 / 2 as int 3 FIRST, then widens 3 to 3.0!
```

### B. Floating-Point Division (At least one `double` or `float`)
If **at least one** operand is a `double` (or `float`), Java promotes the other operand to `double` and performs exact floating-point division:
```java
double exact1 = 7.0 / 2;          // 3.5
double exact2 = (double) 7 / 2;   // 3.5 (Explicitly casts 7 to 7.0 BEFORE dividing)
```

---

## 3. Mastering the Modulo (Remainder) Operator (`%`)
The modulo operator `a % b` returns the **remainder** left over after dividing `a` by `b`.
It satisfies the mathematical identity:
$$(a / b) \times b + (a \bmod b) = a$$

### Everyday Programming Uses of `%`:
1. **Even / Odd Check**: `n % 2 == 0` is `true` for even numbers; `n % 2 != 0` for odd numbers.
2. **Extracting Last Digit(s)**:
   - `1234 % 10` $\rightarrow$ `4` (last digit)
   - `1234 / 10` $\rightarrow$ `123` (removes the last digit!)
3. **Wrapping Around Cyclic Ranges (Clocks, Circular Arrays, Unit Conversions)**:
   - Converting `135` total minutes into hours and remaining minutes:
     - `int hours = 135 / 60;` (`2`)
     - `int remainingMinutes = 135 % 60;` (`15`)

---

## 4. Common Pitfalls
1. **Assigning `int / int` to a `double` variable**:
   - Writing `double average = totalScore / count;` when both variables are `int` loses the decimal **before** assignment! Always cast one operand: `(double) totalScore / count`.
2. **Division by Zero (`ArithmeticException` vs. `Infinity`)**:
   - **Integer division by zero** (`10 / 0` or `10 % 0`) immediately crashes at runtime with `java.lang.ArithmeticException: / by zero`.
   - **Floating-point division by zero** (`10.0 / 0.0`) follows IEEE 754 rules and returns `Infinity` (or `NaN` for `0.0 / 0.0`) without throwing an exception!
3. **Negative Remainder Sign**:
   - In Java, the sign of `a % b` always matches the sign of the **dividend (`a`)**: `-17 % 5` is `-2`, whereas `17 % -5` is `+2`.

---

## 5. Real-World Use Cases
- **ATM Cash Dispensers & Coin Changers**: Using `/` and `%` cascades to break `$187` into `$100`, `$50`, `$20`, `$10`, `$5`, and `$1` bills.
- **Pagination & Grid Layouts**: Calculating total pages needed for `totalItems` when showing `pageSize` items per page.
