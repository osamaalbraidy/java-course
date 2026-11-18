package _02_Java_OOP._21_ArrayList_Class;

import java.util.ArrayList;

/**
 * Lesson 21: ArrayList Class
 * Demonstrates:
 * 1. Creating an `ArrayList<String>` and performing CRUD (`add`, `get`, `set`, `remove`, `size`)
 * 2. Wrapper classes (`ArrayList<Integer>`, `ArrayList<Double>`) with Autoboxing & Unboxing
 * 3. Avoiding the `ArrayList<Integer>.remove(int index)` vs `remove(Integer.valueOf(val))` trap
 * 4. Storing custom OOP Objects inside an `ArrayList<ServerNode>`
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 21: ARRAYLIST & WRAPPER CLASSES         ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. DYNAMIC `ArrayList<String>` CRUD OPERATIONS
        // WHY: Unlike `String[]`, an `ArrayList<String>` starts at size 0 and
        // grows/shrinks dynamically as elements are added and removed!
        // -----------------------------------------------------------------
        System.out.println("--- [1] ArrayList<String> Dynamic CRUD Operations ---");
        ArrayList<String> deployQueue = new ArrayList<>();

        deployQueue.add("auth-service");       // Index 0
        deployQueue.add("payment-service");    // Index 1
        deployQueue.add("notification-worker");// Index 2
        deployQueue.add(0, "api-gateway");     // Inserts at Index 0, shifting others right!

        System.out.println("After 4 adds (size=" + deployQueue.size() + ") : " + deployQueue);
        System.out.println("Element at index 1 (.get)  : " + deployQueue.get(1));

        // Update element at index 2 with `.set(index, newValue)`
        deployQueue.set(2, "payment-service-v2");
        // Remove by value or index with `.remove(...)`
        deployQueue.remove("notification-worker");

        System.out.println("After .set() & .remove()   : " + deployQueue);
        System.out.println();

        // -----------------------------------------------------------------
        // 2. WRAPPER CLASSES (`ArrayList<Integer>`) & AUTOBOXING / UNBOXING
        // WHY: Generics only accept reference types, so we use `Integer` instead of `int`.
        // -----------------------------------------------------------------
        System.out.println("--- [2] ArrayList<Integer>, Autoboxing & The remove() Trap ---");
        ArrayList<Integer> latenciesMs = new ArrayList<>();

        // AUTOBOXING: `int` literals (45, 120, 85) are automatically boxed into `Integer` objects!
        latenciesMs.add(45);
        latenciesMs.add(120);
        latenciesMs.add(85);
        System.out.println("Initial Latencies          : " + latenciesMs);

        // THE `remove` TRAP ON ArrayList<Integer>:
        // `latenciesMs.remove(120)` would try to remove INDEX 120 and crash!
        // To remove the VALUE 120, pass `Integer.valueOf(120)`:
        latenciesMs.remove(Integer.valueOf(120));
        System.out.println("After removing value 120   : " + latenciesMs);

        // UNBOXING: Each `Integer` is automatically unboxed to primitive `int` in the loop!
        int totalLatency = 0;
        for (int ms : latenciesMs) {
            totalLatency += ms;
        }
        System.out.println("Sum of remaining latencies : " + totalLatency + "ms\n");

        // -----------------------------------------------------------------
        // 3. STORING CUSTOM OOP OBJECTS IN AN `ArrayList<CloudInstance>`
        // -----------------------------------------------------------------
        System.out.println("--- [3] ArrayList of Custom OOP Objects ---");
        ArrayList<CloudInstance> fleet = new ArrayList<>();
        fleet.add(new CloudInstance("i-001", "us-east-1", 16));
        fleet.add(new CloudInstance("i-002", "eu-central-1", 32));
        fleet.add(new CloudInstance("i-003", "ap-northeast-1", 64));

        for (CloudInstance node : fleet) {
            System.out.println("  " + node);
        }
    }
}

class CloudInstance {
    private String instanceId;
    private String region;
    private int ramGb;

    public CloudInstance(String instanceId, String region, int ramGb) {
        this.instanceId = instanceId;
        this.region = region;
        this.ramGb = ramGb;
    }

    @Override
    public String toString() {
        return String.format("CloudInstance [ID: %s | Region: %-14s | RAM: %dGB]",
                this.instanceId, this.region, this.ramGb);
    }
}
