# Lesson 21: `ArrayList` Class (Dynamic Arrays vs. Fixed Arrays, CRUD Operations, Wrapper Classes & Autoboxing)

## 1. Fixed Arrays (`Type[]`) vs. Dynamic `ArrayList<Type>`
In Module 1 (Lesson 22), we learned that standard Java arrays (`int[]`, `String[]`) have a **fixed size**: once you create `new String[5]`, you can never add a 6th element or shrink the array without manually allocating a new array and copying elements.

**`java.util.ArrayList<E>`** is a resizable, dynamic list backed by an internal array that **automatically grows and shifts elements** as you add or remove items!

```java
import java.util.ArrayList;

ArrayList<String> tasks = new ArrayList<>(); // Diamond operator `<>` (Java 7+)
```

---

## 2. Core `ArrayList` Methods vs. Standard Arrays

| Operation | Fixed Array (`String[] arr`) | `ArrayList<String> list` |
| :--- | :--- | :--- |
| **Get Size** | `arr.length` *(Property)* | **`list.size()`** *(Method!)* |
| **Append Element** | Not supported (Fixed size) | **`list.add("Task A")`** |
| **Insert at Index** | Manual shift required | **`list.add(0, "Urgent")`** |
| **Read at Index** | `arr[i]` | **`list.get(i)`** |
| **Update at Index** | `arr[i] = "New"` | **`list.set(i, "New")`** |
| **Remove by Index / Value** | Not supported | **`list.remove(0)`** or **`list.remove("Task A")`** |
| **Check Contains** | Manual loop required | **`list.contains("Task A")`** |
| **Clear All** | Manual loop / reallocate | **`list.clear()`** |
| **Print Elements** | `Arrays.toString(arr)` | **`System.out.println(list)`** *(Built-in `toString()`!)* |

---

## 3. Wrapper Classes, Autoboxing, and Unboxing
Java Generics (`ArrayList<E>`) can **ONLY hold Reference/Object types**—writing `ArrayList<int>` or `ArrayList<double>` is a **compile-time error**!
To store primitive values inside an `ArrayList`, use Java's **Wrapper Classes** (`java.lang`):

| Primitive Type | Wrapper Class (`ArrayList<Wrapper>`) |
| :---: | :---: |
| `byte` | `Byte` |
| `short` | `Short` |
| **`int`** | **`Integer`** (`ArrayList<Integer>`) |
| `long` | `Long` |
| `float` | `Float` |
| **`double`** | **`Double`** (`ArrayList<Double>`) |
| **`char`** | **`Character`** (`ArrayList<Character>`) |
| `boolean` | `Boolean` |

- **Autoboxing**: Java automatically converts a primitive `int` (`42`) into an `Integer` object when you call `numbers.add(42);`!
- **Unboxing**: Java automatically converts an `Integer` object back into a primitive `int` when you write `int x = numbers.get(0);`!

---

## 4. Common Pitfalls
1. **The `ArrayList<Integer>.remove(int)` Overload Trap!**:
   - On `ArrayList<Integer>`, `remove` is overloaded:
     - `remove(int index)` removes the element **at that index**.
     - `remove(Object o)` removes the **first matching value**.
   - If you have `list = [10, 20, 30]` and call `list.remove(10)` thinking it removes the value `10`, Java calls `remove(int index)` and crashes with `IndexOutOfBoundsException: Index 10 out of bounds`!
   - **Fix**: Pass `Integer.valueOf(10)` (`list.remove(Integer.valueOf(10))`) to remove the *value* `10`!
2. **Removing Elements Inside a Forward Loop**:
   - When you remove index `i` in a forward `for` loop (`i = 0; i < list.size(); i++`), the next element shifts left into index `i`, and `i++` skips right over it! Iterate backwards (`i = list.size() - 1; i >= 0; i--`) or use `list.removeIf(...)`.

---

## 5. Real-World Use Cases
- **Dynamic Collections of Domain Objects**: Storing `ArrayList<Order>`, `ArrayList<Student>`, or `ArrayList<Product>` when the number of records grows and shrinks at runtime.
