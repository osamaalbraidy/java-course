# Practice Sheet: Lesson 19 — Enumerated Types (`enum`)

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/19_Enumerated_Types_Enum/Exercise.java).

---

## Problem 1: Traffic Light State Machine with `enum` & `switch` (Easy)
### Description
Define an `enum TrafficSignal { RED, YELLOW, GREEN }` and use a Java 17 `switch` expression in `solveProblem1()` to print the driver instruction for each signal in `TrafficSignal.values()`.

### Expected Output
```
Signal RED    (Ordinal 0) -> Action: STOP completely behind the line
Signal YELLOW (Ordinal 1) -> Action: PREPARE to stop safely
Signal GREEN  (Ordinal 2) -> Action: PROCEED with caution
```
### Edge-Case Hints
- Using `TrafficSignal.values()` in a `for-each` loop visits every constant in declaration order.

---

## Problem 2: Rich `HttpStatusCode` Enum with Fields & Constructor (Medium)
### Description
Create an `enum HttpStatusCode` with constants:
- `OK(200, "Success")`
- `CREATED(201, "Resource Created")`
- `BAD_REQUEST(400, "Client Error: Invalid Syntax")`
- `NOT_FOUND(404, "Client Error: Endpoint Missing")`
- `INTERNAL_ERROR(500, "Server Error: Unhandled Exception")`

Include `private final int code;`, `private final String description;`, a constructor, getters, and a `public boolean isError()` method that returns `this.code >= 400`.

### Expected Output
```
HTTP 200 [OK]             : Success (Is Error? false)
HTTP 404 [NOT_FOUND]      : Client Error: Endpoint Missing (Is Error? true)
HTTP 500 [INTERNAL_ERROR] : Server Error: Unhandled Exception (Is Error? true)
```
### Edge-Case Hints
- Don't forget the semicolon `;` after the last enum constant (`INTERNAL_ERROR(...) ;`) when fields and constructors follow!

---

## Problem 3: Using an `enum` Inside a Domain Class (`SupportTicket` & `PriorityLevel`) (Hard)
### Description
Create an `enum PriorityLevel` with constants `LOW(48)`, `MEDIUM(24)`, `HIGH(8)`, `CRITICAL(1)` where the `int slaHours` field represents the maximum response time in hours.
Create a class `SupportTicket` (`ticketId`, `issueSummary`, `PriorityLevel priority`) that uses `priority.getSlaHours()` to display its SLA deadline!

### Expected Output
```
Ticket #901 [Priority: LOW     | Response SLA: 48h] -> Issue: Typo on About page
Ticket #902 [Priority: CRITICAL| Response SLA:  1h] -> Issue: Production database unreachable
```
### Edge-Case Hints
- Storing `PriorityLevel` as a field inside `SupportTicket` makes it impossible to create a ticket with a bogus priority string!
