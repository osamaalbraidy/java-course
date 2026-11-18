# Practice Sheet: Lesson 23 — Arrays and Methods

Complete the exercises inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/01_Java_Basics/23_Arrays_And_Methods/Exercise.java) to practice passing arrays to methods, mutating arrays in-place, and returning new arrays.

---

## Problem 1: In-Place Array Element Swapper (Easy)
### Description
Implement `public static void swapElements(int[] arr, int indexA, int indexB)` that swaps the elements at `arr[indexA]` and `arr[indexB]` in-place using a temporary variable `int temp`.
In `solveProblem1()`, call `swapElements(numbers, 0, numbers.length - 1)` on `int[] numbers = {10, 20, 30, 40, 50};` to swap the first and last elements, and print the array before and after.

### Expected Output
```
Before Swap : [10, 20, 30, 40, 50]
After Swap  : [50, 20, 30, 40, 10]
```
### Edge-Case Hints
- Because arrays are passed by reference value, `swapElements` has `void` return type and mutates `numbers` directly on the Heap!

---

## Problem 2: Non-Destructive Array Clamp (`return int[]`) (Medium)
### Description
In signal processing, "clamping" restricts every value in an array to fall within `[minAllowed, maxAllowed]`:
- Values `< minAllowed` become `minAllowed`.
- Values `> maxAllowed` become `maxAllowed`.
- Values inside `[minAllowed, maxAllowed]` stay unchanged.

Implement `public static int[] createClampedArray(int[] source, int minAllowed, int maxAllowed)` that allocates a **new `int[]`**, populates it with clamped values **without modifying `source`**, and returns the new array.
Test it on `int[] rawSignals = {-25, 10, 55, 100, 140};` with range `[0, 100]`.

### Expected Output
```
Original Raw Signals : [-25, 10, 55, 100, 140]
Clamped Copy [0..100]: [0, 10, 55, 100, 100]
```
### Edge-Case Hints
- Verify that `rawSignals` still prints `[-25, 10, 55, 100, 140]` after calling `createClampedArray`!

---

## Problem 3: Filtering Even Numbers into a Perfectly Sized New Array (Hard)
### Description
Because Java arrays have fixed length, to return a new array containing **only the even numbers** from `int[] input = {11, 24, 37, 42, 50, 63, 88};`, implement `public static int[] extractEvenNumbers(int[] input)` using a **2-pass algorithm**:
1. **Pass 1**: Loop through `input` to count how many elements are even (`evenCount`).
2. Allocate `int[] evens = new int[evenCount];` and initialize `int writeIndex = 0;`.
3. **Pass 2**: Loop through `input` again; whenever an element is even, store `evens[writeIndex++] = element;`.
4. Return `evens`.

### Expected Output
```
Input Array  : [11, 24, 37, 42, 50, 63, 88]
Filtered Even: [24, 42, 50, 88]
```
### Edge-Case Hints
- Notice why two passes are needed: you cannot allocate `new int[evenCount]` until you know how many even numbers exist!
