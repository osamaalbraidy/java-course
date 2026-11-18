package _02_Java_OOP._04_Create_Your_First_Class_Part_1;

/**
 * Lesson 04: Create Your First Class (Part 1)
 * Demonstrates:
 * 1. Default Heap initialization values for instance fields (`null`, `0`, `0.0`, `false`)
 * 2. Instantiating objects with `new` and using the dot operator (`.`)
 * 3. Calling instance methods that compute values from the object's own fields
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 04: CREATE YOUR FIRST CLASS (PART 1)      ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. INSPECTING DEFAULT INSTANCE FIELD VALUES RIGHT AFTER `new`
        // WHY: Unlike local variables on the Stack, instance fields on the Heap
        // are automatically initialized to default values by the JVM.
        // -----------------------------------------------------------------
        System.out.println("--- [1] Default Heap Values of a Brand-New Object ---");
        GymMembership unconfiguredMember = new GymMembership();
        System.out.println("memberName (String)    : " + unconfiguredMember.memberName);     // null
        System.out.println("monthsEnrolled (int)   : " + unconfiguredMember.monthsEnrolled); // 0
        System.out.println("monthlyFee (double)    : " + unconfiguredMember.monthlyFee);     // 0.0
        System.out.println("isVipAccess (boolean)  : " + unconfiguredMember.isVipAccess);    // false
        System.out.println();

        // -----------------------------------------------------------------
        // 2. POPULATING STATE & INVOKING INSTANCE METHODS WITH `.`
        // -----------------------------------------------------------------
        System.out.println("--- [2] Populating Object State & Calling Methods ---");
        GymMembership member1 = new GymMembership();
        member1.memberName = "Sophia Martinez";
        member1.monthsEnrolled = 14;
        member1.monthlyFee = 45.00;
        member1.isVipAccess = false;

        member1.printMemberCard();
        member1.upgradeToVip();
        member1.extendMembership(6);
        member1.printMemberCard();
        System.out.printf("Total Lifetime Value   : $%.2f%n", member1.calculateTotalSpent());
    }
}

/**
 * First custom class blueprint demonstrating instance fields and instance methods.
 */
class GymMembership {
    // 1. Instance Fields (Automatically receive default values when `new GymMembership()` runs)
    String memberName;
    int monthsEnrolled;
    double monthlyFee;
    boolean isVipAccess;

    // 2. Instance Methods (Operate directly on this instance's fields)
    void upgradeToVip() {
        if (!isVipAccess) {
            isVipAccess = true;
            monthlyFee += 15.00; // VIP adds $15/month
            System.out.println("  -> Upgraded " + memberName + " to VIP Access!");
        }
    }

    void extendMembership(int additionalMonths) {
        monthsEnrolled += additionalMonths;
        System.out.println("  -> Extended membership by " + additionalMonths
                + " months (Total: " + monthsEnrolled + " months).");
    }

    double calculateTotalSpent() {
        return monthsEnrolled * monthlyFee;
    }

    void printMemberCard() {
        System.out.printf("  [Member Card] Name: %-16s | Months: %2d | Fee: $%.2f/mo | VIP: %b%n",
                memberName, monthsEnrolled, monthlyFee, isVipAccess);
    }
}
