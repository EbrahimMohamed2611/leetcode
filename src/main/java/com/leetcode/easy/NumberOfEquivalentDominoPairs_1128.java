package com.leetcode.easy;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs/
 */
public class NumberOfEquivalentDominoPairs_1128 {
    public static void main(String[] args) {
        int[][] dominoes = {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}};
        System.out.println(numEquivDominoPairs(dominoes));
    }

    /**
     * using hashMap
     * Time: O(N)
     * Space: O(N);
     * Runtime: 11 ms, faster than 63.72% of Java online submissions for Number of Equivalent Domino Pairs.
     * Memory Usage: 51.7 MB, less than 86.28% of Java online submissions for Number of Equivalent Domino Pairs.
     */

    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> dominoesNumbers = new HashMap<>();
        int counter = 0;
        for (int[] domino : dominoes) {

            int min = Math.min(domino[0], domino[1]);
            int max = Math.max(domino[0], domino[1]);

            int hashCode = min * 10 + max;

            counter += dominoesNumbers.getOrDefault(hashCode, 0);
            dominoesNumbers.put(hashCode, dominoesNumbers.getOrDefault(hashCode, 0) + 1);
        }
        return counter;
    }
}
