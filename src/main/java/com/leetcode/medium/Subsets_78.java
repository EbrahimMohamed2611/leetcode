package com.leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/subsets/
 * Amazon Microsoft Uber Bloomberg Facebook Google Apple Adobe Yahoo
 */
public class Subsets_78 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
     * Memory Usage: 42.5 MB, less than 87.08% of Java online submissions for Subsets.
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> allSubSets = new ArrayList<>();
        getSubSets(0,allSubSets, new ArrayList<>(),nums);
        return allSubSets;
    }

    private void getSubSets(int currentIndex, List<List<Integer>> allSubSets, List<Integer> subSet, int[] nums){
        allSubSets.add(new ArrayList<>(subSet));
        for(int i = currentIndex; i< nums.length; i++){
            subSet.add(nums[i]);
            getSubSets(i+1,allSubSets,subSet,nums);
            subSet.remove(subSet.size()-1);
        }
    }
}
