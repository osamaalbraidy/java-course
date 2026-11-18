package _02_Java_OOP._22_Revision_OOP_Part_1;

import java.util.Objects;

/**
 * Lesson 22: Revision OOP (Part 1)
 * Practice Project Part 1: Classes, Encapsulation, Chained Constructors, Static Counters & Copy Constructors
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 22: OOP REVISION PART 1 (CLASSES & ENCAP) ");
        System.out.println("==================================================\n");

        // 1. Creating objects via overloaded constructors (`this(...)` chaining)
        System.out.println("--- [1] Instantiating Patient Records (Chained Constructors) ---");
        PatientRecord p1 = new PatientRecord("Sarah Connor", 38, "O+");
        PatientRecord p2 = new PatientRecord("John Connor"); // Uses default age 18 & "UNKNOWN" blood type

        p1.updateHeartRate(72);
        p2.updateHeartRate(290); // Blocked by setter validation!
        p2.updateHeartRate(85);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println("Total Patients Registered (Static Count): "
                + PatientRecord.getTotalPatientsRegistered());
        System.out.println();

        // 2. Copy Constructor & Logical Equality (`.equals()`)
        System.out.println("--- [2] Copy Constructor & `.equals()` Verification ---");
        PatientRecord p1Backup = new PatientRecord(p1);
        System.out.println("p1 == p1Backup      (Same Heap object?) : " + (p1 == p1Backup));
        System.out.println("p1.equals(p1Backup) (Same medical data?): " + p1.equals(p1Backup));
    }
}

class PatientRecord {
    private static int nextPatientId = 5001;
    private static int totalPatientsRegistered = 0;

    private final int patientId;
    private String fullName;
    private int age;
    private String bloodType;
    private int heartRateBpm;

    // 1-Arg Constructor chains to 3-Arg Master Constructor
    public PatientRecord(String fullName) {
        this(fullName, 18, "UNKNOWN");
    }

    // 3-Arg Master Constructor
    public PatientRecord(String fullName, int age, String bloodType) {
        this.patientId = nextPatientId++;
        totalPatientsRegistered++;
        this.fullName = (fullName != null && !fullName.trim().isEmpty()) ? fullName.trim() : "Anonymous";
        this.age = (age >= 0 && age <= 130) ? age : 0;
        this.bloodType = bloodType;
        this.heartRateBpm = 70;
    }

    // Copy Constructor
    public PatientRecord(PatientRecord source) {
        this.patientId = source.patientId;
        this.fullName = source.fullName;
        this.age = source.age;
        this.bloodType = source.bloodType;
        this.heartRateBpm = source.heartRateBpm;
    }

    public void updateHeartRate(int bpm) {
        if (bpm >= 30 && bpm <= 220) {
            this.heartRateBpm = bpm;
        } else {
            System.out.println("  [Alert] Rejected invalid heart rate reading: " + bpm + " BPM");
        }
    }

    public static int getTotalPatientsRegistered() {
        return totalPatientsRegistered;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        PatientRecord other = (PatientRecord) obj;
        return this.patientId == other.patientId
                && Objects.equals(this.fullName, other.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.patientId, this.fullName);
    }

    @Override
    public String toString() {
        return String.format("Patient [#%d | Name: %-14s | Age: %2d | Blood: %-7s | HR: %3d BPM]",
                this.patientId, this.fullName, this.age, this.bloodType, this.heartRateBpm);
    }
}
