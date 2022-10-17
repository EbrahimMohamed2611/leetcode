package com.leetcode.easy;

public class MaximumAscendingSubarraySum_1800 {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Ascending Subarray Sum.
    Memory Usage: 41.6 MB, less than 55.65% of Java online submissions for Maximum Ascending Subarray Sum.
     */
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        int secondPointer = 1;

        while(secondPointer < nums.length){
            if(nums[secondPointer] > nums[secondPointer -1]){
                currentSum += nums[secondPointer];
                maxSum = Math.max(maxSum, currentSum);
            }else
                currentSum = nums[secondPointer];

            secondPointer++;
        }
        return maxSum;
    }
}
