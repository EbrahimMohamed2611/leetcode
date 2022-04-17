package com.leetcode.easy;

public class MaximumSubarray_53 {
    public static void main(String[] args) {
        int[] numbers = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] numbers2 = {5, 4, -1, 7, 8};
        int[] numbers3 = {-1, -2, -3};
        int[] numbers4 = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArray(numbers));
        System.out.println(maxSubArray(numbers2));
        System.out.println(maxSubArray(numbers3));
        System.out.println(maxSubArray2(numbers));
        System.out.println(maxSubArray2(numbers2));
        System.out.println(maxSubArray2(numbers3));
        System.out.println(maxSubArray2(numbers4));
    }

    /**
     * Status: Time Limit Exceeded
     * O(N^2)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum > maxSum)
                    maxSum = currentSum;
            }
        }
        return maxSum;
    }

    /**
     * Kadane’s Algorithm
     * O(N)
     * <p>
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
     * Memory Usage: 51.4 MB, less than 95.24% of Java online submissions for Maximum Subarray.
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {

        int maxSum = nums[0], currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (currentSum > maxSum)
                maxSum = currentSum;
            if (currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }
}
