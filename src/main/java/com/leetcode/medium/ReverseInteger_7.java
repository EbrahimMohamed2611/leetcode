package com.leetcode.medium;


/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger_7 {

    public static void main(String[] args) {
        System.out.println(reverse(4568845));
        System.out.println(reverse(Integer.MIN_VALUE));
        System.out.println(reverse(12345));
        System.out.println(reverse(Integer.MIN_VALUE + 1));
    }

    /**
     * Time O(N)
     * Space O(1)
     * Runtime: 1 ms, faster than 98.95% of Java online submissions for Reverse Integer.
     * Memory Usage: 39.5 MB, less than 86.85% of Java online submissions for Reverse Integer.
     * @param x
     * @return
     */
    public static int reverse(int x) {

        int result = 0;
        while (x != 0) {
            int prevSum = result;
            result = (result * 10) + (x % 10); // this line is responsible for overflow
            // compare the last result with the current result after adding the new digit if will overflow the result will  change
            if (prevSum != result / 10)
                return 0;
            x = x / 10;
        }
        return result;

    }

    /**
     * Runtime: 2 ms, faster than 63.85% of Java online submissions for Reverse Integer.
     * Memory Usage: 41 MB, less than 67.49% of Java online submissions for Reverse Integer.
     *
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        final int MAX_INTEGER = Integer.MAX_VALUE;
        final int MIN_INTEGER = Integer.MIN_VALUE;

        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            if (result > (MAX_INTEGER / 10) || (result == (MAX_INTEGER / 10)
                    &&
                    digit >= (MAX_INTEGER % 10)))
                return 0;

            if (result < (MIN_INTEGER / 10) || (result == (MIN_INTEGER / 10)
                    &&
                    digit <= (MIN_INTEGER % 10)))
                return 0;

            result = (result * 10) + digit;
        }
        return result;
    }
}
