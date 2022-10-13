package com.leetcode.medium;

public class ProductOfArrayExceptSelf_238 {
    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
Memory Usage: 50.6 MB, less than 90.67% of Java online submissions for Product of Array Except Self.
     */
    public int[] productExceptSelf2(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        result[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            result[i] = nums[i + 1] * result[i + 1];
        }
        int left = 1;
        for (int i = 0; i < size; i++) {
            result[i] = result[i] * left;
            left = left * nums[i];
        }
        return result;
    }

    /*
    Runtime: 3 ms, faster than 67.86% of Java online submissions for Product of Array Except Self.
Memory Usage: 56.9 MB, less than 83.06% of Java online submissions for Product of Array Except Self.
     */
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] right = new int[size];
        right[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        int[] left = new int[size];
        left[0] = 1;
        for (int i = 1; i < size; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        int[] result = new int[size];
        for (int i = 0; i < size; i++)
            result[i] = right[i] * left[i];

        return result;
    }
}
