package week8.assigment_problems;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Problem 5 - The Streaming Plan Renewal Reminder
 *
 * Plans share one operation (finding the renewal date) but each has a
 * different validity period; the renewal date is the start date plus the
 * plan's validity in days. Uses java.time.LocalDate.plusDays(), which
 * handles leap years (2024) and year changes for us.
 *
 * Business rules: BASIC 30 days, STANDARD 90 days, PREMIUM 365 days.
 */
public class StreamingPlanRenewalReminder {

    interface PlanType {
        String type();
        LocalDate renewalDate(LocalDate startDate);
    }

    static class Basic implements PlanType {
        public String type() { return "BASIC"; }
        public LocalDate renewalDate(LocalDate start) { return start.plusDays(30); }
    }

    static class Standard implements PlanType {
        public String type() { return "STANDARD"; }
        public LocalDate renewalDate(LocalDate start) { return start.plusDays(90); }
    }

    static class Premium implements PlanType {
        public String type() { return "PREMIUM"; }
        public LocalDate renewalDate(LocalDate start) { return start.plusDays(365); }
    }

    static PlanType typeFor(String token) {
        switch (token) {
            case "BASIC":    return new Basic();
            case "STANDARD": return new Standard();
            case "PREMIUM":  return new Premium();
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
        for (int i = 0; i < n && in.hasNextLine(); i++) {
            String[] parts = in.nextLine().trim().split("\\s+");
            if (parts.length < 3) {
                continue;
            }
            PlanType plan = typeFor(parts[0]);
            if (plan == null) {
                continue;
            }
            String name = parts[1];
            LocalDate start = LocalDate.parse(parts[2]);

            System.out.println(name + ": " + plan.renewalDate(start));
        }
    }
}
