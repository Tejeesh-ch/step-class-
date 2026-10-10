package week9.class_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4 - Electricity Connection Billing
 *
 * The abstract base type defines the common `units` property and an
 * abstract bill(); each connection type supplies its own billing logic.
 */
public class ElectricityConnectionBilling {

    abstract static class Connection {
        final int units;
        Connection(int units) { this.units = units; }
        abstract String type();
        abstract double bill();
    }

    static class Home extends Connection {
        Home(int units) { super(units); }
        String type() { return "HOME"; }
        double bill() {
            int first = Math.min(units, 100);
            int rest = Math.max(0, units - 100);
            return (5.0 * first) + (7.0 * rest);
        }
    }

    static class Shop extends Connection {
        Shop(int units) { super(units); }
        String type() { return "SHOP"; }
        double bill() { return (8.0 * units) + 100.0; }
    }

    static class Factory extends Connection {
        Factory(int units) { super(units); }
        String type() { return "FACTORY"; }
        double bill() { return Math.max(6.0 * units, 1000.0); }
    }

    static Connection connectionFor(String type, int units) {
        switch (type) {
            case "HOME":    return new Home(units);
            case "SHOP":    return new Shop(units);
            case "FACTORY": return new Factory(units);
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
            Connection connection = connectionFor(parts[0], Integer.parseInt(parts[1]));
            if (connection == null) {
                continue;
            }
            total += connection.bill();
            System.out.printf(Locale.US, "%s: %.2f%n", connection.type(), connection.bill());
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
