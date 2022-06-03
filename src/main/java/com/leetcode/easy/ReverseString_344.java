package com.leetcode.easy;

public class ReverseString_344 {
    /**
     * https://leetcode.com/problems/reverse-string/
     * Time (1/2 N) ==> N
     * Space O(1)
     * Runtime: 1 ms, faster than 96.14% of Java online submissions for Reverse String.
     * Memory Usage: 54.6 MB, less than 49.03% of Java online submissions for Reverse String.
     * @param s
     */
    public void reverseString(char[] s) {
        int start = 0, end = s.length-1;
        while(end>start){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
