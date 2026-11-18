# Lesson 23: Arrays and Methods (Passing Arrays to Methods, Returning Arrays & Reference Mutation)

## 1. How Arrays Are Passed to Methods (Pass-by-Value of the Reference!)
In Lesson 19, we learned that passing a primitive (`int`, `double`) into a method copies its value on the **Stack**, so modifying the parameter never affects the caller's variable.

In Java, **an array is an Object stored on the Heap**. An array variable on the Stack (`int[] scores`) holds a **memory reference (address)** pointing to that Heap array.

When you pass `scores` into a method `modifyArray(int[] arr)`:
1. Java copies the **memory reference address** into `arr`.
2. Both `scores` (in `main`) and `arr` (in `modifyArray`) now **point to the exact same array on the Heap**!
3. Therefore, **modifying an element inside the method (`arr[0] = 999;`) directly mutates the caller's original array**!

```
STACK                                      HEAP
+----------------------+
| main:   scores [0xA4]| -------------\    +----+----+----+
+----------------------+               \-->| 99 | 20 | 30 |  (Shared Array Object)
| method: arr    [0xA4]| -------------/    +----+----+----+
+----------------------+
```

> **Subtle Distinction:** What if `modifyArray` reassigns `arr = new int[]{1, 2, 3};`? That only points the local parameter `arr` at a brand-new Heap object; `scores` in `main` still points to the original Heap object!

---

## 2. Returning a New Array from a Method
If you want a method to transform an array **without mutating the caller's original array** (non-destructive / immutable style), allocate a `new` array inside the method, populate it, and `return` it:

```java
public static int[] createDoubledCopy(int[] source) {
    int[] result = new int[source.length];
    for (int i = 0; i < source.length; i++) {
        result[i] = source[i] * 2;
    }
    return result;
}
```

---

## 3. Variable-Length Arguments (`varargs`: `int... numbers`)
Java allows a method to accept zero or more arguments of the same type using ellipsis syntax (`Type... name`), which Java automatically packs into an array inside the method:
```java
public static int sumAll(int... numbers) { // `numbers` is treated as `int[]`
    int total = 0;
    for (int n : numbers) total += n;
    return total;
}
// Can be called as: sumAll(1, 2, 3) or sumAll(10, 20, 30, 40, 50)
```

---

## 4. Common Pitfalls
1. **Unintended Side Effects from In-Place Mutation**:
   - Passing a sensitive array to a method that sorts or modifies it in-place alters the caller's data. Pass `Arrays.copyOf(arr, arr.length)` if you want to protect the original!
2. **`NullPointerException` When Passing a `null` Array**:
   - Always check `if (arr == null || arr.length == 0)` at the start of array utility methods.

---

## 5. Real-World Use Cases
- **In-Place Sorting & Reversal Algorithms**: `Arrays.sort(arr)` mutates the array in place without allocating extra memory.
- **Data Transformation Pipelines**: Returning filtered or normalized array copies for financial or scientific calculations.
