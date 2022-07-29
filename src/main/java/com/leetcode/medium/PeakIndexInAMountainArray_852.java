package com.leetcode.medium;

public class PeakIndexInAMountainArray_852 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
     * Memory Usage: 73.5 MB, less than 5.01% of Java online submissions for Peak Index in a Mountain Array.
     */
    public int peakIndexInMountainArray(int[] arr) {
        int mid;
        int start = 0;
        int end = arr.length - 1;
        while (end > start) { // OR while (end != start) {
            mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
