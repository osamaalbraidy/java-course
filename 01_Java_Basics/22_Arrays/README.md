# Lesson 22: One-Dimensional Arrays (Declaration, Indexing, `for` vs. `for-each` Traversal & Bounds Safety)

## 1. What Is an Array?
An **array** is a fixed-size, contiguous block of memory on the **Heap** that stores multiple elements of the **exact same data type** under a single variable name.

```
int[] scores = {85, 92, 78, 95, 88};

Index:       [0]    [1]    [2]    [3]    [4]     (scores.length == 5)
           +------+------+------+------+------+
Elements:  |  85  |  92  |  78  |  95  |  88  |  (Valid indices: 0 to length - 1)
           +------+------+------+------+------+
```

### Key Properties of Java Arrays
1. **Zero-Based Indexing**: The first element is always at index `0`, and the last element is at index `array.length - 1`.
2. **Fixed Length**: Once an array is created (`new int[5]`), its `.length` property **cannot grow or shrink**.
3. **Default Element Initialization**: When allocated with `new`, Java automatically initializes array elements:
   - Numeric primitives (`int`, `double`): `0` or `0.0`
   - `boolean`: `false`
   - `char`: `'\u0000'`
   - Reference types (`String`, Objects): `null`

---

## 2. Two Ways to Declare and Initialize an Array
1. **Dynamic Allocation with `new`** (when values will be populated later):
   ```java
   int[] dailySteps = new int[7]; // Allocates 7 ints, all initialized to 0
   dailySteps[0] = 8500;
   ```
2. **Array Initializer Literal `{ ... }`** (when values are known upfront):
   ```java
   int[] dailySteps = {8500, 10200, 7400, 9100, 11000, 12500, 6800};
   ```

---

## 3. Traversing Arrays: Standard `for` vs. Enhanced `for-each`

| Loop Type | Syntax | When to Use |
| :--- | :--- | :--- |
| **Index-Based `for`** | `for (int i = 0; i < arr.length; i++)` | When you need the **index `i`**, need to **modify elements** (`arr[i] = ...`), or iterate backwards/partially. |
| **Enhanced `for-each`** | `for (int element : arr)` | Cleanest, safest way for **read-only** forward traversal of every element. |

---

## 4. Common Pitfalls
1. **`ArrayIndexOutOfBoundsException` (Off-by-One Loop Error)**:
   - Writing `for (int i = 0; i <= arr.length; i++)` (using `<=` instead of `<`) tries to access `arr[arr.length]`, which crashes at runtime with `java.lang.ArrayIndexOutOfBoundsException`!
2. **Printing an Array Directly (`System.out.println(arr)`)**:
   - Calling `println(arr)` prints the object's internal type and hashcode (`[I@7ad041f3`), NOT the elements! Use `java.util.Arrays.toString(arr)` or a loop to print elements.
3. **Confusing `arr.length` with `str.length()`**:
   - On an array, `.length` is a **final property** (no parentheses: `arr.length`).
   - On a `String`, `.length()` is a **method** (with parentheses: `str.length()`).

---

## 5. Real-World Use Cases
- **Time-Series Sensor Buffers**: Storing 24 hourly temperature readings (`double[24]`) to compute daily min, max, and average statistics.
