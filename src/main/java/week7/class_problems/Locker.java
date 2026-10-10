package week7.class_problems;

/**
 * Problem 4 - The Locker Code
 *
 * The combination is private with NO getter at all -- a "write-only"
 * property: a method to set it exists, but no method to read it exists.
 * changeCode() checks the old code first, before touching the field.
 * The locker number is final, fixed at creation.
 */
public class Locker {

    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public void changeCode(String currentCode, String newCode) {
        // Check the old code first -- if it fails the method does nothing else.
        if (!this.combination.equals(currentCode)) {
            System.out.println("Rejected: incorrect current code (locker " + lockerNumber + " unchanged)");
            return;
        }
        if (newCode == null || newCode.isEmpty()) {
            System.out.println("Rejected: the new code cannot be empty");
            return;
        }
        this.combination = newCode;
        System.out.println("Success: code changed for locker " + lockerNumber);
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    /** Deliberately absent: there is no getCombination(). */

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");   // success
        l.changeCode("0000", "9999");   // rejected -- wrong current code

        System.out.println("Locker number: " + l.getLockerNumber());
        System.out.println("The current combination cannot be read from outside the class.");
    }
}
