package com.leetcode.easy;

/**
 * https://leetcode.com/problems/arranging-coins/
 * Company Amazon
 */

public class ArrangingCoins_441 {

    /**
     * Time O(1) Or Log N for calculate the Sqr(N)
     * Space O (1)
     * The best Solution is using Math Formula
     */
    public static int arrangeCoins(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }



    /**
     * Using Gauss's Formula =>    Sum(N) =  (N/2 + (N+1))
     * Time O(Log N)
     * Space O(1)
     * Runtime: 2 ms, faster than 89.57% of Java online submissions for Arranging Coins.
     * Memory Usage: 41.9 MB, less than 17.54% of Java online submissions for Arranging Coins.
     * @param n
     * @return
     */
    public static int arrangeCoins2(int n) {
        long left = 1, right = n;
        long completeRows = 0;
        while (right >= left) {
            long mid = left + ((right - left) >> 1);
            long sumOfMid = (mid * (mid + 1)) >>1;
            if (sumOfMid == n)
                return (int) mid;
            if (sumOfMid > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                completeRows = Math.max(mid, completeRows);
            }
        }
        // right will be the
        return (int) completeRows;
    }

    /**
     * Input: n = 5
     * Output: 2
     * Explanation: Because the 3rd row is incomplete, we return 2.
     * <p>
     * <p>
     * Time O(N)
     * Space O(1)
     * Runtime: 12 ms, faster than 16.72% of Java online submissions for Arranging Coins.
     * Memory Usage: 41.7 MB, less than 35.35% of Java online submissions for Arranging Coins.
     */
    public static int arrangeCoins1(int n) {
        int numberOfCompleteRows = 0;
        int numberOfCoins = n;
        for (int i = 1; i <= n; i++) {
            numberOfCoins -= i;
            numberOfCompleteRows++;
            if (numberOfCoins == 0)
                return numberOfCompleteRows;
            if (numberOfCoins < 0) {
                break;
            }
        }
        return numberOfCompleteRows - 1;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(1));
        System.out.println(arrangeCoins(1804289383));
        System.out.println("========================");
        System.out.println(arrangeCoins2(5));
        System.out.println(arrangeCoins2(8));
        System.out.println(arrangeCoins2(1));
        System.out.println(arrangeCoins2(1804289383));
    }
}
