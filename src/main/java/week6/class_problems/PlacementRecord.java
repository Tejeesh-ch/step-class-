package week6.class_problems;

import java.util.Arrays;

/**
 * M1. Student Placement Record Management
 *
 * The T&amp;P cell tracked placements with three parallel arrays that went out
 * of sync twice this month. Rebuilt the OOP way: one object owns one
 * student's whole record, so nothing can drift apart.
 */
public class PlacementRecord {

    private final String studentName;
    private final String company;
    private final double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        PlacementRecord[] records = {
                new PlacementRecord("Ravi", "TCS", 4.5),
                new PlacementRecord("Anitha", "Zoho", 6.2),
                new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        for (PlacementRecord record : records) {
            record.printRecord();
        }

        System.out.println();
        System.out.println("Records held: " + Arrays.stream(records).count());
    }
}
