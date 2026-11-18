# Lesson 08: Arithmetic Operators — Part 2 (`++`/`--`, Compound Assignment `+=` & Operator Precedence)

## 1. Increment (`++`) and Decrement (`--`) Operators
The unary increment (`++`) and decrement (`--`) operators add or subtract `1` from a variable. When used inside a larger expression, their position (**prefix** vs. **postfix**) changes the value returned to the expression:

| Form | Syntax | Behavior in an Expression (`int x = 5;`) | `y` Value | Final `x` |
| :--- | :--- | :--- | :---: | :---: |
| **Pre-Increment** | `++x` | Increment `x` **first** (`6`), **then** use the new value | `y = ++x;` $\rightarrow$ `6` | `6` |
| **Post-Increment** | `x++` | Use the **old** value of `x` (`5`) **first**, **then** increment `x` | `y = x++;` $\rightarrow$ `5` | `6` |
| **Pre-Decrement** | `--x` | Decrement `x` **first** (`4`), **then** use the new value | `y = --x;` $\rightarrow$ `4` | `4` |
| **Post-Decrement** | `x--` | Use the **old** value of `x` (`5`) **first**, **then** decrement `x` | `y = x--;` $\rightarrow$ `5` | `4` |

> **Tip:** When written on its own line (`x++;` or `++x;`), both forms produce the exact same result!

---

## 2. Compound Assignment Operators (`+=`, `-=`, `*=`, `/=`, `%=`)
Compound assignment operators combine an arithmetic operation with assignment (`=`):

| Operator | Example | Equivalent Expanded Form |
| :---: | :--- | :--- |
| `+=` | `balance += 50;` | `balance = (Type)(balance + 50);` |
| `-=` | `lives -= 1;` | `lives = (Type)(lives - 1);` |
| `*=` | `price *= 2;` | `price = (Type)(price * 2);` |
| `/=` | `total /= 4;` | `total = (Type)(total / 4);` |
| `%=` | `seconds %= 60;` | `seconds = (Type)(seconds % 60);` |

### Hidden Superpower of Compound Assignment: Implicit Casting
In Java, arithmetic on `byte` or `short` promotes operands to `int`:
```java
byte b = 10;
// b = b + 5; // COMPILE ERROR: (b + 5) is an int, cannot fit in byte without cast!
b += 5;       // VALID! Java translates `b += 5` to `b = (byte)(b + 5)` automatically!
```

---

## 3. Operator Precedence and Associativity
When an expression contains multiple operators, Java evaluates them according to **Operator Precedence** (and **Left-to-Right** associativity for ties, except assignment `=` which is Right-to-Left):

1. **Parentheses**: `( )` *(Highest precedence — always evaluated first)*
2. **Unary Postfix**: `x++`, `x--`
3. **Unary Prefix**: `++x`, `--x`, `+x`, `-x`
4. **Multiplicative**: `*`, `/`, `%` *(Evaluated left-to-right)*
5. **Additive**: `+`, `-` *(Evaluated left-to-right)*
6. **Assignment**: `=`, `+=`, `-=`, `*=`, `/=`, `%=` *(Evaluated right-to-left)*

---

## 4. Common Pitfalls
1. **Writing `x = x++;` (The Self-Post-Increment Bug)**:
   - `x = x++;` saves the old value of `x` (say `5`), increments `x` to `6`, and then **overwrites `x` back with the saved old value `5`**! `x` stays `5` forever. Just write `x++;`.
2. **Right-Hand Side Precedence in Compound Assignment**:
   - `int x = 10; x *= 2 + 3;` evaluates to `x = 10 * (2 + 3) = 50` (NOT `10 * 2 + 3 = 23`), because the entire right-hand side of `*=` is evaluated before multiplying!
3. **Overly Clever Multi-Increment Expressions**:
   - Writing `int z = x++ + ++x * --x;` is hard for humans to read. In production code, keep increments on their own lines.

---

## 5. Real-World Use Cases
- **Running Totals & Counters**: Updating shopping cart subtotals (`subtotal += itemPrice;`), game scores, and loop counters (`i++`).
