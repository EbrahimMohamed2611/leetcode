package com.leetcode.easy;

import java.util.*;

public class MissingRanges_163 {
    /*
    Runtime: 6 ms, faster than 84.82% of Java online submissions for Missing Ranges.
    Memory Usage: 40.9 MB, less than 84.12% of Java online submissions for Missing Ranges.

    Time: O(N)
    Space: O(N1)
    */

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> ranges = new ArrayList<>();

        if (nums.length == 0) {
            addRange(lower, upper, ranges);
            return ranges;
        }

        int prev = lower;
        for (int current : nums) {
            if (current > prev)
                addRange(prev, current - 1, ranges);

            prev = current + 1;
        }

        if (prev <= upper)
            addRange(prev, upper, ranges);
        return ranges;
    }

    private static void addRange(int lower, int upper, List<String> ranges) {
        if (lower == upper) {
            ranges.add(Integer.toString(upper));
        } else {
            ranges.add(lower + "->" + upper);
        }
    }
}
