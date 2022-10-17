package com.leetcode.easy;

public class MergeSortedArray_88 {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
    Memory Usage: 42.8 MB, less than 58.34% of Java online submissions for Merge Sorted Array.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int midPointer = m - 1;
        int lastPointer = n - 1;
        int insertPosition = nums1.length - 1;
        while (lastPointer >= 0) {
            if (midPointer >= 0 && nums1[midPointer] > nums2[lastPointer]) {
                nums1[insertPosition--] = nums1[midPointer--];
            } else {
                nums1[insertPosition--] = nums2[lastPointer--];
            }
        }
    }
}
