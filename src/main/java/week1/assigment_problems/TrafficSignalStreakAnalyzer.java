package week1.assigment_problems;

/**
 * Week 1 Assignment - Problem 3: The Traffic Signal Streak Analyzer
 *
 * Scans a log of signal readings ('R', 'Y', 'G') and reports the longest
 * continuous streak of the same colour.
 */
public class TrafficSignalStreakAnalyzer {

    /** Suggested signature: void findLongestStreak(String signalLog) */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Empty signal log");
            return;
        }

        char bestColor = signalLog.charAt(0);
        int bestLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if (c == currentColor) {
                currentLength++;
            } else {
                currentColor = c;
                currentLength = 1;
            }
            // Strict '>' keeps the FIRST streak in case of a tie.
            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + bestColor + "' repeated " + bestLength
                + (bestLength == 1 ? " time" : " times"));
    }

    public static void main(String[] args) {
        System.out.print("\"RRGGGYRR\"  ->  ");
        findLongestStreak("RRGGGYRR");

        System.out.print("\"RRRRYYGG\"  ->  ");
        findLongestStreak("RRRRYYGG");

        System.out.print("\"GYRGYG\"    ->  ");
        findLongestStreak("GYRGYG");
    }
}
