package week8.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 1 - The Canteen Billing Counter
 *
 * Customer types share one operation (calculating the final amount) but
 * follow different pricing rules; the counter processes the list without
 * any if-else blocks on the customer type.
 *
 * Business rules: STUDENT 10% discount, STAFF 5% discount,
 * GUEST full amount plus a 10 service charge.
 */
public class CanteenBillingCounter {

    interface CustomerType {
        String type();
        double finalAmount(double billAmount);
    }

    static class Student implements CustomerType {
        public String type() { return "STUDENT"; }
        public double finalAmount(double amount) { return amount * 0.90; }
    }

    static class Staff implements CustomerType {
        public String type() { return "STAFF"; }
        public double finalAmount(double amount) { return amount * 0.95; }
    }

    static class Guest implements CustomerType {
        public String type() { return "GUEST"; }
        public double finalAmount(double amount) { return amount + 10; }
    }

    static CustomerType typeFor(String token) {
        switch (token) {
            case "STUDENT": return new Student();
            case "STAFF":   return new Staff();
            case "GUEST":   return new Guest();
            default:        return null;
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
            CustomerType customer = typeFor(parts[0]);
            if (customer == null) {
                continue;
            }
            double amount = customer.finalAmount(Double.parseDouble(parts[1]));
            total += amount;
            System.out.printf(Locale.US, "%s: %.2f%n", customer.type(), amount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
