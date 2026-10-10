package week9.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 1 - Movie Ticket Counter
 *
 * The convenience fee of 20 is written in one place: the abstract Ticket
 * base class. Each seat type only supplies its own price per ticket.
 * A plain "ticket" with no seat type can never be sold, because Ticket
 * is abstract.
 */
public class MovieTicketCounter {

    abstract static class Ticket {
        static final double CONVENIENCE_FEE = 20.0;   // exists only once
        abstract String seatType();
        abstract double pricePerTicket();

        /** amount for a booking of `count` tickets. */
        final double amount(int count) {
            return (pricePerTicket() + CONVENIENCE_FEE) * count;
        }
    }

    static class Regular extends Ticket {
        String seatType() { return "REGULAR"; }
        double pricePerTicket() { return 150.0; }
    }

    static class Premium extends Ticket {
        String seatType() { return "PREMIUM"; }
        double pricePerTicket() { return 250.0; }
    }

    static class Recliner extends Ticket {
        String seatType() { return "RECLINER"; }
        double pricePerTicket() { return 400.0; }
    }

    static Ticket ticketFor(String seatType) {
        switch (seatType) {
            case "REGULAR":  return new Regular();
            case "PREMIUM":  return new Premium();
            case "RECLINER": return new Recliner();
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
        double total = 0;

        for (int i = 0; i < n && in.hasNextLine(); i++) {
            String[] parts = in.nextLine().trim().split("\\s+");
            if (parts.length < 2) {
                continue;
            }
            Ticket ticket = ticketFor(parts[0]);
            if (ticket == null) {
                continue;
            }
            double amount = ticket.amount(Integer.parseInt(parts[1]));
            total += amount;
            System.out.printf(Locale.US, "%s: %.2f%n", ticket.seatType(), amount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
