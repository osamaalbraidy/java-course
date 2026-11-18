package _02_Java_OOP._09_Constructors_And_Overloading_Part_2;

/**
 * Lesson 09: Constructors and Overloading (Part 2) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Overloaded BoxDimensions Constructors ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Chained EmployeeAccount Constructors ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: SmartSensorNode Master Validation ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        BoxDimensions unitCube = new BoxDimensions();
        BoxDimensions cube4 = new BoxDimensions(4.0);
        BoxDimensions customBox = new BoxDimensions(2.0, 3.0, 5.0);

        System.out.println("Unit Cube (0-arg)   -> " + unitCube);
        System.out.println("Cube (side=4.0)     -> " + cube4);
        System.out.println("Box (2.0x3.0x5.0)   -> " + customBox);
    }

    public static void solveProblem2() {
        EmployeeAccount emp1 = new EmployeeAccount("Maya");
        EmployeeAccount emp2 = new EmployeeAccount("Leo", "Engineering");
        EmployeeAccount emp3 = new EmployeeAccount("Zoe", "Architecture", 120000.0);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
    }

    public static void solveProblem3() {
        SmartSensorNode s1 = new SmartSensorNode("NODE-101");
        SmartSensorNode s2 = new SmartSensorNode("NODE-102", "Humidity");
        SmartSensorNode s3 = new SmartSensorNode("", "Pressure", 1);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}

class BoxDimensions {
    private double length;
    private double width;
    private double height;

    // WHY WE USED THIS WAY:
    // Using `this(...)` constructor chaining avoids duplicating `this.length = ...` across
    // three constructors. The 0-arg chains to the 1-arg, which chains to the 3-arg master constructor!
    public BoxDimensions() {
        this(1.0);
    }

    public BoxDimensions(double cubeSide) {
        this(cubeSide, cubeSide, cubeSide);
    }

    public BoxDimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return String.format("%.1f x %.1f x %.1f (Volume: %.1f)",
                length, width, height, getVolume());
    }
}

class EmployeeAccount {
    private String name;
    private String department;
    private double salary;

    public EmployeeAccount(String name) {
        this(name, "General", 50000.0);
    }

    public EmployeeAccount(String name, String department) {
        this(name, department, 65000.0);
    }

    public EmployeeAccount(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Employee [Name: %s | Dept: %s | Salary: $%.2f]",
                name, department, salary);
    }
}

class SmartSensorNode {
    private String nodeId;
    private String sensorType;
    private int pollingIntervalSec;

    public SmartSensorNode(String nodeId) {
        this(nodeId, "Temperature", 60);
    }

    public SmartSensorNode(String nodeId, String sensorType) {
        this(nodeId, sensorType, 60);
    }

    // WHY WE USED THIS WAY:
    // Because the 1-arg and 2-arg constructors chain into this 3-arg Master Constructor via `this(...)`,
    // writing the validation rules ONCE here automatically protects every constructor in the class!
    public SmartSensorNode(String nodeId, String sensorType, int pollingIntervalSec) {
        this.nodeId = (nodeId != null && !nodeId.trim().isEmpty()) ? nodeId.trim() : "NODE-UNKNOWN";
        this.sensorType = sensorType;
        this.pollingIntervalSec = (pollingIntervalSec >= 5) ? pollingIntervalSec : 5;
    }

    @Override
    public String toString() {
        return String.format("Sensor [ID: %s | Type: %s | Poll: %ds]",
                nodeId, sensorType, pollingIntervalSec);
    }
}
