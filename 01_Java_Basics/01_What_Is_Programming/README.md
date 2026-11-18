# Lesson 01: What Is Programming? (Algorithms, Source Code vs. Machine Code & Paradigms)

## 1. What Is Programming?
At its core, **programming** is the art and science of translating human problem-solving logic into precise, unambiguous instructions that a computer processor (CPU) can execute. Computers have zero intuition—they cannot "guess" what you mean. Every action must be broken down into deterministic steps.

---

## 2. What Is an Algorithm?
An **algorithm** is a finite, ordered sequence of well-defined steps used to solve a specific problem or perform a calculation.

Every valid algorithm follows the **IPO (Input → Process → Output)** model and must possess four properties:
1. **Unambiguous**: Every step is clear and has only one interpretation.
2. **Defined Inputs & Outputs**: Takes zero or more inputs and produces at least one output.
3. **Finiteness**: Must terminate after a finite number of steps (never an endless loop).
4. **Language-Independent**: An algorithm is a logical recipe; it can be written in English pseudocode, flowcharts, Java, Python, or C++.

### Example: Algorithm to Find the Largest of Three Numbers (`a`, `b`, `c`)
1. **Start** with three numbers: `a`, `b`, `c`.
2. Assume `max = a`.
3. If `b > max`, update `max = b`.
4. If `c > max`, update `max = c`.
5. **Output** `max` and **Stop**.

---

## 3. Source Code vs. Bytecode vs. Machine Code

| Representation | Who Reads It? | Example | Characteristics |
| :--- | :--- | :--- | :--- |
| **Source Code** (`.java`) | Humans (Developers) | `int sum = a + b;` | High-level, expressive, structured text written in an IDE. |
| **Bytecode** (`.class`) | JVM (Virtual Machine) | `iload_1`, `iload_2`, `iadd` | Compact intermediate instruction set (`0xCA FE BA BE` header). |
| **Machine Code** (Binary) | Physical CPU Hardware | `10110000 01100001` | Raw electrical voltage states (0s and 1s) specific to x86 or ARM. |

---

## 4. Major Programming Paradigms
A **programming paradigm** is a fundamental style or philosophy of structuring code:

1. **Imperative / Procedural Programming**:
   - Focuses on **how** to achieve a task through step-by-step instructions and procedures that mutate program state (e.g., C, early BASIC).
2. **Object-Oriented Programming (OOP)**:
   - Organizes software around **Objects** (which bundle **data/state** and **methods/behavior** together) rather than standalone functions. Java is primarily an Object-Oriented language.
3. **Declarative / Functional Programming**:
   - Focuses on **what** result is desired rather than step-by-step state mutation (supported in modern Java via **Streams** and **Lambda Expressions** introduced in Java 8+).

---

## 5. Common Pitfalls
- **Jumping Straight to Code Without an Algorithm**: Writing Java syntax before understanding the step-by-step logic on paper leads to buggy "spaghetti code."
- **Off-by-One Logic Errors**: An algorithm that compiles cleanly (`javac` reports zero syntax errors) can still produce the wrong answer if the mathematical or logical sequence is flawed.
- **Confusing Syntax Errors with Logical Errors**:
  - **Syntax Error**: Violating Java's grammar rules (e.g., forgetting a semicolon `;`). Caught by `javac`.
  - **Logical Error**: Valid Java grammar, but flawed algorithm (e.g., multiplying instead of adding).

---

## 6. Real-World Use Cases
- **Navigation Apps (Google Maps)**: Uses Dijkstra's / A* shortest-path algorithms to compute the fastest route across millions of road segments.
- **E-Commerce Checkout**: Follows a strict deterministic algorithm: validate cart items → calculate subtotal → apply discount rules → calculate tax → process payment.
