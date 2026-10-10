package week1.assigment_problems;

/**
 * Week 1 Assignment - Problem 2: The Typing Speed Test Accuracy Checker
 *
 * Compares two equal-length strings position by position, reports the match
 * count, the accuracy percentage and the first mismatch.
 */
public class TypingSpeedTestAccuracyChecker {

    /** Suggested signature: void checkTypingAccuracy(String original, String typed) */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input");
            return;
        }

        int total = original.length();
        int limit = Math.min(original.length(), typed.length());
        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < limit; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }
        // Lengths differ: the extra characters cannot match either.
        if (typed.length() != original.length() && firstMismatch == -1) {
            firstMismatch = limit;
        }

        double accuracy = (total == 0) ? 100.0 : (matched * 100.0) / total;

        if (firstMismatch == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n", matched, total, accuracy);
            return;
        }

        char expected = (firstMismatch < original.length()) ? original.charAt(firstMismatch) : ' ';
        char actual = (firstMismatch < typed.length()) ? typed.charAt(firstMismatch) : ' ';
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                matched, total, accuracy, firstMismatch + 1, expected, actual);
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
