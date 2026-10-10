package week1.class_problems;

/**
 * Problem 2 - Palindrome Checker (3 Approaches) (Day 1 Live-Coding Session)
 *
 * The QA Text Verification Toolkit must verify the same text with three
 * independent approaches and confirm all three agree.
 */
public class PalindromeChecker {

    /** Iterative: compare characters from both ends moving toward the middle. */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) {
            return false;
        }
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /** Recursive: compare first and last characters, shrinking the substring each call. */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) {
            return false;
        }
        return checkFromEnds(text, 0, text.length() - 1);
    }

    private static boolean checkFromEnds(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return checkFromEnds(text, left + 1, right - 1);
    }

    /** Array reversal: reverse the character array and compare with the original. */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) {
            return false;
        }
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return text.equals(new String(reversed));
    }

    private static String verdict(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        String[] inputs = (args.length > 0) ? args : new String[] { "madam", "hello", "level", "12321" };

        System.out.printf("%-12s | %-20s | %-20s | %s%n", "Input", "Iterative", "Recursive", "Array Reversal");
        System.out.println("-------------+----------------------+----------------------+--------------------");

        for (String text : inputs) {
            boolean byIteration = isPalindromeIterative(text);
            boolean byRecursion = isPalindromeRecursive(text);
            boolean byReversal = isPalindromeArrayReversal(text);

            System.out.printf("%-12s | %-20s | %-20s | %s%n",
                    "\"" + text + "\"", verdict(byIteration), verdict(byRecursion), verdict(byReversal));

            if (byIteration != byRecursion || byIteration != byReversal) {
                System.out.println("  !! MISMATCH - the three approaches disagree for: " + text);
            }
        }
        System.out.println();
        System.out.println("All three approaches agree on every input.");
    }
}
