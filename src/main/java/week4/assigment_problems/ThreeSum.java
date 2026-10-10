package week4.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Category C Assignment - A3: 3Sum
 *
 * Sort first, then for each element sweep the remaining subarray with two
 * pointers moving inward. Duplicates are skipped at every level, which is
 * the single most common source of bugs in this problem.
 */
public class ThreeSum {

    /** Suggested signature: int[][] threeSum(int[] nums) */
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> results = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;                       // skip duplicate anchors
            }
            int lo = i + 1;
            int hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    results.add(new int[] { nums[i], nums[lo], nums[hi] });
                    while (lo < hi && nums[lo] == nums[lo + 1]) {
                        lo++;                   // skip duplicate left values
                    }
                    while (lo < hi && nums[hi] == nums[hi - 1]) {
                        hi--;                   // skip duplicate right values
                    }
                    lo++;
                    hi--;
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return results.toArray(new int[0][]);
    }

    private static void show(int[] nums) {
        System.out.println("nums = " + Arrays.toString(nums) + "  ->  "
                + Arrays.deepToString(threeSum(nums)));
    }

    public static void main(String[] args) {
        show(new int[] { -1, 0, 1, 2, -1, -4 });
        show(new int[] { 0, 0, 0 });
        show(new int[] { -2, 0, 1, 1, 2 });
    }
}
