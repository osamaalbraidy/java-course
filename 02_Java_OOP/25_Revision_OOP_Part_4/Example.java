package _02_Java_OOP._25_Revision_OOP_Part_4;

import java.util.ArrayList;

/**
 * Lesson 25: Revision OOP (Part 4 — Capstone Project)
 * Full Multi-Class Cloud Fleet & Billing Management System using `ArrayList`
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 25 CAPSTONE: CLOUD FLEET MANAGER (OOP)    ");
        System.out.println("==================================================\n");

        CloudFleetManager fleetManager = new CloudFleetManager("Production-US-East", 1500.00);

        // 1. Provisioning resources into the `ArrayList<CloudResource>` with Exception Handling
        System.out.println("--- [1] Provisioning Cloud Resources ---");
        try {
            fleetManager.provisionResource(
                    new ComputeInstance("k8s-worker-01", ServiceTier.PRO, 16, 400.00));
            fleetManager.provisionResource(
                    new DatabaseCluster("postgres-ha-primary", ServiceTier.ENTERPRISE, 2000, 650.00));
            // This 3rd resource would push monthly cost over the $1,500 budget quota!
            fleetManager.provisionResource(
                    new ComputeInstance("gpu-training-rig", ServiceTier.ENTERPRISE, 64, 900.00));
        } catch (BudgetQuotaExceededException ex) {
            System.out.println("  [QUOTA BLOCKED] " + ex.getMessage());
        }
        System.out.println();

        // 2. Generating the Full Polymorphic Fleet & Billing Report
        System.out.println("--- [2] Fleet Inventory & Monthly Billing Report ---");
        fleetManager.printFleetReport();
    }
}

enum ServiceTier {
    STANDARD(1.0, "99.5% SLA"),
    PRO(1.25, "99.9% SLA"),
    ENTERPRISE(1.50, "99.99% SLA");

    private final double tierMultiplier;
    private final String slaGuarantee;

    ServiceTier(double tierMultiplier, String slaGuarantee) {
        this.tierMultiplier = tierMultiplier;
        this.slaGuarantee = slaGuarantee;
    }

    public double getTierMultiplier() {
        return tierMultiplier;
    }

    public String getSlaGuarantee() {
        return slaGuarantee;
    }
}

interface BillableResource {
    double calculateMonthlyCost();
}

class BudgetQuotaExceededException extends Exception {
    public BudgetQuotaExceededException(String message) {
        super(message);
    }
}

abstract class CloudResource implements BillableResource {
    private static int nextResourceId = 100;

    private final int resourceId;
    private String resourceName;
    private ServiceTier tier;
    protected double baseMonthlyRate;

    public CloudResource(String resourceName, ServiceTier tier, double baseMonthlyRate) {
        this.resourceId = ++nextResourceId;
        this.resourceName = resourceName;
        this.tier = tier;
        this.baseMonthlyRate = baseMonthlyRate;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public ServiceTier getTier() {
        return tier;
    }

    public abstract String getResourceSpecs();

    @Override
    public String toString() {
        return String.format("#%d %-20s [%-10s | %s] | %-22s | Cost: $%,8.2f/mo",
                this.resourceId,
                this.resourceName,
                this.tier.name(),
                this.tier.getSlaGuarantee(),
                getResourceSpecs(),
                calculateMonthlyCost());
    }
}

class ComputeInstance extends CloudResource {
    private int vCpuCores;

    public ComputeInstance(String resourceName, ServiceTier tier, int vCpuCores, double baseMonthlyRate) {
        super(resourceName, tier, baseMonthlyRate);
        this.vCpuCores = vCpuCores;
    }

    @Override
    public double calculateMonthlyCost() {
        return this.baseMonthlyRate * getTier().getTierMultiplier();
    }

    @Override
    public String getResourceSpecs() {
        return "Compute (" + this.vCpuCores + " vCPUs)";
    }
}

class DatabaseCluster extends CloudResource {
    private int storageGb;

    public DatabaseCluster(String resourceName, ServiceTier tier, int storageGb, double baseMonthlyRate) {
        super(resourceName, tier, baseMonthlyRate);
        this.storageGb = storageGb;
    }

    @Override
    public double calculateMonthlyCost() {
        double storageCost = this.storageGb * 0.10;
        return (this.baseMonthlyRate + storageCost) * getTier().getTierMultiplier();
    }

    @Override
    public String getResourceSpecs() {
        return "DB (" + this.storageGb + " GB SSD)";
    }
}

class CloudFleetManager {
    private String clusterName;
    private double monthlyBudgetLimit;
    private ArrayList<CloudResource> resources;

    public CloudFleetManager(String clusterName, double monthlyBudgetLimit) {
        this.clusterName = clusterName;
        this.monthlyBudgetLimit = monthlyBudgetLimit;
        this.resources = new ArrayList<>();
    }

    public void provisionResource(CloudResource candidate) throws BudgetQuotaExceededException {
        double projectedCost = calculateTotalMonthlySpend() + candidate.calculateMonthlyCost();
        if (projectedCost > this.monthlyBudgetLimit) {
            throw new BudgetQuotaExceededException(String.format(
                    "Cannot provision '%s' ($%.2f/mo): Projected total $%.2f exceeds budget $%.2f!",
                    candidate.getResourceName(),
                    candidate.calculateMonthlyCost(),
                    projectedCost,
                    this.monthlyBudgetLimit));
        }
        this.resources.add(candidate);
        System.out.println("  [Provisioned] Added " + candidate.getResourceName()
                + " (#" + candidate.getResourceId() + ")");
    }

    public double calculateTotalMonthlySpend() {
        double sum = 0.0;
        for (CloudResource res : this.resources) {
            sum += res.calculateMonthlyCost();
        }
        return sum;
    }

    public void printFleetReport() {
        System.out.println("Cluster: " + this.clusterName
                + " (Active Resources: " + this.resources.size() + ")");
        for (CloudResource res : this.resources) {
            System.out.println("  " + res);
        }
        System.out.printf("Total Monthly Spend: $%,.2f / $%,.2f Budget%n",
                calculateTotalMonthlySpend(), this.monthlyBudgetLimit);
    }
}
