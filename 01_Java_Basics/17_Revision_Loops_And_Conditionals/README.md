# Lesson 17: Revision — Loops and Conditionals (Comprehensive Mini-Project)

## 1. Module 1 Control-Flow Decision Matrix
Before moving on to **Methods** and **Arrays**, let's synthesize everything we have learned about **Conditionals** (`if-else`, `switch`) and **Loops** (`while`, `do-while`, `for`, `break`, `continue`):

| Scenario | Best Java Construct | Why? |
| :--- | :--- | :--- |
| Testing numeric ranges or compound conditions (`&&`, `\|\|`) | `if / else if / else` | Handles inequalities (`>=`, `<`) and multi-variable boolean logic. |
| Matching 1 variable against fixed constants or strings | `switch` expression (`->`) | Clean jump table, exhaustive checking, zero fall-through risk. |
| Known number of iterations ($1..N$, grids, patterns) | `for` loop | Keeps initialization, condition, and update together in one header. |
| Unknown iterations; condition checked *before* first pass | `while` loop (with flag/sentinel) | Safely skips the loop body (0 executions) if initially false. |
| Unknown iterations; must run *at least once* (CLI menus) | `do-while` loop | Post-test check guarantees the menu or prompt runs first. |

---

## 2. Mini-Project Architecture: Smart Warehouse Order & Analytics Engine
In `Example.java`, we build a complete **Smart Warehouse Order & Analytics Engine** that combines:
1. A **`do-while` CLI Menu** with a **Java 17 `switch` expression** dispatcher.
2. A **Sentinel & Flag-Controlled `while` loop** that processes incoming item prices, uses **`continue`** to skip negative corrupted entries, uses **`if / else if`** to classify items into pricing tiers (`Budget`, `Standard`, `Premium`), and tracks min/max/sum accumulators.
3. A **Nested `for` loop** that renders an ASCII bar chart of category counts.

---

## 3. Common Pitfalls in Combined Loop + Conditional Programs
1. **Initializing Min/Max Accumulators to `0`**:
   - If all item prices are positive (e.g., `$15, $40, $25`) and you initialize `double minPrice = 0.0;`, no positive price will ever be `< 0.0`, so `minPrice` wrongly stays `0.0`!
   - **Fix**: Initialize `minPrice = Double.MAX_VALUE;` (and `maxPrice = Double.MIN_VALUE;` or `-Double.MAX_VALUE`).
2. **Resetting Accumulators Inside the Loop**:
   - Declare counters and sums **before** the loop starts, not inside the loop body.
