package com.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 *
 *
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 */
public class RunningSumOf1dArray_1480 {
    public static void main(String[] args) {
        int[] numbers = {3,1,2,10,1};
//        runningSum(numbers);
        runningSumV2(numbers);

    }

    private static int[] runningSum(int[] nums) {
/**
 * Runtime: 3 ms, faster than 6.42% of Java online submissions for Running Sum of 1d Array.
 * Memory Usage: 44.1 MB, less than 5.43% of Java online submissions for Running Sum of 1d Array.
 */
        int[] resultSum = new int[nums.length];
        resultSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            resultSum[i] = resultSum[i-1] + nums[i];
        }
        System.out.println(Arrays.toString(resultSum));
        return resultSum;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Running Sum of 1d Array.
     * Memory Usage: 43.5 MB, less than 38.91% of Java online submissions for Running Sum of 1d Array.
     * @param nums
     * @return int[]
     */
    private static int[] runningSumV2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1] ;
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
