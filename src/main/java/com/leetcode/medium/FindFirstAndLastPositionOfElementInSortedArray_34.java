package com.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    /**
     * Using binary Search
     * Time O(logN)
     * space O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     * Memory Usage: 46.7 MB, less than 70.41% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     *
     * @param array
     * @param key
     * @return
     */
    public static int[] searchRange(int[] array, int key) {
        int[] range = new int[]{-1, -1};
        int start = 0, end = array.length - 1;

        int startRange = binarySearch(start, end, array, key, true);
        if (startRange == -1)
            return range;
        range[0] = startRange;
        int endRange = binarySearch(startRange, end, array, key, false);
        range[1] = endRange;
        return range;
    }

    private static int binarySearch(int start, int end, int[] array, int key, boolean isFirstIndex) {
        int mid;
        int index = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] == key) {
                index = mid;
                if (isFirstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (key > array[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }
}
