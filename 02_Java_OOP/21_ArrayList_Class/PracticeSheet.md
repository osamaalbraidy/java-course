# Practice Sheet: Lesson 21 — `ArrayList` Class

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/21_ArrayList_Class/Exercise.java).

---

## Problem 1: Task Backlog Manager (`ArrayList<String>` CRUD) (Easy)
### Description
Using an `ArrayList<String> backlog = new ArrayList<>();`:
1. Add `"Design DB Schema"`, `"Write REST API"`, and `"Deploy to Cloud"`.
2. Insert `"Configure Security"` at index `1` (`backlog.add(1, "Configure Security")`).
3. Update index `2` (`"Write REST API"`) to `"Write GraphQL API"` using `backlog.set(2, ...)`.
4. Remove `"Deploy to Cloud"` and print the final size and list.

### Expected Output
```
Final Backlog (Size: 3): [Design DB Schema, Configure Security, Write GraphQL API]
```
### Edge-Case Hints
- Remember: `add(index, item)` inserts and shifts elements right, whereas `set(index, item)` overwrites the element at `index`!

---

## Problem 2: `ArrayList<Double>` Sensor Filter & Safe Removal (Medium)
### Description
Populate an `ArrayList<Double>` with `22.5, -999.0, 24.0, -999.0, 23.5`.
Remove all corrupted `-999.0` readings safely by iterating **backwards** (`for (int i = readings.size() - 1; i >= 0; i--)`), then compute the average of the valid readings!

### Expected Output
```
Cleaned Readings : [22.5, 24.0, 23.5]
Average Temp     : 23.33 C
```
### Edge-Case Hints
- Iterating backwards (`size() - 1` down to `0`) when calling `remove(i)` prevents index-shifting from skipping adjacent `-999.0` elements!

---

## Problem 3: `ArrayList<CartProduct>` Shopping Cart Total & Search (Hard)
### Description
Create a `CartProduct` class (`name`, `price`, `quantity`) and store 3 products inside an `ArrayList<CartProduct>`:
- `"Mechanical Keyboard"`, `$120.00`, qty `1`
- `"USB-C Hub"`, `$45.00`, qty `2`
- `"Webcam 4K"`, `$95.00`, qty `1`
Traverse the `ArrayList<CartProduct>` to compute the grand total and find the most expensive line item (`price * quantity`).

### Expected Output
```
  CartItem: Mechanical Keyboard  | Qty: 1 | Line Total: $120.00
  CartItem: USB-C Hub            | Qty: 2 | Line Total: $90.00
  CartItem: Webcam 4K            | Qty: 1 | Line Total: $95.00
Grand Total: $305.00 | Highest Line Item: Mechanical Keyboard ($120.00)
```
### Edge-Case Hints
- Use `for (CartProduct item : cart)` to iterate cleanly over custom objects in an `ArrayList`.
