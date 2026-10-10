package week9.class_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3 - Library Late Fine Counter
 *
 * A base type mandates the fine() calculation; each item type implements
 * its own rule, including the DVD's 50 cap.
 */
public class LibraryLateFineCounter {

    abstract static class LibraryItem {
        final String title;
        final int daysLate;
        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }
        abstract double fine();
    }

    static class Book extends LibraryItem {
        Book(String title, int daysLate) { super(title, daysLate); }
        double fine() { return 2.0 * daysLate; }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title, int daysLate) { super(title, daysLate); }
        double fine() { return Math.min(5.0 * daysLate, 50.0); }   // capped at 50
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) { super(title, daysLate); }
        double fine() { return 1.0 * daysLate; }
    }

    static LibraryItem itemFor(String type, String title, int daysLate) {
        switch (type) {
            case "BOOK":     return new Book(title, daysLate);
            case "DVD":      return new Dvd(title, daysLate);
            case "MAGAZINE": return new Magazine(title, daysLate);
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
            if (parts.length < 3) {
                continue;
            }
            LibraryItem item = itemFor(parts[0], parts[1], Integer.parseInt(parts[2]));
            if (item == null) {
                continue;
            }
            total += item.fine();
            System.out.printf(Locale.US, "%s: %.2f%n", item.title, item.fine());
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
    }
}
