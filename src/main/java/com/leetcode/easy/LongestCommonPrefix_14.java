package com.leetcode.easy;


/**
 * https://leetcode.com/problems/longest-common-prefix/
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 */
public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"f", "flow", "flight"};
//        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        if(strs[0].length() == 0)
            return "";
        StringBuilder commonPreFix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
        commonPreFix.append(strs[0].charAt(i));
            for (String str : strs) {
                if (!str.startsWith(commonPreFix.toString()))
                    return commonPreFix.deleteCharAt(i).toString();
            }
        }
        return commonPreFix.toString();

    }

    /**
     * Runtime: 1 ms, faster than 81.85% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 42.2 MB, less than 47.15% of Java online submissions for Longest Common Prefix.
     * @param strs
     * @return
     */
    public String longestCommonPrefixV2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
