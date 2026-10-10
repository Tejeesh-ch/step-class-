package week2.assigment_problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Week 2 Assignment - Problem 5: Stop-Word-Filtered Word Frequency Report
 *
 * Lowercases and strips punctuation, splits on whitespace, skips the fixed
 * stop-word list, counts the remaining words and prints them sorted by
 * count (descending). Ties keep their first-seen order.
 */
public class StopWordFilteredWordFrequency {

    private static final String[] STOP_WORDS = { "the", "was", "and", "a", "is", "of", "in" };

    /** Suggested signature: void printFilteredWordFrequency(String feedback) */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");

        // LinkedHashMap keeps first-seen order so ties are printed deterministically.
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : words) {
            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());
        entries.sort(Comparator.comparingInt((Map.Entry<String, Integer> e) -> e.getValue()).reversed());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static boolean isStopWord(String word) {
        for (String stop : STOP_WORDS) {
            if (stop.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
