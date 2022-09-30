package com.leetcode.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllNumbersDisappearedInAnArray_448 {


    // Using Cycle Sort
    // Amazon Apple Google Microsoft Adobe

    /*
    Runtime: 5 ms, faster than 97.68% of Java online submissions for Find All Numbers Disappeared in an Array.
    Memory Usage: 50.4 MB, less than 92.65% of Java online submissions for Find All Numbers Disappeared in an Array.
     */
    public static List<Integer> findDisappearedNumbers4(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int pointer = 0;
        while (pointer < nums.length) {
            int current = nums[pointer] - 1;
            if (nums[pointer] == nums[current])
                pointer++;
            else
                swap(nums, pointer, current);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i])
                missingNumbers.add(i + 1);
        }

        return missingNumbers;
    }

    private static void swap(int[] nums, int firstPosition, int secondPosition) {
        int temp = nums[firstPosition];
        nums[firstPosition] = nums[secondPosition];
        nums[secondPosition] = temp;
    }


    public static void main(String[] args) {
//        int[] nums = {4,2,2,1,5};
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums2 = {1, 1};
        System.out.println(findDisappearedNumbers(nums));
//        System.out.println(findDisappearedNumbers(nums2));
    }


    /**
     * Using Frequency Array
     * Time O(N)
     * space O(1)
     * Runtime: 6 ms, faster than 80.65% of Java online submissions for Find All Numbers Disappeared in an Array.
     * Memory Usage: 50.2 MB, less than 92.63%
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            int i = Math.abs(num) - 1;
            nums[i] = -1 * Math.abs(nums[i]);
        }
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                missingNumbers.add(i + 1);
        }

        return missingNumbers;
    }


    /**
     * Using Frequency Array
     * Time O(N)
     * space O(N)
     * Runtime: 3 ms, faster than 100.00% of Java online submissions for Find All Numbers Disappeared in an Array.
     * Memory Usage: 50.1 MB, less than 95.31% of Java online submissions for Find All Numbers Disappeared in an Array.
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        int[] freq = new int[nums.length + 1];
        List<Integer> missingNumbers = new ArrayList<>();
        for (int num : nums) {
            freq[num] = 1;
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0)
                missingNumbers.add(i);
        }
        return missingNumbers;
    }

    /**
     * Time Limit Exceeded
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            numbers.add(i);
        }

        for (Integer num : nums) {
            numbers.remove(num);
        }
        return numbers;
    }
}
