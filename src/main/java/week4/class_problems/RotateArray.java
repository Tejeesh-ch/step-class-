package week4.class_problems;

import java.util.Arrays;

/**
 * Category C Practice - L5: Rotate Array
 *
 * k is first reduced with k % length, then every element is placed at its
 * calculated wraparound position: newArray[(i + k) % length] = nums[i].
 */
public class RotateArray {

    /** Suggested signature: int[] rotateArray(int[] nums, int k) */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return (nums == null) ? null : new int[0];
        }

        k = k % nums.length;              // rotating by a multiple of the length does nothing
        int[] rotated = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        System.out.println("nums = [1, 2, 3, 4, 5, 6, 7], k = 3  ->  "
                + Arrays.toString(rotateArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3)));
        System.out.println("nums = [1, 2], k = 3                  ->  "
                + Arrays.toString(rotateArray(new int[] { 1, 2 }, 3))
                + " (k % length = 3 % 2 = 1, a single rotation)");
    }
}
