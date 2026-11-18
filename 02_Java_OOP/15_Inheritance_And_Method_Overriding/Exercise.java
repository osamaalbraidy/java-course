package _02_Java_OOP._15_Inheritance_And_Method_Overriding;

/**
 * Lesson 15: Inheritance and Method Overriding — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Overriding vs. Overloading Comparison ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Overriding with super.method() in CoffeeOrder ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: FeeCheckingAccount Withdrawal Override ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        System.out.println("1. Parameters   : Overriding keeps IDENTICAL parameters; Overloading requires DIFFERENT parameters");
        System.out.println("2. Class Scope  : Overriding requires Superclass/Subclass; Overloading can be in the SAME class");
        System.out.println("3. Binding Time : Overriding uses Runtime Dynamic Dispatch; Overloading uses Compile-Time Binding");
        System.out.println("4. Annotation   : Overriding uses @Override; Overloading does NOT use @Override");
    }

    public static void solveProblem2() {
        CoffeeOrder simpleCoffee = new CoffeeOrder("Large", 3.50);
        SpecialtyLatteOrder vanillaOatLatte = new SpecialtyLatteOrder("Large", 3.50, "Vanilla", true);

        System.out.printf("Base Order      : %s -> $%.2f%n",
                simpleCoffee.getDescription(), simpleCoffee.getCost());
        System.out.printf("Specialty Order : %s -> $%.2f%n",
                vanillaOatLatte.getDescription(), vanillaOatLatte.getCost());
    }

    public static void solveProblem3() {
        CheckingAccount standard = new CheckingAccount(200.00);
        boolean ok1 = standard.withdraw(50.00);
        System.out.printf("Standard Checking ($200 - $50)     -> Approved: %-5b | Remaining: $%.2f%n",
                ok1, standard.getBalance());

        FeeCheckingAccount feeAcc = new FeeCheckingAccount(200.00, 2.50);
        boolean ok2 = feeAcc.withdraw(50.00);
        System.out.printf("Fee Checking      ($200 - $50-$2.5)-> Approved: %-5b | Remaining: $%.2f%n",
                ok2, feeAcc.getBalance());

        // Attempting to withdraw $146.00 + $2.50 fee = $148.50 (> $147.50 balance -> rejected!)
        boolean ok3 = feeAcc.withdraw(146.00);
        System.out.printf("Fee Checking Overdraft ($147.50)   -> Approved: %-5b | Remaining: $%.2f%n",
                ok3, feeAcc.getBalance());
    }
}

// -----------------------------------------------------------------
// Problem 2 Classes
// -----------------------------------------------------------------
class CoffeeOrder {
    private String size;
    private double basePrice;

    public CoffeeOrder(String size, double basePrice) {
        this.size = size;
        this.basePrice = basePrice;
    }

    public double getCost() {
        return this.basePrice;
    }

    public String getDescription() {
        return this.size + " Coffee";
    }
}

class SpecialtyLatteOrder extends CoffeeOrder {
    private String syrupFlavor;
    private boolean oatMilk;

    public SpecialtyLatteOrder(String size, double basePrice, String syrupFlavor, boolean oatMilk) {
        super(size, basePrice);
        this.syrupFlavor = syrupFlavor;
        this.oatMilk = oatMilk;
    }

    // WHY WE USED THIS WAY:
    // `@Override` verifies the signature matches `CoffeeOrder.getCost()`, and calling
    // `super.getCost()` fetches the base coffee price so we only add the add-on costs!
    @Override
    public double getCost() {
        double total = super.getCost() + 0.75; // +$0.75 for syrup
        if (this.oatMilk) {
            total += 1.00; // +$1.00 for oat milk
        }
        return total;
    }

    @Override
    public String getDescription() {
        String desc = super.getDescription() + " + " + this.syrupFlavor + " Syrup";
        if (this.oatMilk) {
            desc += " + Oat Milk";
        }
        return desc;
    }
}

// -----------------------------------------------------------------
// Problem 3 Classes
// -----------------------------------------------------------------
class CheckingAccount {
    private double balance;

    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

class FeeCheckingAccount extends CheckingAccount {
    private double transactionFee;

    public FeeCheckingAccount(double balance, double transactionFee) {
        super(balance);
        this.transactionFee = transactionFee;
    }

    // WHY WE USED THIS WAY:
    // By overriding `withdraw(double amount)` and delegating `super.withdraw(amount + transactionFee)`,
    // the parent class automatically verifies that `balance` covers BOTH the withdrawal AND the fee!
    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + this.transactionFee);
    }
}
