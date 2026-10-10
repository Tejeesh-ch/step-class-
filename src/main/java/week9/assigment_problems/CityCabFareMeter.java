package week9.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4 - City Cab Fare Meter
 *
 * The minimum-fare rule is shared: it is written once in the base class
 * and applies to every cab. "Can offer night service" is an ability only
 * some cabs have, so subclasses override supportsNightService() -- a new
 * cab type simply chooses true or false.
 */
public class CityCabFareMeter {

    static final double MINIMUM_FARE = 100.0;
    static final double NIGHT_SURCHARGE = 0.20;

    abstract static class Cab {
        abstract String type();
        abstract double ratePerKm();

        /** Most cabs do not offer night service; sedans and SUVs do. */
        boolean supportsNightService() { return false; }

        /** Rejects the trip, or returns -1 when night service is unavailable. */
        final double fare(double km, boolean night) {
            if (night && !supportsNightService()) {
                return -1;
            }
            double fare = Math.max(km * ratePerKm(), MINIMUM_FARE);   // shared rule
            if (night) {
                fare += fare * NIGHT_SURCHARGE;                       // after the minimum
            }
            return fare;
        }
    }

    static class Mini extends Cab {
        String type() { return "MINI"; }
        double ratePerKm() { return 10.0; }
    }

    static class Sedan extends Cab {
        String type() { return "SEDAN"; }
        double ratePerKm() { return 14.0; }
        boolean supportsNightService() { return true; }
    }

    static class Suv extends Cab {
        String type() { return "SUV"; }
        double ratePerKm() { return 18.0; }
        boolean supportsNightService() { return true; }
    }

    static Cab cabFor(String type) {
        switch (type) {
            case "MINI":  return new Mini();
            case "SEDAN": return new Sedan();
            case "SUV":   return new Suv();
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
            if (parts.length < 3) {
                continue;
            }
            Cab cab = cabFor(parts[0]);
            if (cab == null) {
                continue;
            }
            double km = Double.parseDouble(parts[1]);
            boolean night = parts[2].equalsIgnoreCase("NIGHT");

            double fare = cab.fare(km, night);
            if (fare < 0) {
                System.out.printf(Locale.US, "%s: night service not available%n", cab.type());
                continue;                       // a rejected trip is not counted
            }
            total += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", cab.type(), fare);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
