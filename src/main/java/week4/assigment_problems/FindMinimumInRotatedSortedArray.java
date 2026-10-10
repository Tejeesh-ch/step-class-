package week4.assigment_problems;

/**
 * Category C Assignment - A5: Find Minimum in Rotated Sorted Array
 *
 * A modified binary search: compare the middle element with the rightmost
 * element to decide which half must contain the minimum. The already-sorted
 * (never rotated) case falls out of the same comparison.
 */
public class FindMinimumInRotatedSortedArray {

    /** Suggested signature: int findMin(int[] nums) */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums must contain at least one element");
        }

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                // the pivot (and so the minimum) is to the right of mid
                low = mid + 1;
            } else {
                // mid is inside the sorted run -- minimum is at mid or to its left
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println("nums = [3, 4, 5, 1, 2]        ->  " + findMin(new int[] { 3, 4, 5, 1, 2 }));
        System.out.println("nums = [4, 5, 6, 7, 0, 1, 2]  ->  " + findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
        System.out.println("nums = [11, 13, 15, 17]       ->  " + findMin(new int[] { 11, 13, 15, 17 })
                + " (no rotation actually occurred)");
    }
}
