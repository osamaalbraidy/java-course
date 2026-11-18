# Lesson 03: What Is OOP? — Part 3 (Abstraction, Cohesion, Coupling & Domain Modeling)

## 1. What Is Abstraction?
**Abstraction** is the principle of exposing only the **essential high-level contract** ("**What** an object does") to the caller while hiding the **complex low-level mechanics** ("**How** it does it") inside the class.

- **Real-World Analogy**: When you brew espresso with a coffee machine, you press **one button**: `brewEspresso()`. You do not manually open water valves, regulate boiler pressure to 9 bars, or time the extraction in milliseconds—those 50 internal steps are **abstracted away** inside `private` methods!
- **Encapsulation vs. Abstraction**:
  - **Encapsulation** is about **protecting state** (`private` fields + validation).
  - **Abstraction** is about **reducing cognitive complexity** (hiding multi-step algorithmic details behind clean, intuitive `public` method APIs).

---

## 2. High Cohesion vs. Loose Coupling (Software Architecture Golden Rules)
Every Senior Java Architect evaluates OOP class designs using two metrics:
$$\text{Goal: }\mathbf{High\ Cohesion} + \mathbf{Loose\ Coupling}$$

### A. Cohesion (Single Responsibility Principle)
**Cohesion** measures how focused and strongly related the responsibilities of a single class are.
- **Low Cohesion (Bad — "God Class")**: A single `OrderManager` class that calculates taxes, formats HTML emails, writes SQL queries, and resizes product images.
- **High Cohesion (Good)**: Separating those duties into focused classes: `TaxCalculator`, `InvoicePrinter`, and `PaymentGateway`. Each class does **one job well**.

### B. Coupling (Dependency Between Classes)
**Coupling** measures how tightly one class is tied to the internal implementation details of another class.
- **Tight Coupling (Bad)**: Class A directly manipulates Class B's internal fields and calls 6 internal setup steps in a fragile order. If Class B changes internally, Class A breaks!
- **Loose Coupling (Good)**: Class A calls a single high-level method on Class B (`paymentGateway.charge(amount)`), remaining completely ignorant of Class B's internal steps.

---

## 3. Common Pitfalls
1. **Leaky Abstractions**:
   - Forcing the caller of `CoffeeMachine` to call `machine.heatWater()`, then `machine.grindBeans()`, then `machine.pumpWater()` in the exact right order! If the caller forgets step 1, the machine breaks. Expose `makeCoffee()` as `public` and make the internal steps `private`!
2. **"God Object" Anti-Pattern**:
   - Putting every method in the application into a single 3,000-line class instead of modeling distinct domain entities.

---

## 4. Real-World Use Cases
- **Cloud Storage SDKs (`StorageService.uploadFile(file)`)**: Hides DNS resolution, TLS handshakes, chunked multipart streaming, and checksum verification behind a single 1-line method call.
