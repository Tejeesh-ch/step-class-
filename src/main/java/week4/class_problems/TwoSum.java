package week4.class_problems;

import java.util.Arrays;

/**
 * Category C Practice - L1: Two Sum
 *
 * Two nested loops check every pair of distinct positions; the first pair
 * that adds up to the target is returned immediately.
 */
public class TwoSum {

    /** Suggested signature: int[] twoSum(int[] nums, int target) */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println("nums = [2, 7, 11, 15], target = 9  ->  "
                + Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
        System.out.println("nums = [3, 2, 4], target = 6        ->  "
                + Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
    }
}
