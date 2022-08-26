package com.leetcode.medium;

public class HouseRobber_213 {
    public static int rob(int[] nums) {
        int[] withoutFirstHouse = new int[nums.length - 1];
        int[] withoutLastHouse = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0)
                withoutFirstHouse[i - 1] = nums[i];
            if (i != nums.length - 1)
                withoutLastHouse[i] = nums[i];
        }

        return Math.max(rob(withoutLastHouse, new int[nums.length - 1], withoutFirstHouse.length - 1), rob(withoutFirstHouse, new int[nums.length - 1], withoutFirstHouse.length - 1));

    }


    private static int rob(int[] houses, int[] dp, int currentHouse) {
        if (currentHouse == 0)
            return houses[currentHouse];
        if (currentHouse < 0)
            return 0;


        if (dp[currentHouse] != 0)
            return dp[currentHouse];

        int currentAndNonAdjacentHouse = houses[currentHouse] + rob(houses, dp, currentHouse - 2);
        int skipCurrentHouse = rob(houses, dp, currentHouse - 1);

        return dp[currentHouse] = Math.max(currentAndNonAdjacentHouse, skipCurrentHouse);
    }

    // Using Tabulation
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
    Memory Usage: 41.6 MB, less than 50.59% of Java online submissions for House Robber II.
     */
    public static int robWithTabulation(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] withoutFirstHouse = new int[nums.length - 1];
        int[] withoutLastHouse = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0)
                withoutFirstHouse[i - 1] = nums[i];
            if (i != nums.length - 1)
                withoutLastHouse[i] = nums[i];
        }
        return Math.max(robWithTabulationHelper(withoutFirstHouse), robWithTabulationHelper(withoutLastHouse));
    }

    private static int robWithTabulationHelper(int[] houses) {
        if(houses.length == 1) return houses[0];
        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        int i;
        int currentAndThird = 0;
        int nextHouse = 0;
        for (i = 1; i < houses.length; i++) {
            currentAndThird = houses[i];
            if (i > 1)
                currentAndThird += dp[i - 2];
            nextHouse = dp[i - 1];
            dp[i] = Math.max(currentAndThird, nextHouse);
        }
        return dp[i - 1];

    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2})); // 3
        System.out.println(rob(new int[]{1, 2, 3, 1}));// 4
        System.out.println(rob(new int[]{1, 2, 3})); // 3

        System.out.println(robWithTabulation(new int[]{2, 3, 2})); // 3
        System.out.println(robWithTabulation(new int[]{1, 2, 3, 1}));// 4
        System.out.println(robWithTabulation(new int[]{1, 2, 3})); // 3
        System.out.println(robWithTabulation(new int[]{0})); // 3
    }
}
