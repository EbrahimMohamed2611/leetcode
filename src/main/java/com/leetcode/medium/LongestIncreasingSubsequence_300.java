package com.leetcode.medium;

public class LongestIncreasingSubsequence_300 {



    // USing Tabulation O(N^2)
    public static int lengthOfLongestIncreasingSubSequence(int[] nums) {
    int maxLength = 1;
    int[] dp = new int[nums.length+1];
    dp[nums.length] = 1;
        for (int prev = nums.length; prev >=0; prev--) {
            for (int current = prev; current < nums.length; current++) {
                if(nums[current]< nums[prev]){
                    maxLength = Math.max(maxLength, dp[current]);
                }
            }
        }
        return maxLength;
    }



    //Using Memoization
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return lengthOfLIS(-1, 0, nums, dp);
    }

    private int lengthOfLIS(int prev, int current, int[] nums, int[][] dp) {
        if (current == nums.length)
            return 0;
        if (dp[prev + 1][current] != 0)
            return dp[prev + 1][current];
        // first not take the current Element
        int notTake = lengthOfLIS(prev, current + 1, nums, dp);
        // second with take the current element
        int take = 0;
        if (prev == -1 || nums[prev] < nums[current])
            take = 1 + lengthOfLIS(current, current + 1, nums, dp);

        return dp[prev + 1][current] = Math.max(notTake, take);
    }



    // Using Tabulation
    /*
    Runtime: 78 ms, faster than 49.01% of Java online submissions for Longest Increasing Subsequence.
    Memory Usage: 44.6 MB, less than 35.73% of Java online submissions for Longest Increasing Subsequence.
     */
    public int lengthOfLIS2(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    maxLength = Math.max(maxLength, dp[i]);
                }
        }
        return maxLength;

    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{1,2,4,3})); // 3
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{4,2,3,6,10,1,12})); // 5
        System.out.println(lengthOfLongestIncreasingSubSequence(new int[]{-4,10,3,7,15})); // 4
    }
}
