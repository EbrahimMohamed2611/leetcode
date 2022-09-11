package com.leetcode.easy;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers_628 {
    /*
    Runtime: 12 ms, faster than 71.42% of Java online submissions for Maximum Product of Three Numbers.
    Memory Usage: 43.6 MB, less than 92.21% of Java online submissions for Maximum Product of Three Numbers.
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int firstTwoAndTheLast = nums[0] * nums[1] * nums[nums.length-1];
        int lastThreeElements = nums[nums.length-3] * nums[nums.length-2] * nums[nums.length-1];
        return Math.max(firstTwoAndTheLast, lastThreeElements);
    }
}
