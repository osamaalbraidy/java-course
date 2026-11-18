package _02_Java_OOP._12_Comparing_And_Copying_Objects;

import java.util.Arrays;
import java.util.Objects;

/**
 * Lesson 12: Comparing and Copying Objects — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Overriding equals() in BookRecord ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Copy Constructor in GameSaveState ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Deep Copy Constructor in Playlist ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        BookRecord b1 = new BookRecord("978-0134685991", "Effective Java");
        BookRecord b2 = new BookRecord("978-0134685991", "Effective Java");
        BookRecord b3 = new BookRecord("978-0132350884", "Clean Code");

        // WHY WE USED THIS WAY:
        // `b1 == b2` is false because `new` created two separate objects at different Heap addresses.
        // Overriding `equals()` in `BookRecord` compares the actual `isbn` and `title` Strings!
        System.out.println("b1 == b2      (Memory Address Check) : " + (b1 == b2));
        System.out.println("b1.equals(b2) (Logical ISBN/Title)   : " + b1.equals(b2));
        System.out.println("b1.equals(b3) (Different ISBN)       : " + b1.equals(b3));
    }

    public static void solveProblem2() {
        GameSaveState checkpoint1 = new GameSaveState(5, 250);

        // WHY WE USED THIS WAY:
        // Using the Copy Constructor `new GameSaveState(checkpoint1)` allocates an independent
        // object on the Heap initialized with `checkpoint1`'s values. Advancing `checkpoint2`
        // to Level 6 leaves `checkpoint1` safely at Level 5!
        GameSaveState checkpoint2 = new GameSaveState(checkpoint1);
        checkpoint2.advanceLevel(100);

        System.out.println("Original Checkpoint 1 (Untouched) : " + checkpoint1);
        System.out.println("Cloned Checkpoint 2 (Leveled Up)  : " + checkpoint2);
    }

    public static void solveProblem3() {
        String[] tracks = {"Lo-Fi Beats", "Synthwave", "Classical"};
        Playlist originalPlaylist = new Playlist("Coding Focus", tracks);

        // WHY WE USED THIS WAY:
        // Because `Playlist` contains an array field (`String[] songs`), a shallow copy would
        // share the same array between both playlists! Our Deep Copy Constructor duplicates the
        // array with `Arrays.copyOf(...)` so editing `deepCopy` never corrupts `originalPlaylist`.
        Playlist deepCopy = new Playlist(originalPlaylist);
        deepCopy.replaceSong(0, "Heavy Metal");

        System.out.println("Original Playlist : " + originalPlaylist);
        System.out.println("Deep Copy Playlist: " + deepCopy);
    }
}

class BookRecord {
    private String isbn;
    private String title;

    public BookRecord(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        BookRecord other = (BookRecord) obj;
        return Objects.equals(this.isbn, other.isbn)
                && Objects.equals(this.title, other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.isbn, this.title);
    }
}

class GameSaveState {
    private int level;
    private int coins;

    public GameSaveState(int level, int coins) {
        this.level = level;
        this.coins = coins;
    }

    // Copy Constructor
    public GameSaveState(GameSaveState source) {
        this.level = source.level;
        this.coins = source.coins;
    }

    public void advanceLevel(int bonusCoins) {
        this.level++;
        this.coins += bonusCoins;
    }

    @Override
    public String toString() {
        return String.format("Save [Level: %d | Coins: %d]", this.level, this.coins);
    }
}

class Playlist {
    private String title;
    private String[] songs;

    public Playlist(String title, String[] songs) {
        this.title = title;
        this.songs = Arrays.copyOf(songs, songs.length);
    }

    // Deep Copy Constructor
    public Playlist(Playlist source) {
        this.title = source.title;
        // Deep copy the internal array so both Playlists have separate String[] arrays on the Heap!
        this.songs = Arrays.copyOf(source.songs, source.songs.length);
    }

    public void replaceSong(int index, String newSong) {
        if (index >= 0 && index < this.songs.length) {
            this.songs[index] = newSong;
        }
    }

    @Override
    public String toString() {
        return this.title + " -> " + Arrays.toString(this.songs);
    }
}
