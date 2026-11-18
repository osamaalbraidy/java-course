package _02_Java_OOP._01_What_Is_OOP_Part_1;

/**
 * Lesson 01: What Is OOP? (Part 1) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Class vs. Object Classifier ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Instantiating Two SmartLightBulb Objects ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: GameCharacter State & Behavior ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // A Class (`Car`, `java.lang.String`) is the abstract blueprint/type definition,
        // whereas an Object is a concrete instance allocated in memory with specific state.
        System.out.println("1. Car                                     -> CLASS (Blueprint)");
        System.out.println("2. Red 2026 Porsche 911 (VIN #WP0AB2)      -> OBJECT (Instance)");
        System.out.println("3. java.lang.String                        -> CLASS (Blueprint)");
        System.out.println("4. \"Hello World\"                           -> OBJECT (Instance)");
    }

    public static void solveProblem2() {
        // WHY WE USED THIS WAY:
        // Each `new SmartLightBulb()` call allocates a separate object on the Heap.
        // Calling `livingRoomBulb.turnOn()` mutates ONLY `livingRoomBulb.isOn`, leaving
        // `kitchenBulb.isOn` as `false`!
        SmartLightBulb livingRoomBulb = new SmartLightBulb();
        livingRoomBulb.roomName = "Living Room";
        livingRoomBulb.brightness = 80;
        livingRoomBulb.isOn = false;

        SmartLightBulb kitchenBulb = new SmartLightBulb();
        kitchenBulb.roomName = "Kitchen";
        kitchenBulb.brightness = 100;
        kitchenBulb.isOn = false;

        livingRoomBulb.turnOn();

        livingRoomBulb.printStatus();
        kitchenBulb.printStatus();
    }

    public static void solveProblem3() {
        GameCharacter merlin = new GameCharacter();
        merlin.name = "Merlin";
        merlin.health = 100;
        merlin.mana = 50;

        merlin.takeDamage(30);
        merlin.castSpell("Fireball", 35); // Succeeds: 50 - 35 = 15 mana left
        merlin.castSpell("Meteor", 35);   // Fails: only 15 mana left!

        System.out.println(merlin.name + " Status -> Health: " + merlin.health
                + " | Mana: " + merlin.mana);
    }
}

class SmartLightBulb {
    String roomName;
    int brightness;
    boolean isOn;

    void turnOn() {
        isOn = true;
    }

    void turnOff() {
        isOn = false;
    }

    void printStatus() {
        System.out.printf("[%-11s] Light is %-3s (Brightness: %d%%)%n",
                roomName, (isOn ? "ON" : "OFF"), brightness);
    }
}

class GameCharacter {
    String name;
    int health;
    int mana;

    // WHY WE USED THIS WAY:
    // Instance methods (`takeDamage` and `castSpell`) read and update this character's
    // own `health` and `mana` fields directly on the Heap.
    void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    void castSpell(String spellName, int manaCost) {
        if (mana >= manaCost) {
            mana -= manaCost;
            System.out.println(name + " casts " + spellName + "! (Mana left: " + mana + ")");
        } else {
            System.out.println(name + " has insufficient mana for " + spellName + "!");
        }
    }
}
