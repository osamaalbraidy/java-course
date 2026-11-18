package _02_Java_OOP._00_OOP_Get_Started;

/**
 * Lesson 00: OOP Get Started — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: The 4 Pillars of OOP Matcher ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Refactoring Procedural Variables into Objects ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: State-Protecting Behavior in ThermostatPreview ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // Summarizes the 4 core pillars of Object-Oriented Programming and the architectural
        // problem each pillar solves.
        System.out.println("1. Encapsulation : Bundles data and methods; hides internal state via private fields");
        System.out.println("2. Abstraction   : Exposes essential behavior while hiding complex implementation details");
        System.out.println("3. Inheritance   : Allows subclasses to reuse and extend parent class state and behavior");
        System.out.println("4. Polymorphism  : Enables one common interface to represent multiple runtime forms");
    }

    public static void solveProblem2() {
        // WHY WE USED THIS WAY:
        // Instead of juggling loose `emp1Name`, `emp1Salary`, `emp2Name`, `emp2Salary` variables,
        // each `EmployeePreview` object bundles its own name and salary together and exposes
        // `giveRaise()` and `printBadge()` methods to operate on its own internal state.
        EmployeePreview emp1 = new EmployeePreview("Liam", 70000.0);
        EmployeePreview emp2 = new EmployeePreview("Noah", 85000.0);

        emp1.giveRaise(10.0);
        emp2.giveRaise(5.0);

        emp1.printBadge();
        emp2.printBadge();
    }

    public static void solveProblem3() {
        ThermostatPreview thermostat = new ThermostatPreview();
        thermostat.setTemperature(24);
        thermostat.setTemperature(45); // Blocked by internal range validation!
        thermostat.setTemperature(18);
    }
}

class EmployeePreview {
    private String name;
    private double salary;

    public EmployeePreview(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void giveRaise(double percent) {
        salary += salary * (percent / 100.0);
    }

    public void printBadge() {
        System.out.printf("Employee: %s | Salary: $%.2f%n", name, salary);
    }
}

class ThermostatPreview {
    private int temperature = 20;

    public void setTemperature(int newTemp) {
        // WHY WE USED THIS WAY:
        // Because `temperature` is `private`, external code CANNOT bypass this `if` guard.
        // This guarantees that the thermostat stays within its safe [16..30]C range at all times.
        if (newTemp >= 16 && newTemp <= 30) {
            temperature = newTemp;
            System.out.println("Thermostat updated to " + temperature + "C");
        } else {
            System.out.println("Rejected unsafe temperature: " + newTemp
                    + "C ( stays at " + temperature + "C)");
        }
    }
}
