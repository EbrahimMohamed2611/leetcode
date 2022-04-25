package com.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber_268 {
    public static void main(String[] args) {
        System.out.println(10 ^ 9 ^10);
//        System.out.println(22 & 1);
        System.out.println(missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber(new int[]{0,1}));
    }


    /**
     * Using XOR
     * Time O(N)
     * Space O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
     * Memory Usage: 51.9 MB, less than 13.52% of Java online submissions for Missing Number.
     * @param nums array
     * @return missing Number from range 0 -> n
     */
    public static int missingNumber(int[] nums) {
        int xor = 0, i;
        for (i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }

        return xor ^ i;
    }

    /**
     * Time(NlogN)
     * Space O(1)
     * Runtime: 8 ms, faster than 17.06% of Java online submissions for Missing Number.
     * Memory Usage: 51.4 MB, less than 33.89% of Java online submissions for Missing Number.
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        int lastNumber = nums.length;
        Arrays.sort(nums);
        int i;
        for(i=0; i< nums.length; i++){
            if(nums[i] != i)
                return i;
        }
        if(i == lastNumber)
            return lastNumber;
        return -1;
    }
}
