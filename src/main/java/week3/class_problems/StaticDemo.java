package week3.class_problems;

/**
 * Week 3 - OOP, Classes and Objects, Section 6: Instance vs Class (static) Members
 *
 * Ask one question per field: does every object need its own copy, or is
 * there only ever one of these for the whole college?
 *
 * A static method cannot touch instance fields or `this` -- it belongs to
 * the class, not to any object. That is why main is static: the JVM has to
 * call it before any object exists.
 */
public class StaticDemo {

    static class SrmStudent {
        String name;                                   // INSTANCE: yours alone
        String regNo;                                  // INSTANCE: yours alone

        static String university = "SRM Institute of Science and Technology";
        static String campus = "SRM Kattankulathur";   // STATIC: one for everyone
        static int admissionCount = 0;                 // STATIC: shared counter

        SrmStudent(String name) {
            this.name = name;
            admissionCount++;                          // same counter, every time
            this.regNo = "RA23110030101" + admissionCount;
        }

        void printIdCard() {                           // instance method: needs an object
            System.out.println(regNo + " | " + name + " | " + campus);
        }

        static void printTotalAdmissions() {           // static method: called on the class
            System.out.println("Students admitted so far: " + admissionCount);
            // System.out.println(name);               // ERROR -- whose name, exactly?
        }
    }

    public static void main(String[] args) {
        SrmStudent ravi = new SrmStudent("Ravi");
        SrmStudent meera = new SrmStudent("Meera");

        ravi.printIdCard();
        meera.printIdCard();

        SrmStudent.printTotalAdmissions();             // no object needed

        SrmStudent.campus = "SRM Ramapuram";           // one line, every student transferred
        ravi.printIdCard();
        meera.printIdCard();
    }
}
