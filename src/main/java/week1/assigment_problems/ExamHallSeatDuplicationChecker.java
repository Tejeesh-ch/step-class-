package week1.assigment_problems;

/**
 * Week 1 Assignment - Problem 1: The Exam Hall Seat Duplication Checker
 *
 * Arrays and loops only -- no Collections class.
 */
public class ExamHallSeatDuplicationChecker {

    /** Suggested signature: void checkDuplicateSeats(int[] seatNumbers) */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean foundAny = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            // Only report seatNumbers[i] if it is the FIRST index holding that value,
            // otherwise the same duplicate would be printed once per extra occurrence.
            boolean firstOccurrence = true;
            for (int prev = 0; prev < i; prev++) {
                if (seatNumbers[prev] == seatNumbers[i]) {
                    firstOccurrence = false;
                    break;
                }
            }
            if (!firstOccurrence) {
                continue;
            }

            // Is this value repeated anywhere later?
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundAny = true;
                    break;
                }
            }
        }

        if (!foundAny) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.print("{101, 102, 103, 102, 105}  ->  ");
        checkDuplicateSeats(new int[] { 101, 102, 103, 102, 105 });

        System.out.print("{101, 102, 103, 104, 105}  ->  ");
        checkDuplicateSeats(new int[] { 101, 102, 103, 104, 105 });

        System.out.print("{7, 7, 7, 9, 9}            ->  ");
        checkDuplicateSeats(new int[] { 7, 7, 7, 9, 9 });
    }
}
