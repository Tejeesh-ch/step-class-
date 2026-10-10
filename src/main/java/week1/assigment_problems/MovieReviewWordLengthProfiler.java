package week1.assigment_problems;

/**
 * Week 1 Assignment - Problem 5: The Movie Review Word Length Profiler
 *
 * Splits a review into words and counts how many are Short (1-4 letters),
 * Medium (5-8 letters) and Long (9+ letters).
 */
public class MovieReviewWordLengthProfiler {

    /** Suggested signature: void classifyWordLengths(String review) */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {
            int length = word.length();
            if (length <= 4) {
                shortWords++;
            } else if (length <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords + " | Medium: " + mediumWords + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        System.out.print("\"This movie was absolutely fantastic and thrilling\"  ->  ");
        classifyWordLengths("This movie was absolutely fantastic and thrilling");

        System.out.print("\"A truly wonderful journey across distant stars\"     ->  ");
        classifyWordLengths("A truly wonderful journey across distant stars");
    }
}
