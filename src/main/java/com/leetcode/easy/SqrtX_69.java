package com.leetcode.easy;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class SqrtX_69 {
    public static void main(String[] args) {
        //46340
        System.out.println(mySqrt(2147395600));
    }


    /** Using Binary Search
     * Runtime: 2 ms, faster than 79.01% of Java online submissions for Sqrt(x).
     * Memory Usage: 41.4 MB, less than 55.55% of Java online submissions for Sqrt(x).
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int left = 1;
        int right = x;
        int result = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid <= x) {
                left = (int)mid + 1;
                result = (int)mid;
            } else {
                right = (int)mid - 1;
            }
        }
        return result;

    }

    /** using linear search
     * Runtime: 54 ms, faster than 5.71% of Java online submissions for Sqrt(x).
     * Memory Usage: 41.3 MB, less than 55.55% of Java online submissions for Sqrt(x).
     *
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        long y = 0;
        while (y * y <= x)
            y++;
        return (int) y - 1;

    }
}
