package com.leetcode.easy;

public class PowerOfTwo_231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(7));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo2(4));
        System.out.println(isPowerOfTwo2(7));
        System.out.println(isPowerOfTwo2(16));
        System.out.println(isPowerOfTwo2(1));
        System.out.println(isPowerOfTwo2(0));
    }

    /**
     * Using Bitwise
     * Time N(1) constant
     * Space N(1) constant
     * @param n
     * @return isPowerOfTwo or not
     */
    public static boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        return (n & (n-1)) == 0;
    }

    /**
     * Brute Force
     * Time O(logN)
     * Space O(1)
     * Runtime: 1 ms, faster than 95.48% of Java online submissions for Power of Two.
     * Memory Usage: 39.4 MB, less than 91.58% of Java online submissions for Power of Two.
     * @param n
     * @return isPowerOfTwo
     */
    public static boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 != 0)
                return false;
            else {
                n = (n>>1);
            }
        }
        return true;
    }


}
