package com.leetcode.easy;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare_367 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
    }

    /**
     * Using Binary Search
     * Time (Log N)
     * space O(1)
     *Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
     * Memory Usage: 41.6 MB, less than 9.34% of Java online submissions for Valid Perfect Square.
     * @param num square
     * @return is Perfect or Not
     */
    public static boolean isPerfectSquare(int num) {
        long left = 0, right = num;
        while (right >= left) {
            // use  right shift instead of /2 because is faster
            long mid = (left + right) >> 1;
            if (mid * mid == num)
                return true;
            else if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }


    /**
     * Time Limit Exceeded
     *
     * @param num
     * @return is Perfect or not
     */
    public static boolean isPerfectSquare2(int num) {
        for (int i = 1; i <= num; i++) {
            if (i * i == num)
                return true;
            if(i*i > num)
                return false;
        }
        return false;
    }
}
