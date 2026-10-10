package week1.class_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 4 - First Non-Repeating Character (Day 1 Live-Coding Session)
 *
 * The Unique Letter Hunt mini-game: find the first character that appears
 * only once in the entire input.
 */
public class FirstNonRepeatingCharacter {

    /** Returned when the input has no non-repeating character. */
    public static final char NONE = '\0';

    /** Suggested signature: char findFirstNonRepeatingChar(String text) */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return NONE;
        }

        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequency.merge(c, 1, Integer::sum);
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (frequency.getOrDefault(c, 0) == 1) {
                return c;
            }
        }
        return NONE;
    }

    private static void report(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result == NONE) {
            System.out.printf("%-12s -> No Non-Repeating Character Found%n", "\"" + text + "\"");
        } else {
            System.out.printf("%-12s -> First Non-Repeating Character: '%c'%n", "\"" + text + "\"", result);
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String text : args) {
                report(text);
            }
            return;
        }
        for (String text : new String[] { "swiss", "aabbcc", "success", "leetcode", "x" }) {
            report(text);
        }
    }
}
