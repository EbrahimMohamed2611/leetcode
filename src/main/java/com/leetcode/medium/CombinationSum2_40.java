package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/
public class CombinationSum2_40 {

    /**
     Runtime: 2 ms, faster than 99.89% of Java online submissions for Combination Sum II.
     Memory Usage: 42.7 MB, less than 85.45% of Java online submissions for Combination Sum II.
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(0, candidates, result, list, target);
        return result;
    }

    private static void combinationSum(int index, int[] elements, List<List<Integer>> results, List<Integer> list, int target) {
        if (target < 0)
            return;
        else if (target == 0)
            results.add(new ArrayList<>(list));
        else {
            for (int i = index; i < elements.length; i++) {
                if (i > index && elements[i] == elements[i - 1]) continue;
                if (target < elements[i]) return;
                list.add(elements[i]);
                combinationSum(i + 1, elements, results, list, target - elements[i]);
                list.remove(list.size() - 1); // remove the last elements that added
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
