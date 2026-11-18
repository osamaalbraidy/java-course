# Practice Sheet: Lesson 24 — Revision OOP (Part 3: Interfaces, Enums & Exception Handling)

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/24_Revision_OOP_Part_3/Exercise.java).

---

## Problem 1: `OrderStatus` Enum State Machine with Transition Guard (Easy)
### Description
Create an `enum OrderLifecycle { CREATED, PAID, SHIPPED, CANCELLED }`.
Write a method `advanceStatus` that throws an `IllegalStateException` if someone tries to ship a `CANCELLED` order!

### Expected Output
```
Order #501 transitioned: CREATED -> PAID -> SHIPPED
Blocked illegal transition: Cannot ship a CANCELLED order!
```

---

## Problem 2: `Refundable` & `Taxable` Interfaces on `DigitalSubscription` (Medium)
### Description
Implement both `Taxable` (`double calculateTax()`) and `Refundable` (`void processRefund() throws RefundWindowExpiredException`) on `DigitalSubscription`.
If `daysSincePurchase > 14`, throw `RefundWindowExpiredException`.

### Expected Output
```
Subscription Tax (8%) : $7.92
Refund Approved       : Refunded $99.00 for Pro IDE License (Purchased 5 days ago)
Refund Denied         : Refund window (14 days) expired! Purchased 30 days ago.
```

---

## Problem 3: End-to-End Payment Gateway (`PaymentRail` Enum + `PaymentGateway` Interface + Custom Exception) (Hard)
### Description
Combine an `enum CurrencyCode { USD(1.0), EUR(1.08), GBP(1.27) }`, a `PaymentProcessor` interface, and a custom checked `FraudRiskException` thrown when a single transaction exceeds `$10,000.00` USD equivalent!

### Expected Output
```
[StripeGateway] Approved 500.00 EUR ($540.00 USD equivalent)
[Fraud Alert]   Blocked 12000.00 GBP ($15240.00 USD exceeds $10000.00 limit!)
```
