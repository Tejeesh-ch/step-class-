package week5.class_problems;

import java.util.Arrays;

/**
 * Category C - Problem 3 (Intermediate): Top-3 Podium Finder
 *
 * A single pass with three running variables -- no Arrays.sort. The ">="
 * comparisons are what let a genuine tie for first push both 90s onto the
 * podium and leave 82 in third place.
 */
public class TopThreePodiumFinder {

    /** static int[] findTopThreeScores(int[] scores) */
    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            throw new IllegalArgumentException("scores must contain at least 3 entries");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= first) {          // new highest: everything shifts down
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {  // a new second place
                third = second;
                second = score;
            } else if (score >= third) {   // a new third place
                third = score;
            }
        }
        return new int[] { first, second, third };
    }

    public static void main(String[] args) {
        int[] scores = { 45, 82, 79, 90, 33, 90, 61 };
        System.out.println(Arrays.toString(scores) + "  ->  "
                + Arrays.toString(findTopThreeScores(scores)));
    }
}
