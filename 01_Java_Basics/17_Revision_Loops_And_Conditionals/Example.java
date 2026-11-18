package _01_Java_Basics._17_Revision_Loops_And_Conditionals;

import java.util.Scanner;

/**
 * Lesson 17: Revision — Loops and Conditionals (Mini-Project)
 *
 * Mini-Project: Smart Warehouse Order & Analytics Engine
 * Combines:
 * - `do-while` menu loop + `switch` dispatcher with `new Scanner(System.in)`
 * - Sentinel-controlled `while` loop + `continue` filter
 * - `if / else if / else` tier classification + Min/Max/Sum accumulators
 * - Nested `for` loop ASCII histogram generator
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 17 MINI-PROJECT: ORDER ANALYTICS ENGINE   ");
        System.out.println("==================================================\n");

        Scanner input = new Scanner(System.in);

        int validItemCount = 0;
        double totalRevenue = 0.0;
        double minPrice = Double.MAX_VALUE;
        double maxPrice = 0.0;

        int budgetTierCount = 0;   // < $25
        int standardTierCount = 0; // $25 .. $99.99
        int premiumTierCount = 0;  // >= $100

        int menuChoice;

        // 1. OUTER `do-while` MENU LOOP
        do {
            System.out.println("[MENU] 1: Ingest Price Batch | 2: Print Tier Histogram | 0: Exit");
            System.out.print("Select menu command: ");
            menuChoice = input.nextInt();

            // 2. SWITCH STATEMENT DISPATCHER
            switch (menuChoice) {
                case 1 -> {
                    System.out.println("  -> Starting batch ingestion (Enter -1.0 to stop)...");
                    boolean batchDone = false;

                    // 3. SENTINEL + FLAG `while` LOOP
                    while (!batchDone) {
                        System.out.print("  Enter item price (-1.0 to finish): ");
                        double price = input.nextDouble();

                        if (price == -1.0) {
                            batchDone = true;
                            System.out.println("  -> [Sentinel -1] Batch ingestion complete.");
                            continue;
                        }

                        // 4. `continue` TO SKIP INVALID NEGATIVE PRICES
                        if (price <= 0.0) {
                            System.out.printf("  -> [Skipped] Invalid price entry: $%.2f%n", price);
                            continue;
                        }

                        // Update accumulators
                        validItemCount++;
                        totalRevenue += price;
                        if (price < minPrice) {
                            minPrice = price;
                        }
                        if (price > maxPrice) {
                            maxPrice = price;
                        }

                        // 5. `if-else if-else` TIER CLASSIFICATION
                        String tierName;
                        if (price >= 100.0) {
                            premiumTierCount++;
                            tierName = "PREMIUM";
                        } else if (price >= 25.0) {
                            standardTierCount++;
                            tierName = "STANDARD";
                        } else {
                            budgetTierCount++;
                            tierName = "BUDGET";
                        }

                        System.out.printf("  -> Recorded Item #%d: $%6.2f [%s]%n",
                                validItemCount, price, tierName);
                    }

                    if (validItemCount > 0) {
                        double avgPrice = totalRevenue / validItemCount;
                        System.out.printf("  [Stats] Items: %d | Revenue: $%.2f | Avg: $%.2f | Min: $%.2f | Max: $%.2f%n%n",
                                validItemCount, totalRevenue, avgPrice, minPrice, maxPrice);
                    }
                }
                case 2 -> {
                    // 6. `for` LOOPS FOR ASCII HISTOGRAM
                    System.out.println("  -> Rendering Tier Distribution Histogram:");
                    for (int tier = 1; tier <= 3; tier++) {
                        String label = switch (tier) {
                            case 1 -> "Budget   (<$25)  ";
                            case 2 -> "Standard ($25-99)";
                            default -> "Premium  ($100+) ";
                        };
                        int count = switch (tier) {
                            case 1 -> budgetTierCount;
                            case 2 -> standardTierCount;
                            default -> premiumTierCount;
                        };

                        System.out.print("     " + label + " | ");
                        for (int bar = 1; bar <= count; bar++) {
                            System.out.print("#");
                        }
                        System.out.println(" (" + count + ")");
                    }
                    System.out.println();
                }
                case 0 -> System.out.println("  -> Shutting down Analytics Engine. Goodbye!");
                default -> System.out.println("  -> Unknown menu command.\n");
            }
        } while (menuChoice != 0);

        input.close();
    }
}
