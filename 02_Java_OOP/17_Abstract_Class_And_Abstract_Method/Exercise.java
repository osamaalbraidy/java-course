package _02_Java_OOP._17_Abstract_Class_And_Abstract_Method;

/**
 * Lesson 17: Abstract Class and Abstract Method — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Abstract EmployeeCompensation Hierarchy ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Abstract GeometricShape Contracts ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Template Method Pattern (DatabaseMigrationTask) ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // `EmployeeCompensation` is abstract because there is no single pay formula for
        // a generic employee. Marking `calculateBiweeklyPay()` as `abstract` forces both
        // `SalariedEngineer` and `HourlyContractor` to provide their own exact formula!
        EmployeeCompensation emp1 = new SalariedEngineer("Elena (Salaried)", 104_000.00);
        EmployeeCompensation emp2 = new HourlyContractor("Marcus (Contractor)", 85.00, 40);

        emp1.printPayStub();
        emp2.printPayStub();
    }

    public static void solveProblem2() {
        GeometricShape s1 = new RightTriangle("Blue", 3.0, 4.0);
        GeometricShape s2 = new SquareShape("Gold", 6.0);

        s1.printMetrics();
        s2.printMetrics();
    }

    public static void solveProblem3() {
        DatabaseMigrationTask task = new AddUsersTableMigration("V1__Add_Users_Table");
        task.runMigration();
    }
}

// -----------------------------------------------------------------
// Problem 1 Classes
// -----------------------------------------------------------------
abstract class EmployeeCompensation {
    private String name;

    public EmployeeCompensation(String name) {
        this.name = name;
    }

    public abstract double calculateBiweeklyPay();

    public void printPayStub() {
        System.out.printf("Pay Stub -> Name: %-19s| Biweekly Pay: $%,.2f%n",
                this.name, calculateBiweeklyPay());
    }
}

class SalariedEngineer extends EmployeeCompensation {
    private double annualSalary;

    public SalariedEngineer(String name, double annualSalary) {
        super(name);
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateBiweeklyPay() {
        return this.annualSalary / 26.0;
    }
}

class HourlyContractor extends EmployeeCompensation {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyContractor(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateBiweeklyPay() {
        return this.hourlyRate * this.hoursWorked;
    }
}

// -----------------------------------------------------------------
// Problem 2 Classes
// -----------------------------------------------------------------
abstract class GeometricShape {
    private String color;

    public GeometricShape(String color) {
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public void printMetrics() {
        System.out.printf("%-19s -> Area: %.2f | Perimeter: %.2f%n",
                this.color + " " + this.getClass().getSimpleName(),
                getArea(), getPerimeter());
    }
}

class RightTriangle extends GeometricShape {
    private double base;
    private double height;

    public RightTriangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * this.base * this.height;
    }

    @Override
    public double getPerimeter() {
        double hypotenuse = Math.sqrt(this.base * this.base + this.height * this.height);
        return this.base + this.height + hypotenuse;
    }
}

class SquareShape extends GeometricShape {
    private double side;

    public SquareShape(String color, double side) {
        super(color);
        this.side = side;
    }

    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public double getPerimeter() {
        return 4.0 * this.side;
    }
}

// -----------------------------------------------------------------
// Problem 3 Classes (Template Method Design Pattern)
// -----------------------------------------------------------------
abstract class DatabaseMigrationTask {
    private String versionName;

    public DatabaseMigrationTask(String versionName) {
        this.versionName = versionName;
    }

    // WHY WE USED THIS WAY:
    // The Template Method (`runMigration`) is `public final` so it locks the 3-step sequence
    // (Open -> Apply -> Commit), while delegating step 2 to the `abstract` method `applySchemaChanges()`.
    public final void runMigration() {
        System.out.println("Running Migration: " + this.versionName);
        System.out.println("  1. [DB] Transaction opened.");
        applySchemaChanges();
        System.out.println("  3. [DB] Transaction committed cleanly.");
    }

    protected abstract void applySchemaChanges();
}

class AddUsersTableMigration extends DatabaseMigrationTask {
    public AddUsersTableMigration(String versionName) {
        super(versionName);
    }

    @Override
    protected void applySchemaChanges() {
        System.out.println("  2. [SQL] CREATE TABLE users (id BIGINT PRIMARY KEY, email VARCHAR(255));");
    }
}
