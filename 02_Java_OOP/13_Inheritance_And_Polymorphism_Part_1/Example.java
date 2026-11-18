package _02_Java_OOP._13_Inheritance_And_Polymorphism_Part_1;

/**
 * Lesson 13: Inheritance and Polymorphism (Part 1)
 * Demonstrates:
 * 1. Creating an IS-A hierarchy with the `extends` keyword (`Employee` -> `Developer`, `SalesManager`)
 * 2. Constructor chaining up the hierarchy using `super(...)`
 * 3. Reusing inherited parent methods alongside specialized child methods
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 13: INHERITANCE (`extends` & `super`)     ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. INSTANTIATING SUBCLASSES (Watch Constructor Execution Order!)
        // WHY: When `new SoftwareDeveloper(...)` runs, its constructor calls
        // `super(id, name, salary)` FIRST so the parent `StaffMember` slice is
        // initialized before the child's specialized fields!
        // -----------------------------------------------------------------
        System.out.println("--- [1] Parent -> Child Constructor Execution Order ---");
        SoftwareDeveloper dev = new SoftwareDeveloper(101, "Ada Lovelace", 115_000.0, "Java 17");
        System.out.println();

        SalesExecutive sales = new SalesExecutive(102, "Jordan Belfort", 85_000.0, 25_000.0);
        System.out.println();

        // -----------------------------------------------------------------
        // 2. CALLING INHERITED METHODS VS. SPECIALIZED CHILD METHODS
        // WHY: Neither `SoftwareDeveloper` nor `SalesExecutive` wrote `getName()`
        // or `printBaseBadge()`—they inherited them for free from `StaffMember`!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Inherited Methods + Specialized Child Methods ---");
        dev.printBaseBadge();          // Inherited from StaffMember
        dev.writeCode();               // Specialized in SoftwareDeveloper
        System.out.println();

        sales.printBaseBadge();        // Inherited from StaffMember
        sales.printTotalCompensation();// Uses `super.getBaseSalary()` + child `commission`
    }
}

/**
 * SUPERCLASS (Parent / Base Class):
 * Holds common state and behavior shared by ALL staff members.
 */
class StaffMember {
    private int employeeId;
    private String name;
    private double baseSalary;

    public StaffMember(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
        System.out.println("  [1. Parent Constructor] Initialized StaffMember #"
                + this.employeeId + " (" + this.name + ")");
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void printBaseBadge() {
        System.out.printf("  [Staff Badge] ID: #%d | Name: %-16s | Base Salary: $%,.2f%n",
                this.employeeId, this.name, this.baseSalary);
    }
}

/**
 * SUBCLASS #1: `SoftwareDeveloper` IS-A `StaffMember`.
 */
class SoftwareDeveloper extends StaffMember {
    private String primaryLanguage;

    public SoftwareDeveloper(int employeeId, String name, double baseSalary, String primaryLanguage) {
        // `super(...)` MUST be the very first statement in the subclass constructor!
        super(employeeId, name, baseSalary);
        this.primaryLanguage = primaryLanguage;
        System.out.println("  [2. Child Constructor]  Specialized as SoftwareDeveloper ("
                + this.primaryLanguage + ")");
    }

    public void writeCode() {
        // Calls inherited `getName()` from parent class
        System.out.println("  [Dev Action]  " + getName()
                + " is deploying microservices in " + this.primaryLanguage + ".");
    }
}

/**
 * SUBCLASS #2: `SalesExecutive` IS-A `StaffMember`.
 */
class SalesExecutive extends StaffMember {
    private double commissionEarned;

    public SalesExecutive(int employeeId, String name, double baseSalary, double commissionEarned) {
        super(employeeId, name, baseSalary);
        this.commissionEarned = commissionEarned;
        System.out.println("  [2. Child Constructor]  Specialized as SalesExecutive (Commission: $"
                + this.commissionEarned + ")");
    }

    public void printTotalCompensation() {
        double total = super.getBaseSalary() + this.commissionEarned;
        System.out.printf("  [Sales Comp]  %s Total Pay (Base + Commission): $%,.2f%n",
                getName(), total);
    }
}
