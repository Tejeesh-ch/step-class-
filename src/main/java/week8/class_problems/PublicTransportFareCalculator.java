package week8.class_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 5 - Public Transport Fare Calculator
 *
 * Each transport type prices journeys its own way; the central system
 * processes every journey uniformly through the TransportType interface.
 *
 * Business rules:
 *   BUS    2  + 0.10/km, capped at a maximum fare of 10
 *   TRAIN  3  + 0.15/km
 *   METRO (1.50 + 0.20/km) * PeakHourFactor
 */
public class PublicTransportFareCalculator {

    interface TransportType {
        String type();
        double fare(double distance, double peakHourFactor);
    }

    static class Bus implements TransportType {
        public String type() { return "BUS"; }
        public double fare(double distance, double peakHourFactor) {
            double fare = 2.0 + (0.10 * distance);
            return Math.min(fare, 10.0);          // maximum fare 10
        }
    }

    static class Train implements TransportType {
        public String type() { return "TRAIN"; }
        public double fare(double distance, double peakHourFactor) {
            return 3.0 + (0.15 * distance);
        }
    }

    static class Metro implements TransportType {
        public String type() { return "METRO"; }
        public double fare(double distance, double peakHourFactor) {
            return (1.50 + (0.20 * distance)) * peakHourFactor;
        }
    }

    static TransportType typeFor(String token) {
        switch (token) {
            case "BUS":   return new Bus();
            case "TRAIN": return new Train();
            case "METRO": return new Metro();
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
            TransportType transport = typeFor(parts[0]);
            if (transport == null) {
                continue;
            }
            double distance = Double.parseDouble(parts[1]);
            double peakHourFactor = (parts.length >= 3) ? Double.parseDouble(parts[2]) : 1.0;

            double fare = transport.fare(distance, peakHourFactor);
            total += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", transport.type(), fare);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
