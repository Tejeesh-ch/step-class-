package week5.class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Category C - Problem 5 (Advanced): Placement Drive Shortlisting &amp; Ranking Engine
 *
 * Topics integrated: arrays, method overloading, static methods,
 * Arrays.sort(), constructors and encapsulation.
 *
 * Eligibility has two rules -- a strong CGPA alone is enough, while a
 * borderline CGPA can still qualify through a genuinely good coding score.
 * Once shortlisted, Candidate.compareTo() lets Arrays.sort() do the ranking.
 */
public class PlacementDriveShortlistingAndRanking {

    /** The CGPA-only quick filter. */
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    /** The combined filter for borderline CGPAs: also needs a strong coding score. */
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> shortlisted = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (isEligible(candidate.getCgpa()) || isEligible(candidate.getCgpa(), candidate.getCodingScore())) {
                shortlisted.add(candidate);
            }
        }

        // Candidate implements Comparable, so this sort alone does the ranking.
        Candidate[] ranked = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(ranked);

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < ranked.length; i++) {
            if (i > 0) {
                line.append(" | ");
            }
            line.append(i + 1).append(". ").append(ranked[i]);
        }
        return line.toString();
    }

    public static void main(String[] args) {
        Candidate[] batch = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println("Shortlisted and ranked:");
        System.out.println(shortlistAndRank(batch));

        System.out.println();
        for (Candidate candidate : batch) {
            System.out.println(candidate.getName()
                    + " -> CGPA-only: " + isEligible(candidate.getCgpa())
                    + " | Combined: " + isEligible(candidate.getCgpa(), candidate.getCodingScore()));
        }
    }
}
