package week7.class_problems;

/**
 * Problem 5 - The Attendance Sheet
 *
 * Present students are held in a private array. Only a count and a yes/no
 * lookup are exposed -- never the full list. Names are checked before
 * being added, so a repeat mark does not count twice.
 */
public class AttendanceSheet {

    private final String[] present;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        this.present = new String[maxClassSize];
    }

    public void markPresent(String studentName) {
        if (studentName == null || studentName.isEmpty()) {
            return;
        }
        if (isPresent(studentName)) {
            return;                       // already marked -- no duplicate
        }
        if (count >= present.length) {
            System.out.println("Sheet full: " + studentName + " could not be marked");
            return;
        }
        present[count++] = studentName;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String studentName) {
        for (int i = 0; i < count; i++) {
            if (present[i].equals(studentName)) {
                return true;
            }
        }
        return false;
    }

    /** Deliberately absent: there is no method that returns the whole array. */

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");        // duplicate -- not counted again

        System.out.println("getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("isPresent(\"Ben\")  -> " + sheet.isPresent("Ben"));
        System.out.println("isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
