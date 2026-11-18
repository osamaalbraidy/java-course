package _02_Java_OOP._19_Enumerated_Types_Enum;

/**
 * Lesson 19: Enumerated Types (Enum)
 * Demonstrates:
 * 1. Basic `enum` declaration and built-in methods (`values()`, `ordinal()`, `valueOf()`)
 * 2. Exhaustive Java 17 `switch` expressions on an `enum` (no `default` branch needed!)
 * 3. Rich `enum` with `private final` fields, a `private` constructor, and custom methods
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 19: ENUMERATED TYPES (ENUM)             ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. ITERATING OVER `values()` & INSPECTING `name()` / `ordinal()`
        // -----------------------------------------------------------------
        System.out.println("--- [1] Built-In Enum Methods (values, name, ordinal) ---");
        for (DeploymentStage stage : DeploymentStage.values()) {
            System.out.println("  Ordinal [" + stage.ordinal() + "] -> Constant Name: " + stage.name());
        }

        DeploymentStage parsedStage = DeploymentStage.valueOf("STAGING");
        System.out.println("Parsed via valueOf(\"STAGING\") == DeploymentStage.STAGING : "
                + (parsedStage == DeploymentStage.STAGING));
        System.out.println();

        // -----------------------------------------------------------------
        // 2. EXHAUSTIVE JAVA 17 `switch` EXPRESSION ON AN ENUM
        // WHY: Because the compiler knows `DeploymentStage` has ONLY 4 possible
        // constants, a `switch` expression covering all 4 does not even need `default`!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Exhaustive Switch Expression on Enum ---");
        DeploymentStage currentStage = DeploymentStage.PRODUCTION;

        String clusterUrl = switch (currentStage) {
            case LOCAL_DEV  -> "http://localhost:8080";
            case QA_TEST    -> "https://qa.internal.app";
            case STAGING    -> "https://staging.internal.app";
            case PRODUCTION -> "https://api.company.com (HA Cluster)";
        };
        System.out.println("Active Stage: " + currentStage + " -> Target URL: " + clusterUrl);
        System.out.println();

        // -----------------------------------------------------------------
        // 3. RICH ENUM WITH FIELDS, CONSTRUCTOR & METHODS (`SubscriptionTier`)
        // -----------------------------------------------------------------
        System.out.println("--- [3] Rich Enum with Fields, Constructor & Methods ---");
        for (SubscriptionTier tier : SubscriptionTier.values()) {
            System.out.printf("  Tier: %-10s | Monthly: $%6.2f | Annual (15%% off): $%7.2f | Max Storage: %4d GB%n",
                    tier.name(),
                    tier.getMonthlyPrice(),
                    tier.calculateAnnualPrice(),
                    tier.getStorageLimitGb());
        }
    }
}

/**
 * Simple Enum representing the 4 environments in a software release pipeline.
 */
enum DeploymentStage {
    LOCAL_DEV,
    QA_TEST,
    STAGING,
    PRODUCTION
}

/**
 * Rich Enum: Each enum constant invokes the `private` constructor with its own
 * monthly price and storage limit, and shares custom business methods!
 */
enum SubscriptionTier {
    FREE(0.00, 5),
    STARTER(12.00, 100),
    PRO(29.00, 1000),
    ENTERPRISE(99.00, 10000); // Semicolon required before fields/constructors!

    private final double monthlyPrice;
    private final int storageLimitGb;

    // Enum constructors are implicitly `private`!
    SubscriptionTier(double monthlyPrice, int storageLimitGb) {
        this.monthlyPrice = monthlyPrice;
        this.storageLimitGb = storageLimitGb;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public int getStorageLimitGb() {
        return storageLimitGb;
    }

    public double calculateAnnualPrice() {
        // Annual billing gives a 15% discount on 12 months
        return (this.monthlyPrice * 12.0) * 0.85;
    }
}
