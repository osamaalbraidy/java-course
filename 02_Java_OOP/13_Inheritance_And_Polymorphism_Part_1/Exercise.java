package _02_Java_OOP._13_Inheritance_And_Polymorphism_Part_1;

/**
 * Lesson 13: Inheritance and Polymorphism (Part 1) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Vehicle and ElectricCar Inheritance ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: BankAccount and SavingsAccount ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: 3-Level Multilevel Inheritance ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // `ElectricCar` extends `Vehicle`, so it inherits `getBrand()` and `printVehicleInfo()`
        // without rewriting them, while adding its own `batteryCapacityKwh` field and method!
        ElectricCar ev = new ElectricCar("Rivian R1T", 200, 135);
        ev.printVehicleInfo();
        ev.printBatterySpecs();
    }

    public static void solveProblem2() {
        SavingsAccount savings = new SavingsAccount("Liam", 1000.00, 0.05);
        System.out.printf("Initial Savings Balance         : $%.2f%n", savings.getBalance());

        // WHY WE USED THIS WAY:
        // Inside `SavingsAccount.applyAnnualInterest()`, we reuse `getBalance()` and
        // `super.deposit(interest)` inherited from `BankAccount` rather than duplicating balance logic.
        savings.applyAnnualInterest();
        System.out.printf("Balance After Interest Applied  : $%.2f%n", savings.getBalance());
    }

    public static void solveProblem3() {
        // WHY WE USED THIS WAY:
        // Multilevel inheritance (`ElectronicDevice -> Computer -> GamingLaptop`) lets each layer
        // initialize its own state via `super(...)` while accumulating all parent capabilities!
        GamingLaptop rog = new GamingLaptop("ASUS ROG", 32, "RTX 4090");
        rog.printFullSpecs();
    }
}

// -----------------------------------------------------------------
// Problem 1 Classes
// -----------------------------------------------------------------
class Vehicle {
    private String brand;
    private int maxSpeedKmH;

    public Vehicle(String brand, int maxSpeedKmH) {
        this.brand = brand;
        this.maxSpeedKmH = maxSpeedKmH;
    }

    public String getBrand() {
        return brand;
    }

    public void printVehicleInfo() {
        System.out.println("Vehicle [Brand: " + this.brand + " | Max Speed: " + this.maxSpeedKmH + " km/h]");
    }
}

class ElectricCar extends Vehicle {
    private int batteryCapacityKwh;

    public ElectricCar(String brand, int maxSpeedKmH, int batteryCapacityKwh) {
        super(brand, maxSpeedKmH); // Initializes the parent `Vehicle` portion first!
        this.batteryCapacityKwh = batteryCapacityKwh;
    }

    public void printBatterySpecs() {
        System.out.println("EV Specs [Brand: " + getBrand() + " | Battery: " + this.batteryCapacityKwh + " kWh]");
    }
}

// -----------------------------------------------------------------
// Problem 2 Classes
// -----------------------------------------------------------------
class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String owner, double balance, double interestRate) {
        super(owner, balance);
        this.interestRate = interestRate;
    }

    public void applyAnnualInterest() {
        double interest = getBalance() * this.interestRate;
        System.out.printf("Interest Earned (%.1f%%)          : $%.2f%n",
                this.interestRate * 100, interest);
        super.deposit(interest);
    }
}

// -----------------------------------------------------------------
// Problem 3 Classes (3-Level Hierarchy)
// -----------------------------------------------------------------
class ElectronicDevice {
    private String manufacturer;

    public ElectronicDevice(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}

class Computer extends ElectronicDevice {
    private int ramGb;

    public Computer(String manufacturer, int ramGb) {
        super(manufacturer);
        this.ramGb = ramGb;
    }

    public int getRamGb() {
        return ramGb;
    }
}

class GamingLaptop extends Computer {
    private String gpuModel;

    public GamingLaptop(String manufacturer, int ramGb, String gpuModel) {
        super(manufacturer, ramGb);
        this.gpuModel = gpuModel;
    }

    public void printFullSpecs() {
        System.out.println("GamingLaptop [Maker: " + getManufacturer()
                + " | RAM: " + getRamGb() + "GB | GPU: " + this.gpuModel + "]");
    }
}
