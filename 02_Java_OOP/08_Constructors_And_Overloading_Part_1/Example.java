package _02_Java_OOP._08_Constructors_And_Overloading_Part_1;

/**
 * Lesson 08: Constructors and Overloading (Part 1)
 * Demonstrates:
 * 1. Compiler-synthesized default constructor (`DefaultSensor`)
 * 2. Explicit No-Arg Constructor vs. Parameterized Constructor (`DatabaseConnection`)
 * 3. Enforcing validation rules right at object creation time
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 08: CONSTRUCTORS & INITIALIZATION (PT 1)  ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. COMPILER-GENERATED DEFAULT CONSTRUCTOR
        // WHY: `DefaultSensor` defines zero constructors in source code, so
        // `javac` automatically generates `DefaultSensor() {}` in bytecode.
        // -----------------------------------------------------------------
        System.out.println("--- [1] Compiler-Provided Default Constructor ---");
        DefaultSensor rawSensor = new DefaultSensor();
        System.out.println("DefaultSensor -> label: " + rawSensor.label + ", reading: " + rawSensor.reading);
        System.out.println();

        // -----------------------------------------------------------------
        // 2. EXPLICIT NO-ARG CONSTRUCTOR VS. PARAMETERIZED CONSTRUCTOR
        // -----------------------------------------------------------------
        System.out.println("--- [2] Explicit No-Arg vs. Parameterized Constructor ---");

        // Invokes the explicit no-arg constructor (sets local dev defaults)
        DatabaseConnection devDb = new DatabaseConnection();
        devDb.printStatus();

        // Invokes the parameterized constructor (sets production cluster parameters)
        DatabaseConnection prodDb = new DatabaseConnection("db-prod.internal", 5432, 50);
        prodDb.printStatus();
        System.out.println();

        // -----------------------------------------------------------------
        // 3. DEFENSIVE VALIDATION INSIDE A PARAMETERIZED CONSTRUCTOR
        // WHY: An object should NEVER be born in an invalid state!
        // -----------------------------------------------------------------
        System.out.println("--- [3] Constructor Validation Guard ---");
        DatabaseConnection badConfigDb = new DatabaseConnection("", -99, 0);
        badConfigDb.printStatus();
    }
}

/**
 * Has NO constructors written in source code -> `javac` provides `DefaultSensor()`.
 */
class DefaultSensor {
    String label;
    double reading;
}

/**
 * Defines both an explicit No-Arg Constructor and a Parameterized Constructor.
 * Note: Once the Parameterized Constructor was added, we HAD to write the No-Arg
 * Constructor explicitly if we still wanted `new DatabaseConnection()` to compile!
 */
class DatabaseConnection {
    private String host;
    private int port;
    private int maxPoolSize;

    // 1. Explicit No-Arg Constructor: Initializes sensible local development defaults
    public DatabaseConnection() {
        this.host = "localhost";
        this.port = 3306;
        this.maxPoolSize = 10;
        System.out.println("  [Constructor] Initialized DatabaseConnection with LOCAL_DEV defaults.");
    }

    // 2. Parameterized Constructor: Accepts custom configuration + validates invariants
    public DatabaseConnection(String host, int port, int maxPoolSize) {
        this.host = (host != null && !host.trim().isEmpty()) ? host.trim() : "localhost";
        this.port = (port >= 1024 && port <= 65535) ? port : 5432;
        this.maxPoolSize = (maxPoolSize >= 1) ? maxPoolSize : 5;
        System.out.println("  [Constructor] Initialized DatabaseConnection for host '" + this.host + "'.");
    }

    public void printStatus() {
        System.out.printf("  -> DB Connection [jdbc://%s:%d | Max Pool: %d connections]%n",
                this.host, this.port, this.maxPoolSize);
    }
}
