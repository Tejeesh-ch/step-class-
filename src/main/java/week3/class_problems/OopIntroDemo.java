package week3.class_problems;

/**
 * Week 3 - OOP, Classes and Objects, Section 1: What is OOP?
 *
 * The old way keeps name, regNo and attendance in three parallel variables.
 * OOP bundles them into a single unit so the data and the behaviour that
 * acts on it live together.
 *
 * Procedural thinking: What steps should my program perform?
 * OOP thinking:        What things exist, and what can each of them do?
 */
public class OopIntroDemo {

    /** One student: the DATA that describes them plus the BEHAVIOUR that belongs to them. */
    static class SrmStudent {
        String name;
        String regNo;
        int attendance;

        void checkExamEligibility() {
            if (attendance >= 75) {
                System.out.println(name + " (" + regNo + ") - " + attendance
                        + "% - Hall ticket released");
            } else {
                System.out.println(name + " (" + regNo + ") - " + attendance
                        + "% - Detained, meet your class advisor");
            }
        }
    }

    public static void main(String[] args) {
        SrmStudent s1 = new SrmStudent();
        s1.name = "Ravi";
        s1.regNo = "RA2311003010123";
        s1.attendance = 82;

        SrmStudent s2 = new SrmStudent();
        s2.name = "Anitha";
        s2.regNo = "RA2311003010124";
        s2.attendance = 68;

        s1.checkExamEligibility();
        s2.checkExamEligibility();
    }
}
