package com.leetcode.hard;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
/* Amazon Apple  Microsoft  Facebook Google Uber  Oracle  */
public class FindMinimumInRotatedSortedArray_154 {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array II.
    Memory Usage: 41.7 MB, less than 99.22% of Java online submissions for Find Minimum in Rotated Sorted Array II.
     */
    public int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (high > low) {
            mid = (high + low) / 2;
            if (arr[mid] < arr[high])
                high = mid;
            else if (arr[mid] > arr[high])
                low = mid + 1;
            else {
                high--; // if its equal we can ignore the high and depend on the middle Value (both have the same value)
            }
        }

        return arr[high];
    }
}
