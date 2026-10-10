package week8.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4 - The Festival Bonus Calculator
 *
 * Employee types share common details (name and salary) and one operation
 * (calculating the bonus), while each type follows its own bonus rule.
 *
 * Business rules:
 *   FULLTIME 10% of monthly salary
 *   PARTTIME 5% of monthly salary
 *   INTERN   a fixed bonus of 2000, whatever the salary
 */
public class FestivalBonusCalculator {

    interface EmployeeType {
        String type();
        double bonus(double monthlySalary);
    }

    static class FullTime implements EmployeeType {
        public String type() { return "FULLTIME"; }
        public double bonus(double salary) { return salary * 0.10; }
    }

    static class PartTime implements EmployeeType {
        public String type() { return "PARTTIME"; }
        public double bonus(double salary) { return salary * 0.05; }
    }

    static class Intern implements EmployeeType {
        public String type() { return "INTERN"; }
        public double bonus(double salary) { return 2000.0; }
    }

    static EmployeeType typeFor(String token) {
        switch (token) {
            case "FULLTIME": return new FullTime();
            case "PARTTIME": return new PartTime();
            case "INTERN":   return new Intern();
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
            EmployeeType employee = typeFor(parts[0]);
            if (employee == null) {
                continue;
            }
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            double amount = employee.bonus(salary);
            total += amount;
            System.out.printf(Locale.US, "%s: %.2f%n", name, amount);
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }
}
