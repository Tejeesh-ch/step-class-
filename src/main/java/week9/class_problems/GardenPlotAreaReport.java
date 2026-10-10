package week9.class_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 1 - Garden Plot Area Report
 *
 * Different shapes share an owner but calculate area differently, so there
 * is a common abstract Plot type declaring area(). Adding a new shape
 * means adding a class -- the reporting code is never modified.
 */
public class GardenPlotAreaReport {

    /** The shared abstraction: every plot has an owner and an area. */
    abstract static class Plot {
        final String owner;
        Plot(String owner) { this.owner = owner; }
        abstract String shape();
        abstract double area();
    }

    static class Circle extends Plot {
        private final double radius;
        Circle(String owner, double radius) { super(owner); this.radius = radius; }
        String shape() { return "CIRCLE"; }
        double area() { return Math.PI * radius * radius; }
    }

    static class Rectangle extends Plot {
        private final double length;
        private final double width;
        Rectangle(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }
        String shape() { return "RECTANGLE"; }
        double area() { return length * width; }
    }

    static class Triangle extends Plot {
        private final double base;
        private final double height;
        Triangle(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }
        String shape() { return "TRIANGLE"; }
        double area() { return 0.5 * base * height; }
    }

    static Plot plotFor(String[] parts) {
        switch (parts[0]) {
            case "CIRCLE":    return new Circle(parts[1], Double.parseDouble(parts[2]));
            case "RECTANGLE": return new Rectangle(parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            case "TRIANGLE":  return new Triangle(parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            default:          return null;
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
            Plot plot = plotFor(parts);
            if (plot == null) {
                continue;
            }
            total += plot.area();
            System.out.printf(Locale.US, "%s (%s): %.2f%n", plot.owner, plot.shape(), plot.area());
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
    }
}
