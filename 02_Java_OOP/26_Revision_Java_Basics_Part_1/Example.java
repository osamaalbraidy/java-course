package _02_Java_OOP._26_Revision_Java_Basics_Part_1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Lesson 26: Cumulative Review — Java Basics + Java OOP
 * Demonstrates how Module 1 fundamentals (primitives, loops, 2D arrays, methods)
 * and Module 2 OOP architecture (encapsulation, inheritance, interfaces, enums,
 * exceptions, ArrayList) work together in a single analytical program.
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 26: CUMULATIVE REVIEW (BASICS + OOP)      ");
        System.out.println("==================================================\n");

        // 1. Combining 1D/2D Arrays, Loops, Conditionals & OOP Objects
        ArrayList<StudentTranscript> cohort = new ArrayList<>();
        cohort.add(new UndergraduateTranscript("S-101", "Alice", new int[]{92, 88, 95, 91}));
        cohort.add(new GraduateTranscript("S-102", "Bob", new int[]{84, 79, 88, 85}, true));
        cohort.add(new UndergraduateTranscript("S-103", "Charlie", new int[]{62, 58, 65, 63}));

        System.out.println("--- [1] Cohort Academic Evaluation Report ---");
        for (StudentTranscript student : cohort) {
            System.out.println("  " + student.generateReportLine());
        }
    }
}

enum AcademicStanding {
    DEANS_LIST,
    GOOD_STANDING,
    ACADEMIC_PROBATION
}

interface Evaluatable {
    double computeWeightedAverage();

    AcademicStanding determineStanding();
}

abstract class StudentTranscript implements Evaluatable {
    private String studentId;
    private String name;
    protected int[] examScores;

    public StudentTranscript(String studentId, String name, int[] examScores) {
        this.studentId = studentId;
        this.name = name;
        // Deep copy of 1D array (Module 1 + Module 2!)
        this.examScores = Arrays.copyOf(examScores, examScores.length);
    }

    // Uses Module 1 `for-each` loop and floating-point cast `(double)`
    protected double calculateRawAverage() {
        int sum = 0;
        for (int score : this.examScores) {
            sum += score;
        }
        return (double) sum / this.examScores.length;
    }

    // Uses Module 1 `if-else if` ladder + Module 2 `enum`
    @Override
    public AcademicStanding determineStanding() {
        double avg = computeWeightedAverage();
        if (avg >= 90.0) {
            return AcademicStanding.DEANS_LIST;
        } else if (avg >= 70.0) {
            return AcademicStanding.GOOD_STANDING;
        } else {
            return AcademicStanding.ACADEMIC_PROBATION;
        }
    }

    public String generateReportLine() {
        return String.format("[%s] %-8s | Scores: %-18s | Final Avg: %5.2f | Standing: %s",
                this.studentId,
                this.name,
                Arrays.toString(this.examScores),
                computeWeightedAverage(),
                determineStanding().name());
    }
}

class UndergraduateTranscript extends StudentTranscript {
    public UndergraduateTranscript(String studentId, String name, int[] examScores) {
        super(studentId, name, examScores);
    }

    @Override
    public double computeWeightedAverage() {
        return calculateRawAverage();
    }
}

class GraduateTranscript extends StudentTranscript {
    private boolean thesisApproved;

    public GraduateTranscript(String studentId, String name, int[] examScores, boolean thesisApproved) {
        super(studentId, name, examScores);
        this.thesisApproved = thesisApproved;
    }

    @Override
    public double computeWeightedAverage() {
        double base = calculateRawAverage();
        return this.thesisApproved ? Math.min(100.0, base + 5.0) : base;
    }
}
