package week5.class_problems;

import java.util.Arrays;

/**
 * Category C - Problem 1 (Easy): Hackathon Score Curve Booster
 *
 * An array parameter gives the method direct access to the same boxes the
 * caller has, so the scores are boosted in place and nothing is returned.
 */
public class HackathonScoreCurveBooster {

    /** static void curveScores(int[] scores, int bonus) */
    public static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = { 70, 85, 60 };
        curveScores(scores, 10);
        System.out.println("Before: [70, 85, 60]");
        System.out.println("After:  " + Arrays.toString(scores));
    }
}
