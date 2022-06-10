package com.leetcode.easy;

public class ReverseBits_190 {
    // you need treat n as an unsigned value

    /**
     Runtime: 1 ms, faster than 95.97% of Java online submissions for Reverse Bits.
     Memory Usage: 42.7 MB, less than 34.97% of Java online submissions for Reverse Bits.
     * Time O(1)
     * Space (1)
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        int reversed = (n&1);
        n = (n>>>1);
        int counter = 0;
        while(counter<31){
            reversed = (reversed<<1) | (n&1);
            n >>>=1;
            counter++;
        }
        return reversed;
    }
    public static void main(String[] args) {
        int number = 43261596;
        System.out.println(reverseBits(number)); // 964176192
    }
}
