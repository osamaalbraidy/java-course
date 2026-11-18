package _02_Java_OOP._25_Revision_OOP_Part_4;

import java.util.ArrayList;

/**
 * Lesson 25: Revision OOP (Part 4 — Capstone Project) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Part A & B: Enrolling Students with Credit Overload Protection ===");

        UniversityStudent s1 = new UniversityStudent(1001, "Alice", AcademicLevel.UNDERGRADUATE);
        UniversityStudent s2 = new UniversityStudent(1002, "Bob", AcademicLevel.GRADUATE);

        // WHY WE USED THIS WAY:
        // Wrapping `addCredits(...)` in `try-catch (CreditOverloadException)` protects
        // students from exceeding the 18-credit cap while allowing the program to recover
        // and enroll Bob in a valid 12-credit load afterward!
        try {
            s1.addCredits(15);
            s2.addCredits(21); // Throws CreditOverloadException!
        } catch (CreditOverloadException ex) {
            System.out.println("[Blocked]  CreditOverloadException: " + ex.getMessage());
        }

        try {
            s2.addCredits(12); // Valid recovery!
        } catch (CreditOverloadException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\n=== Part C: University Registry ArrayList Tuition Report ===");
        UniversityRegistry registry = new UniversityRegistry();
        registry.registerStudent(s1);
        registry.registerStudent(s2);
        registry.printTuitionReport();
    }
}

enum AcademicLevel {
    UNDERGRADUATE(350.00),
    GRADUATE(550.00);

    private final double costPerCredit;

    AcademicLevel(double costPerCredit) {
        this.costPerCredit = costPerCredit;
    }

    public double getCostPerCredit() {
        return costPerCredit;
    }
}

interface TuitionPayer {
    int MAX_SEMESTER_CREDITS = 18;

    double calculateSemesterBill();
}

class CreditOverloadException extends Exception {
    public CreditOverloadException(String message) {
        super(message);
    }
}

abstract class UniversityMember {
    private int id;
    private String name;

    public UniversityMember(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class UniversityStudent extends UniversityMember implements TuitionPayer {
    private AcademicLevel level;
    private int enrolledCredits;

    public UniversityStudent(int id, String name, AcademicLevel level) {
        super(id, name);
        this.level = level;
        this.enrolledCredits = 0;
    }

    public void addCredits(int credits) throws CreditOverloadException {
        if (this.enrolledCredits + credits > MAX_SEMESTER_CREDITS) {
            throw new CreditOverloadException(getName() + " cannot add " + credits
                    + " credits (Max allowed: " + MAX_SEMESTER_CREDITS + ")!");
        }
        this.enrolledCredits += credits;
        System.out.println("[Enrolled] " + getName() + " (" + this.level.name()
                + ") added +" + credits + " credits.");
    }

    @Override
    public double calculateSemesterBill() {
        return this.enrolledCredits * this.level.getCostPerCredit();
    }

    @Override
    public String toString() {
        return String.format("Student #%d: %-5s | Level: %-13s | Credits: %2d | Tuition: $%,.2f",
                getId(), getName(), this.level.name(), this.enrolledCredits, calculateSemesterBill());
    }
}

class UniversityRegistry {
    private ArrayList<UniversityStudent> students = new ArrayList<>();

    public void registerStudent(UniversityStudent student) {
        if (student != null) {
            this.students.add(student);
        }
    }

    public void printTuitionReport() {
        double totalRevenue = 0.0;
        for (UniversityStudent s : this.students) {
            System.out.println("  " + s);
            totalRevenue += s.calculateSemesterBill();
        }
        System.out.printf("Total Semester Tuition Revenue: $%,.2f%n", totalRevenue);
    }
}
