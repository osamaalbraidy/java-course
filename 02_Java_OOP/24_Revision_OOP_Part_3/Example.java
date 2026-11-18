package _02_Java_OOP._24_Revision_OOP_Part_3;

/**
 * Lesson 24: Revision OOP (Part 3)
 * Practice Project Part 3: Interfaces, Enums & Custom Checked Exception Handling
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 24: OOP REVISION PART 3 (INTF/ENUM/EXCEP) ");
        System.out.println("==================================================\n");

        PharmacyOrder order1 = new PharmacyOrder(
                "RX-701", "Amoxicillin 500mg", 14, TriageSeverity.NON_URGENT, false);
        PharmacyOrder order2 = new PharmacyOrder(
                "RX-702", "Morphine Sulfate", 60, TriageSeverity.IMMEDIATE_RESUSCITATION, true);

        PharmacyOrder[] orders = {order1, order2};

        for (PharmacyOrder order : orders) {
            System.out.println("Processing " + order.getRxCode()
                    + " [Triage: " + order.getSeverity().name()
                    + " | Max Wait: " + order.getSeverity().getMaxWaitMinutes() + "m]");
            try {
                order.dispenseMedication("DR-LICENSE-9981");
            } catch (ControlledSubstanceLimitException ex) {
                System.out.println("  [PHARMACY BLOCKED] " + ex.getMessage());
            } finally {
                order.recordAuditLog();
                System.out.println();
            }
        }
    }
}

enum TriageSeverity {
    NON_URGENT(120),
    URGENT(30),
    EMERGENCY(10),
    IMMEDIATE_RESUSCITATION(0);

    private final int maxWaitMinutes;

    TriageSeverity(int maxWaitMinutes) {
        this.maxWaitMinutes = maxWaitMinutes;
    }

    public int getMaxWaitMinutes() {
        return maxWaitMinutes;
    }
}

interface Dispenseable {
    int MAX_CONTROLLED_UNITS = 30;

    void dispenseMedication(String doctorLicense) throws ControlledSubstanceLimitException;
}

interface ComplianceAuditable {
    String getRxCode();

    default void recordAuditLog() {
        System.out.println("  [HIPAA Audit] Logged compliance event for prescription " + getRxCode() + ".");
    }
}

class ControlledSubstanceLimitException extends Exception {
    public ControlledSubstanceLimitException(String message) {
        super(message);
    }
}

class PharmacyOrder implements Dispenseable, ComplianceAuditable {
    private String rxCode;
    private String medicationName;
    private int unitsRequested;
    private TriageSeverity severity;
    private boolean controlledSubstance;

    public PharmacyOrder(String rxCode, String medicationName, int unitsRequested,
                         TriageSeverity severity, boolean controlledSubstance) {
        this.rxCode = rxCode;
        this.medicationName = medicationName;
        this.unitsRequested = unitsRequested;
        this.severity = severity;
        this.controlledSubstance = controlledSubstance;
    }

    @Override
    public String getRxCode() {
        return this.rxCode;
    }

    public TriageSeverity getSeverity() {
        return this.severity;
    }

    @Override
    public void dispenseMedication(String doctorLicense) throws ControlledSubstanceLimitException {
        if (this.controlledSubstance && this.unitsRequested > MAX_CONTROLLED_UNITS) {
            throw new ControlledSubstanceLimitException(
                    "Order " + this.rxCode + " (" + this.medicationName + ") requested "
                    + this.unitsRequested + " units, exceeding legal limit of " + MAX_CONTROLLED_UNITS + "!");
        }
        System.out.println("  [DISPENSED] " + this.unitsRequested + " units of "
                + this.medicationName + " (Authorized by " + doctorLicense + ")");
    }
}
