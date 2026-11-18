# Lesson 22: Revision OOP — Part 1 (OOP Practice Project Part 1: Classes, Encapsulation, Constructors & `static`)

## 1. Project Overview: Hospital Patient & Medical Record Domain Model
In this 4-part OOP Revision series (Lessons 22–25), we progressively engineer an enterprise-style domain system applying every concept from Module 2.

In **Part 1 (Lesson 22)**, we review:
1. **Strict Encapsulation**: All instance fields are `private`, protected by validation guards inside constructors and setters.
2. **Constructor Overloading & Chaining (`this(...)`)**: Providing multiple convenient ways to instantiate domain objects while funneling validation through a single Master Constructor.
3. **`static` Class Members**: Auto-incrementing unique record IDs across all instances.
4. **Copy Constructors & `.equals()` / `.toString()`**: Safe cloning and value comparison.
