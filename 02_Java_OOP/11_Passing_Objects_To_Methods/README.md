# Lesson 11: Passing Objects to Methods (Object References Passed by Value & Mutating Object State)

## 1. How Java Passes Objects to Methods
In Java, **every argument is passed by value**. However, for an **Object**, the variable on the Stack does not hold the object itself—it holds the **Heap memory reference (address)** pointing to that object!

When you pass an object reference `Account myAcc` into `processAccount(Account param)`:
1. The **memory address** inside `myAcc` (say `0x4F20`) is **copied** into `param`.
2. Both `myAcc` (in `main`) and `param` (in `processAccount`) now point to the **exact same object on the Heap**!

```
STACK                                    HEAP
+-----------------------+
| main:   myAcc [0x4F20]| ------------\  +-------------------------------+
+-----------------------+              ->| Account Instance (0x4F20)     |
| method: param [0x4F20]| ------------/  | owner = "Alice", bal = $600   |
+-----------------------+                +-------------------------------+
```

---

## 2. Mutating Object State vs. Reassigning the Parameter Reference

| Action Inside `void modify(Account param)` | Effect on Caller's `myAcc` in `main()` | Why? |
| :--- | :--- | :--- |
| **`param.deposit(100.0);`** *(Mutating Heap state)* | **`myAcc` IS modified!** | Follows the `0x4F20` pointer to the shared Heap object and mutates its fields. |
| **`param = new Account("Bob", 0);`** *(Reassigning reference)* | **`myAcc` is UNCHANGED!** | Overwrites the local stack variable `param` to point to a new Heap address (`0x99A0`), leaving `myAcc` pointing to `0x4F20`. |

---

## 3. Returning an Object from a Method (Factory Methods & Immutable Operations)
Just as methods can accept objects as parameters, a method's return type can be a **Class Type** (`public static BankAccount createPremiumAccount(...)` or `public Vector2D add(Vector2D other)`), returning a reference to a newly allocated Heap object.

---

## 4. Common Pitfalls
1. **`NullPointerException` Inside a Method Accepting an Object**:
   - If a caller passes `null` (`processAccount(null);`), calling `param.deposit(50)` inside the method immediately throws a `NullPointerException`. Always guard object parameters with `if (param == null) return;`!
2. **Accidental Mutation of Shared Objects**:
   - If a method only intends to *calculate* a projection from an object, don't call mutator methods (`setXxx`) on the passed-in object!

---

## 5. Real-World Use Cases
- **Peer-to-Peer Money Transfers**: `aliceAccount.transferTo(bobAccount, 250.00)` passes `bobAccount` into `aliceAccount`'s method so `aliceAccount` can deduct `$250` from itself (`this`) and deposit `$250` into `bobAccount`!
