package com.leetcode.easy;

public class PowerOfThree_326 {
    /*
Runtime: 15 ms, faster than 95.88% of Java online submissions for Power of Three.
Memory Usage: 42.2 MB, less than 89.78% of Java online submissions for Power of Three.
*/
    public boolean isPowerOfThree(int n) {
        if(n < 1) return false;
        while(n / 3 >0){
            if(n % 3 != 0) return false;
            n /= 3;
        }
        return n == 1;
    }
}
