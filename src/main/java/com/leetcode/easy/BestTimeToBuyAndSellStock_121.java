package com.leetcode.easy;

public class BestTimeToBuyAndSellStock_121 {

    public int maxProfit3(int[] prices) {
        if(prices.length == 0 ) return 0;
        int currentMinPrice = prices[0];
        int maxProfit = 0; // the worst case will buy and sell in the same day
        for(int i =1; i< prices.length;i++){
            int currentCost = prices[i] - currentMinPrice;
            maxProfit = Math.max(currentCost, maxProfit);
            // keep the min price until now
            currentMinPrice = Math.min(currentMinPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        int[] array2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(array));
        System.out.println(maxProfit(array2));
    }

    /**
     * Time O(N)
     * space O(1)
     * Using Two Pointers
     *Runtime: 2 ms, faster than 96.38% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 59.2 MB, less than 80.97% of Java online submissions for Best Time to Buy and Sell Stock.
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0; // default and if we can not find profit
        int buyPointer = 0;
        int sellPointer = 1;
        for (int i = 0; i < prices.length -1; i++) {
            if (prices[buyPointer] < prices[sellPointer]) {
                maxProfit = Math.max(maxProfit, (prices[sellPointer] - prices[buyPointer]));
            } else {
                buyPointer = sellPointer;
            }
                sellPointer += 1;
        }
        return maxProfit;
    }


    /**
     * O(N^2)
     * Time Limit Exceeded
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int maxProfit = 0; // default and if we can not find profit
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = Math.max(maxProfit, (prices[j] - prices[i]));
                }
            }
        }
        return maxProfit;
    }
}
