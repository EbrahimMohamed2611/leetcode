package com.leetcode.medium;

public class JumpGameII_45 {
    /*
    Runtime: 161 ms, faster than 14.95% of Java online submissions for Jump Game II.
    Memory Usage: 42.9 MB, less than 89.30% of Java online submissions for Jump Game II
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        return minimumNumberOfJumps(0, nums, dp);
    }

    private int  minimumNumberOfJumps(int index, int[]nums, int[] dp){
        if(index == nums.length -1)
            return 0;
        if(index >= nums.length)
            return Integer.MAX_VALUE;
        if(dp[index] != 0)
            return dp[index];
        int cuurentMin = Integer.MAX_VALUE;
        for(int start = index+1; start<= index+nums[index] && start< nums.length; start++){
            int min = minimumNumberOfJumps(start, nums, dp);
            if( min != Integer.MAX_VALUE)
                cuurentMin = Math.min(1 + min,cuurentMin);
        }

        return dp[index] = cuurentMin;
    }
}
