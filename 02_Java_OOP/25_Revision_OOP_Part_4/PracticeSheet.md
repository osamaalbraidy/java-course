# Practice Sheet: Lesson 25 — Revision OOP (Part 4: Capstone Management System)

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/25_Revision_OOP_Part_4/Exercise.java).

---

## Problem 1–3 Integrated Capstone: University Course Enrollment & Tuition Management System (Easy -> Medium -> Hard)
### Description
Build a complete multi-class **University Registry System** inside `Exercise.java`:
1. **Part A (Easy — Domain Hierarchy & Enum)**:
   - `enum AcademicLevel { UNDERGRADUATE(350.0), GRADUATE(550.0) }` holding the per-credit tuition rate.
   - `abstract class UniversityMember` (`id`, `name`) with subclasses `UniversityStudent` (`AcademicLevel`, `enrolledCredits`) and `FacultyProfessor` (`annualGrant`).
2. **Part B (Medium — Interfaces & Custom Checked Exception)**:
   - `interface TuitionPayer { double calculateSemesterBill(); }`
   - Custom exception `CreditOverloadException extends Exception` thrown if a student tries to enroll in more than `18` credits in a semester!
3. **Part C (Hard — `ArrayList` Registry Manager)**:
   - `UniversityRegistry` holding an `ArrayList<UniversityStudent>`: implements `registerStudent(UniversityStudent s)`, `findTopScholarshipCandidate()`, and `printTuitionReport()`.

### Expected Output
```
=== Part A & B: Enrolling Students with Credit Overload Protection ===
[Enrolled] Alice (UNDERGRADUATE) added +15 credits.
[Blocked]  CreditOverloadException: Bob cannot add 21 credits (Max allowed: 18)!
[Enrolled] Bob (GRADUATE) added +12 credits.

=== Part C: University Registry ArrayList Tuition Report ===
  Student #1001: Alice | Level: UNDERGRADUATE | Credits: 15 | Tuition: $5,250.00
  Student #1002: Bob   | Level: GRADUATE      | Credits: 12 | Tuition: $6,600.00
Total Semester Tuition Revenue: $11,850.00
```
