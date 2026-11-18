# Practice Sheet: Lesson 12 — Comparing and Copying Objects

Review the problems below and study the complete solutions and explanations inside [`Exercise.java`](file:///d:/Dev/09-Courses/Java/02_Java_OOP/12_Comparing_And_Copying_Objects/Exercise.java).

---

## Problem 1: Overriding `equals()` in `BookRecord` (`==` vs. `.equals()`) (Easy)
### Description
In `BookRecord`, two books are logically equal if they have the same `isbn` and `title`.
Override `public boolean equals(Object obj)` in `BookRecord` and compare two distinct `new BookRecord("978-0134685991", "Effective Java")` objects using both `==` and `.equals()`.

### Expected Output
```
b1 == b2      (Memory Address Check) : false
b1.equals(b2) (Logical ISBN/Title)   : true
b1.equals(b3) (Different ISBN)       : false
```
### Edge-Case Hints
- Always check `if (this == obj) return true;` and `if (obj == null || getClass() != obj.getClass()) return false;` before casting `(BookRecord) obj`!

---

## Problem 2: Reference Aliasing Bug vs. Copy Constructor in `GameSaveState` (Medium)
### Description
Demonstrate why `GameSaveState alias = checkpoint1;` is dangerous (modifying `alias` corrupts `checkpoint1`), and implement a **Copy Constructor** `public GameSaveState(GameSaveState source)` so `checkpoint2` can be modified to Level 6 without changing `checkpoint1` (Level 5)!

### Expected Output
```
Original Checkpoint 1 (Untouched) : Save [Level: 5 | Coins: 250]
Cloned Checkpoint 2 (Leveled Up)  : Save [Level: 6 | Coins: 350]
```
### Edge-Case Hints
- A Copy Constructor has the signature `public ClassName(ClassName source)`.

---

## Problem 3: Deep Copy Constructor for `Playlist` (With `String[] songs`) (Hard)
### Description
A `Playlist` class holds `private String title;` and a mutable array `private String[] songs;`.
Implement a **Deep Copy Constructor** `public Playlist(Playlist source)` that uses `Arrays.copyOf(source.songs, source.songs.length)` to allocate a separate `String[]` on the Heap.
Prove that replacing song index `0` in `clonedPlaylist` does **not** alter `originalPlaylist`!

### Expected Output
```
Original Playlist : Coding Focus -> [Lo-Fi Beats, Synthwave, Classical]
Deep Copy Playlist: Coding Focus -> [Heavy Metal, Synthwave, Classical]
```
### Edge-Case Hints
- If you wrote `this.songs = source.songs;` (a shallow copy), changing `clonedPlaylist`'s song `0` to `"Heavy Metal"` would overwrite `"Lo-Fi Beats"` in `originalPlaylist` too!
