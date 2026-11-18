package _01_Java_Basics._00_Introduction;

/**
 * Lesson 00: Introduction to Java Architecture (JVM, JRE, JDK & Compilation Flow)
 *
 * Package Note: Because Java identifiers cannot start with a digit, our package
 * names prefix folder numbers with an underscore: `_01_Java_Basics._00_Introduction`.
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   WELCOME TO JAVA ARCHITECTURE DIAGNOSTICS       ");
        System.out.println("==================================================\n");

        // 1. Inspecting JDK / JRE / JVM Details via System Properties
        // WHY: System.getProperty() queries the underlying JVM environment at runtime,
        // proving that our bytecode interacts with the host through the JVM abstraction layer.
        String javaVersion = System.getProperty("java.version");
        String jvmName = System.getProperty("java.vm.name");
        String jvmVendor = System.getProperty("java.vm.vendor");
        String javaHome = System.getProperty("java.home");

        System.out.println("--- [1] Java Virtual Machine & Runtime Info ---");
        System.out.println("Java Runtime Version : " + javaVersion);
        System.out.println("JVM Implementation   : " + jvmName);
        System.out.println("JVM Vendor           : " + jvmVendor);
        System.out.println("Java Installation Dir: " + javaHome);
        System.out.println();

        // 2. Inspecting the Host Operating System ("Write Once, Run Anywhere")
        // WHY: The exact same compiled Example.class file will output different OS details
        // depending on whether it is executed on Windows, Linux, or macOS.
        String osName = System.getProperty("os.name");
        String osArch = System.getProperty("os.arch");
        String osVersion = System.getProperty("os.version");

        System.out.println("--- [2] Host Operating System Details ---");
        System.out.println("Operating System     : " + osName);
        System.out.println("OS Architecture      : " + osArch);
        System.out.println("OS Version           : " + osVersion);
        System.out.println();

        // 3. Inspecting JVM Hardware & Memory Resources via Runtime API
        // WHY: The JVM manages its own memory heap and Garbage Collector (GC) independent
        // of raw OS pointers, protecting developers from manual memory management bugs.
        Runtime jvmRuntime = Runtime.getRuntime();
        int availableCores = jvmRuntime.availableProcessors();
        long maxMemoryMB = jvmRuntime.maxMemory() / (1024 * 1024);
        long totalMemoryMB = jvmRuntime.totalMemory() / (1024 * 1024);
        long freeMemoryMB = jvmRuntime.freeMemory() / (1024 * 1024);

        System.out.println("--- [3] JVM Execution Engine & Memory Heap ---");
        System.out.println("Available CPU Cores  : " + availableCores);
        System.out.println("Max Heap Memory      : " + maxMemoryMB + " MB");
        System.out.println("Allocated Heap Memory: " + totalMemoryMB + " MB");
        System.out.println("Free Allocated Memory: " + freeMemoryMB + " MB");
        System.out.println();

        // 4. Visualizing the Compilation & Execution Pipeline
        System.out.println("--- [4] Java WORA Execution Pipeline ---");
        System.out.println("Step 1: [Example.java]  --(javac compiler)--> [Example.class (Bytecode)]");
        System.out.println("Step 2: [Example.class] --(JVM ClassLoader)-> [Bytecode Verifier]");
        System.out.println("Step 3: [Verifier]      --(Interpreter/JIT)-> [" + osName + " (" + osArch + ") Machine Code]");
    }
}
