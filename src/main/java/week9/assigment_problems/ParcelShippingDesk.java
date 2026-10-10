package week9.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 2 - Parcel Shipping Desk
 *
 * Two different questions are asked of each parcel:
 *   "how much does shipping cost?" -- EVERY parcel answers this (abstract
 *                                     charge() on the base class), and
 *   "can it be insured?"           -- only SOME parcels can, so it is a
 *                                     separate capability with a safe
 *                                     default of 0.00.
 *
 * Making a new parcel type insurable means overriding insurance(); the
 * types that are not insured are never touched.
 */
public class ParcelShippingDesk {

    static final double INSURANCE_RATE = 0.02;   // 2% of the declared value

    abstract static class Parcel {
        final double weightKg;
        final double declaredValue;
        Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        abstract String type();
        abstract double charge();

        /** Not every parcel is insured -- the default is zero. */
        double insurance() { return 0.0; }

        final double total() { return charge() + insurance(); }
    }

    static class Standard extends Parcel {
        Standard(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
        String type() { return "STANDARD"; }
        double charge() { return 40.0 + (10.0 * weightKg); }
    }

    static class Express extends Parcel {
        Express(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
        String type() { return "EXPRESS"; }
        double charge() { return 80.0 + (15.0 * weightKg); }
        double insurance() { return declaredValue * INSURANCE_RATE; }
    }

    static class Fragile extends Parcel {
        Fragile(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
        String type() { return "FRAGILE"; }
        double charge() { return (40.0 + (10.0 * weightKg)) + 50.0; }   // standard + handling
        double insurance() { return declaredValue * INSURANCE_RATE; }
    }

    static Parcel parcelFor(String type, double weightKg, double declaredValue) {
        switch (type) {
            case "STANDARD": return new Standard(weightKg, declaredValue);
            case "EXPRESS":  return new Express(weightKg, declaredValue);
            case "FRAGILE":  return new Fragile(weightKg, declaredValue);
            default:         return null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextLine()) {
            System.out.println("No input provided.");
            return;
        }
        int n = Integer.parseInt(in.nextLine().trim());
        double grandTotal = 0;

        for (int i = 0; i < n && in.hasNextLine(); i++) {
            String[] parts = in.nextLine().trim().split("\\s+");
            if (parts.length < 3) {
                continue;
            }
            Parcel parcel = parcelFor(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
            if (parcel == null) {
                continue;
            }
            grandTotal += parcel.total();
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.type(), parcel.charge(), parcel.insurance(), parcel.total());
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}
