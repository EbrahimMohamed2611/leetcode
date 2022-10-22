package com.leetcode.medium;

import java.util.Arrays;

public class ThreeSumSmaller_259 {
    /*
   Runtime: 12 ms, faster than 86.26% of Java online submissions for 3Sum Smaller.
   Memory Usage: 41.9 MB, less than 92.40% of Java online submissions for 3Sum Smaller.
   */
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int counter =0;
        int size = nums.length;
        for(int i =0; i < size; i++){
            int currentTarget = (target - nums[i]);
            counter += searchOnTwoSmallerPair(i+1, size-1, currentTarget, nums);
        }
        return counter;
    }

    private static int searchOnTwoSmallerPair(int start, int end, int target, int[] nums){
        int counter = 0;
        while(end > start){
            if(nums[start] + nums[end] < target){
                counter+= (end - start);
                start++;
            }else{
                end--;
            }
        }
        return counter;
    }
}
