package com.leetcode.medium;

import java.util.*;

public class DecodeWays_91 {

    /*
Runtime: 1 ms, faster than 98.45% of Java online submissions for Decode Ways.
Memory Usage: 40.8 MB, less than 87.64% of Java online submissions for Decode Ways.
*/
    public int numDecodings(String string) {

        Map<Integer, Integer> cache = new HashMap<>();
        return numDecodings(string, 0, cache);
    }

    private static int numDecodings(String s, int index, Map<Integer, Integer> cache) {

        if (cache.containsKey(index))
            return cache.get(index);

        if (index == s.length())
            return 1;

        if (s.charAt(index) == '0')
            return 0;


        int currentWays = numDecodings(s, index + 1, cache);
        // if start with 1 that mean may be 10 11 12 13 14 15 16 17 18 19 ana all of this are valid
        if (index + 1 <= s.length() - 1 && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) <= '6')))
            currentWays += numDecodings(s, index + 2, cache);

        cache.put(index, currentWays);
        return currentWays;
    }
}
