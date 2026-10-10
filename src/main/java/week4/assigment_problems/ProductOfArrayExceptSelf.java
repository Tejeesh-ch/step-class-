package week4.assigment_problems;

import java.util.Arrays;

/**
 * Category C Assignment - A1: Product of Array Except Self
 *
 * O(n) with two passes and no division anywhere: a forward pass fills each
 * index with the running product of everything to its left, a backward pass
 * multiplies in the running product of everything to its right.
 */
public class ProductOfArrayExceptSelf {

    /** Suggested signature: int[] productExceptSelf(int[] nums) */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int runningLeft = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = runningLeft;
            runningLeft *= nums[i];
        }

        int runningRight = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= runningRight;
            runningRight *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("nums = [1, 2, 3, 4]        ->  "
                + Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
        System.out.println("nums = [-1, 1, 0, -3, 3]    ->  "
                + Arrays.toString(productExceptSelf(new int[] { -1, 1, 0, -3, 3 }))
                + " (a single zero forces every OTHER position to 0)");
    }
}
