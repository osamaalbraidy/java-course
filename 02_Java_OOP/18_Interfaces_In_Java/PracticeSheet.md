# Practice Sheet: Lesson 18 — Interfaces in Java

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/18_Interfaces_In_Java/Exercise.java).

---

## Problem 1: Polymorphic `Notifiable` Interface Contract (Easy)
### Description
Define an interface `Notifiable` with `void sendNotification(String message);` and a `default void printChannelType()` method.
Implement `Notifiable` in two unrelated classes: `EmailService` and `WebhookService`, store them in a `Notifiable[]` array, and invoke both methods on each element.

### Expected Output
```
[Channel: EmailService]   -> Sending Email: Server deployed!
[Channel: WebhookService] -> POSTing JSON Webhook: Server deployed!
```
### Edge-Case Hints
- Remember that methods implementing an interface **must** be declared `public`!

---

## Problem 2: Multiple Interface Implementation (`SmartThermostat implements Schedulable, WifiConnectable`) (Medium)
### Description
Create two interfaces:
1. `WifiConnectable`: `void connectToWifi(String ssid);`
2. `Schedulable`: `void scheduleTask(String cronTime);`
Create a class `SmartThermostat implements WifiConnectable, Schedulable` that implements both interfaces and test calling both capabilities in `solveProblem2()`.

### Expected Output
```
[SmartThermostat] Connected to Wi-Fi network: "Home-5GHz"
[SmartThermostat] Scheduled Eco-Mode at: "22:00 Daily"
```
### Edge-Case Hints
- A Java class can only `extends` one parent class, but can `implements` any number of comma-separated interfaces!

---

## Problem 3: Combining `extends` and `implements` (`CloudStorageProvider`) (Hard)
### Description
A class can both **extend a superclass** AND **implement multiple interfaces** (`class AwsS3Bucket extends CloudResource implements Encryptable, Auditable`):
- `extends` always comes **before** `implements` in the class header!
Implement `AwsS3Bucket extends CloudResource implements Encryptable, Auditable` and test all inherited and implemented methods.

### Expected Output
```
CloudResource [Region: us-east-1]
  -> [Encryptable] Bucket 'prod-backups' encrypted with AES-256
  -> [Auditable]   Audit log generated for bucket 'prod-backups'
```
### Edge-Case Hints
- Syntax order rule: `class SubClass extends SuperClass implements Interface1, Interface2`.
