package com.leetcode.medium;

public class JumpGame_55 {
    /*
    Runtime: 798 ms, faster than 7.74% of Java online submissions for Jump Game.
Memory Usage: 69.9 MB, less than 5.67% of Java online submissions for Jump Game.
     */
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        return canJump(0, nums,dp) ;
    }
    // 2 is true and -1 is false
    private boolean canJump(int startIndex, int[]nums, int[] dp){
        if(startIndex == nums.length -1)
            return true;

        if(dp[startIndex] != 0)
            return (dp[startIndex] == 2);

        for(int i = startIndex+1; i<=startIndex+nums[startIndex] && i<nums.length;i++)
            if(canJump(i,nums,dp))   {
                dp[startIndex] = 2;
                return true;
            }


        dp[startIndex] = -1;
        return false;
    }
}
