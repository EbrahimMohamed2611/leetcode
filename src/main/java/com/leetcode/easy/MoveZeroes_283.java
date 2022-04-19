package com.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] numbers = {0, 1, 0, 3, 12};
        int[] numbers2 = {5, 1, 6, 0, 12};
        moveZeroes(numbers);
        moveZeroes(numbers2);
        System.out.println(Arrays.toString(numbers2));
    }


    /**
     * Using Two Pointers
     * O(N)
     * Space O(1)
     * @param nums
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Move Zeroes.
     * Memory Usage: 44.1 MB, less than 78.16% of Java online submissions for Move Zeroes.
     */
    public static void moveZeroes(int[] nums) {

        int leftPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[leftPointer];
                nums[leftPointer] = temp;
                leftPointer += 1;
            }
        }
    }
}
