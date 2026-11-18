package _02_Java_OOP._22_Revision_OOP_Part_1;

import java.util.Arrays;
import java.util.Objects;

/**
 * Lesson 22: Revision OOP (Part 1) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Encapsulated LibraryBook & Static Counter ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Fluent WorkoutSession Builder ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Deep Copy & Equality in LabExperiment ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // The 1-arg constructor chains into the 3-arg master constructor via `this(...)`,
        // so `totalBooksCataloged++` and validation happen in one single place!
        LibraryBook b1 = new LibraryBook("Clean Architecture", "Robert Martin", 432);
        LibraryBook b2 = new LibraryBook("Mystery Manuscript");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println("Total Books Cataloged: " + LibraryBook.getTotalBooksCataloged());
    }

    public static void solveProblem2() {
        // WHY WE USED THIS WAY:
        // Returning `this` from `withDuration` and `withCaloriesPerMin` allows callers
        // to configure the object in a clean, readable method chain.
        WorkoutSession session = new WorkoutSession("HIIT Cardio")
                .withDuration(45)
                .withCaloriesPerMin(11.5);

        System.out.println(session);
    }

    public static void solveProblem3() {
        double[] initialData = {1.5, 2.5, 3.5};
        LabExperiment original = new LabExperiment("EXP-404", initialData);
        LabExperiment clone = new LabExperiment(original);

        // WHY WE USED THIS WAY:
        // 1. `new LabExperiment(original)` uses `Arrays.copyOf` so `clone` gets its own
        //    independent `double[]` array on the Heap.
        // 2. Overriding `equals()` with `Arrays.equals(...)` compares array contents element-by-element!
        System.out.println("Original == Clone (Same Address?)    : " + (original == clone));
        System.out.println("Original.equals(Clone) Before Edit   : " + original.equals(clone));

        clone.updateMeasurement(0, 99.9);
        System.out.println("Original.equals(Clone) After Edit    : " + original.equals(clone));
        System.out.println("Original Measurements (Protected!)   : " + original.getMeasurementsString());
    }
}

class LibraryBook {
    private static int totalBooksCataloged = 0;

    private String title;
    private String author;
    private int pageCount;

    public LibraryBook(String title) {
        this(title, "Unknown Author", 200);
    }

    public LibraryBook(String title, String author, int pageCount) {
        totalBooksCataloged++;
        this.title = title;
        this.author = author;
        this.pageCount = (pageCount >= 1) ? pageCount : 100;
    }

    public static int getTotalBooksCataloged() {
        return totalBooksCataloged;
    }

    @Override
    public String toString() {
        return String.format("Book [Title: %-20s | Author: %-15s | Pages: %d]",
                this.title, this.author, this.pageCount);
    }
}

class WorkoutSession {
    private String activityName;
    private int durationMinutes = 30;
    private double caloriesBurnedPerMin = 5.0;

    public WorkoutSession(String activityName) {
        this.activityName = activityName;
    }

    public WorkoutSession withDuration(int mins) {
        if (mins > 0) {
            this.durationMinutes = mins;
        }
        return this;
    }

    public WorkoutSession withCaloriesPerMin(double cal) {
        if (cal > 0.0) {
            this.caloriesBurnedPerMin = cal;
        }
        return this;
    }

    public double getTotalCaloriesBurned() {
        return this.durationMinutes * this.caloriesBurnedPerMin;
    }

    @Override
    public String toString() {
        return String.format("Workout [%s | %d mins | %.1f cal/min | Total Burned: %.1f cal]",
                this.activityName, this.durationMinutes, this.caloriesBurnedPerMin, getTotalCaloriesBurned());
    }
}

class LabExperiment {
    private String experimentCode;
    private double[] measurements;

    public LabExperiment(String experimentCode, double[] measurements) {
        this.experimentCode = experimentCode;
        this.measurements = Arrays.copyOf(measurements, measurements.length);
    }

    // Deep Copy Constructor
    public LabExperiment(LabExperiment source) {
        this.experimentCode = source.experimentCode;
        this.measurements = Arrays.copyOf(source.measurements, source.measurements.length);
    }

    public void updateMeasurement(int index, double newValue) {
        if (index >= 0 && index < this.measurements.length) {
            this.measurements[index] = newValue;
        }
    }

    public String getMeasurementsString() {
        return Arrays.toString(this.measurements);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        LabExperiment other = (LabExperiment) obj;
        return Objects.equals(this.experimentCode, other.experimentCode)
                && Arrays.equals(this.measurements, other.measurements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(this.experimentCode);
        result = 31 * result + Arrays.hashCode(this.measurements);
        return result;
    }
}
