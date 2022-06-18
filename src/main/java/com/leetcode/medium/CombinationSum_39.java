package com.leetcode.medium;

import java.util.*;

public class CombinationSum_39 {

    /**
     * Runtime: 6 ms, faster than 57.83% of Java online submissions for Combination Sum.
     * Memory Usage: 42.6 MB, less than 89.24% of Java online submissions for Combination Sum.
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum(0,candidates,result, list,target);
        return result;
    }

    private void combinationSum(int index, int[] elements, List<List<Integer>> results, List<Integer> list, int target){
        if(index == elements.length){
            if(target == 0){
                results.add(new ArrayList<>(list));
            }
            return;
        }

        if(target > 0){
            list.add(elements[index]);
            combinationSum(index, elements, results, list, target - elements[index]);
            list.remove(list.size()-1); // remove the last elements that added
        }
        combinationSum(index+1, elements, results, list, target);
    }
}
