package com.leetcode.easy;

public class NumberOf1Bits_191 {
    // Time Log(N)
    //Space O(1)

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of 1 Bits.
     * Memory Usage: 39.2 MB, less than 92.08% of Java online submissions for Number of 1 Bits.
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            count += (n&1);
            n >>>= 1;
        }
        return count;
    }
}
