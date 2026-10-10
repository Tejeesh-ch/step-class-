package week1.class_problems;

import java.util.Random;

/**
 * Problem 3 - BMI Calculator for a Team (Day 1 Live-Coding Session)
 *
 * BMI = weight / (height * height)
 *   BMI &lt; 18.5          - Underweight
 *   18.5 &lt;= BMI &lt; 25.0  - Normal
 *   25.0 &lt;= BMI &lt; 30.0  - Overweight
 *   BMI &gt;= 30.0         - Obese
 */
public class BMICalculator {

    /** Suggested signature: String getBmiStatus(double bmi) */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        }
        return "Obese";
    }

    public static double calculateBmi(double heightMeters, double weightKg) {
        return weightKg / (heightMeters * heightMeters);
    }

    /** Suggested signature: void printWellnessReport(double[] heights, double[] weights) */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Height and weight arrays must be non-null and of equal length.");
            return;
        }
        System.out.println("+--------+--------------+----------------+--------+--------------+");
        System.out.printf("| %-6s | %-12s | %-14s | %-6s | %-12s |%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("+--------+--------------+----------------+--------+--------------+");
        for (int i = 0; i < heights.length; i++) {
            double bmi = calculateBmi(heights[i], weights[i]);
            System.out.printf("| %-6d | %-12.2f | %-14.2f | %-6.2f | %-12s |%n",
                    (i + 1), heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
        System.out.println("+--------+--------------+----------------+--------+--------------+");
    }

    public static void main(String[] args) {
        int teamSize = 10;
        Random random = new Random();

        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + random.nextDouble() * 0.45;
            weights[i] = 45.0 + random.nextDouble() * 55.0;
        }

        System.out.println("Wellness report for a team of " + teamSize + " people");
        System.out.println("(heights and weights generated randomly for the live demo)");
        System.out.println();
        printWellnessReport(heights, weights);

        System.out.println();
        System.out.println("Sample checks from the problem statement:");
        double bmi1 = calculateBmi(1.75, 70.0);
        double bmi2 = calculateBmi(1.60, 90.0);
        System.out.printf("Person 1 -- Height: 1.75 m, Weight: 70 kg  ->  BMI: %.2f | Status: %s%n",
                bmi1, getBmiStatus(bmi1));
        System.out.printf("Person 2 -- Height: 1.60 m, Weight: 90 kg  ->  BMI: %.2f | Status: %s%n",
                bmi2, getBmiStatus(bmi2));
    }
}
