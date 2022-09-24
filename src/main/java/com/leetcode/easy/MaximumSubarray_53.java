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
        // use thi variable to determine if the next number will increase the current or not if is then add it the current max
        int currentMax = nums[0];
        // use this variable to store the max sub so fare about compare it with the current
        int maxSubArraySoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax =  Math.max(nums[i],nums[i]+currentMax);

            if(maxSubArraySoFar < currentMax)
                maxSubArraySoFar = currentMax;
        }
        return maxSubArraySoFar;
    }
}
