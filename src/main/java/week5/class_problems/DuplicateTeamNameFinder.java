package week5.class_problems;

/**
 * Category C - Problem 2 (Easy): Duplicate Team Name Finder
 *
 * Plain nested loops, no Collections class. Each name is only compared
 * against the names after it, and the first duplicate found scanning in
 * order is reported.
 */
public class DuplicateTeamNameFinder {

    /** static String findDuplicateTeam(String[] teamNames) */
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null) {
            return "No Duplicates Found";
        }
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    private static void show(String[] teamNames) {
        System.out.println(java.util.Arrays.toString(teamNames) + "  ->  "
                + findDuplicateTeam(teamNames));
    }

    public static void main(String[] args) {
        show(new String[] { "ByteForce", "CodeCrafters", "ByteForce" });
        show(new String[] { "ByteForce", "CodeCrafters", "NullPointers" });
    }
}
