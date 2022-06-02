package com.leetcode.easy;

/**
 * https://leetcode.com/problems/find-greatest-common-divisor-of-array/
 */
public class FindGreatestCommonDivisorOfArray_1979 {

    /**
     * Runtime: 1 ms, faster than 83.31% of Java online submissions for Find Greatest Common Divisor of Array.
     * Memory Usage: 44.3 MB, less than 14.23% of Java online submissions for Find Greatest Common Divisor of Array
     * Time O(N)
     * Space O(1)
     * @param nums
     * @return
     */
    public int findGCD(int[] nums) {
        // Arrays.sort(nums);
        int min = nums[0];
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max)
                max = nums[i];
            if(min>nums[i])
                min = nums[i];
        }
        return gcd(min,max);
    }

    private int gcd(int firstNumber, int secondNumber){
        if(firstNumber == secondNumber)
            return firstNumber;
        else if(firstNumber> secondNumber){
            return gcd(firstNumber-secondNumber, secondNumber);
        }else{
            return gcd(firstNumber,secondNumber-firstNumber);
        }
    }
}
