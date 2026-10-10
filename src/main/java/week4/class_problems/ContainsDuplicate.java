package week4.class_problems;

/**
 * Category C Practice - L3: Contains Duplicate
 *
 * Nested loops compare every element against every element at a different
 * position, with an early exit as soon as a match is found.
 */
public class ContainsDuplicate {

    /** Suggested signature: boolean containsDuplicate(int[] nums) */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("nums = [1, 2, 3, 1]  ->  " + containsDuplicate(new int[] { 1, 2, 3, 1 })
                + " (the value 1 appears at two different positions)");
        System.out.println("nums = [1, 2, 3, 4]  ->  " + containsDuplicate(new int[] { 1, 2, 3, 4 })
                + " (every value is distinct)");
    }
}
