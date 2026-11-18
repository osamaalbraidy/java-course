package _01_Java_Basics._02_How_To_Install_Java;

/**
 * Lesson 02: How To Install Java — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): CLI Command Builder
        // =================================================================
        System.out.println("=== Problem 1: CLI Command Builder ===");

        // WHY WE USED THIS WAY:
        // - `javac -d bin` tells the compiler to place generated `.class` files inside the `bin`
        //   folder matching the package hierarchy, and takes a file path ending in `.java`.
        // - `java -cp bin` tells the JVM to look inside `bin` for compiled classes, and takes
        //   the fully qualified package.ClassName (with dots `.` and NO `.class` extension!).
        System.out.println("Compile Command : javac -d bin com/company/app/App.java");
        System.out.println("Execute Command : java -cp bin com.company.app.App");

        // =================================================================
        // Problem 2 (Medium): JAVA_HOME Validator
        // =================================================================
        System.out.println("\n=== Problem 2: JAVA_HOME Validator ===");

        String candidatePath = "C:\\Program Files\\Java\\jdk-17.0.1\\bin";
        System.out.println("Original JAVA_HOME  : " + candidatePath);

        // WHY WE USED THIS WAY:
        // Build tools (Maven, Gradle) automatically append `\bin\java` to JAVA_HOME.
        // If JAVA_HOME already ends with `\bin`, we strip the last 4 characters (`\bin`)
        // using substring(0, length - 4) so JAVA_HOME points cleanly to the JDK root folder.
        String correctedPath = candidatePath;
        if (candidatePath.endsWith("\\bin")) {
            correctedPath = candidatePath.substring(0, candidatePath.length() - 4);
        }
        System.out.println("Corrected JAVA_HOME : " + correctedPath);

        // =================================================================
        // Problem 3 (Hard): Class File Version Calculator
        // =================================================================
        System.out.println("\n=== Problem 3: Class File Version Calculator ===");

        // WHY WE USED THIS WAY:
        // Every Java release increments the `.class` bytecode major version by 1 according
        // to the constant offset formula: `classVersion = javaMajorVersion + 44`.
        // If you compile with Java 17 (61.0) and try to run on Java 8 (52.0), the JVM
        // compares these numbers and throws `UnsupportedClassVersionError`.
        int java8ClassVer = 8 + 44;
        int java11ClassVer = 11 + 44;
        int java17ClassVer = 17 + 44;
        int java21ClassVer = 21 + 44;

        System.out.println("Java 8  -> Bytecode Class Version: " + java8ClassVer + ".0");
        System.out.println("Java 11 -> Bytecode Class Version: " + java11ClassVer + ".0");
        System.out.println("Java 17 -> Bytecode Class Version: " + java17ClassVer + ".0");
        System.out.println("Java 21 -> Bytecode Class Version: " + java21ClassVer + ".0");
    }
}
