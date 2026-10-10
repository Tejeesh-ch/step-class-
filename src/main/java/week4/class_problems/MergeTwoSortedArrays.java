package week4.class_problems;

import java.util.Arrays;

/**
 * Category C Practice - L4: Merge Two Sorted Arrays
 *
 * Two index pointers start at 0; a while loop copies the smaller of the
 * two current elements each time. Once one array is exhausted the rest of
 * the other is copied straight onto the end.
 */
public class MergeTwoSortedArrays {

    /** Suggested signature: int[] mergeSortedArrays(int[] arr1, int[] arr2) */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] safe1 = (arr1 == null) ? new int[0] : arr1;
        int[] safe2 = (arr2 == null) ? new int[0] : arr2;

        int[] result = new int[safe1.length + safe2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < safe1.length && j < safe2.length) {
            if (safe1[i] <= safe2[j]) {
                result[k++] = safe1[i++];
            } else {
                result[k++] = safe2[j++];
            }
        }
        while (i < safe1.length) {
            result[k++] = safe1[i++];
        }
        while (j < safe2.length) {
            result[k++] = safe2[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("arr1 = [1, 3, 5], arr2 = [2, 4, 6]  ->  "
                + Arrays.toString(mergeSortedArrays(new int[] { 1, 3, 5 }, new int[] { 2, 4, 6 })));
        System.out.println("arr1 = [],        arr2 = [1, 2, 3]  ->  "
                + Arrays.toString(mergeSortedArrays(new int[0], new int[] { 1, 2, 3 })));
    }
}
