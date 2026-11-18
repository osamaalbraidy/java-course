package _02_Java_OOP._09_Constructors_And_Overloading_Part_2;

/**
 * Lesson 09: Constructors and Overloading (Part 2)
 * Demonstrates:
 * 1. Overloading constructors with 0, 1, 2, and 4 parameters
 * 2. Telescoping Constructor Chaining with `this(...)` into a single Master Constructor
 * 3. Tracing the execution order of chained constructors
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 09: CONSTRUCTOR OVERLOADING & `this()`    ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. CALLING THE 0-ARG CONSTRUCTOR (Chains: 0-arg -> 1-arg -> 2-arg -> 4-arg)
        // -----------------------------------------------------------------
        System.out.println("--- [1] Creating Container with 0-Arg Constructor ---");
        CloudContainer c1 = new CloudContainer();
        System.out.println("Result: " + c1 + "\n");

        // -----------------------------------------------------------------
        // 2. CALLING THE 2-ARG CONSTRUCTOR (Chains: 2-arg -> 4-arg)
        // -----------------------------------------------------------------
        System.out.println("--- [2] Creating Container with 2-Arg Constructor ---");
        CloudContainer c2 = new CloudContainer("redis-cache", 4096);
        System.out.println("Result: " + c2 + "\n");

        // -----------------------------------------------------------------
        // 3. CALLING THE 4-ARG MASTER CONSTRUCTOR DIRECTLY
        // -----------------------------------------------------------------
        System.out.println("--- [3] Creating Container with 4-Arg Master Constructor ---");
        CloudContainer c3 = new CloudContainer("ml-inference-gpu", 32768, 8, true);
        System.out.println("Result: " + c3);
    }
}

/**
 * Demonstrates the Telescoping Constructor Pattern using `this(...)`.
 * All validation and field assignment happen in ONE place (the 4-arg Master Constructor).
 */
class CloudContainer {
    private String imageName;
    private int memoryMb;
    private int cpuCores;
    private boolean autoRestart;

    // 1. 0-Arg Constructor -> Chains to 1-Arg Constructor
    public CloudContainer() {
        this("nginx-alpine"); // MUST be the first statement!
        System.out.println("  [Trace] Finished 0-Arg Constructor body.");
    }

    // 2. 1-Arg Constructor -> Chains to 2-Arg Constructor
    public CloudContainer(String imageName) {
        this(imageName, 512);
        System.out.println("  [Trace] Finished 1-Arg Constructor body.");
    }

    // 3. 2-Arg Constructor -> Chains to 4-Arg Master Constructor
    public CloudContainer(String imageName, int memoryMb) {
        this(imageName, memoryMb, 2, true);
        System.out.println("  [Trace] Finished 2-Arg Constructor body.");
    }

    // 4. MASTER 4-ARG CONSTRUCTOR (Single Source of Truth!)
    public CloudContainer(String imageName, int memoryMb, int cpuCores, boolean autoRestart) {
        this.imageName = (imageName != null && !imageName.isEmpty()) ? imageName : "default-image";
        this.memoryMb = (memoryMb >= 128) ? memoryMb : 128;
        this.cpuCores = (cpuCores >= 1) ? cpuCores : 1;
        this.autoRestart = autoRestart;
        System.out.println("  [Trace] Executed 4-Arg Master Constructor for '" + this.imageName + "'.");
    }

    @Override
    public String toString() {
        return String.format("CloudContainer [Image: %s | RAM: %dMB | CPUs: %d | AutoRestart: %b]",
                this.imageName, this.memoryMb, this.cpuCores, this.autoRestart);
    }
}
