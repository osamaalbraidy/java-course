package _02_Java_OOP._12_Comparing_And_Copying_Objects;

import java.util.Arrays;
import java.util.Objects;

/**
 * Lesson 12: Comparing and Copying Objects
 * Demonstrates:
 * 1. `==` (Memory Address Identity) vs. overridden `.equals()` (Logical State Equality)
 * 2. Reference Aliasing (`b2 = b1`) vs. True Copy Constructor (`new Blueprint(b1)`)
 * 3. Shallow Copy vs. Deep Copy when an object contains a mutable array field
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 12: COMPARING AND COPYING OBJECTS       ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. COMPARING OBJECTS: `==` VS. OVERRIDDEN `.equals()`
        // -----------------------------------------------------------------
        System.out.println("--- [1] Comparing Objects: `==` vs. `.equals()` ---");
        SecurityKey key1 = new SecurityKey("KEY-7788", 256);
        SecurityKey key2 = new SecurityKey("KEY-7788", 256); // Distinct Heap object, identical state!

        System.out.println("key1 == key2      (Same Heap address?) : " + (key1 == key2));      // false!
        System.out.println("key1.equals(key2) (Same field values?) : " + key1.equals(key2));   // true!
        System.out.println();

        // -----------------------------------------------------------------
        // 2. REFERENCE ALIASING (`=`) VS. COPY CONSTRUCTOR
        // WHY: `aliasKey = key1` points both variables at the SAME Heap object!
        // `new SecurityKey(key1)` creates an independent clone on the Heap.
        // -----------------------------------------------------------------
        System.out.println("--- [2] Reference Aliasing (`=`) vs. Copy Constructor ---");
        SecurityKey aliasKey = key1;                // Alias: points to key1's Heap address!
        SecurityKey clonedKey = new SecurityKey(key1); // Copy Constructor: brand-new Heap object!

        System.out.println("key1 == aliasKey  (Alias shares address) : " + (key1 == aliasKey));
        System.out.println("key1 == clonedKey (Clone has new address): " + (key1 == clonedKey));
        System.out.println("key1.equals(clonedKey)                   : " + key1.equals(clonedKey));
        System.out.println();

        // -----------------------------------------------------------------
        // 3. SHALLOW COPY VS. DEEP COPY (Objects with Mutable Array Fields)
        // WHY: A shallow copy copies the array's memory address, so mutating
        // the clone's array accidentally mutates the original's array too!
        // A deep copy duplicates the array (`Arrays.copyOf`) for 100% isolation.
        // -----------------------------------------------------------------
        System.out.println("--- [3] Shallow Copy vs. Deep Copy ---");
        int[] initialTemps = {20, 22, 24};
        ServerRack originalRack = new ServerRack("RACK-A", initialTemps);

        // Create a DEEP copy using the Copy Constructor:
        ServerRack deepClonedRack = new ServerRack(originalRack);

        // Mutate index 0 inside the deep clone:
        deepClonedRack.setSensorReading(0, 99);

        System.out.println("Original Rack (Protected by Deep Copy) : " + originalRack);
        System.out.println("Deep Cloned Rack (Modified index 0->99): " + deepClonedRack);
    }
}

/**
 * Demonstrates overriding `equals()`, `hashCode()`, and providing a Copy Constructor.
 */
class SecurityKey {
    private String keyId;
    private int bitStrength;

    public SecurityKey(String keyId, int bitStrength) {
        this.keyId = keyId;
        this.bitStrength = bitStrength;
    }

    // COPY CONSTRUCTOR: Initializes a brand-new SecurityKey from an existing SecurityKey
    public SecurityKey(SecurityKey source) {
        this.keyId = source.keyId;
        this.bitStrength = source.bitStrength;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. Reflexive check: are both references pointing to the exact same Heap address?
        if (this == obj) {
            return true;
        }
        // 2. Null check and exact runtime class check
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        // 3. Cast and compare logical fields
        SecurityKey other = (SecurityKey) obj;
        return this.bitStrength == other.bitStrength
                && Objects.equals(this.keyId, other.keyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.keyId, this.bitStrength);
    }
}

/**
 * Demonstrates DEEP COPYING a mutable array field inside the constructor and copy constructor.
 */
class ServerRack {
    private String rackName;
    private int[] sensorReadings;

    public ServerRack(String rackName, int[] readings) {
        this.rackName = rackName;
        // Defensive Deep Copy of the array!
        this.sensorReadings = Arrays.copyOf(readings, readings.length);
    }

    // DEEP COPY CONSTRUCTOR: Allocates a brand-new `int[]` so original and copy never share array memory!
    public ServerRack(ServerRack source) {
        this.rackName = source.rackName + "_CLONE";
        this.sensorReadings = Arrays.copyOf(source.sensorReadings, source.sensorReadings.length);
    }

    public void setSensorReading(int index, int newTemp) {
        if (index >= 0 && index < this.sensorReadings.length) {
            this.sensorReadings[index] = newTemp;
        }
    }

    @Override
    public String toString() {
        return String.format("%s -> Sensors: %s",
                this.rackName, Arrays.toString(this.sensorReadings));
    }
}
