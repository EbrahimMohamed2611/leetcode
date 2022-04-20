package com.leetcode.medium;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIIInputArrayIsSorted_167 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    /**
     * using two pointer
     * Runtime: 1 ms, faster than 99.43% of Java online submissions for Two Sum II - Input Array Is Sorted.
     * Memory Usage: 45.1 MB, less than 86.48% of Java online submissions for Two Sum II - Input Array Is Sorted.
     * <p>
     * Time O(N)
     * Space O(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int rightPointer = numbers.length - 1;
        int leftPointer = 0;

        while (rightPointer > leftPointer) {
            if (numbers[rightPointer] + numbers[leftPointer] > target)
                rightPointer -= 1;
            else if (numbers[rightPointer] + numbers[leftPointer] < target)
                leftPointer += 1;
            else
                return new int[]{leftPointer + 1, rightPointer + 1};

        }
        return null;
    }
}
