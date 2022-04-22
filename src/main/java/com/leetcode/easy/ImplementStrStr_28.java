package com.leetcode.easy;


/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr_28 {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
    }

    /**
     * Time O(N^2)
     * Space O(1)
     * Using Two Pointer
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement strStr().
     * Memory Usage: 40.1 MB, less than 97.60% of Java online submissions for Implement strStr().
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        int hayStackSize = haystack.length();
        int needleSize = needle.length();
        if (needleSize > hayStackSize)
            return -1;

        for (int i = 0; i <= hayStackSize - needleSize; i++) {
            int j;
            for (j = 0; j < needleSize; j++) {
                if (haystack.charAt(j+i) != needle.charAt(j))
                    break;
            }
            if( j == needleSize)
                return i;
        }
        return -1;
    }
}
