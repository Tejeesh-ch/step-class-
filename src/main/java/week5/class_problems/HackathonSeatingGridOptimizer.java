package week5.class_problems;

/**
 * Category C - Problem 4 (Intermediate): Hackathon Seating Grid Optimizer
 *
 * rowAverage() does nothing except compute one row's average; the outer
 * loop in classifyRows() is the only place that decides Quiet vs Buzzing.
 * Rows may vary in length (jagged grid).
 */
public class HackathonSeatingGridOptimizer {

    /** static double rowAverage(int[] row) */
    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }

    /** static String classifyRows(int[][] seatingScores, int threshold) */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder report = new StringBuilder();
        for (int row = 0; row < seatingScores.length; row++) {
            if (row > 0) {
                report.append(" | ");
            }
            String zone = (rowAverage(seatingScores[row]) < threshold) ? "Quiet Zone" : "Buzzing Zone";
            report.append("Row ").append(row).append(": ").append(zone);
        }
        return report.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
                { 40, 50, 45 },
                { 85, 90, 95 },
                { 30, 20, 25 }
        };
        System.out.println(classifyRows(seatingScores, 60));

        int[][] jagged = { { 100, 90 }, { 10, 20, 30, 40 } };
        System.out.println(classifyRows(jagged, 60));
    }
}
