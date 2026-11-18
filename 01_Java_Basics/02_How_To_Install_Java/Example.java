package _01_Java_Basics._02_How_To_Install_Java;

import java.io.File;

/**
 * Lesson 02: How To Install Java (JDK, JAVA_HOME, PATH & Version Verification)
 *
 * Demonstrates how a Java application can programmatically audit the developer's
 * JDK installation, environment variables, and Java 17+ feature readiness.
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     JDK INSTALLATION & ENVIRONMENT AUDITOR       ");
        System.out.println("==================================================\n");

        // 1. Checking Runtime Version vs. Target Curriculum Standard (Java 17+)
        String versionString = System.getProperty("java.specification.version");
        String fullVersion = System.getProperty("java.runtime.version");
        String javaHomeProp = System.getProperty("java.home");

        System.out.println("--- [1] Active Java Runtime Inspection ---");
        System.out.println("Java Spec Version    : " + versionString);
        System.out.println("Full Runtime Build   : " + fullVersion);
        System.out.println("Active java.home     : " + javaHomeProp);

        // Parse major version number inline (handles both "1.8" legacy format and "17" modern format)
        int majorVersion;
        if (versionString.startsWith("1.")) {
            majorVersion = Integer.parseInt(versionString.substring(2, 3));
        } else {
            majorVersion = Integer.parseInt(versionString);
        }

        if (majorVersion >= 17) {
            System.out.println("Status               : [PASS] Modern Java LTS (Java " + majorVersion + ") is active!");
        } else {
            System.out.println("Status               : [WARN] Running on Java " + majorVersion
                    + ". Consider switching PATH to JDK 17+.");
        }
        System.out.println();

        // 2. Verifying the Compiler (javac) Binary Inside the JDK
        // WHY: A JRE only has 'java', whereas a full JDK has both 'java' and 'javac' inside /bin.
        System.out.println("--- [2] Checking for JDK Compiler (javac) ---");
        boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
        String javacExecutableName = isWindows ? "javac.exe" : "javac";

        File binDirectory = new File(javaHomeProp, "bin");
        File javacFile = new File(binDirectory, javacExecutableName);

        System.out.println("Expected bin Folder  : " + binDirectory.getAbsolutePath());
        System.out.println("Compiler Binary Path : " + javacFile.getAbsolutePath());
        System.out.println("Is Full JDK Present? : " + (javacFile.exists() ? "YES (javac found)" : "NO (JRE only or nested jre dir)"));
        System.out.println();

        // 3. Checking Environment Variable JAVA_HOME
        // WHY: Build tools like Maven, Gradle, and Tomcat rely on the OS environment variable JAVA_HOME.
        System.out.println("--- [3] OS Environment Variable Check ---");
        String envJavaHome = System.getenv("JAVA_HOME");
        if (envJavaHome != null && !envJavaHome.isEmpty()) {
            System.out.println("OS JAVA_HOME Env Var : " + envJavaHome);
            if (envJavaHome.endsWith("bin") || envJavaHome.endsWith("bin\\") || envJavaHome.endsWith("bin/")) {
                System.out.println("Configuration Alert  : [ERROR] JAVA_HOME should NOT end with '/bin'!");
            } else {
                System.out.println("Configuration Alert  : [OK] JAVA_HOME points cleanly to root directory.");
            }
        } else {
            System.out.println("OS JAVA_HOME Env Var : [NOT SET] (Relying on system PATH only)");
        }
        System.out.println();

        // 4. CLI Compilation Cheat Sheet
        System.out.println("--- [4] CLI vs. Single-File Execution Cheat Sheet ---");
        System.out.println("Traditional Compile  : javac -d out 01_Java_Basics/02_How_To_Install_Java/Example.java");
        System.out.println("Traditional Run      : java -cp out _01_Java_Basics._02_How_To_Install_Java.Example");
        System.out.println("Java 11+ Direct Run  : java 01_Java_Basics/02_How_To_Install_Java/Example.java");
    }
}
