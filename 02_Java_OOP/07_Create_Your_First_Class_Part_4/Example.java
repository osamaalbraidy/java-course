package _02_Java_OOP._07_Create_Your_First_Class_Part_4;

/**
 * Lesson 07: Create Your First Class (Part 4) — UML to Java Translation
 *
 * Translates the following complete UML Class Diagram into production-grade Java:
 * +---------------------------------------------------------------+
 * |                         FlightTicket                          |
 * +---------------------------------------------------------------+
 * | - flightNumber   : String                                     |
 * | - passengerName  : String                                     |
 * | - baseFare       : double                                     |
 * | - checkedBags    : int                                        |
 * | - businessClass  : boolean                                    |
 * +---------------------------------------------------------------+
 * | + FlightTicket(flightNo: String, passenger: String,           |
 * |                baseFare: double)                              |
 * | + addCheckedBag(count: int) : void                            |
 * | + upgradeToBusinessClass() : void                             |
 * | + calculateTotalFare() : double                               |
 * | - calculateBaggageFee() : double                              |
 * | + toString() : String                                         |
 * +---------------------------------------------------------------+
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 07: UML DIAGRAMS TO FULL JAVA CLASS       ");
        System.out.println("==================================================\n");

        // 1. Instantiating our UML-designed FlightTicket class
        FlightTicket ticket1 = new FlightTicket("JL-708", "Kenji Takahashi", 450.00);
        System.out.println("--- [1] Initial Ticket State (via overridden toString()) ---");
        // WHY: Passing `ticket1` to println automatically invokes `ticket1.toString()`!
        System.out.println(ticket1);
        System.out.println();

        // 2. Executing domain behaviors defined in the UML Operations compartment
        System.out.println("--- [2] Applying Domain Operations ---");
        ticket1.addCheckedBag(2);
        ticket1.upgradeToBusinessClass();

        System.out.println("\n--- [3] Updated Ticket State ---");
        System.out.println(ticket1);
    }
}

/**
 * Complete implementation of the FlightTicket UML Class Diagram.
 */
class FlightTicket {
    // -----------------------------------------------------------------
    // COMPARTMENT 2: UML ATTRIBUTES (`-` maps to `private`)
    // -----------------------------------------------------------------
    private String flightNumber;
    private String passengerName;
    private double baseFare;
    private int checkedBags;
    private boolean businessClass;

    // -----------------------------------------------------------------
    // COMPARTMENT 3: UML OPERATIONS (`+` maps to `public`, `-` to `private`)
    // -----------------------------------------------------------------
    public FlightTicket(String flightNo, String passenger, double baseFare) {
        this.flightNumber = flightNo;
        this.passengerName = passenger;
        this.baseFare = (baseFare > 0) ? baseFare : 100.00;
        this.checkedBags = 0;
        this.businessClass = false;
    }

    public void addCheckedBag(int count) {
        if (count > 0) {
            this.checkedBags += count;
            System.out.println("  [+] Added " + count + " checked bag(s) for " + this.passengerName);
        }
    }

    public void upgradeToBusinessClass() {
        if (!this.businessClass) {
            this.businessClass = true;
            System.out.println("  [+] Upgraded " + this.passengerName + " on flight "
                    + this.flightNumber + " to Business Class!");
        }
    }

    public double calculateTotalFare() {
        double classMultiplier = this.businessClass ? 1.75 : 1.0;
        return (this.baseFare * classMultiplier) + calculateBaggageFee();
    }

    // UML `- calculateBaggageFee() : double` -> private helper method!
    private double calculateBaggageFee() {
        // First bag is $35.00; each additional bag is $45.00
        if (this.checkedBags <= 0) {
            return 0.0;
        }
        return 35.00 + (this.checkedBags - 1) * 45.00;
    }

    // Getters
    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getPassengerName() {
        return this.passengerName;
    }

    public boolean isBusinessClass() {
        return this.businessClass;
    }

    @Override
    public String toString() {
        return String.format(
                "FlightTicket [Flight: %s | Passenger: %s | Cabin: %s | Bags: %d | Total Fare: $%.2f]",
                this.flightNumber,
                this.passengerName,
                (this.businessClass ? "BUSINESS" : "ECONOMY"),
                this.checkedBags,
                calculateTotalFare());
    }
}
