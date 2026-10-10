package week6.class_problems;

/**
 * M3. Course Credit Management
 *
 * Two constructors so theory-only and lab courses are both supported
 * without writing the same setup logic twice: the three-argument version
 * chains to the four-argument one with this(...) and labCredits = 0.
 */
public class Course {

    private final String code;
    private final String title;
    private final int credits;
    private final int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    /** Theory-only course -- chains instead of duplicating the assignments. */
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }

    public void printTotal() {
        System.out.println(code + " total credits: " + totalCredits());
    }

    public static void main(String[] args) {
        Course theoryOnly = new Course("21CSC201J", "Data Structures", 4);
        Course withLab = new Course("21CSC205L", "DSA Lab", 3, 1);

        theoryOnly.printTotal();
        withLab.printTotal();
    }
}
