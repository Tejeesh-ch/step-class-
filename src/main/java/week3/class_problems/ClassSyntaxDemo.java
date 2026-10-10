package week3.class_problems;

/**
 * Week 3 - OOP, Classes and Objects, Section 4: Class Definition and Syntax
 *
 * A class has three ingredients: FIELDS, CONSTRUCTOR, METHODS.
 * The constructor has the same name as the class and NO return type -- not
 * even void -- so an object can never exist half-built. `this` settles
 * field-vs-parameter name clashes.
 */
public class ClassSyntaxDemo {

    static class Course {
        // FIELDS -- private, because nobody outside should rewrite your grade point
        private String code;
        private String title;
        private int credits;
        private int gradePoint;

        // CONSTRUCTOR -- same name as the class, no return type
        public Course(String code, String title, int credits, int gradePoint) {
            this.code = code;            // 'this.code' is the field
            this.title = title;          // plain 'code' is the parameter
            this.credits = credits;
            this.gradePoint = gradePoint;
        }

        // METHODS -- behaviour that belongs to a course
        public int creditPoints() {
            return credits * gradePoint;
        }

        public void printCard() {
            System.out.println(code + " | " + title + " | " + credits
                    + " credits | GP " + gradePoint);
        }
    }

    public static void main(String[] args) {
        Course dsa = new Course("21CSC201J", "Data Structures", 4, 9);
        Course oops = new Course("21CSC203P", "Advanced Programming Practice", 3, 8);

        dsa.printCard();
        oops.printCard();

        System.out.println("Total credit points: "
                + (dsa.creditPoints() + oops.creditPoints()));
    }
}
