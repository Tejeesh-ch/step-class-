package week2.class_problems;

/**
 * Day 2 Live-Coding Session - Problem 2: CSV Student Record Parser
 *
 * Splits "Name,RollNumber,Department" on commas, validates that exactly
 * three fields are present, and prints a formatted record.
 */
public class CsvStudentRecordParser {

    /** Suggested signature: void parseStudentRecord(String csvLine) */
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3 || fields[0].trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + fields[0].trim()
                + " | Roll No: " + fields[1].trim()
                + " | Dept: " + fields[2].trim());
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
    }
}
