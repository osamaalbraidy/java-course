# Practice Sheet: Lesson 14 — Inheritance and Polymorphism (Part 2: Upcasting & Dynamic Dispatch)

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/14_Inheritance_And_Polymorphism_Part_2/Exercise.java).

---

## Problem 1: Polymorphic `Shape2D[]` Area Calculator (Easy)
### Description
Create a base class `Shape2D` (`public double calculateArea()`) and two subclasses:
- `CircleShape extends Shape2D` (`radius = 5.0` $\rightarrow$ $\pi r^2 = 78.54$)
- `RectangleShape extends Shape2D` (`width = 10.0, height = 4.0` $\rightarrow$ $40.00$)
Upcast both into a `Shape2D[] shapes` array, loop through the array, and accumulate the total area!

### Expected Output
```
CircleShape Area    : 78.54
RectangleShape Area : 40.00
Total Combined Area : 118.54
```
### Edge-Case Hints
- Notice that the loop only knows about `Shape2D`, yet `shape.calculateArea()` runs circle math for the circle and rectangle math for the rectangle!

---

## Problem 2: Polymorphic Method Parameter (`processPayment(PaymentMethod method, double amount)`) (Medium)
### Description
Write a single method `public static void executeCheckout(PaymentMethod method, double amount)` that accepts the parent type `PaymentMethod`.
Pass both a `CreditCardPayment` and a `DigitalWalletPayment` into `executeCheckout(...)` to prove that one method can handle any current or future subclass!

### Expected Output
```
[CreditCard] Charged $149.99 (2% Cashback earned: $3.00)
[ApplePay]   Charged $45.00 via biometric token
```
### Edge-Case Hints
- Designing method parameters to accept the **Superclass** (`PaymentMethod`) instead of concrete subclasses makes your code loosely coupled and extensible!

---

## Problem 3: Safe Downcasting with Java 17 `instanceof` (`MediaFile` Hierarchy) (Hard)
### Description
Given a `MediaFile[] playlist = { new AudioTrack("Synthwave.mp3"), new VideoClip("JavaTutorial.mp4", "4K") };`:
- Loop through `playlist` and call `media.play()` on every item.
- Use Java 17 pattern matching (`if (media instanceof VideoClip video)`) to call the `VideoClip`-only method `video.enableSubtitles()` only on video files!

### Expected Output
```
Playing audio stream: Synthwave.mp3
Playing video stream: JavaTutorial.mp4 (4K)
  -> Subtitles enabled for 4K video: JavaTutorial.mp4
```
### Edge-Case Hints
- Without checking `instanceof VideoClip`, attempting to cast `AudioTrack` to `(VideoClip)` would throw `ClassCastException` at runtime!
