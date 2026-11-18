package _02_Java_OOP._15_Inheritance_And_Method_Overriding;

/**
 * Lesson 15: Inheritance and Method Overriding
 * Demonstrates:
 * 1. Overriding parent methods with `@Override`
 * 2. Extending (rather than completely replacing) parent behavior with `super.methodName()`
 * 3. Side-by-side comparison of Overriding (same signature) vs. Overloading (different parameters)
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 15: INHERITANCE & METHOD OVERRIDING       ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. METHOD OVERRIDING & EXTENDING PARENT LOGIC VIA `super.method()`
        // -----------------------------------------------------------------
        System.out.println("--- [1] Overriding `computeMonthlyPay()` Across Subclasses ---");
        PayrollEmployee regular = new PayrollEmployee("Alice (Base Staff)", 5000.00);
        EngineeringLead lead = new EngineeringLead("Bob (Eng Lead)", 5000.00, 1200.00);
        ExecutiveDirector director = new ExecutiveDirector("Carol (Director)", 5000.00, 25);

        System.out.println(regular.getSummaryLine());
        System.out.println(lead.getSummaryLine());
        System.out.println(director.getSummaryLine());
        System.out.println();

        // -----------------------------------------------------------------
        // 2. OVERRIDING VS. OVERLOADING IN THE SAME HIERARCHY
        // WHY:
        // - `lead.computeMonthlyPay()` (0 args) OVERRIDES the parent method.
        // - `lead.computeMonthlyPay(doubleextraBonus)` (1 arg) OVERLOADS it!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Overriding (0-arg) vs. Overloading (1-arg) ---");
        System.out.printf("Overridden 0-arg call : $%,.2f%n", lead.computeMonthlyPay());
        System.out.printf("Overloaded 1-arg call : $%,.2f (Includes $500 spot bonus)%n",
                lead.computeMonthlyPay(500.00));
    }
}

class PayrollEmployee {
    private String name;
    private double baseMonthlySalary;

    public PayrollEmployee(String name, double baseMonthlySalary) {
        this.name = name;
        this.baseMonthlySalary = baseMonthlySalary;
    }

    public String getName() {
        return name;
    }

    public double computeMonthlyPay() {
        return this.baseMonthlySalary;
    }

    public String getSummaryLine() {
        return String.format("  %-22s -> Monthly Pay: $%,8.2f",
                this.name, computeMonthlyPay());
    }
}

class EngineeringLead extends PayrollEmployee {
    private double leadershipStipend;

    public EngineeringLead(String name, double baseMonthlySalary, double leadershipStipend) {
        super(name, baseMonthlySalary);
        this.leadershipStipend = leadershipStipend;
    }

    // OVERRIDING: Exact same method name AND exact same 0-parameter list as PayrollEmployee!
    @Override
    public double computeMonthlyPay() {
        // Reuses parent calculation via `super.computeMonthlyPay()` and adds stipend!
        return super.computeMonthlyPay() + this.leadershipStipend;
    }

    // OVERLOADING: Same method name, DIFFERENT parameter list (`double spotBonus`)!
    // Notice we do NOT put `@Override` here because this is an overload, not an override!
    public double computeMonthlyPay(double spotBonus) {
        return this.computeMonthlyPay() + spotBonus;
    }
}

class ExecutiveDirector extends PayrollEmployee {
    private int bonusPercent;

    public ExecutiveDirector(String name, double baseMonthlySalary, int bonusPercent) {
        super(name, baseMonthlySalary);
        this.bonusPercent = bonusPercent;
    }

    @Override
    public double computeMonthlyPay() {
        double base = super.computeMonthlyPay();
        return base + (base * (this.bonusPercent / 100.0));
    }
}
