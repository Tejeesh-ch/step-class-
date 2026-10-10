package week8.class_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3 - Delivery Fee Calculator
 *
 * Each delivery type calculates its fee by its own rules; the central
 * system processes the whole request list uniformly.
 *
 * Business rules as stated in the sheet:
 *   STANDARD      5  + 0.50/kg + 0.10/km
 *   EXPRESS       15 + 1.00/kg + 0.20/km
 *   INTERNATIONAL 25 + 2.00/kg + 0.50/km + CustomsFee
 *
 * NOTE ON THE SHEET'S SAMPLE OUTPUT
 * The stated rules give EXPRESS = 15 + 5 + 4 = 24.00 and
 * INTERNATIONAL = 25 + 40 + 50 + 30 = 145.00 for the sample input, while
 * the sheet prints 29.00 and 155.00. STANDARD (15.00) matches the rules
 * exactly, so the business rules are implemented here as the specification.
 */
public class DeliveryFeeCalculator {

    interface DeliveryType {
        String type();
        double fee(double weight, double distance, double customsFee);
    }

    static class StandardDelivery implements DeliveryType {
        public String type() { return "STANDARD"; }
        public double fee(double weight, double distance, double customsFee) {
            return 5.0 + (0.50 * weight) + (0.10 * distance);
        }
    }

    static class ExpressDelivery implements DeliveryType {
        public String type() { return "EXPRESS"; }
        public double fee(double weight, double distance, double customsFee) {
            return 15.0 + (1.00 * weight) + (0.20 * distance);
        }
    }

    static class InternationalDelivery implements DeliveryType {
        public String type() { return "INTERNATIONAL"; }
        public double fee(double weight, double distance, double customsFee) {
            return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
        }
    }

    static DeliveryType typeFor(String token) {
        switch (token) {
            case "STANDARD":      return new StandardDelivery();
            case "EXPRESS":       return new ExpressDelivery();
            case "INTERNATIONAL": return new InternationalDelivery();
            default:              return null;
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
            if (parts.length < 3) {
                continue;
            }
            DeliveryType delivery = typeFor(parts[0]);
            if (delivery == null) {
                continue;
            }
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);
            double customsFee = (parts.length >= 4) ? Double.parseDouble(parts[3]) : 0.0;

            double fee = delivery.fee(weight, distance, customsFee);
            total += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", delivery.type(), fee);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
