package week8.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3 - The Hostel Electricity Bill
 *
 * Room types share one operation (calculating the bill) but each uses its
 * own rule. SHARED needs one extra value -- the number of occupants --
 * which is supplied when the room is built, so the main flow can still
 * treat every room the same way.
 *
 * Business rules:
 *   SINGLE 8 per unit
 *   SHARED 6 per unit, divided equally among the occupants
 *   AC     10 per unit, plus a fixed charge of 200
 */
public class HostelElectricityBill {

    interface RoomType {
        String type();
        double bill(int units);
    }

    static class SingleRoom implements RoomType {
        public String type() { return "SINGLE"; }
        public double bill(int units) { return 8.0 * units; }
    }

    static class SharedRoom implements RoomType {
        private final int occupants;
        SharedRoom(int occupants) { this.occupants = Math.max(1, occupants); }
        public String type() { return "SHARED"; }
        public double bill(int units) { return (6.0 * units) / occupants; }
    }

    static class AcRoom implements RoomType {
        public String type() { return "AC"; }
        public double bill(int units) { return (10.0 * units) + 200.0; }
    }

    static RoomType roomFor(String token, int occupants) {
        switch (token) {
            case "SINGLE": return new SingleRoom();
            case "SHARED": return new SharedRoom(occupants);
            case "AC":     return new AcRoom();
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
        double total = 0;

        for (int i = 0; i < n && in.hasNextLine(); i++) {
            String[] parts = in.nextLine().trim().split("\\s+");
            if (parts.length < 2) {
                continue;
            }
            int units = Integer.parseInt(parts[1]);
            int occupants = (parts.length >= 3) ? Integer.parseInt(parts[2]) : 1;

            RoomType room = roomFor(parts[0], occupants);
            if (room == null) {
                continue;
            }
            double amount = room.bill(units);
            total += amount;
            System.out.printf(Locale.US, "%s: %.2f%n", room.type(), amount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
