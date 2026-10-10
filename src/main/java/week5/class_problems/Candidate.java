package week5.class_problems;

/**
 * Category C - Problem 5 (Advanced): the candidate model.
 *
 * Implements Comparable&lt;Candidate&gt; so that a plain Arrays.sort() ranks a
 * shortlisted array by composite score, descending, with no separate
 * comparison logic written anywhere else.
 *
 * Composite score = (cgpa * 10) + (codingScore * 0.5)
 */
public class Candidate implements Comparable<Candidate> {

    private final String name;
    private final double cgpa;
    private final int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    /** The combined score used to rank shortlisted candidates. */
    public double compositeScore() {
        return (cgpa * 10.0) + (codingScore * 0.5);
    }

    /** Descending: the best composite score sorts first. */
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore(), this.compositeScore());
    }

    @Override
    public String toString() {
        return name + " (" + compositeScore() + ")";
    }
}
