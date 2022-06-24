package com.leetcode.medium;

import java.util.*;

public class CombinationSum_39 {

    /**
     * Runtime: 6 ms, faster than 58.42% of Java online submissions for Combination Sum.
     * Memory Usage: 45.2 MB, less than 38.88% of Java online submissions for Combination Sum.
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum(0, candidates, result, list, target);
        return result;
    }

    private static void combinationSum(int index, int[] elements, List<List<Integer>> results, List<Integer> list, int target) {
        if (index == elements.length) {
            if (target == 0) {
                results.add(new ArrayList<>(list));
            }
            return;
        }

        if (target < 0)
            return;
        list.add(elements[index]);
        combinationSum(index, elements, results, list, target - elements[index]);
        list.remove(list.size() - 1); // remove the last elements that added

        combinationSum(index + 1, elements, results, list, target);
    }


    /**
     * Using sort and iterative
     * Runtime: 2 ms, faster than 99.97% of Java online submissions for Combination Sum.
     * Memory Usage: 42.6 MB, less than 90.00% of Java online submissions for Combination Sum.
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(0, candidates, result, list, target);
        return result;
    }

    private static void combinationSum2(int index, int[] elements, List<List<Integer>> results, List<Integer> list, int target) {
        if (target < 0)
            return;
        else if (target == 0)
            results.add(new ArrayList<>(list));
        else {
            for (int i = index; i < elements.length; i++) {
                if (target < elements[i]) return;
                list.add(elements[i]);
                combinationSum2(i, elements, results, list, target - elements[i]);
                list.remove(list.size() - 1); // remove the last elements that added
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum2(new int[]{2, 3, 6, 7}, 7));
    }
}
