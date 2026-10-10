package week8.class_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 1 - Payment System Fee Calculation
 *
 * Every payment method shares one operation (calculating the final amount)
 * but has distinct fee logic. The central processor handles the collection
 * uniformly through the PaymentMethod interface -- no type checking anywhere.
 *
 * Business rules: CARD 2% fee, WALLET 1% fee, BANKTRANSFER no fee.
 */
public class PaymentSystemFeeCalculation {

    /** The shared operation. */
    interface PaymentMethod {
        String type();
        double finalAmount(double amount);
    }

    static class CardPayment implements PaymentMethod {
        public String type() { return "CARD"; }
        public double finalAmount(double amount) { return amount * 1.02; }
    }

    static class WalletPayment implements PaymentMethod {
        public String type() { return "WALLET"; }
        public double finalAmount(double amount) { return amount * 1.01; }
    }

    static class BankTransferPayment implements PaymentMethod {
        public String type() { return "BANKTRANSFER"; }
        public double finalAmount(double amount) { return amount; }
    }

    /** Maps the input token to a concrete strategy -- the ONLY place that knows the types. */
    static PaymentMethod methodFor(String token) {
        switch (token) {
            case "CARD":         return new CardPayment();
            case "WALLET":       return new WalletPayment();
            case "BANKTRANSFER": return new BankTransferPayment();
            default:             return null;
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
            PaymentMethod method = methodFor(parts[0]);
            if (method == null) {
                continue;
            }
            double adjusted = method.finalAmount(Double.parseDouble(parts[1]));
            total += adjusted;
            System.out.printf(Locale.US, "%s: %.2f%n", method.type(), adjusted);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
