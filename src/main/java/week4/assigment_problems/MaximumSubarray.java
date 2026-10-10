package week4.assigment_problems;

/**
 * Category C Assignment - A2: Maximum Subarray
 *
 * Kadane's algorithm: at each element decide whether to extend the current
 * running subarray or abandon it and start fresh, whichever gives the
 * larger sum. All-negative input correctly returns the largest single value.
 */
public class MaximumSubarray {

    /** Suggested signature: int maxSubArray(int[] nums) */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums must contain at least one element");
        }

        int bestEndingHere = nums[0];
        int bestOverall = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // extend vs. restart -- pick whichever is larger
            bestEndingHere = Math.max(nums[i], bestEndingHere + nums[i]);
            bestOverall = Math.max(bestOverall, bestEndingHere);
        }
        return bestOverall;
    }

    public static void main(String[] args) {
        System.out.println("nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]  ->  "
                + maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 })
                + " (the subarray [4, -1, 2, 1] sums to 6)");
        System.out.println("nums = [-3, -1, -2]                     ->  "
                + maxSubArray(new int[] { -3, -1, -2 })
                + " (all negative -- best is the single largest value)");
    }
}
