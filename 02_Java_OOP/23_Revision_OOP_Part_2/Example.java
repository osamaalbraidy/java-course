package _02_Java_OOP._23_Revision_OOP_Part_2;

/**
 * Lesson 23: Revision OOP (Part 2)
 * Practice Project Part 2: Inheritance, Abstract Classes, Overriding, `final`/`protected` & Polymorphism
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 23: OOP REVISION PART 2 (INHERIT & POLY)  ");
        System.out.println("==================================================\n");

        // 1. Upcasting concrete subclasses into a polymorphic `MedicalStaff[]` array
        MedicalStaff[] roster = {
            new ChiefSurgeon("DR-101", "Dr. Stephen Strange", "Neurosurgery", 18_000.00, 4),
            new NursePractitioner("NP-204", "Claire Temple", "Emergency ER", 7_500.00, 15)
        };

        // 2. Dynamic Method Dispatch + Locked `final` Template Method
        System.out.println("--- [1] Polymorphic Payroll & Shift Dispatch ---");
        double totalHospitalPayroll = 0.0;

        for (MedicalStaff member : roster) {
            member.clockInForShift(); // Calls `public final` template method!
            double pay = member.calculateMonthlyCompensation(); // Dynamic dispatch!
            totalHospitalPayroll += pay;
            System.out.printf("  [Payroll] %-22s -> Monthly Pay: $%,10.2f%n", member.getFullName(), pay);

            // 3. Safe Downcasting with Java 17 `instanceof` Pattern Matching
            if (member instanceof ChiefSurgeon surgeon) {
                surgeon.scheduleOperatingRoom();
            }
            System.out.println();
        }

        System.out.printf("Total Monthly Department Payroll: $%,.2f%n", totalHospitalPayroll);
    }
}

abstract class MedicalStaff {
    private String staffId;
    private String fullName;
    protected String department; // `protected` so subclasses can access directly

    public MedicalStaff(String staffId, String fullName, String department) {
        this.staffId = staffId;
        this.fullName = fullName;
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    // `final` method: locks badge security scan before shift start
    public final void clockInForShift() {
        System.out.println("  [Security Scan] Verified ID Badge [" + this.staffId
                + "] for " + this.fullName + " (" + this.department + ")");
        performDailyRounds();
    }

    // Abstract methods: every subclass MUST implement these!
    protected abstract void performDailyRounds();

    public abstract double calculateMonthlyCompensation();
}

class ChiefSurgeon extends MedicalStaff {
    private double baseSalary;
    private int surgeriesPerformed;

    public ChiefSurgeon(String staffId, String fullName, String department,
                        double baseSalary, int surgeriesPerformed) {
        super(staffId, fullName, department);
        this.baseSalary = baseSalary;
        this.surgeriesPerformed = surgeriesPerformed;
    }

    @Override
    protected void performDailyRounds() {
        System.out.println("  [Surgeon Rounds] Reviewing pre-op scans in " + this.department + ".");
    }

    @Override
    public double calculateMonthlyCompensation() {
        // $1,500 bonus per surgery performed
        return this.baseSalary + (this.surgeriesPerformed * 1500.00);
    }

    // Subclass-specific method (requires downcasting when referenced as MedicalStaff)
    public void scheduleOperatingRoom() {
        System.out.println("  [OR Booking]    Reserved Operating Theater #1 for " + getFullName() + ".");
    }
}

class NursePractitioner extends MedicalStaff {
    private double baseSalary;
    private int overtimeHours;

    public NursePractitioner(String staffId, String fullName, String department,
                             double baseSalary, int overtimeHours) {
        super(staffId, fullName, department);
        this.baseSalary = baseSalary;
        this.overtimeHours = overtimeHours;
    }

    @Override
    protected void performDailyRounds() {
        System.out.println("  [Triage Rounds] Updating patient vitals in " + this.department + ".");
    }

    @Override
    public double calculateMonthlyCompensation() {
        return this.baseSalary + (this.overtimeHours * 75.00);
    }
}
