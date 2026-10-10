package week7.class_problems;

/**
 * Problem 2 - The Quiz Scorecard
 *
 * The results live in a private boolean[] filled in one answer at a time.
 * Only the total score is ever exposed -- never the array itself, in any
 * form. The number of questions is fixed at construction.
 */
public class Scorecard {

    private final boolean[] results;
    private int recorded;              // how many answers recorded so far

    public Scorecard(int questionCount) {
        if (questionCount <= 0) {
            throw new IllegalArgumentException("questionCount must be positive");
        }
        this.results = new boolean[questionCount];
    }

    public void recordAnswer(boolean correct) {
        if (recorded >= results.length) {
            System.out.println("Ignored: all " + results.length + " answers are already recorded");
            return;
        }
        results[recorded++] = correct;
    }

    /** Exposes only the count of correct answers -- the array never leaves the class. */
    public int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("getScore() -> " + sc.getScore());
        sc.recordAnswer(true);              // beyond the fixed question count
    }
}
