package com.leetcode.easy;


/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray_26 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    /**
     * Using Two Pointer Technique
     * Time (N)
     * Space O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 44 MB, less than 84.79% of Java online submissions for Remove Duplicates from Sorted Array.
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int leftPointer = 1;
        for (int rightPointer = 1; rightPointer < nums.length; rightPointer++) {
            if (nums[rightPointer] != nums[rightPointer - 1]) {
                nums[leftPointer] = nums[rightPointer];
                ++leftPointer;
            }
        }
        return leftPointer;
    }
}
