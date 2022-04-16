package com.leetcode.easy;


import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;

/**
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber_136 {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1, 2};
//        System.out.println(singleNumber(numbers));
//        System.out.println(singleNumberV2(numbers));
        System.out.println(singleNumberV3(numbers));
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number.
     * Memory Usage: 42.5 MB, less than 84.50% of Java online submissions for Single Number.
     *
     * @param nums
     * @return single number
     */
    public static int singleNumber(int[] nums) {

        // Constant space
        int result = 0; //  n XOR 0 ==> n
        // O(n) linear solution
        for (int num : nums) {
            result = num ^ result;
        }
        return result;
    }


    public static int singleNumberV2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i+=2) {
            // because it sorted and every element appears twice except one
            if(nums[i] != nums[i-1])
                return nums[i];
        }
        // because always number of elements will be odd
        return nums[nums.length -1];
    }

    /**
     * using hashtable
     */
    public static int singleNumberV3(int[] nums) {
        // Space Complexity O(n)
        HashSet<Integer> set = new HashSet<>();
        int a = 0;
        for (int i : nums) {
            if (!set.add(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
//        System.out.println(set);
        return set.stream().findFirst().get();
//        return a;
    }
}
