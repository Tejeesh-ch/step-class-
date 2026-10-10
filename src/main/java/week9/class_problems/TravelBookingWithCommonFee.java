package week9.class_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 5 - Travel Booking with a Common Fee
 *
 * The booking fee of 50 lives in ONE place only: the abstract base class.
 * Subclasses implement only their mode-specific base fare. If the fee
 * changes, exactly one line of code changes.
 */
public class TravelBookingWithCommonFee {

    abstract static class Booking {
        static final double BOOKING_FEE = 50.0;      // the single place the fee is written
        final double distanceKm;
        Booking(double distanceKm) { this.distanceKm = distanceKm; }

        abstract String mode();
        abstract double baseFare();

        /** Template method: shared fee applied uniformly to every mode. */
        final double total() {
            return baseFare() + BOOKING_FEE;
        }
    }

    static class BusBooking extends Booking {
        BusBooking(double distanceKm) { super(distanceKm); }
        String mode() { return "BUS"; }
        double baseFare() { return 2.0 * distanceKm; }
    }

    static class TrainBooking extends Booking {
        TrainBooking(double distanceKm) { super(distanceKm); }
        String mode() { return "TRAIN"; }
        double baseFare() { return 1.5 * distanceKm; }
    }

    static class FlightBooking extends Booking {
        FlightBooking(double distanceKm) { super(distanceKm); }
        String mode() { return "FLIGHT"; }
        double baseFare() { return 2500.0 + (4.0 * distanceKm); }
    }

    static Booking bookingFor(String mode, double distanceKm) {
        switch (mode) {
            case "BUS":    return new BusBooking(distanceKm);
            case "TRAIN":  return new TrainBooking(distanceKm);
            case "FLIGHT": return new FlightBooking(distanceKm);
            default:       return null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextLine()) {
            System.out.println("No input provided.");
            return;
        }
        int n = Integer.parseInt(in.nextLine().trim());

        for (int i = 0; i < n && in.hasNextLine(); i++) {
            String[] parts = in.nextLine().trim().split("\\s+");
            if (parts.length < 2) {
                continue;
            }
            Booking booking = bookingFor(parts[0], Double.parseDouble(parts[1]));
            if (booking == null) {
                continue;
            }
            System.out.printf(Locale.US, "%s: %.2f%n", booking.mode(), booking.total());
        }
    }
}
