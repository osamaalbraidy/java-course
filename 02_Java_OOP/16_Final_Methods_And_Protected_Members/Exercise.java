package _02_Java_OOP._16_Final_Methods_And_Protected_Members;

/**
 * Lesson 16: Final Methods and Protected Members — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: The 3 Uses of `final` Summary ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Accessing `protected` Parent Members ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Locking a Security Pipeline with `final` ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        System.out.println("1. final Variable : Value cannot be reassigned after initialization (Constant)");
        System.out.println("2. final Method   : Method cannot be overridden (@Override) by any subclass");
        System.out.println("3. final Class    : Class cannot be extended (subclassed) by any other class");
    }

    public static void solveProblem2() {
        BossMonster boss = new BossMonster("Shadow Dragon", 500);
        boss.triggerEnragePhase();
    }

    public static void solveProblem3() {
        TwoFactorAuthenticator auth = new TwoFactorAuthenticator();
        auth.login("admin", "Secret#2026");
    }
}

// -----------------------------------------------------------------
// Problem 2 Classes
// -----------------------------------------------------------------
class GameEntity {
    // WHY WE USED THIS WAY:
    // Marking these members `protected` allows subclasses (`BossMonster`) to access
    // `entityName`, `healthPoints`, and `heal()` directly without exposing them as `public`.
    protected String entityName;
    protected int healthPoints;

    public GameEntity(String entityName, int healthPoints) {
        this.entityName = entityName;
        this.healthPoints = healthPoints;
    }

    protected void heal(int amount) {
        if (amount > 0) {
            this.healthPoints += amount;
        }
    }
}

class BossMonster extends GameEntity {
    public BossMonster(String entityName, int healthPoints) {
        super(entityName, healthPoints);
    }

    public void triggerEnragePhase() {
        heal(250); // Calls `protected` parent method directly
        System.out.println("Boss [" + this.entityName
                + "] triggered Enrage Phase! Healed +250 HP -> Current HP: " + this.healthPoints);
    }
}

// -----------------------------------------------------------------
// Problem 3 Classes
// -----------------------------------------------------------------
class BaseAuthenticator {

    // WHY WE USED THIS WAY:
    // Marking `login` as `public final` locks the outer audit-logging sequence so no
    // subclass can override `login` and skip the "[Security Audit]" log lines!
    public final boolean login(String username, String password) {
        System.out.println("[Security Audit] Login attempt for user: " + username);
        boolean success = verifyCredentials(username, password);
        System.out.println("[Security Audit] Result: " + (success ? "GRANTED" : "DENIED"));
        return success;
    }

    protected boolean verifyCredentials(String username, String password) {
        return password != null && password.length() >= 8;
    }
}

class TwoFactorAuthenticator extends BaseAuthenticator {

    // Subclasses ARE allowed to override the `protected` hook method `verifyCredentials`!
    @Override
    protected boolean verifyCredentials(String username, String password) {
        boolean baseValid = super.verifyCredentials(username, password);
        System.out.println("  -> [2FA Check] Verified password + hardware token for " + username);
        return baseValid && username.equals("admin");
    }
}
