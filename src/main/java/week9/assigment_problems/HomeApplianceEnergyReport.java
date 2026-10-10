package week9.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 5 - Home Appliance Energy Report
 *
 * Every appliance computes units the same way from its own power rating
 * (that logic lives once in the base class), but only some appliances have
 * a saver mode. The report asks supportsSaver() instead of listing
 * appliance types in an if-else chain.
 */
public class HomeApplianceEnergyReport {

    static final double COST_PER_UNIT = 8.0;

    abstract static class Appliance {
        final String type;
        final double powerWatts;
        Appliance(String type, double powerWatts) {
            this.type = type;
            this.powerWatts = powerWatts;
        }

        /** Only the AC and the washer can do it. */
        boolean supportsSaver() { return false; }

        /** -1 means the requested mode is not supported. */
        final double units(int hours, boolean saver) {
            if (saver && !supportsSaver()) {
                return -1;
            }
            double units = (powerWatts * hours) / 1000.0;
            if (saver) {
                units -= units * 0.25;          // saver mode cuts energy use by 25%
            }
            return units;
        }
    }

    static class Fridge extends Appliance {
        Fridge() { super("FRIDGE", 150); }
    }

    static class Ac extends Appliance {
        Ac() { super("AC", 1500); }
        boolean supportsSaver() { return true; }
    }

    static class Tv extends Appliance {
        Tv() { super("TV", 100); }
    }

    static class Washer extends Appliance {
        Washer() { super("WASHER", 500); }
        boolean supportsSaver() { return true; }
    }

    static Appliance applianceFor(String type) {
        switch (type) {
            case "FRIDGE": return new Fridge();
            case "AC":     return new Ac();
            case "TV":     return new Tv();
            case "WASHER": return new Washer();
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
        double totalCost = 0;

        for (int i = 0; i < n && in.hasNextLine(); i++) {
            String[] parts = in.nextLine().trim().split("\\s+");
            if (parts.length < 2) {
                continue;
            }
            Appliance appliance = applianceFor(parts[0]);
            if (appliance == null) {
                continue;
            }
            int hours = Integer.parseInt(parts[1]);
            boolean saver = parts.length >= 3 && parts[2].equalsIgnoreCase("SAVER");

            double units = appliance.units(hours, saver);
            if (units < 0) {
                System.out.printf(Locale.US, "%s: saver mode not supported%n", appliance.type);
                continue;                       // no cost is calculated or counted
            }
            double cost = units * COST_PER_UNIT;
            totalCost += cost;
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", appliance.type, units, cost);
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }
}
