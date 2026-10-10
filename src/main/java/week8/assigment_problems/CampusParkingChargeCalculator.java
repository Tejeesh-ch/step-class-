package week8.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 2 - The Campus Parking Charge Calculator
 *
 * Vehicle types share one operation (calculating the charge) but each has
 * its own charging rule; no type checking happens in the main loop.
 *
 * Business rules:
 *   BIKE  10 per hour
 *   CAR   30 for the first hour, plus 20 for each additional hour
 *   TRUCK 50 per hour, with a minimum charge of 100
 */
public class CampusParkingChargeCalculator {

    interface VehicleType {
        String type();
        double charge(int hours);
    }

    static class Bike implements VehicleType {
        public String type() { return "BIKE"; }
        public double charge(int hours) { return 10.0 * hours; }
    }

    static class Car implements VehicleType {
        public String type() { return "CAR"; }
        public double charge(int hours) {
            if (hours <= 1) {
                return 30.0;
            }
            return 30.0 + (20.0 * (hours - 1));
        }
    }

    static class Truck implements VehicleType {
        public String type() { return "TRUCK"; }
        public double charge(int hours) { return Math.max(50.0 * hours, 100.0); }
    }

    static VehicleType typeFor(String token) {
        switch (token) {
            case "BIKE":  return new Bike();
            case "CAR":   return new Car();
            case "TRUCK": return new Truck();
            default:      return null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextLine()) {
            System.out.println("No input provided.");
            return;
        }

        int n = Integer.parseInt(in.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n && in.hasNextLine(); i++) {
            String[] parts = in.nextLine().trim().split("\\s+");
            if (parts.length < 2) {
                continue;
            }
            VehicleType vehicle = typeFor(parts[0]);
            if (vehicle == null) {
                continue;
            }
            double amount = vehicle.charge(Integer.parseInt(parts[1]));
            total += amount;
            System.out.printf(Locale.US, "%s: %.2f%n", vehicle.type(), amount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
