package _01_Java_Basics._05_Input_And_Variables_Part_1;

import java.util.Scanner;

/**
 * Lesson 05: Input and Variables (Part 1) — Exercise Solutions
 *
 * NOTE: All solutions are written directly inside `main()` because custom methods
 * are not introduced until Lesson 18.
 */
public class Exercise {

    public static void main(String[] args) {

        // =================================================================
        // Problem 1 (Easy): Choosing the Right Primitive Type
        // =================================================================
        System.out.println("=== Problem 1: Choosing the Right Primitive Type ===");

        // WHY WE USED THIS WAY:
        // - `byte` (1 byte: -128..127) is ideal for `dayOfMonth` (1..31) to save memory.
        // - `long` (8 bytes) with the `L` suffix is required for `149_600_000_000L` because
        //   it exceeds the 32-bit `int` limit (~2.14 billion).
        // - `float` (4 bytes) requires the `f` suffix because decimal literals default to `double`.
        // - `char` uses single quotes `'O'` to store a single 16-bit Unicode character.
        byte dayOfMonth = 28;
        long distanceToSunKm = 149_600_000_000L;
        float batteryVoltage = 3.75f;
        char bloodGroup = 'O';

        System.out.println("Day of Month       : " + dayOfMonth);
        System.out.println("Distance to Sun    : " + distanceToSunKm + " km");
        System.out.println("Battery Voltage    : " + batteryVoltage + " V");
        System.out.println("Blood Group        : " + bloodGroup);

        // =================================================================
        // Problem 2 (Medium): Reading Sensor Telemetry with Scanner(System.in)
        // =================================================================
        System.out.println("\n=== Problem 2: Reading Sensor Telemetry with Scanner ===");

        // WHY WE USED THIS WAY:
        // We create `Scanner input = new Scanner(System.in);` to read directly from the
        // keyboard console using `input.nextLine()`, `input.nextInt()`, and `input.nextDouble()`.
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Sensor ID: ");
        String sensorId = input.nextLine();

        System.out.print("Enter Reading Count: ");
        int readingCount = input.nextInt();

        System.out.print("Enter Temperature (C): ");
        double temperatureCelsius = input.nextDouble();

        System.out.println("Sensor ID   : " + sensorId);
        System.out.println("Readings    : " + readingCount);
        System.out.println("Temperature : " + temperatureCelsius + " C");

        input.close();

        // =================================================================
        // Problem 3 (Hard): Integer Overflow Demonstration
        // =================================================================
        System.out.println("\n=== Problem 3: Integer Overflow Demonstration ===");

        int maxInt = Integer.MAX_VALUE; // 2,147,483,647

        // WHY WE USED THIS WAY:
        // 1. Adding 1 to an `int` at `Integer.MAX_VALUE` overflows the 32-bit signed binary
        //    representation and wraps around to `Integer.MIN_VALUE` (-2,147,483,648).
        // 2. By casting `(long) maxInt` BEFORE adding `1L`, Java performs 64-bit `long`
        //    addition instead of 32-bit `int` addition, preventing the overflow!
        int overflowedInt = maxInt + 1;
        long safeResult = (long) maxInt + 1L;

        System.out.println("Max int value          : " + maxInt);
        System.out.println("After int + 1 (Wrap!)  : " + overflowedInt);
        System.out.println("Using long + 1L (Safe) : " + safeResult);
    }
}
