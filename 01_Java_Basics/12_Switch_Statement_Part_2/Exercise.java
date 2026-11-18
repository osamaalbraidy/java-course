package _01_Java_Basics._12_Switch_Statement_Part_2;

/**
 * Lesson 12: Switch Statement (Part 2) — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Quarter of the Year Classifier (Case Grouping)
        // =================================================================
        System.out.println("=== Problem 1: Quarter of the Year Classifier ===");

        int month = 6;

        // WHY WE USED THIS WAY:
        // By intentionally stacking `case 4: case 5: case 6:` (or using Java 17 `case 4, 5, 6 ->`),
        // multiple months share a single output block without duplicating println statements.
        switch (month) {
            case 1:
            case 2:
            case 3:
                System.out.println("Month " + month + "  -> Q1 (First Quarter)");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("Month " + month + "  -> Q2 (Second Quarter)");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("Month " + month + "  -> Q3 (Third Quarter)");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("Month " + month + " -> Q4 (Fourth Quarter)");
                break;
            default:
                System.out.println("Month " + month + " -> Invalid Month");
                break;
        }

        // =================================================================
        // Problem 2 (Medium): Cloud Region Latency Lookup (`switch` on `String`)
        // =================================================================
        System.out.println("\n=== Problem 2: Cloud Region Latency Lookup ===");

        String regionCode = "  US-EAST ";

        // WHY WE USED THIS WAY:
        // `switch` on a `String` is case-sensitive. Calling `.trim().toLowerCase()` first
        // removes accidental spaces and normalizes casing so `"US-EAST"`, `"us-east"`,
        // and `"  Us-East "` all match our lowercase `case "us-east"` label!
        String normalizedRegion = regionCode.trim().toLowerCase();

        switch (normalizedRegion) {
            case "us-east":
            case "us-west":
                System.out.println("Region '" + normalizedRegion + "' -> North America Cluster (25ms)");
                break;
            case "eu-central":
            case "eu-west":
                System.out.println("Region '" + normalizedRegion + "' -> Europe Cluster (40ms)");
                break;
            case "ap-south":
            case "ap-east":
                System.out.println("Region '" + normalizedRegion + "' -> Asia-Pacific Cluster (65ms)");
                break;
            default:
                System.out.println("Region '" + normalizedRegion + "' -> Unknown Region");
                break;
        }

        // =================================================================
        // Problem 3 (Hard): Modern Java 17 `switch` Expression with `yield`
        // =================================================================
        System.out.println("\n=== Problem 3: Modern Java 17 switch Expression with yield ===");

        String gradeCode = "D";
        int extraCreditPoints = 8;

        // WHY WE USED THIS WAY:
        // A modern Java 17 `switch` expression (`->`) returns a value directly into `basePoints`
        // without needing `break;` statements. When a branch needs a `{ ... }` block (like
        // `"D", "F"`), the `yield` keyword specifies the value returned from that block.
        int basePoints = switch (gradeCode) {
            case "A"      -> 90;
            case "B"      -> 80;
            case "C"      -> 70;
            case "D", "F" -> {
                int boosted = 50 + extraCreditPoints;
                yield boosted;
            }
            default       -> 0;
        };

        System.out.println("Grade " + gradeCode + " (Extra +" + extraCreditPoints
                + ") -> Total Score: " + basePoints);
    }
}
