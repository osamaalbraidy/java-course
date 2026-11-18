package _02_Java_OOP._02_What_Is_OOP_Part_2;

/**
 * Lesson 02: What Is OOP? (Part 2) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Access Modifier Visibility Table ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Encapsulating UserCredentials ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Encapsulated InventoryItem Stock Guard ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        System.out.println("1. private                   : Visible ONLY within the declaring class");
        System.out.println("2. default (package-private) : Visible within the same package folder");
        System.out.println("3. protected                 : Visible within the same package + subclasses anywhere");
        System.out.println("4. public                    : Visible everywhere across all packages");
    }

    public static void solveProblem2() {
        UserCredentials user = new UserCredentials("admin_user", "InitialPass123");

        System.out.print("Update with wrong old pass : ");
        user.updatePassword("WrongOldPass", "NewSecret999");

        System.out.print("Update with short new pass : ");
        user.updatePassword("InitialPass123", "short");

        System.out.print("Update with valid new pass : ");
        user.updatePassword("InitialPass123", "NewSecret999");

        System.out.println("Login with new password    : " + user.authenticate("NewSecret999"));
    }

    public static void solveProblem3() {
        InventoryItem item = new InventoryItem("SKU-900");
        item.restock(50);
        item.fulfillOrder(35);
        item.fulfillOrder(20);
    }
}

class UserCredentials {
    private String username;
    private String password;

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String attempt) {
        return password.equals(attempt);
    }

    // WHY WE USED THIS WAY:
    // Because `password` is `private`, external callers MUST go through `updatePassword()`,
    // which verifies the old password AND checks strength via the `private` helper `isStrongEnough()`.
    public void updatePassword(String currentPass, String newPass) {
        if (!authenticate(currentPass)) {
            System.out.println("Password update failed: Incorrect current password!");
        } else if (!isStrongEnough(newPass)) {
            System.out.println("Password update failed: New password must be >= 8 chars!");
        } else {
            password = newPass;
            System.out.println("Password updated successfully for " + username);
        }
    }

    // Marked `private` because external classes don't need to call this internal helper directly!
    private boolean isStrongEnough(String candidate) {
        return candidate != null && candidate.length() >= 8;
    }
}

class InventoryItem {
    private String sku;
    private int quantityInStock;

    public InventoryItem(String sku) {
        this.sku = sku;
        this.quantityInStock = 0;
    }

    public void restock(int units) {
        if (units > 0) {
            quantityInStock += units;
            System.out.println("Restocked +" + units + " units of " + sku
                    + " (Stock: " + quantityInStock + ")");
        }
    }

    // WHY WE USED THIS WAY:
    // Encapsulating `quantityInStock` as `private` and checking `requestedUnits <= quantityInStock`
    // inside `fulfillOrder` guarantees warehouse stock can never go negative!
    public boolean fulfillOrder(int requestedUnits) {
        if (requestedUnits > 0 && requestedUnits <= quantityInStock) {
            quantityInStock -= requestedUnits;
            System.out.println("Fulfilled " + requestedUnits + " units of " + sku
                    + " (Remaining: " + quantityInStock + ")");
            return true;
        } else {
            System.out.println("Order rejected for " + requestedUnits + " units of " + sku
                    + " (Only " + quantityInStock + " in stock)");
            return false;
        }
    }
}
