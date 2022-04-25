package com.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));
    }

    /**
     * Using binary Search
     * Time O(logN)
     * space O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     * Memory Usage: 46.7 MB, less than 70.41% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int firstOccurrence = firstOrLastOccurrence(nums, target, true);
        int lastOccurrence = firstOrLastOccurrence(nums, target, false);

        if (firstOccurrence == -1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{firstOccurrence, lastOccurrence};
        }
    }

    private static int firstOrLastOccurrence(int[] numbers, int element, boolean isFirst) {
        int left = 0, right = numbers.length - 1, occurrencePosition = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] == element) {
                // for first occurrence
                if (isFirst) {
                    occurrencePosition = mid;
                    right = mid - 1;
                } else {
                    occurrencePosition = mid;
                    left = mid + 1;
                }
            } else if (numbers[mid] < element) {
                left = mid + 1;
            } else {
                right = mid - 1;

            }
        }
        return occurrencePosition;
    }
}
