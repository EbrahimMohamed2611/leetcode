package com.leetcode.easy;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber_509 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
     * Memory Usage: 40.7 MB, less than 57.66% of Java online submissions for Fibonacci Number.
     * Time O(N)
     * Space O(1)
     * @param n
     * @return
     */
    public int fib(int n) {

        if (n <= 1)
            return n;
        int last = 0;
        int secondLast = 1;
        for (int i = 2; i <= n; i++) {
            int sum = last + secondLast;
            last = secondLast;
            secondLast = sum;
        }
        return secondLast;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
     * Memory Usage: 41.5 MB, less than 13.06% of Java online submissions for Fibonacci Number.
     * Time O(n)
     * Space O(N)
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        int[] fib = new int[n + 1];
        if (n <= 1)
            return n;
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }


}
