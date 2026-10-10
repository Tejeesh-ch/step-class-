package week9.class_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 2 - Weekly Staff Pay
 *
 * StaffMember is abstract: a generic "staff member" with no pay rule can
 * never be created, because calculatePay() is abstract and must be
 * implemented by every concrete subclass.
 */
public class WeeklyStaffPay {

    abstract static class StaffMember {
        final String name;
        StaffMember(String name) { this.name = name; }
        /** No default implementation -- every subclass must supply its own rule. */
        abstract double calculatePay();
    }

    static class FullTime extends StaffMember {
        private final double weeklySalary;
        FullTime(String name, double weeklySalary) { super(name); this.weeklySalary = weeklySalary; }
        double calculatePay() { return weeklySalary; }
    }

    static class Hourly extends StaffMember {
        private final double hours;
        private final double rate;
        Hourly(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
        double calculatePay() {
            double regular = Math.min(hours, 40) * rate;
            double overtime = Math.max(0, hours - 40) * rate * 1.5;
            return regular + overtime;
        }
    }

    static class Intern extends StaffMember {
        private final double stipend;
        Intern(String name, double stipend) { super(name); this.stipend = stipend; }
        double calculatePay() { return stipend; }
    }

    static StaffMember staffFor(String[] parts) {
        switch (parts[0]) {
            case "FULLTIME": return new FullTime(parts[1], Double.parseDouble(parts[2]));
            case "HOURLY":   return new Hourly(parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            case "INTERN":   return new Intern(parts[1], Double.parseDouble(parts[2]));
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
            StaffMember member = staffFor(parts);
            if (member == null) {
                continue;
            }
            double pay = member.calculatePay();
            total += pay;
            System.out.printf(Locale.US, "%s: %.2f%n", member.name, pay);
        }
        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
    }
}
