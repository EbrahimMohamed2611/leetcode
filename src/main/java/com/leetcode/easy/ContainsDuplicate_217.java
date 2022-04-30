package com.leetcode.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate_217 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 1, 2, 3, 4, 5}));
        System.out.println(containsDuplicate1(new int[]{1, 1, 2, 3, 4, 5}));
    }

    /**
     * Time O(NLogN)
     * Space O(1)
     * Runtime: 27 ms, faster than 12.64% of Java online submissions for Contains Duplicate.
     * Memory Usage: 71.7 MB, less than 16.05% of Java online submissions for Contains Duplicate.
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    /**
     * Time O(N)
     * Space O(N)
     Runtime: 9 ms, faster than 76.08% of Java online submissions for Contains Duplicate.
     Memory Usage: 71.4 MB, less than 20.34% of Java online submissions for Contains Duplicate.
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums){

            if (numbers.contains(num))
                return true;
            numbers.add(num);
        }

        return false;
    }
}
