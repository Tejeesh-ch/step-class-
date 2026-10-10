package week8.class_problems;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Problem 4 - Examination Question Grader
 *
 * Each question type evaluates an answer by its own grading criteria; the
 * central grader processes all questions uniformly.
 *
 * Business rules:
 *   MCQ   -- full points when the student answer exactly matches
 *   TF    -- full points when the student answer exactly matches
 *   ESSAY -- keywords come comma-separated from the correct answer.
 *            2+ keywords present (case-insensitive) -> 75% of the points
 *            1 keyword present                      -> 50% of the points
 *            otherwise                              -> 0
 */
public class ExaminationQuestionGrader {

    private static final Pattern QUOTED = Pattern.compile("\"([^\"]*)\"");

    interface Grader {
        String type();
        double score(String correctAnswer, String studentAnswer, int points);
    }

    static class McqGrader implements Grader {
        public String type() { return "MCQ"; }
        public double score(String correct, String student, int points) {
            return correct.equals(student) ? points : 0;
        }
    }

    static class TrueFalseGrader implements Grader {
        public String type() { return "TF"; }
        public double score(String correct, String student, int points) {
            return correct.equals(student) ? points : 0;
        }
    }

    static class EssayGrader implements Grader {
        public String type() { return "ESSAY"; }
        public double score(String correct, String student, int points) {
            String studentLower = student.toLowerCase(Locale.ROOT);
            String[] keywords = correct.split(",");
            int hits = 0;
            for (String keyword : keywords) {
                if (!keyword.trim().isEmpty()
                        && studentLower.contains(keyword.trim().toLowerCase(Locale.ROOT))) {
                    hits++;
                }
            }
            if (hits >= 2) {
                return points * 0.75;
            }
            if (hits == 1) {
                return points * 0.50;
            }
            return 0;
        }
    }

    static Grader graderFor(String type) {
        switch (type) {
            case "MCQ":   return new McqGrader();
            case "TF":    return new TrueFalseGrader();
            case "ESSAY": return new EssayGrader();
            default:      return null;
        }
    }

    /** Splits `TYPE "question" "correct" "student" points` into its four parts. */
    static String[] parse(String line) {
        Matcher matcher = QUOTED.matcher(line);
        java.util.List<String> quoted = new java.util.ArrayList<>();
        while (matcher.find()) {
            quoted.add(matcher.group(1));
        }
        if (quoted.size() < 3) {
            return null;
        }
        int lastQuote = line.lastIndexOf('"');
        String pointsPart = line.substring(lastQuote + 1).trim();
        String type = line.substring(0, line.indexOf('"')).trim();
        return new String[] { type, quoted.get(0), quoted.get(1), quoted.get(2), pointsPart };
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextLine()) {
            System.out.println("No input provided.");
            return;
        }

        int n = Integer.parseInt(in.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n && in.hasNextLine(); i++) {
            String[] parsed = parse(in.nextLine());
            if (parsed == null) {
                continue;
            }
            Grader grader = graderFor(parsed[0]);
            if (grader == null) {
                continue;
            }
            int points = Integer.parseInt(parsed[4]);
            double score = grader.score(parsed[2], parsed[3], points);
            total += score;
            System.out.printf(Locale.US, "%s: %.2f%n", grader.type(), score);
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}
