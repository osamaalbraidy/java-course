package _02_Java_OOP._08_Constructors_And_Overloading_Part_1;

/**
 * Lesson 08: Constructors and Overloading (Part 1) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Fixing the 'void Constructor' Bug ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Restoring the No-Arg Constructor ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Constructor Validation Guards ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        PodcastEpisode ep = new PodcastEpisode("Java Deep Dive", 45);
        ep.printEpisode();
    }

    public static void solveProblem2() {
        ServerInstance defaultServer = new ServerInstance();
        ServerInstance customServer = new ServerInstance("eu-west-1", 16);

        defaultServer.printServer();
        customServer.printServer();
    }

    public static void solveProblem3() {
        BankVaultAccount validAcc = new BankVaultAccount("  Clara Oswald  ", 500.00);
        validAcc.printAccount();

        BankVaultAccount guardedAcc = new BankVaultAccount("", 10.00);
        guardedAcc.printAccount();
    }
}

class PodcastEpisode {
    private String title;
    private int durationMinutes;

    // WHY WE USED THIS WAY:
    // Removed the `void` keyword! In Java, constructors MUST NOT have a return type.
    // With `void` removed, `new PodcastEpisode("Java Deep Dive", 45)` properly invokes
    // this constructor and initializes `title` and `durationMinutes`.
    public PodcastEpisode(String title, int durationMinutes) {
        this.title = title;
        this.durationMinutes = durationMinutes;
    }

    public void printEpisode() {
        System.out.println("Podcast: \"" + this.title + "\" (" + this.durationMinutes + " mins)");
    }
}

class ServerInstance {
    private String region;
    private int vCpuCount;

    // WHY WE USED THIS WAY:
    // Because `ServerInstance` defines a 2-argument constructor below, the compiler no
    // longer generates a default no-arg constructor automatically. Writing `public ServerInstance()`
    // explicitly allows callers to use both `new ServerInstance()` and `new ServerInstance(region, cpus)`!
    public ServerInstance() {
        this.region = "us-east-1";
        this.vCpuCount = 2;
    }

    public ServerInstance(String region, int vCpuCount) {
        this.region = region;
        this.vCpuCount = vCpuCount;
    }

    public void printServer() {
        System.out.println("Server [Region: " + this.region + " | vCPUs: " + this.vCpuCount + "]");
    }
}

class BankVaultAccount {
    private String ownerName;
    private double balance;

    // WHY WE USED THIS WAY:
    // Enforcing validation directly inside the constructor guarantees that an invalid
    // `BankVaultAccount` (blank owner or < $50 balance) can NEVER be created in memory!
    public BankVaultAccount(String ownerName, double initialDeposit) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            this.ownerName = "Unknown Owner";
        } else {
            this.ownerName = ownerName.trim();
        }

        if (initialDeposit < 50.00) {
            System.out.println("Warning: Minimum opening deposit is $50.00. Setting initial balance to $50.00.");
            this.balance = 50.00;
        } else {
            this.balance = initialDeposit;
        }
    }

    public void printAccount() {
        System.out.printf("Account [Owner: %s | Balance: $%.2f]%n", this.ownerName, this.balance);
    }
}
