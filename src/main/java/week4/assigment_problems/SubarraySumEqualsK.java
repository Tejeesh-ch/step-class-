package week4.assigment_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Category C Assignment - A4: Subarray Sum Equals K
 *
 * Running prefix sums plus a hash map of prefix-sum frequencies: the sum of
 * subarray [i+1, j] is prefixSum[j] - prefixSum[i], so at each position we
 * need how many earlier prefix sums equal (currentSum - k).
 *
 * A sliding window would NOT work here because the array can contain
 * negative numbers, so the running sum is not monotonic.
 */
public class SubarraySumEqualsK {

    /** Suggested signature: int subarraySum(int[] nums, int k) */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);              // the empty prefix

        int runningSum = 0;
        int count = 0;

        for (int num : nums) {
            runningSum += num;
            count += prefixCounts.getOrDefault(runningSum - k, 0);
            prefixCounts.merge(runningSum, 1, Integer::sum);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("nums = [1, 1, 1], k = 2  ->  " + subarraySum(new int[] { 1, 1, 1 }, 2)
                + " (subarrays [1,1] at 0-1 and 1-2 both sum to 2)");
        System.out.println("nums = [1, -1, 0], k = 0  ->  " + subarraySum(new int[] { 1, -1, 0 }, 0));
    }
}
