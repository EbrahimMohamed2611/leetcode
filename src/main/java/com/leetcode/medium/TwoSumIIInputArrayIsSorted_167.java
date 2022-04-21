package com.leetcode.medium;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIIInputArrayIsSorted_167 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));
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
    public static int[] twoSum2(int[] numbers, int target) {
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


    /**
     * Using Tow Pointers and BinarySearch
     * Time (logN)
     * space O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input Array Is Sorted.
     * Memory Usage: 44.8 MB, less than 95.18% of Java online submissions for Two Sum II - Input Array Is Sorted.
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int rightPointer = numbers.length - 1;
        int leftPointer = 0;
        int mid, currentSum;
        while (rightPointer > leftPointer) {
            currentSum = numbers[leftPointer] + numbers[rightPointer];
            mid = (rightPointer + leftPointer) / 2;
            if (currentSum == target)
                return new int[]{leftPointer + 1, rightPointer + 1};
            if (currentSum > target)
                rightPointer = (numbers[leftPointer] + numbers[mid] > target) ? mid : rightPointer - 1;
            if(currentSum < target)
                leftPointer = (numbers[mid] + numbers[rightPointer] < target) ? mid : leftPointer + 1;
        }
        return null;
    }
}
