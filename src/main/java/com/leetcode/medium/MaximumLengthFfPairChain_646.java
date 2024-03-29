package com.leetcode.medium;

import java.util.*;

public class MaximumLengthFfPairChain_646 {
    /*
Runtime: 9 ms, faster than 99.14% of Java online submissions for Maximum Length of Pair Chain.
Memory Usage: 42.2 MB, less than 95.78% of Java online submissions for Maximum Length of Pair Chain.
*/
    public int findLongestChain(int[][] pairs) {

        if (pairs.length == 0) return 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int pre = pairs[0][1];
        int count = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > pre) {
                count++;
                pre = pairs[i][1];
            }
        }
        return count;

    }
}
