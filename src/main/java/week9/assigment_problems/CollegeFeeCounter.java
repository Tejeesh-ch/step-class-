package week9.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3 - College Fee Counter
 *
 * The transport fee lives in one place (the base class constant). The fee
 * counter asks each student `usesBus()` rather than checking the student
 * type by name, so a new student type simply answers the question itself.
 */
public class CollegeFeeCounter {

    abstract static class Student {
        static final double TRANSPORT_FEE = 12000.0;   // one place only
        final String name;
        Student(String name) { this.name = name; }

        abstract String type();
        abstract double tuition();
        /** Does this student use the college bus? */
        abstract boolean usesBus();

        final double totalFee() {
            return tuition() + (usesBus() ? TRANSPORT_FEE : 0.0);
        }
    }

    static class DayScholar extends Student {
        DayScholar(String name) { super(name); }
        String type() { return "DAY_SCHOLAR"; }
        double tuition() { return 40000.0; }
        boolean usesBus() { return true; }
    }

    static class Hosteller extends Student {
        Hosteller(String name) { super(name); }
        String type() { return "HOSTELLER"; }
        double tuition() { return 40000.0 + 60000.0; }
        boolean usesBus() { return false; }        // lives on campus
    }

    static class Scholar extends Student {
        Scholar(String name) { super(name); }
        String type() { return "SCHOLAR"; }
        double tuition() { return 20000.0; }       // half the normal tuition
        boolean usesBus() { return true; }
    }

    static Student studentFor(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR": return new DayScholar(name);
            case "HOSTELLER":   return new Hosteller(name);
            case "SCHOLAR":     return new Scholar(name);
            default:            return null;
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
            Student student = studentFor(parts[0], parts[1]);
            if (student == null) {
                continue;
            }
            double fee = student.totalFee();
            total += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", student.name, fee);
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}
