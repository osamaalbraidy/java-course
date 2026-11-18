# Lesson 23: Revision OOP — Part 2 (OOP Practice Project Part 2: Inheritance, Polymorphism & Abstract Classes)

## 1. Project Overview: Hospital Medical Staff & Billing Hierarchy
In **Part 2 (Lesson 23)** of our OOP Revision series, we build an inheritance and runtime polymorphism hierarchy covering:
1. **`abstract` Base Classes (`MedicalStaff`)**: Defining shared state (`staffId`, `fullName`, `department`) and enforcing an `abstract` contract (`calculateMonthlyCompensation()`).
2. **Method Overriding (`@Override`) & `super`**: Specializing behavior in `Surgeon`, `ResidentDoctor`, and `HeadNurse`.
3. **`final` Methods & `protected` Members**: Locking hospital credential verification while sharing `protected` helper calculations with subclasses.
4. **Upcasting, Dynamic Dispatch & Java 17 `instanceof` Pattern Matching**: Processing a heterogeneous array of medical staff polymorphically.
