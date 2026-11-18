package _01_Java_Basics._00_Introduction;

/**
 * Lesson 00: Introduction to Java Architecture — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): JDK, JRE, and JVM Component Classifier
        // =================================================================
        System.out.println("=== Problem 1: JDK, JRE, and JVM Component Classifier ===");

        // WHY WE USED THIS WAY:
        // System.out.println() prints each string literal followed by a line break,
        // allowing us to format a clean ASCII table classifying each Java layer:
        // - javac belongs to the JDK (Development tools)
        // - Standard Class Libraries belong to the JRE (Runtime libraries)
        // - Garbage Collector & JIT Compiler belong to the JVM (Execution engine)
        System.out.println("Component                                     | Layer");
        System.out.println("----------------------------------------------+------");
        System.out.println("javac (Java Compiler)                         | JDK");
        System.out.println("Standard Class Libraries (java.lang, util)    | JRE");
        System.out.println("Garbage Collector (GC) & JIT Compiler         | JVM");

        // =================================================================
        // Problem 2 (Medium): WORA Platform Inspector
        // =================================================================
        System.out.println("\n=== Problem 2: WORA Platform Inspector ===");

        // WHY WE USED THIS WAY:
        // Instead of hardcoding OS-specific values, System.getProperty() queries the
        // JVM dynamically at runtime so our code works on Windows, macOS, and Linux ("Write Once, Run Anywhere").
        String workingDir = System.getProperty("user.dir");
        String classVersion = System.getProperty("java.class.version");
        String fileSeparator = System.getProperty("file.separator");

        System.out.println("Working Directory : " + workingDir);
        System.out.println("Class Format Ver  : " + classVersion);
        System.out.println("OS File Separator : " + fileSeparator);

        // =================================================================
        // Problem 3 (Hard): JVM Heap Used-Memory Calculator
        // =================================================================
        System.out.println("\n=== Problem 3: JVM Heap Used-Memory Calculator ===");

        // WHY WE USED THIS WAY:
        // 1. Runtime.getRuntime() gives us access to the active JVM memory manager.
        // 2. We store memory sizes in `long` (64-bit integer) instead of `int` because
        //    modern heaps exceed 2 GB (2,147,483,647 bytes), which would overflow an `int`.
        // 3. Subtracting freeMemory() from totalMemory() yields the exact bytes currently in use,
        //    and dividing by 1024 converts bytes into Kilobytes (KB).
        Runtime jvmRuntime = Runtime.getRuntime();
        long totalBytes = jvmRuntime.totalMemory();
        long freeBytes = jvmRuntime.freeMemory();
        long usedBytes = totalBytes - freeBytes;

        long totalKB = totalBytes / 1024;
        long freeKB = freeBytes / 1024;
        long usedKB = usedBytes / 1024;

        System.out.println("Total Heap (KB) : " + totalKB);
        System.out.println("Free Heap (KB)  : " + freeKB);
        System.out.println("Used Heap (KB)  : " + usedKB);
    }
}
