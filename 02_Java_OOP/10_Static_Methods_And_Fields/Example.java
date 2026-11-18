package _02_Java_OOP._10_Static_Methods_And_Fields;

/**
 * Lesson 10: Static Methods and Fields
 * Demonstrates:
 * 1. `static` initializer blocks (run once when the class is loaded into the JVM)
 * 2. Shared `static` fields vs. per-object instance fields (Auto-incrementing ID generator)
 * 3. Stateless `static` Utility Class methods (`MathConverter`)
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 10: STATIC METHODS AND FIELDS           ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. CALLING A `static` METHOD BEFORE ANY OBJECTS EXIST
        // WHY: `getActiveSessionCount()` is `static`, so we call it on the
        // class name `UserSession.getActiveSessionCount()` when 0 objects exist!
        // -----------------------------------------------------------------
        System.out.println("--- [1] Accessing Static Members via Class Name ---");
        System.out.println("Max Allowed Sessions (Constant) : " + UserSession.MAX_CONCURRENT_SESSIONS);
        System.out.println("Active Sessions Before `new`    : " + UserSession.getActiveSessionCount());
        System.out.println();

        // -----------------------------------------------------------------
        // 2. INSTANCE FIELDS (Unique per Object) VS. STATIC FIELDS (Shared)
        // WHY: Each `new UserSession(...)` increments the single shared `static`
        // counter `activeSessionCount` and assigns a unique `sessionId`!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Creating 3 UserSession Objects ---");
        UserSession s1 = new UserSession("alice@company.com");
        UserSession s2 = new UserSession("bob@company.com");
        UserSession s3 = new UserSession("charlie@company.com");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("Active Sessions After 3 Logins  : " + UserSession.getActiveSessionCount());
        System.out.println();

        // -----------------------------------------------------------------
        // 3. STATELESS UTILITY CLASS (`DataSizeConverter`)
        // WHY: Pure mathematical conversion functions don't need object state,
        // so we mark them `static` and call them directly on the class name.
        // -----------------------------------------------------------------
        System.out.println("--- [3] Stateless Static Utility Methods ---");
        long bytes = 5_368_709_120L; // 5 GB
        System.out.println(bytes + " Bytes = " + DataSizeConverter.bytesToMegabytes(bytes) + " MB");
        System.out.println(bytes + " Bytes = " + DataSizeConverter.bytesToGigabytes(bytes) + " GB");
    }
}

/**
 * Demonstrates combining shared `static` fields/blocks with per-instance fields.
 */
class UserSession {
    // 1. STATIC CONSTANT (Shared, immutable across all instances)
    public static final int MAX_CONCURRENT_SESSIONS = 1000;

    // 2. STATIC FIELDS (One shared copy in memory for the entire UserSession class)
    private static int activeSessionCount;
    private static int nextSessionNumber;

    // 3. STATIC INITIALIZER BLOCK: Runs ONCE when UserSession is first loaded by the JVM!
    static {
        activeSessionCount = 0;
        nextSessionNumber = 5000;
        System.out.println("  [Static Block] UserSession class loaded into JVM. Starting ID seed at "
                + nextSessionNumber + ".");
    }

    // 4. INSTANCE FIELDS (Each UserSession object on the Heap gets its own copy)
    private final int sessionId;
    private String userEmail;

    public UserSession(String userEmail) {
        activeSessionCount++;                // Updates shared static counter
        this.sessionId = ++nextSessionNumber; // Assigns unique auto-incremented ID
        this.userEmail = userEmail;
    }

    // 5. STATIC METHOD: Can ONLY access static fields (`activeSessionCount`), NOT `this.userEmail`!
    public static int getActiveSessionCount() {
        return activeSessionCount;
    }

    @Override
    public String toString() {
        return String.format("  Session [ID: #%d | User: %-20s | Total Active: %d]",
                this.sessionId, this.userEmail, activeSessionCount);
    }
}

/**
 * Utility Class Pattern (like `java.lang.Math`):
 * - Private constructor prevents `new DataSizeConverter()`
 * - All methods and constants are `public static`
 */
class DataSizeConverter {
    public static final long BYTES_PER_KB = 1024L;
    public static final long BYTES_PER_MB = 1024L * 1024L;
    public static final long BYTES_PER_GB = 1024L * 1024L * 1024L;

    private DataSizeConverter() {
        // Private constructor prevents instantiation of utility class
    }

    public static double bytesToMegabytes(long bytes) {
        return (double) bytes / BYTES_PER_MB;
    }

    public static double bytesToGigabytes(long bytes) {
        return (double) bytes / BYTES_PER_GB;
    }
}
