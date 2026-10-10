package week6.class_problems;

/**
 * M5. Student and College Information Management
 *
 * The first draft stored the college name as an INSTANCE field, so every
 * student object carried its own copy of "SRM Institute of Science and
 * Technology". Fixed: collegeName and studentCount are static, shared by
 * every student.
 */
public class Student {

    private final String name;
    private int attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;                       // increments once per object, every time
    }

    /** Static method: must not reference any instance field. */
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Student ravi = new Student("Ravi", 82);
        Student anitha = new Student("Anitha", 68);

        // Called through the class name, not through either object.
        Student.printCollegeInfo();
    }
}
